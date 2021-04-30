/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _Controlleur;

import Vue.HOME1;
import Model.adresse_cl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edmm
 */
public class const_adresse implements ActionListener, MouseListener, KeyListener{

    HOME1 hom = new HOME1();
    adresse_cl adr = new adresse_cl();
    
    public const_adresse(HOME1 hom, adresse_cl adr){
       
        this.hom = hom;
        this.adr = adr;
        
        
        this.hom.b_add.addActionListener(this);
        this.hom.b_modifier.addActionListener(this);
        this.hom.b_delete.addActionListener(this);
        this.hom.b_actualiser.addActionListener(this);
        this.hom.table_adresse.addMouseListener(this);
        this.hom.recherche.addKeyListener(this);
        
        this.hom.b_delete.setEnabled(false);
        this.hom.b_modifier.setEnabled(false);
        this.hom.txt_id_adr.setEditable(false);
        
        listTable_adresse(hom.table_adresse);
        hom.table_adresse.setSelectionMode(0);
        
    }
    
    
    public void vider(){
        
            hom.txt_id_adr.setText("");
            hom.txt_pay.setText("");
            hom.txt_prov.setText("");
            hom.txt_com.setText("");
            hom.txt_quar.setText("");
            hom.recherche.setText("");
            this.hom.txt_id_adr.setEditable(false);
           
    }
    
      public void listTable_adresse(JTable table_ad){
       
        DefaultTableModel model = new DefaultTableModel();
        table_ad.setModel(model);
        
        model.addColumn("N°");
        model.addColumn("Pays");
        model.addColumn("Province");
        model.addColumn("Commune");
        model.addColumn("Quartier");
        
       Object[] colonne = new Object[5];
       
      int nbr = adr.List_Adresse().size();
      
       for(int i =0; i < nbr; i++)
       {
         colonne[0] = adr.List_Adresse().get(i).getIdadresse();
         colonne[1] = adr.List_Adresse().get(i).getPays();
         colonne[2] = adr.List_Adresse().get(i).getProvince();
         colonne[3] = adr.List_Adresse().get(i).getCommune();
         colonne[4] = adr.List_Adresse().get(i).getQuartier();
         
         
         model.addRow(colonne);
       }
           
   }
      /*public void actDesact(){
          
          boolean val= false;
         if(val=!hom.txt_pay.getText().trim().isEmpty() || !hom.txt_prov.getText().trim().isEmpty() 
                    || !hom.txt_com.getText().trim().isEmpty() || !hom.txt_quar.getText().trim().isEmpty()){
             hom.b_add.setEnabled(val);
      }
    }*/
    
    @Override
    public void actionPerformed(ActionEvent e) {
      
       
        if (e.getSource() == hom.b_add) {
           
            if (hom.txt_pay.getText().equals("") || hom.txt_prov.getText().equals("") 
                    || hom.txt_com.getText().equals("") || hom.txt_quar.getText().equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp");
            }else {
               
            String pays = hom.txt_pay.getText();
            String province = hom.txt_prov.getText();
            String commune = hom.txt_com.getText();
            String quartier = hom.txt_quar.getText();
            
           adresse_cl add = new adresse_cl(pays, province, commune, quartier);
           add.ajoute_adresse();
           JOptionPane.showMessageDialog(null, add.getInfo());
           vider();
           listTable_adresse(hom.table_adresse);
           this.hom.txt_id_adr.setEditable(false);
           
            }
            
        }
        
        if (e.getSource() == hom.b_actualiser) {
            vider();
            hom.txt_id_adr.setEditable(true);
            hom.b_add.setEnabled(true);
            hom.b_delete.setEnabled(false);
            hom.b_modifier.setEnabled(false);
            
            listTable_adresse(hom.table_adresse);
            this.hom.txt_id_adr.setEditable(false);
        }
        
        if (e.getSource() == hom.b_modifier) {
          
            
           if (hom.txt_pay.getText().equals("") || hom.txt_prov.getText().equals("") 
                    || hom.txt_com.getText().equals("") || hom.txt_quar.getText().equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp");
            }  else {
               
                if(JOptionPane.showConfirmDialog(null, "Voulez-vous modifier "+hom.txt_pay.getText()+" "+hom.txt_quar.getText()+" ?","Modification d'Adresse",JOptionPane.YES_NO_OPTION)
                == JOptionPane.OK_OPTION){
               
             int id = Integer.parseInt(hom.txt_id_adr.getText());
              
            String pays = hom.txt_pay.getText();
            String province = hom.txt_prov.getText();
            String commune = hom.txt_com.getText();
            String quartier = hom.txt_quar.getText();
            
           adresse_cl mod = new adresse_cl(pays, province, commune, quartier, id);
          mod.modifier_Adresse();
           JOptionPane.showMessageDialog(null, mod.getInfo());
           
           vider();
           
            hom.txt_id_adr.setEditable(false);
            hom.b_add.setEnabled(true);
            hom.b_delete.setEnabled(false);
            hom.b_modifier.setEnabled(false);
            listTable_adresse(hom.table_adresse);
           
            }}
        }
        
        if (e.getSource() == hom.b_delete) {
            
          
          if (hom.txt_id_adr.getText().equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez selectionnez une adresse");
            }  else {
               
              if(JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer "+hom.txt_pay.getText()+" "+hom.txt_quar.getText()+" ?","Suppression d'Adresse",JOptionPane.YES_NO_OPTION)
                == JOptionPane.OK_OPTION){
               
             int id = Integer.parseInt(hom.txt_id_adr.getText());
              
            
           adresse_cl del = new adresse_cl(id);
           del.supprimer_Adresse();
           JOptionPane.showMessageDialog(null, del.getInfo());
           
           vider();
            hom.txt_id_adr.setEditable(false);
            hom.b_add.setEnabled(true);
             hom.b_delete.setEnabled(false);
            hom.b_modifier.setEnabled(false);
            listTable_adresse(hom.table_adresse);
           
            } } 
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
     
        if (e.getSource() == hom.table_adresse) {
            
        
        int id = hom.table_adresse.getSelectedRow();
            
            hom.txt_id_adr.setEditable(false);
            hom.txt_id_adr.setText(String.valueOf(hom.table_adresse.getValueAt(id, 0)));
            hom.txt_pay.setText(String.valueOf(hom.table_adresse.getValueAt(id, 1)));
            hom.txt_prov.setText(String.valueOf(hom.table_adresse.getValueAt(id, 2)));
            hom.txt_com.setText(String.valueOf(hom.table_adresse.getValueAt(id, 3)));
            hom.txt_quar.setText(String.valueOf(hom.table_adresse.getValueAt(id, 4)));
         
             hom.b_add.setEnabled(false);
             hom.b_delete.setEnabled(true);
             hom.b_modifier.setEnabled(true);
            
       }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
      
         if (e.getSource() == hom.recherche) {
          
            char c = e.getKeyChar();
            
            if ((c<'a' || c>'z') && (c<'A' || c>'Z') && (c!= (char)KeyEvent.VK_SPACE)) {
                
                e.consume();
                
            }
            
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        if (e.getSource() == hom.recherche) {
            
              String rech = hom.recherche.getText();
          DefaultTableModel model1 = new DefaultTableModel();
          
          hom.table_adresse.setModel(model1);
        
        model1.addColumn("N°");
        model1.addColumn("Pays");
        model1.addColumn("Province");
        model1.addColumn("ommune");
        model1.addColumn("Quartier");
        
       Object[] colonne = new Object[5];
       adresse_cl reche = new adresse_cl(rech);
       
       int numR = reche.Recherche_adresse().size();
        
       //int numR = modeloCrud.Recherche().size();
        
            for (int i = 0; i < numR; i++) {
               
                colonne[0] = reche.Recherche_adresse().get(i).getIdadresse();
                colonne[1] = reche.Recherche_adresse().get(i).getPays();
                colonne[2] = reche.Recherche_adresse().get(i).getProvince();
                colonne[3] = reche.Recherche_adresse().get(i).getCommune();
                colonne[4] = reche.Recherche_adresse().get(i).getQuartier();
               
                model1.addRow(colonne);
                
            } 
 
            
        }
        
    }
    
}

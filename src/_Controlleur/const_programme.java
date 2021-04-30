/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _Controlleur;

import Vue.HOME1;
import Model.personnel_programme;
import Model.programme_cl;
import Model.vehicule_cl;
import Model.vehicule_programme_cl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edmm
 */
public class const_programme implements ActionListener,MouseListener, ItemListener{

    
    HOME1 f_hom = new  HOME1(); 
    programme_cl f_prog = new programme_cl();
    vehicule_programme_cl vh = new vehicule_programme_cl();

    public const_programme(HOME1 h,programme_cl p,vehicule_programme_cl ve_pr) {
        
        this.f_hom = h;
        this.f_prog = p;
       this.vh = ve_pr;
       
        vehicule_programme_cl.alimenter_Com_vehicule(f_hom.com_vehicule);
        vehicule_programme_cl.alimenter_Com_programme(f_hom.com_programme);
        personnel_programme.alimenter_Com_chauffeur(f_hom.com_chauffeur);
        personnel_programme.alimenter_Com_programme(f_hom.com_programme_v);
        
        this.f_hom.b_add_programme.addActionListener(this);
        this.f_hom.b_modifier_programme.addActionListener(this);
        this.f_hom.b_delete_programme.addActionListener(this);
        this.f_hom.b_actualiser_programme.addActionListener(this);
        this.f_hom.b_fermer_programme.addActionListener(this);
        this.f_hom.table_programme.addMouseListener(this);
        
        this.f_hom.b_add_vehicule_programme.addActionListener(this);
        this.f_hom.b_modifier_vehicule_programme.addActionListener(this);
        this.f_hom.b_delete_vehicule_programme.addActionListener(this);
        this.f_hom.b_fermer_vehicule_programme.addActionListener(this);
        
        
        
        listTable_programme(f_hom.table_programme);
        listTable_programme_all(f_hom.table_all_programme);
        listTable_vehicule_programme(f_hom.table_vehicule_programme);
        listTable_chauffeur_programme(f_hom.table_chauffeur_programme);
        
        f_hom.txt_id_programme.setEditable(false);
        f_hom.txt_id_vehicule_programme.setEditable(false);
        
        f_hom.table_chauffeur_programme.setSelectionMode(0);
        f_hom.table_all_programme.setSelectionMode(0);
        f_hom.table_vehicule_programme.setSelectionMode(0);
        
    }
    
    public void vider_programme(){
        
        f_hom.txt_prog_heure.setText("");
         f_hom.txt_id_programme.setText("");
          f_hom.txt_prog_ville_arr.setText("");
           f_hom.txt_prog_ville_dep.setText("");
            f_hom.txt_prog_date.setDate(null);
    }
    
      public void listTable_programme(JTable table_prog){
       
        DefaultTableModel model = new DefaultTableModel();
        table_prog.setModel(model);
        
        model.addColumn("N°");
        model.addColumn("Date du Programme");
        model.addColumn("Heure du Programme");
        model.addColumn("Ville de départ");
        model.addColumn("Ville d'arrivée");
        
        
       Object[] colonne = new Object[5];
       programme_cl progr = new programme_cl();
       
      int nbr = progr.List_programme().size();
       
       for(int i =0; i < nbr; i++)
       {
         colonne[0] = progr.List_programme().get(i).getIdprogramme();
         colonne[1] = progr.List_programme().get(i).getDate_p();
         colonne[2] = progr.List_programme().get(i).getHeure_p();
         colonne[3] = progr.List_programme().get(i).getVille_depart();
         colonne[4] = progr.List_programme().get(i).getVille_arrivee();
        
         model.addRow(colonne);
       }
           
   }
      
       public void listTable_vehicule_programme(JTable table_veh_prog){
       
        DefaultTableModel model = new DefaultTableModel();
        table_veh_prog.setModel(model);
        
        model.addColumn("N°");
        model.addColumn("Date du Programme");
         model.addColumn("Heure du Programme");
        model.addColumn("Marque du Vehicule");
        model.addColumn("Immatricule");
        
        
       Object[] colonne = new Object[5];
       vehicule_programme_cl veh_prog = new vehicule_programme_cl();
       
      int nbr = veh_prog.List_vehicule_programme().size();
       
       for(int i =0; i < nbr; i++)
       {
         colonne[0] = veh_prog.List_vehicule_programme().get(i).getIdvehicule_programme();
         colonne[1] = veh_prog.List_vehicule_programme().get(i).getIdprogramme().getDate_p();
         colonne[2] = veh_prog.List_vehicule_programme().get(i).getIdprogramme().getHeure_p();
         colonne[3] = veh_prog.List_vehicule_programme().get(i).getIdvehicule().getMarque();
         colonne[4] = veh_prog.List_vehicule_programme().get(i).getIdvehicule().getImmatricule();
        
        
         model.addRow(colonne);
       }
           
   }
      
      public void listTable_programme_all(JTable table_prog_all){
       
        DefaultTableModel model = new DefaultTableModel();
        table_prog_all.setModel(model);
        
        model.addColumn("Chauffeur");
        model.addColumn("Vehicule");
        model.addColumn("Date du Programme");
        model.addColumn("Heure du Programme");
        model.addColumn("Ville de départ");
        model.addColumn("Ville d'arrivée");
        
        
       Object[] colonne = new Object[6];
       programme_cl progra = new programme_cl();
       
      int nbr = progra.List_programme_all().size();
       
       for(int i =0; i < nbr; i++)
       {
         colonne[0] = progra.List_programme_all().get(i).getNom().getNom();
         colonne[1] = progra.List_programme_all().get(i).getMarque().getMarque();
         colonne[2] = progra.List_programme_all().get(i).getDate_p();
         colonne[3] = progra.List_programme_all().get(i).getHeure_p();
         colonne[4] = progra.List_programme_all().get(i).getVille_depart();
         colonne[5] = progra.List_programme_all().get(i).getVille_arrivee();
        
         model.addRow(colonne);
       }
           
   }
    // ========================================== liste des chauffeurs liés au programme ================================================
      public void listTable_chauffeur_programme(JTable table_personnel_prog){
       
        DefaultTableModel model = new DefaultTableModel();
        table_personnel_prog.setModel(model);
        
        model.addColumn("N°");
        model.addColumn("Nom");
        model.addColumn("Matricule");
        model.addColumn("Date du Programme");
        model.addColumn("Heure du programme");
       
        
        
       Object[] colonne = new Object[5];
          personnel_programme pers_prog = new personnel_programme();
       
      int nbr = pers_prog.List_chauffeur_programme().size();
       
       for(int i =0; i < nbr; i++)
       {
         colonne[0] = pers_prog.List_chauffeur_programme().get(i).getIdprogramme_personnel();
         colonne[1] = pers_prog.List_chauffeur_programme().get(i).getIdpersonnel().getIdpersonne().getNom();
         colonne[2] = pers_prog.List_chauffeur_programme().get(i).getIdpersonnel().getMatricule();
         colonne[3] = pers_prog.List_chauffeur_programme().get(i).getIdprogramme().getDate_p();
         colonne[4] = pers_prog.List_chauffeur_programme().get(i).getIdprogramme().getHeure_p();
     
        
         model.addRow(colonne);
       }
           
   }
      
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == f_hom.b_add_programme) {
            
            SimpleDateFormat formatFecha = new SimpleDateFormat("yyyy-MM-dd");
             String date = formatFecha.format(f_hom.txt_prog_date.getDate());
             
             String heure = f_hom.txt_prog_heure.getText();
             String ville_dp = f_hom.txt_prog_ville_dep.getText();
             String ville_arr = f_hom.txt_prog_ville_arr.getText();
             
             if (f_hom.txt_prog_date.getDate().equals("") || f_hom.txt_prog_heure.getText().equals("") || f_hom.txt_prog_ville_dep.getText().equals("") || f_hom.txt_prog_ville_arr.getText().equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp");
            }else {
             
            programme_cl add_prog = new programme_cl(date, heure, ville_dp, ville_arr);
            add_prog.ajoute_programme();
            
            JOptionPane.showMessageDialog(null, add_prog.getInfo());
            listTable_programme(f_hom.table_programme);
            vider_programme();
            
        }
        }
       
        
         if (e.getSource() == f_hom.b_modifier_programme) {
          
            if (f_hom.txt_prog_date.getDate() == null || f_hom.txt_prog_heure.getText().equals("") || f_hom.txt_prog_ville_dep.getText().equals("") || f_hom.txt_prog_ville_arr.getText().equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp");
            }else {
                if(JOptionPane.showConfirmDialog(null, "Voulez-vous modifier "+f_hom.txt_prog_heure.getText()+" ?","Modification de Programme",JOptionPane.YES_NO_OPTION)
                == JOptionPane.OK_OPTION){
               
             int id = Integer.parseInt(f_hom.txt_id_programme.getText());
              
          SimpleDateFormat formatFecha = new SimpleDateFormat("yyyy-MM-dd");
             String date = formatFecha.format(f_hom.txt_prog_date.getDate());
             
             String heure = f_hom.txt_prog_heure.getText();
             String ville_dp = f_hom.txt_prog_ville_dep.getText();
             String ville_arr = f_hom.txt_prog_ville_arr.getText();
             
          programme_cl mod_prog = new programme_cl(date, heure, ville_dp, ville_arr, id);
          mod_prog.modifier_programme();
           
           JOptionPane.showMessageDialog(null, mod_prog.getInfo());
           vider_programme();
           listTable_programme(f_hom.table_programme);
           this.f_hom.txt_id_programme.setEditable(false);
           
                }
            }
        }
         
       if (e.getSource() == f_hom.b_delete_programme) {
            
          if (f_hom.txt_id_programme.getText().equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez selectionner un element");
            }  else {
               if(JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer "+f_hom.txt_prog_date.getDate()+" "+f_hom.txt_prog_heure.getText()+" ?","Suppression de Programme",JOptionPane.YES_NO_OPTION)
                == JOptionPane.OK_OPTION){
               
             int id = Integer.parseInt(f_hom.txt_id_programme.getText());
              
            programme_cl del_prog = new programme_cl(id);
            del_prog.supprimer_programme();
          
           JOptionPane.showMessageDialog(null, del_prog.getInfo());
           
           vider_programme();
           
           f_hom.txt_id_programme.setEditable(false);
            f_hom.b_add_programme.setEnabled(true);
            f_hom.b_delete_programme.setEnabled(false);
            f_hom.b_modifier_programme.setEnabled(false);
            
            listTable_programme(f_hom.table_programme);
           
            }
          }  
        }
       
        if (e.getSource()== f_hom.b_actualiser_programme) {
           
            vider_programme();
              f_hom.txt_id_programme.setEditable(false);
            f_hom.b_add_programme.setEnabled(true);
            f_hom.b_delete_programme.setEnabled(false);
            f_hom.b_modifier_programme.setEnabled(false);
        }
        if (e.getSource()== f_hom.b_fermer_programme) {
            
            f_hom.jP_programme.setVisible(false);
        }
 // =============================================== action veheicule_programme =========================================================
       
        if (e.getSource() == f_hom.b_add_vehicule_programme) {
            
            
           vehicule_cl veh;
           programme_cl prog;
           
           
            veh = (vehicule_cl)f_hom.com_vehicule.getSelectedItem();
            prog = (programme_cl)f_hom.com_programme.getSelectedItem();
            
             if (f_hom.txt_id_vehicule_programme.equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp");
            }else {
             
            vehicule_programme_cl add_vp = new vehicule_programme_cl(prog, veh);
            add_vp.ajouter_vehicule_programme();
            
            JOptionPane.showMessageDialog(null, add_vp.getInfo());
            
                 listTable_vehicule_programme(f_hom.table_vehicule_programme);
                 listTable_programme_all(f_hom.table_all_programme);
             f_hom.b_modifier_vehicule_programme.setVisible(false);
             f_hom.b_delete_vehicule_programme.setVisible(false);
             
            
        }
        }
       
        
         if (e.getSource() == f_hom.b_modifier_vehicule_programme) {
          
            if (f_hom.txt_id_vehicule_programme.equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp");
            }else {
                if(JOptionPane.showConfirmDialog(null, "Voulez-vous modifier "+f_hom.com_vehicule.getSelectedItem()+" ?","Modification du Vehicule lié au Programme",JOptionPane.YES_NO_OPTION)
                == JOptionPane.OK_OPTION){
                    
           vehicule_cl veh;
           programme_cl prog;
           
           
            veh = (vehicule_cl)f_hom.com_vehicule.getSelectedItem();
            prog = (programme_cl)f_hom.com_programme.getSelectedItem();
               
             int id = Integer.parseInt(f_hom.txt_id_vehicule_programme.getText());
              
          
            vehicule_programme_cl mod_vp = new vehicule_programme_cl(id);
            mod_vp.modifier_vehicule_programme();
           
           JOptionPane.showMessageDialog(null, mod_vp.getInfo());
          
            listTable_vehicule_programme(f_hom.table_vehicule_programme);
                 listTable_programme_all(f_hom.table_all_programme);
                 
           this.f_hom.txt_id_programme.setEditable(false);
            f_hom.b_modifier_vehicule_programme.setVisible(false);
             f_hom.b_delete_vehicule_programme.setVisible(false);
             f_hom.b_add_vehicule_programme.setVisible(true);
           
                }
            }
        }
         
       if (e.getSource() == f_hom.b_delete_vehicule_programme) {
            
          if (f_hom.txt_id_vehicule_programme.getText().equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez selectionner un element");
            }  else {
               if(JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer "+f_hom.com_vehicule.getSelectedItem()+" ?","Suppression du Vehicuele lié au Programme",JOptionPane.YES_NO_OPTION)
                == JOptionPane.OK_OPTION){
               
             int id = Integer.parseInt(f_hom.txt_id_programme.getText());
              
            programme_cl del_prog = new programme_cl(id);
            del_prog.supprimer_programme();
          
           JOptionPane.showMessageDialog(null, del_prog.getInfo());
           
           vider_programme();
           
           f_hom.txt_id_programme.setEditable(false);
            f_hom.b_add_programme.setEnabled(true);
            f_hom.b_delete_programme.setEnabled(false);
            f_hom.b_modifier_programme.setEnabled(false);
            
            listTable_programme(f_hom.table_programme);
           
            }
          }  
        }
       
        if (e.getSource()== f_hom.b_actualiser_vehicule_programme) {
           
            f_hom.txt_id_vehicule_programme.setText("");
            
           
        }
        if (e.getSource()== f_hom.b_fermer_vehicule_programme) {
            
            f_hom.jP_prog_vehicule.setVisible(false);
        }
        
    }
// =================================================================== fin actionPerformed() ===============================================
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == f_hom.table_programme) {
            
        
        int id = f_hom.table_programme.getSelectedRow();
            
            f_hom.txt_id_programme.setEditable(false);
            f_hom.txt_id_programme.setText(String.valueOf(f_hom.table_programme.getValueAt(id, 0)));
            
            f_hom.txt_prog_heure.setText(String.valueOf(f_hom.table_programme.getValueAt(id, 2)));
            f_hom.txt_prog_ville_dep.setText(String.valueOf(f_hom.table_programme.getValueAt(id, 3)));
            f_hom.txt_prog_ville_arr.setText(String.valueOf(f_hom.table_programme.getValueAt(id, 4)));
         
             f_hom.b_add_programme.setEnabled(false);
             f_hom.b_delete_programme.setEnabled(true);
             f_hom.b_modifier_programme.setEnabled(true);
            
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
    public void itemStateChanged(ItemEvent e) {
      vehicule_cl veh ;
      programme_cl prog;
       
        if(e!=null){
           veh = (vehicule_cl)e.getItem(); 
        } 
        
        if(e!=null){
           prog = (programme_cl)e.getItem();
          
        }
    }
    
}

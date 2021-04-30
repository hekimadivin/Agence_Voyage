
package _Controlleur;

import Vue.HOME1;
import Model.adresse_cl;
import Model.identite;
import Model.personnel_cl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edmm
 */
public class const_identite implements ActionListener, ItemListener, MouseListener{

    
    HOME1 f_hom = new HOME1();
    identite f_ident = new identite();
    personnel_cl pers = new  personnel_cl();
   
    
    public const_identite(HOME1 f_hom, identite f_ident,personnel_cl p){
         
        this.f_hom = f_hom;
        this.f_ident = f_ident;
        this.pers = p;
      
        this.f_hom.com_adress.addItemListener(this);
        identite.alimenter_Com_adresse(f_hom.com_adress);
        
        this.f_hom.masculin.addActionListener(this);
        this.f_hom.femme.addActionListener(this);
       
        this.f_hom.table_identite.addMouseListener(this);
        
        this.f_hom.b_add_ident.addActionListener(this);
        this.f_hom.b_modifier_ident.addActionListener(this);
        this.f_hom.b_delete_ident.addActionListener(this);
        this.f_hom.b_actualiser_idnet.addActionListener(this);
        
       listTable_identite(f_hom.table_identite);
       f_hom.table_identite.setSelectionMode(0);
    }
    public void vider_ident(){
          
          f_hom.txt_id_ident.setEditable(false);
          f_hom.txt_id_ident.setText("");
          f_hom.txt_nom.setText("");
          f_hom.txt_prenom.setText("");
          f_hom.txt_quar.setText("");
          f_hom.txt_telephone.setText("");
          f_hom.txt_cni.setText("");
          f_hom.com_adress.setSelectedIndex(0);
          
          f_hom.masculin.setSelected(true);
          f_hom.femme.setSelected(false);
          f_hom.b_add_ident.setEnabled(true);
          f_hom.table_identite.setSelectionMode(0);
          
    }
    
      public void listTable_identite(JTable table_ident){
       
        DefaultTableModel model1 = new DefaultTableModel();
        table_ident.setModel(model1);
        
        model1.addColumn("N°");
        model1.addColumn("Nom");
        model1.addColumn("Prénom");
        model1.addColumn("Sexe");
        model1.addColumn("CNI");
        model1.addColumn("Téléphone");
        model1.addColumn("Adresse");
        
       Object[] colonne1 = new Object[7];
       
      int nbr = f_ident.List_Identite().size();
    
       for(int i =0; i < nbr; i++)
       {
         colonne1[0] = f_ident.List_Identite().get(i).getIdpersonne();
         colonne1[1] = f_ident.List_Identite().get(i).getNom();
         colonne1[2] = f_ident.List_Identite().get(i).getPrenom();
         colonne1[3] = f_ident.List_Identite().get(i).getSexe();
         colonne1[4] = f_ident.List_Identite().get(i).getCNI();
         colonne1[5] = f_ident.List_Identite().get(i).getTelephone();
         colonne1[6] = f_ident.List_Identite().get(i).getIdadresse().getQuartier();
         
         model1.addRow(colonne1);
       }
          
   }
      
       public void selection_identite(){
     
           int id =f_hom.table_identite.getSelectedRow();
      //int nbr = f_ident.List_Identite().size();
    
      
         //f_hom.txt_id_ident.setText(Integer.parseInt(f_ident.List_Identite().get(id).getIdpersonne()));
        /*f_ident.List_Identite().get(i).getNom();
          f_ident.List_Identite().get(i).getPrenom();
         f_ident.List_Identite().get(i).getSexe();
          f_ident.List_Identite().get(i).getCNI();
          f_ident.List_Identite().get(i).getTelephone();
         f_ident.List_Identite().get(i).getIdadresse().getQuartier();*/
         
         
     
          
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == f_hom.b_actualiser_idnet) {
           vider_ident();
        }
        if (e.getSource() == f_hom.masculin) {
          
            f_hom.masculin.setSelected(true);
            f_hom.femme.setSelected(false);
        }
        if (e.getSource() == f_hom.femme) {
          
            f_hom.masculin.setSelected(false);
            f_hom.femme.setSelected(true);
        }
        
        if (e.getSource() == f_hom.b_add_ident) {
          String sexe = "";
              if (f_hom.txt_nom.getText().equals("") || f_hom.txt_prenom.getText().equals("") 
                    || f_hom.txt_cni.getText().equals("") || f_hom.txt_telephone.getText().equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp");
            }else {
                  
                   if (f_hom.masculin.isSelected()){
                     sexe=f_hom.masculin.getText();
           
                   }else if(f_hom.femme.isSelected()){
            
                     sexe=f_hom.femme.getText();
                   }
             adresse_cl idadr;  
            String nom = f_hom.txt_nom.getText();
            String prenom = f_hom.txt_prenom.getText();
            
            String cni = f_hom.txt_cni.getText();
            String tel = f_hom.txt_telephone.getText();
            
            idadr = (adresse_cl)f_hom.com_adress.getSelectedItem();
            
            identite enr_ident = new identite(idadr, nom, prenom, sexe, cni, tel);
            enr_ident.ajoute_identite();
           JOptionPane.showMessageDialog(null, enr_ident.getInfo());
                  listTable_identite(f_hom.table_identite);
                   personnel_cl.alimenter_Com_identite(f_hom.com_identite);
           
           vider_ident();
           
            }
            
        }
  if (e.getSource() == f_hom.b_modifier_ident) {
          String sexe = "";
          
         
           int id = Integer.parseInt(f_hom.txt_id_ident.getText());
          
              if (f_hom.txt_nom.getText().equals("") || f_hom.txt_prenom.getText().equals("") 
                    || f_hom.txt_cni.getText().equals("") || f_hom.txt_telephone.getText().equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp");
            }else {   
                  
                  if(JOptionPane.showConfirmDialog(null, "Voulez-vous modifier "+f_hom.txt_nom.getText()+" "+f_hom.txt_cni.getText()+" ?","Modification d'Identité",JOptionPane.YES_NO_OPTION)
                == JOptionPane.OK_OPTION){
                  
                   if (f_hom.masculin.isSelected()){
                     sexe=f_hom.masculin.getText();
           
                   }else if(f_hom.femme.isSelected()){
            
                     sexe=f_hom.femme.getText();
                   }
             adresse_cl idadr;  
            String nom = f_hom.txt_nom.getText();
            String prenom = f_hom.txt_prenom.getText();
            
            String cn = f_hom.txt_cni.getText();
            String tel = f_hom.txt_telephone.getText();
            
            idadr = (adresse_cl)f_hom.com_adress.getSelectedItem();
            
            identite mod_ident = new identite(idadr, nom, prenom, sexe, cn, tel, id);
                    
            mod_ident.modif_identite();
            
           JOptionPane.showMessageDialog(null, mod_ident.getInfo());
           
           vider_ident();
                  listTable_identite(f_hom.table_identite);
           
            }
              }
            
        }
  
   if (e.getSource() == f_hom.b_delete_ident) {
            
          if (f_hom.txt_id_ident.getText().equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez selectionner un element");
            }  else {
               if(JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer "+f_hom.txt_nom.getText()+" "+f_hom.txt_cni.getText()+" ?","Suppression d'Identité",JOptionPane.YES_NO_OPTION)
                == JOptionPane.OK_OPTION){
               
             int id = Integer.parseInt(f_hom.txt_id_ident.getText());
              
            
           identite del_ident = new identite(id);
           del_ident.supprimer_identite();
           JOptionPane.showMessageDialog(null, del_ident.getInfo());
           
           vider_ident();
           
           f_hom.txt_id_ident.setEditable(false);
            f_hom.b_add_ident.setEnabled(true);
            f_hom.b_delete_ident.setEnabled(false);
            f_hom.b_modifier_ident.setEnabled(false);
            
            listTable_identite(f_hom.table_identite);
           
            }
          }  
        }
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
          adresse_cl adr;
       
        if(e!=null){
           adr = (adresse_cl)e.getItem();
          } 
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
        if (e.getSource() == f_hom.table_identite) {
        
        int id = f_hom.table_identite.getSelectedRow();
            
            f_hom.txt_id_ident.setEditable(false);
            f_hom.txt_id_ident.setText(String.valueOf(f_hom.table_identite.getValueAt(id, 0)));
            f_hom.txt_nom.setText(String.valueOf(f_hom.table_identite.getValueAt(id, 1)));
            f_hom.txt_prenom.setText(String.valueOf(f_hom.table_identite.getValueAt(id, 2)));
            
            //JOptionPane.showMessageDialog(null, String.valueOf(f_hom.table_identite.getValueAt(id, 6)));
        
           String sexe = String.valueOf(f_hom.table_identite.getValueAt(id, 3));
        if(sexe.equals("M")){
            f_hom.masculin.setSelected(true);
            f_hom.femme.setSelected(false);
           } else{
            f_hom.femme.setSelected(true);
            f_hom.masculin.setSelected(false);
        }
       
            
            
             f_hom.txt_cni.setText(String.valueOf(f_hom.table_identite.getValueAt(id, 4)));
             f_hom.txt_telephone.setText(String.valueOf(f_hom.table_identite.getValueAt(id, 5)));
             
             
            
            f_hom.com_adress.setSelectedItem(String.valueOf(f_hom.table_identite.getValueAt(id, 6)));
            
             
            
            
             f_hom.b_add_ident.setEnabled(false);
             f_hom.b_delete_ident.setEnabled(true);
             f_hom.b_modifier_ident.setEnabled(true);
            
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
    
}

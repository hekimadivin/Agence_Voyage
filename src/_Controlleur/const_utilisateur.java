/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _Controlleur;


import Vue.HOME1;
import Model.fonction_cl;
import Model.identite;
import Model.personnel_cl;
import Model.personnel_fonction;
import Model.vehicule_cl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public final class const_utilisateur implements ActionListener, KeyListener,MouseListener,ItemListener{
    
    vehicule_cl f_veh = new vehicule_cl();
    fonction_cl fonct = new fonction_cl();
    HOME1 f_hom = new HOME1();
    
    public const_utilisateur(HOME1 hom, vehicule_cl veh,fonction_cl fn){
        
        this.f_hom = hom;
        this.f_veh = veh;
        this.fonct = fn;
        this.f_hom.b_add_vehicule.addActionListener(this);
        this.f_hom.b_modifier_vehicule.addActionListener(this);
        this.f_hom.b_delete_vehicule.addActionListener(this);
        this.f_hom.b_actualiser_vehicule.addActionListener(this);
        this.f_hom.table_vehicule.addMouseListener(this);
        this.f_hom.table_personnel.addMouseListener(this);
        
        this.f_hom.b_add_personnel.addActionListener(this);
        this.f_hom.b_delete_perosnnel.addActionListener(this);
        this.f_hom.b_modifier_personnel.addActionListener(this);
        this.f_hom.b_actualiser_personnel.addActionListener(this);
        
        this.f_hom.b_add_fonction.addActionListener(this);
        this.f_hom.b_modifier_fonction.addActionListener(this);
        this.f_hom.b_delete_fonction.addActionListener(this);
        this.f_hom.b_actualiser_fonction.addActionListener(this);
        this.f_hom.table_fonction.addMouseListener(this);
        
        this.f_hom.b_add_personnel_fonction.addActionListener(this);
        this.f_hom.b_modifier_personnel_fonction.addActionListener(this);
        this.f_hom.b_delete_personnel_fonction.addActionListener(this);
        this.f_hom.b_actualiser_personnel_fonction.addActionListener(this);
        
        
        this.f_hom.b_voir_nbre_place.addActionListener(this);
        
         this.f_hom.b_delete_vehicule.setEnabled(false);
         this.f_hom.b_modifier_vehicule.setEnabled(false);
         this.f_hom.txt_id_veh.setEditable(false);
         
        listTable_vehicuele(f_hom.table_vehicule);
        listTable_personnel(f_hom.table_personnel);
        listTable_fonction(f_hom.table_fonction);
        listTable_personnel_fonction_all(f_hom.table_all_personnel_fonction);
        listTable_personnel_fonction(f_hom.table_personnel_fonction);
        
        personnel_cl.alimenter_Com_identite(f_hom.com_identite);
        personnel_fonction.alimenter_Com_fonction(f_hom.com_fonction);
        personnel_fonction.alimenter_Com_personnel(f_hom.com_personnel);
        
        this.f_hom.b_modifier_personnel.setEnabled(false);
        this.f_hom.b_delete_perosnnel.setEnabled(false);
        
       
       
        
    }
    
     public void vider_vehicule(){
        
            f_hom.txt_id_veh.setText("");
            f_hom.txt_marque.setText("");
            f_hom.txt_immatricule.setText("");
          
            this.f_hom.txt_id_veh.setEditable(false);
           
    }
      public void vider_personnel(){
        
            f_hom.txt_id_personnel.setText("");
            f_hom.txt_matricule.setText("");
            
            f_hom.com_identite.setSelectedItem("");
            this.f_hom.txt_id_personnel.setEditable(false);
            
            f_hom.b_modifier_personnel.setEnabled(false);
            f_hom.b_delete_perosnnel.setEnabled(false);
            f_hom.table_personnel.setSelectionMode(-0);
           
    }
       public void vider_fonction(){
        
            f_hom.txt_id_fonction.setText("");
            f_hom.txt_nom_fonction.setText("");
            f_hom.txt_salaire.setText("");
          
            this.f_hom.txt_id_fonction.setEditable(false);
           
    }
       
          public void listTable_fonction(JTable table_fonc){
       
        DefaultTableModel model = new DefaultTableModel();
        table_fonc.setModel(model);
        
        model.addColumn("N°");
        model.addColumn("Nom de la fonction");
        model.addColumn("Salaire");
        
        
        
       Object[] colonne = new Object[3];
       fonction_cl fonc = new fonction_cl();
       
      int nbr = fonc.List_fonction().size();
       
       for(int i =0; i < nbr; i++)
       {
         colonne[0] = fonc.List_fonction().get(i).getIdfonction();
         colonne[1] = fonc.List_fonction().get(i).getNom_fonction();
         colonne[2] = fonc.List_fonction().get(i).getSalaire();
         
        
         model.addRow(colonne);
       }
           
   }
     
         public void listTable_vehicuele(JTable table_veh){
       
        DefaultTableModel model = new DefaultTableModel();
        table_veh.setModel(model);
        
        model.addColumn("N°");
        model.addColumn("Marque");
        model.addColumn("Immatricule");
        model.addColumn("Nombre de Place");
        
        
       Object[] colonne = new Object[4];
       vehicule_cl vh = new vehicule_cl();
       
      int nbr = vh.List_vehicule().size();
       
       for(int i =0; i < nbr; i++)
       {
         colonne[0] = vh.List_vehicule().get(i).getIdvehicule();
         colonne[1] = vh.List_vehicule().get(i).getMarque();
         colonne[2] = vh.List_vehicule().get(i).getImmatricule();
         colonne[3] = vh.List_vehicule().get(i).getNombre_place();
         
        
         model.addRow(colonne);
       }
           
   }
    
         
         //======================================================= personnel affichage ======================================================
         
       public void listTable_personnel(JTable table_personnel){
       
        DefaultTableModel model = new DefaultTableModel();
        table_personnel.setModel(model);
        
        model.addColumn("N°");
        model.addColumn("Nom");
        model.addColumn("Prénom");
        model.addColumn("Sexe");
        model.addColumn("Matricule");
        model.addColumn("Adresse");
        
        
       Object[] colonne = new Object[6];
       personnel_cl perso = new personnel_cl();
       
      int nbr = perso.List_personnel().size();
       
       for(int i =0; i < nbr; i++)
       {
         colonne[0] = perso.List_personnel().get(i).getIdpersonnel();
         colonne[1] = perso.List_personnel().get(i).getIdpersonne().getNom();
         colonne[2] = perso.List_personnel().get(i).getIdpersonne().getPrenom();
         colonne[3] = perso.List_personnel().get(i).getIdpersonne().getSexe();
         colonne[4] = perso.List_personnel().get(i).getMatricule();
         colonne[5] = perso.List_personnel().get(i).getIdpersonne().getIdadresse().getQuartier();
        
         model.addRow(colonne);
       }
           
   }
    //=================================== liste_ all_personnel_liés aux fonction==========================================
       
        public void listTable_personnel_fonction_all(JTable table_pers_fonct_all){
       
        DefaultTableModel model = new DefaultTableModel();
        table_pers_fonct_all.setModel(model);
        
        model.addColumn("N°");
        model.addColumn("Nom");
        model.addColumn("Prénom");
        model.addColumn("Sexe");
        model.addColumn("Matricule");
        model.addColumn("Fonction");
        model.addColumn("Salaire");
        model.addColumn("Date d'Entrée");
        model.addColumn("Date de Sortie");
        
       Object[] colonne = new Object[9];
       
       personnel_fonction pers_fonct = new personnel_fonction();
       
      int nbr = pers_fonct.List_personnel_fonction_all().size();
       
       for(int i =0; i < nbr; i++)
       {
         colonne[0] = pers_fonct.List_personnel_fonction_all().get(i).getIdpersonnel_fonction();
         colonne[1] = pers_fonct.List_personnel_fonction_all().get(i).getIdpersonnel().getIdpersonne().getNom();
         colonne[2] = pers_fonct.List_personnel_fonction_all().get(i).getIdpersonnel().getIdpersonne().getPrenom();
         colonne[3] = pers_fonct.List_personnel_fonction_all().get(i).getIdpersonnel().getIdpersonne().getSexe();
         colonne[4] = pers_fonct.List_personnel_fonction_all().get(i).getIdpersonnel().getMatricule();
         colonne[5] = pers_fonct.List_personnel_fonction_all().get(i).getIdfonction().getNom_fonction();
         colonne[6] = pers_fonct.List_personnel_fonction_all().get(i).getIdfonction().getSalaire();
         colonne[7] = pers_fonct.List_personnel_fonction_all().get(i).getDate_entree();
         colonne[8] = pers_fonct.List_personnel_fonction_all().get(i).getDate_sortie();
                 
        
         model.addRow(colonne);
       }
           
   }
        
        
        //=================================== liste_personnel_liés aux fonction==========================================
        //====================================================================================================================
       
        public void listTable_personnel_fonction(JTable table_pers_fonct){
       
        DefaultTableModel model = new DefaultTableModel();
        table_pers_fonct.setModel(model);
        
        model.addColumn("N°");
        model.addColumn("Nom");
      
        model.addColumn("Matricule");
        model.addColumn("Fonction");
        
        model.addColumn("Date d'Entrée");
        model.addColumn("Date de Sortie");
        
       Object[] colonne = new Object[6];
       
       personnel_fonction pers_fonct = new personnel_fonction();
       
      int nbr = pers_fonct.List_personnel_fonction().size();
       
       for(int i =0; i < nbr; i++)
       {
         colonne[0] = pers_fonct.List_personnel_fonction().get(i).getIdpersonnel_fonction();
         colonne[1] = pers_fonct.List_personnel_fonction().get(i).getIdpersonnel().getIdpersonne().getNom();
         
         colonne[2] = pers_fonct.List_personnel_fonction().get(i).getIdpersonnel().getMatricule();
         colonne[3] = pers_fonct.List_personnel_fonction().get(i).getIdfonction().getNom_fonction();
         
         colonne[4] = pers_fonct.List_personnel_fonction().get(i).getDate_entree();
         colonne[5] = pers_fonct.List_personnel_fonction().get(i).getDate_sortie();
                 
        
         model.addRow(colonne);
       }
           
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        
         if (e.getSource() == f_hom.b_add_vehicule) {
           
            if (f_hom.txt_marque.getText().equals("") || f_hom.txt_immatricule.getText().equals("") || f_hom.txt_nbre_vh.getText().equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp");
            }else {
               
            String marque = f_hom.txt_marque.getText();
            String immatricule = f_hom.txt_immatricule.getText();
            String nbre_place = f_hom.txt_nbre_vh.getText();
           
           vehicule_cl add_veh = new vehicule_cl(marque, immatricule,Integer.parseInt(nbre_place));
           add_veh.ajouter_vehicule();
           
           JOptionPane.showMessageDialog(null, add_veh.getInfo());
           vider_vehicule();
           listTable_vehicuele(f_hom.table_vehicule);
           this.f_hom.txt_id_veh.setEditable(false);
           
            }
            
        }
        
        if (e.getSource() == f_hom.b_actualiser_vehicule) {
            vider_vehicule();
           f_hom.txt_id_veh.setEditable(true);
           f_hom.b_add_vehicule.setEnabled(true);
           f_hom.b_delete_vehicule.setEnabled(false);
           f_hom.b_modifier_vehicule.setEnabled(false);
            
            listTable_vehicuele(f_hom.table_vehicule);
            this.f_hom.txt_id_veh.setEditable(false);
        }
        
        if (e.getSource() == f_hom.b_modifier_vehicule) {
          
           if (f_hom.txt_marque.getText().equals("") || f_hom.txt_immatricule.getText().equals("") || f_hom.txt_nbre_vh.getText().equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp");
            }else {
               
             int id = Integer.parseInt(f_hom.txt_id_veh.getText());
              
            String marque = f_hom.txt_marque.getText();
            String immatricule = f_hom.txt_immatricule.getText();
            String nbre_place = f_hom.txt_nbre_vh.getText();
           
           vehicule_cl mod_veh = new vehicule_cl(marque, immatricule, Integer.parseInt(nbre_place), id);
           mod_veh.modifier_vehicule();
           
           JOptionPane.showMessageDialog(null, mod_veh.getInfo());
           vider_vehicule();
           listTable_vehicuele(f_hom.table_vehicule);
           this.f_hom.txt_id_veh.setEditable(false);
           
           
            }
        }
        
        if (e.getSource() == f_hom.b_delete_vehicule) {
            
          if (f_hom.txt_id_veh.getText().equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez selectionner un element");
            }  else {
               
             int id = Integer.parseInt(f_hom.txt_id_veh.getText());
              
            
           vehicule_cl del_veh = new vehicule_cl(id);
           del_veh.supprimer_vehicule();
           JOptionPane.showMessageDialog(null, del_veh.getInfo());
           
           vider_vehicule();
            f_hom.txt_id_veh.setEditable(false);
            f_hom.b_add_vehicule.setEnabled(true);
            f_hom.b_delete_vehicule.setEnabled(false);
            f_hom.b_modifier_vehicule.setEnabled(false);
            listTable_vehicuele(f_hom.table_vehicule);
           
            }  
        }
        
       if (e.getSource() == f_hom.b_voir_nbre_place) {
            
           String txt_aff = f_hom.txt_affi_nbr_place.getText();
            String txt_saisir = f_hom.txt_verif_nbr_place.getText();
            
            vehicule_cl aff_nb_place = new vehicule_cl(txt_saisir);
            aff_nb_place.affiche_nbr_place();
            
            //JOptionPane.showMessageDialog(null, aff_nb_place.getNombre_place());
         //f_hom.j_affi_nbr.
           f_hom.txt_affi_nbr_place.setText(String.valueOf(aff_nb_place.getNombre_place()));
            
        }
       // ======================================= action Performed du personnel =================================================================
       
       if (e.getSource() == f_hom.b_add_personnel) {
           
            if (f_hom.txt_matricule.getText().equals("") || f_hom.com_identite.getSelectedItem() == null) {
              
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp");
            }else {
               
            String matricule = f_hom.txt_matricule.getText();
            identite ident;
            
            ident = (identite)f_hom.com_identite.getSelectedItem();
          
           personnel_cl add_perso = new personnel_cl(ident, matricule);
           add_perso.ajoute_personnel();
           
           JOptionPane.showMessageDialog(null, add_perso.getInfo());
           vider_personnel();
           
           listTable_personnel(f_hom.table_personnel);
           this.f_hom.txt_id_personnel.setEditable(false);
           this.f_hom.b_modifier_personnel.setEnabled(false);
           this.f_hom.b_delete_perosnnel.setEnabled(false);
           
            }
            
        }
       
       if (e.getSource() == f_hom.b_modifier_personnel) {
          
            if (f_hom.txt_id_personnel.equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp");
            }else {
                if(JOptionPane.showConfirmDialog(null, "Voulez-vous modifier "+f_hom.txt_matricule.getText()+" ?","Modification du Personnel",JOptionPane.YES_NO_OPTION)
                == JOptionPane.OK_OPTION){
                    
          identite iden;
           
           
            iden = (identite)f_hom.com_identite.getSelectedItem();
            String matricule = f_hom.txt_matricule.getText();
            
               
             int id = Integer.parseInt(f_hom.txt_id_personnel.getText());
              
          
           personnel_cl mod_pers = new personnel_cl(id, iden, matricule);
           JOptionPane.showMessageDialog(null, mod_pers.getInfo());
          
            listTable_personnel(f_hom.table_personnel);
            vider_personnel();
            
            this.f_hom.txt_id_personnel.setEditable(false);
              f_hom.b_modifier_personnel.setVisible(false);
             f_hom.b_delete_perosnnel.setVisible(false);
             f_hom.b_add_personnel.setVisible(true);
           
                }
            }
        }
         
       if (e.getSource() == f_hom.b_delete_perosnnel) {
            
          if (f_hom.txt_id_personnel.getText().equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez selectionner un element");
            }  else {
               if(JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer "+f_hom.txt_matricule.getText()+" ?","Suppression du Personnel",JOptionPane.YES_NO_OPTION)
                == JOptionPane.OK_OPTION){
               
             int id = Integer.parseInt(f_hom.txt_id_personnel.getText());
              
            personnel_cl del_pers = new personnel_cl(id);
          
           JOptionPane.showMessageDialog(null, del_pers.getInfo());
           
           vider_personnel();
           
           f_hom.txt_id_personnel.setEditable(false);
            f_hom.b_add_personnel.setEnabled(true);
            f_hom.b_delete_perosnnel.setEnabled(false);
            f_hom.b_modifier_personnel.setEnabled(false);
            
            listTable_personnel(f_hom.table_personnel);
           
            }
          }  
        }
        if (e.getSource() == f_hom.b_actualiser_personnel) {
            vider_personnel();
            
        }
        
        //========================================= action performed pour la fonction =========================================
        
         if (e.getSource() == f_hom.b_add_fonction) {
           
            if (f_hom.txt_nom_fonction.getText().equals("") || f_hom.txt_salaire.getText().equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp");
            }else {
               
            String nom_fonction = f_hom.txt_nom_fonction.getText();
            String salaire = f_hom.txt_salaire.getText();
            
           
           fonction_cl add_fonct = new fonction_cl(nom_fonction, Float.parseFloat(salaire));
           add_fonct.ajouter_fonction();
           
           JOptionPane.showMessageDialog(null, add_fonct.getInfo());
           vider_fonction();
           listTable_fonction(f_hom.table_fonction);
           this.f_hom.txt_id_fonction.setEditable(false);
           listTable_personnel_fonction_all(f_hom.table_all_personnel_fonction);
           
            }
            
        }
        
        if (e.getSource() == f_hom.b_actualiser_fonction) {
            vider_fonction();
           f_hom.txt_id_fonction.setEditable(true);
           f_hom.b_add_fonction.setEnabled(true);
           f_hom.b_delete_fonction.setEnabled(false);
           f_hom.b_modifier_fonction.setEnabled(false);
            
            listTable_fonction(f_hom.table_fonction);
            this.f_hom.txt_id_fonction.setEditable(false);
        }
        
        if (e.getSource() == f_hom.b_modifier_fonction) {
          
           if (f_hom.txt_nom_fonction.getText().equals("") || f_hom.txt_salaire.getText().equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp");
            }else {
               
             int id = Integer.parseInt(f_hom.txt_id_fonction.getText());
              
            String nom_fonction = f_hom.txt_nom_fonction.getText();
            String salaire = f_hom.txt_salaire.getText();
           
           fonction_cl mod_fonct = new fonction_cl(id,nom_fonction, Float.parseFloat(salaire));
           mod_fonct.modifier_fonction();
           
           JOptionPane.showMessageDialog(null, mod_fonct.getInfo());
           vider_fonction();
           listTable_fonction(f_hom.table_fonction);
           this.f_hom.txt_id_fonction.setEditable(false);
           listTable_personnel_fonction_all(f_hom.table_all_personnel_fonction);
           
           
            }
        }
        
        if (e.getSource() == f_hom.b_delete_fonction) {
            
          if (f_hom.txt_id_fonction.getText().equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez selectionner un element");
            }  else {
               
             int id = Integer.parseInt(f_hom.txt_id_fonction.getText());
              
            
           fonction_cl del_fonc = new fonction_cl(id);
           del_fonc.supprimer_fonction();
           
           JOptionPane.showMessageDialog(null, del_fonc.getInfo());
           
           vider_fonction();
            f_hom.txt_id_fonction.setEditable(false);
            f_hom.b_add_fonction.setEnabled(true);
            f_hom.b_delete_fonction.setEnabled(false);
            f_hom.b_modifier_fonction.setEnabled(false);
            listTable_fonction(f_hom.table_fonction);
            listTable_personnel_fonction_all(f_hom.table_all_personnel_fonction);
           
            }  
        }
     //=============================================action performed personnel_fonction =======================================================
     //========================================================================================================================================
        
         if (e.getSource() == f_hom.b_add_personnel_fonction) {
             fonction_cl fonc;
           personnel_cl pers;
           
           
            fonc = (fonction_cl)f_hom.com_fonction.getSelectedItem();
            pers = (personnel_cl)f_hom.com_personnel.getSelectedItem();
            
            SimpleDateFormat formatFecha = new SimpleDateFormat("yyyy-MM-dd");
            
            String date_entree = formatFecha.format(f_hom.date_entree_pers_fonct.getDate());
            
             
            
             if (f_hom.date_sortie_pers_fonct.getDate()==null) {
                 
                 personnel_fonction add_per_fonc = new personnel_fonction(pers, fonc, date_entree);
             add_per_fonc.ajouter_personnel_fonction1();
            
            JOptionPane.showMessageDialog(null, add_per_fonc.getInfo());
            
               listTable_personnel_fonction_all(f_hom.table_all_personnel_fonction);
               listTable_personnel_fonction(f_hom.table_personnel_fonction);
               
             f_hom.b_modifier_personnel_fonction.setVisible(false);
             f_hom.b_delete_personnel_fonction.setVisible(false);  
             }
             else {
                 
                  
            SimpleDateFormat formatFecha1 = new SimpleDateFormat("yyyy-MM-dd");
            
             String date_sortie = formatFecha1.format(f_hom.date_sortie_pers_fonct.getDate());
                 
                 personnel_fonction add_per_fonc = new personnel_fonction(pers, fonc, date_entree, date_sortie);
           add_per_fonc.ajouter_personnel_fonction();
            
            JOptionPane.showMessageDialog(null, add_per_fonc.getInfo());
            
               listTable_personnel_fonction_all(f_hom.table_all_personnel_fonction);
               listTable_personnel_fonction(f_hom.table_personnel_fonction);
               
             f_hom.b_modifier_personnel_fonction.setVisible(false);
             f_hom.b_delete_personnel_fonction.setVisible(false);
             }
          
            
            
         }
        
         if (e.getSource() == f_hom.b_modifier_personnel_fonction) {
          
             int id = f_hom.table_personnel_fonction.getSelectedRowCount();
             
            if (f_hom.txt_id_personnel_fonction.equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp");
            }else {
                if(JOptionPane.showConfirmDialog(null, "Voulez-vous modifier "+ f_hom.table_personnel_fonction.getValueAt(id, 1)+" ?","Modification du Personnel lié à la Fonction",JOptionPane.YES_NO_OPTION)
                == JOptionPane.OK_OPTION){
                    
           fonction_cl fonc;
           personnel_cl pers;
           
            fonc = (fonction_cl)f_hom.com_fonction.getSelectedItem();
            pers = (personnel_cl)f_hom.com_personnel.getSelectedItem();
               
             int id1 = Integer.parseInt(f_hom.txt_id_personnel_fonction.getText());
              
          personnel_fonction mod_pf = new personnel_fonction();
          mod_pf.modifier_personnel_fonction();
           
           JOptionPane.showMessageDialog(null, mod_pf.getInfo());
          
            listTable_personnel_fonction_all(f_hom.table_all_personnel_fonction);
            listTable_personnel_fonction(f_hom.table_personnel_fonction);
               
             f_hom.b_modifier_personnel_fonction.setVisible(false);
             f_hom.b_delete_personnel_fonction.setVisible(false); 
           
             f_hom.b_add_personnel_fonction.setVisible(true);
           
                }
            }
        }
         
       if (e.getSource() == f_hom.b_delete_personnel_fonction) {
            
         int id = f_hom.table_personnel_fonction.getSelectedRowCount();
             
            if (f_hom.txt_id_personnel_fonction.equals("")) {
              
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp");
            }else {
                if(JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer "+ f_hom.table_personnel_fonction.getValueAt(id, 1)+" ?","Suppression du Personnel lié à la Fonction",JOptionPane.YES_NO_OPTION)
                == JOptionPane.OK_OPTION){
               
             int id1 = Integer.parseInt(f_hom.txt_id_personnel_fonction.getText());
              
            personnel_fonction del_pf = new personnel_fonction(id1);
            del_pf.supprimer_personnel_fonction();
          
           JOptionPane.showMessageDialog(null, del_pf.getInfo());
           
          listTable_personnel_fonction_all(f_hom.table_all_personnel_fonction);
            listTable_personnel_fonction(f_hom.table_personnel_fonction);
               
             f_hom.b_modifier_personnel_fonction.setVisible(false);
             f_hom.b_delete_personnel_fonction.setVisible(false); 
           
             f_hom.b_add_personnel_fonction.setVisible(true);
           
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
    

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
           if (e.getSource() == f_hom.table_vehicule) {
            
        
        int id = f_hom.table_vehicule.getSelectedRow();
            
            f_hom.txt_id_veh.setEditable(false);
            f_hom.txt_id_veh.setText(String.valueOf(f_hom.table_vehicule.getValueAt(id, 0)));
            f_hom.txt_marque.setText(String.valueOf(f_hom.table_vehicule.getValueAt(id, 1)));
            f_hom.txt_immatricule.setText(String.valueOf(f_hom.table_vehicule.getValueAt(id, 2)));
             f_hom.txt_nbre_vh.setText(String.valueOf(f_hom.table_vehicule.getValueAt(id, 3)));
           
         
             f_hom.b_add_vehicule.setEnabled(false);
             f_hom.b_delete_vehicule.setEnabled(true);
             f_hom.b_modifier_vehicule.setEnabled(true);
            
       }
           
           if (e.getSource() == f_hom.table_personnel) {
            
        
        int id = f_hom.table_personnel.getSelectedRow();
            
            f_hom.txt_id_personnel.setEditable(false);
            
            identite index;
            //index = 
           
            f_hom.txt_id_personnel.setText(String.valueOf(f_hom.table_personnel.getValueAt(id, 0)));
           
            //f_hom.txt_marque.setText(String.valueOf(f_hom.table_personnel.getValueAt(id, 1)));
     
            //ident.addItem(new identite(result.getString("nom"), result.getString("CNI"), result.getInt("idpersonne")));
            
            //f_hom.com_identite.setSelectedItem(String.valueOf(new identite(f_hom.table_personnel.get, null, id)));
            
            f_hom.txt_matricule.setText(String.valueOf(f_hom.table_personnel.getValueAt(id, 2)));
           
           
         
             f_hom.b_add_personnel.setEnabled(false);
             f_hom.b_delete_perosnnel.setEnabled(true);
             f_hom.b_modifier_personnel.setEnabled(true);
            
       }
           
            if (e.getSource() == f_hom.table_fonction) {
            
        
        int id = f_hom.table_fonction.getSelectedRow();
            
            f_hom.txt_id_fonction.setEditable(false);
            f_hom.txt_id_fonction.setText(String.valueOf(f_hom.table_fonction.getValueAt(id, 0)));
            f_hom.txt_nom_fonction.setText(String.valueOf(f_hom.table_fonction.getValueAt(id, 1)));
            f_hom.txt_salaire.setText(String.valueOf(f_hom.table_fonction.getValueAt(id, 2)));
             
         
             f_hom.b_add_fonction.setEnabled(false);
             f_hom.b_delete_fonction.setEnabled(true);
             f_hom.b_modifier_fonction.setEnabled(true);
            
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
       personnel_cl perso;
       
        if(e!=null){
          perso = (personnel_cl)e.getItem(); 
        } 
    }
    
}

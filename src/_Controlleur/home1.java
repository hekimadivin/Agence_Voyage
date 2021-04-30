/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _Controlleur;

import Vue.HOME1;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author edmm
 */
public class home1 implements ActionListener, MouseListener{

    HOME1 hom1 = new HOME1();
   
    
    public home1(HOME1 home1){
        
        this.hom1 = home1;
        this.hom1.adresse.addMouseListener(this);
        this.hom1.identite.addMouseListener(this);
        this.hom1.home1.addMouseListener(this);
        this.hom1.b_Vehicule.addMouseListener(this);
        this.hom1.programme.addMouseListener(this);
        this.hom1.voyage.addMouseListener(this);
        this.hom1.fonction.addMouseListener(this);
        this.hom1.personnel.addMouseListener(this);
        
        this.hom1.bt_ajout_chauff_prog.addActionListener(this);
        this.hom1.bt_ajout_veh_prog.addActionListener(this);
        this.hom1.bt_ajout_prog.addActionListener(this);
        this.hom1.bt_fermer_sous_menu.addActionListener(this);
        
        this.hom1.b_sous_voy_course.addActionListener(this);
         this.hom1.b_sous_voy_voyage.addActionListener(this);
          this.hom1.b_sous_voy_reservation.addActionListener(this);
           this.hom1.b_voir_nbre_place.addActionListener(this);
            this.hom1.b_sous_voy_fermer.addActionListener(this);
            
            this.hom1.b_sous_fonction.addActionListener(this);
            this.hom1.b_sous_personnel_fonction.addActionListener(this);
            this.hom1.b_fermer_personnel_fonction.addActionListener(this);
            this.hom1.b_sous_actualiser_personnel_fonction.addActionListener(this);
      
       
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == hom1.bt_ajout_prog) {
            
            hom1.jP_prog_chauffeur.setVisible(false);
            hom1.jP_prog_vehicule.setVisible(false);
            hom1.jP_programme.setVisible(true);
        }
      
        if (e.getSource() == hom1.bt_ajout_chauff_prog) {
            
            hom1.jP_prog_chauffeur.setVisible(true);
            hom1.jP_prog_vehicule.setVisible(false);
            hom1.jP_programme.setVisible(false);
         
        }
        
         if (e.getSource() == hom1.bt_ajout_veh_prog) {
            
            hom1.jP_prog_chauffeur.setVisible(false);
            hom1.jP_prog_vehicule.setVisible(true);
            hom1.jP_programme.setVisible(false);
         
        }
         
        if (e.getSource() == hom1.bt_fermer_sous_menu) {
            
            hom1.jP_prog_chauffeur.setVisible(false);
            hom1.jP_prog_vehicule.setVisible(false);
            hom1.jP_programme.setVisible(false);
        }
        
        if (e.getSource() == hom1.b_sous_voy_reservation) {
            
            hom1.jp_sous_reservation.setVisible(true);
            hom1.jp_sous_course.setVisible(false);
            hom1.jp_sous_voir_place_dispo.setVisible(false);
            hom1.jp_sous_voyage.setVisible(false);
            
        }
        
       if (e.getSource() == hom1.b_sous_voy_fermer) {
            
            hom1.jp_sous_reservation.setVisible(false);
            hom1.jp_sous_course.setVisible(false);
            hom1.jp_sous_voir_place_dispo.setVisible(false);
            hom1.jp_sous_voyage.setVisible(false);
            
        }
       
        if (e.getSource() == hom1.b_sous_voy_course) {
            
            hom1.jp_sous_reservation.setVisible(false);
            hom1.jp_sous_course.setVisible(true);
            hom1.jp_sous_voir_place_dispo.setVisible(false);
            hom1.jp_sous_voyage.setVisible(false);
            
        }
       if (e.getSource() == hom1.b_voir_nbre_place) {
            
            hom1.jp_sous_reservation.setVisible(false);
            hom1.jp_sous_course.setVisible(false);
            hom1.jp_sous_voir_place_dispo.setVisible(true);
            hom1.jp_sous_voyage.setVisible(false);
            
        }
       
        if (e.getSource() == hom1.b_sous_voy_voyage) {
            
            hom1.jp_sous_reservation.setVisible(false);
            hom1.jp_sous_course.setVisible(false);
            hom1.jp_sous_voir_place_dispo.setVisible(false);
            hom1.jp_sous_voyage.setVisible(true);
            
        }
        
         if (e.getSource() == hom1.b_sous_fonction) {
            
            hom1.P_sous_fonction.setVisible(true);
            hom1.P_sous_personnel_fonction.setVisible(false);
         
        }
         
          if (e.getSource() == hom1.b_sous_personnel_fonction) {
            
            hom1.P_sous_fonction.setVisible(false);
            hom1.P_sous_personnel_fonction.setVisible(true);
         
        }
      if (e.getSource() == hom1.b_fermer_personnel_fonction) {
            
            hom1.P_sous_fonction.setVisible(false);
            hom1.P_sous_personnel_fonction.setVisible(false);
         
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == hom1.adresse) {
            
            hom1.P_adresse.setVisible(true);
            hom1.P_identite.setVisible(false);
            hom1.P_Home.setVisible(false);
            hom1.P_vehicule.setVisible(false);
            hom1.P_programme.setVisible(false);
             hom1.P_voyage.setVisible(false);
             hom1.P_personnel.setVisible(false);
             hom1.P_fonction.setVisible(false);
          
            
        }
        
         if (e.getSource() == hom1.personnel) {
            
            hom1.P_adresse.setVisible(false);
            hom1.P_identite.setVisible(false);
            hom1.P_Home.setVisible(false);
            hom1.P_vehicule.setVisible(false);
            hom1.P_programme.setVisible(false);
             hom1.P_voyage.setVisible(false);
             hom1.P_personnel.setVisible(true);
             hom1.P_fonction.setVisible(false);
          
            
        }
        
        if (e.getSource() == hom1.identite) {
            
            hom1.P_adresse.setVisible(false);
            hom1.P_identite.setVisible(true);
            hom1.P_Home.setVisible(false);
            hom1.P_vehicule.setVisible(false);
            hom1.P_programme.setVisible(false);
             hom1.P_voyage.setVisible(false);
             hom1.P_personnel.setVisible(false);
             hom1.P_fonction.setVisible(false);
          
           
        }
       if (e.getSource() == hom1.home1) {
            
            hom1.P_Home.setVisible(true);
            hom1.P_adresse.setVisible(false);
            hom1.P_identite.setVisible(false);
            hom1.P_vehicule.setVisible(false);
            hom1.P_programme.setVisible(false);
            hom1.P_personnel.setVisible(false);
             hom1.P_voyage.setVisible(false);
             hom1.P_fonction.setVisible(false);
          
        }
       if (e.getSource() == hom1.b_Vehicule) {
            
            hom1.P_vehicule.setVisible(true);
            hom1.P_adresse.setVisible(false);
            hom1.P_identite.setVisible(false);
            hom1.P_Home.setVisible(false);
            hom1.P_programme.setVisible(false);
             hom1.P_voyage.setVisible(false);
             hom1.P_personnel.setVisible(false);
           hom1.P_fonction.setVisible(false);
           
        }
       
      if (e.getSource() == hom1.programme) {
            
            hom1.P_programme.setVisible(true);
            hom1.P_vehicule.setVisible(false);
            hom1.P_adresse.setVisible(false);
            hom1.P_identite.setVisible(false);
            hom1.P_Home.setVisible(false);
             hom1.P_voyage.setVisible(false);
             hom1.P_personnel.setVisible(false);
           hom1.P_fonction.setVisible(false);
            // sous menu
           
            hom1.jP_prog_chauffeur.setVisible(false);
            hom1.jP_prog_vehicule.setVisible(false);
            hom1.jP_programme.setVisible(false);
            
          
        }
      
      if (e.getSource() == hom1.voyage) {
            
            hom1.P_voyage.setVisible(true);
            hom1.P_vehicule.setVisible(false);
            hom1.P_adresse.setVisible(false);
            hom1.P_identite.setVisible(false);
            hom1.P_Home.setVisible(false);
            hom1.P_programme.setVisible(false);
            hom1.P_personnel.setVisible(false);
             hom1.P_fonction.setVisible(false);
            
            //sous menu
            
            hom1.jp_sous_course.setVisible(false);
            hom1.jp_sous_voyage.setVisible(false);
            hom1.jp_sous_reservation.setVisible(false);
            hom1.jp_sous_voir_place_dispo.setVisible(false);
           
           
        } 
      
       if (e.getSource() == hom1.fonction) {
            
           hom1.P_fonction.setVisible(true);
           hom1.P_vehicule.setVisible(false);
            hom1.P_adresse.setVisible(false);
            hom1.P_identite.setVisible(false);
            hom1.P_Home.setVisible(false);
            hom1.P_programme.setVisible(false);
             hom1.P_voyage.setVisible(false);
             hom1.P_personnel.setVisible(false);
             
             hom1.P_sous_fonction.setVisible(false);
             hom1.P_sous_personnel_fonction.setVisible(false);
           
           
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

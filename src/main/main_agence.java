/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Vue.HOME1;
import Model.adresse_cl;
import Model.fonction_cl;
import Model.identite;
import Model.personnel_cl;
import Model.programme_cl;
import Model.vehicule_cl;
import Model.vehicule_programme_cl;
import _Controlleur.const_adresse;
import _Controlleur.const_identite;
import _Controlleur.const_programme;
import _Controlleur.const_utilisateur;
import _Controlleur.home1;


/**
 *
 * @author edmm
 */
public class main_agence {
    
    public static void main(String[] args) {
       
    HOME1 h = new HOME1();
    adresse_cl ad = new adresse_cl();
    identite iden = new identite();
    vehicule_cl veh = new vehicule_cl();
    fonction_cl fonc = new fonction_cl();
    home1 h1 = new home1(h);
    programme_cl pr = new programme_cl();
    vehicule_programme_cl ve_p = new vehicule_programme_cl();
    personnel_cl pers = new personnel_cl();
    
    const_adresse cons = new const_adresse(h, ad);
    const_identite indent = new const_identite(h, iden,pers);
    const_utilisateur vehicul = new const_utilisateur(h, veh,fonc);
    const_programme prog = new const_programme(h, pr,ve_p);
    
    
    h.setVisible(true);
    h.setLocationRelativeTo(null);
    
     h.P_Home.setVisible(true);
     h.P_identite.setVisible(false);
     h.P_adresse.setVisible(false);
     h.masculin.setSelected(true);
     h.txt_id_ident.setEditable(false);
     h.txt_id_veh.setEditable(false);
     h.P_vehicule.setVisible(false);
     h.P_programme.setVisible(false);
     h.P_voyage.setVisible(false);
     h.P_personnel.setVisible(false);
     h.P_fonction.setVisible(false);
     h.P_agence.setVisible(false);
   
     
    
    }
    
}

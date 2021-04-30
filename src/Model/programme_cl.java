/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import db.db_Mysql;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author edmm
 */
public class programme_cl {
    
    Statement st = null;
    ResultSet rs = null;
    
    	private int idprogramme;	
        private String date_p, heure_p,	ville_depart, ville_arrivee, info;
        vehicule_cl marque;
        identite nom;

    public identite getNom() {
        return nom;
    }

    public void setNom(identite nom) {
        this.nom = nom;
    }
       
    public vehicule_cl getMarque() {
        return marque;
    }

    public void setMarque(vehicule_cl marque) {
        this.marque = marque;
    }
       
        

    public programme_cl(String date_p, String heure_p, String ville_depart, String ville_arrivee,int idprogramme) {
        this.idprogramme = idprogramme;
        this.date_p = date_p;
        this.heure_p = heure_p;
        this.ville_depart = ville_depart;
        this.ville_arrivee = ville_arrivee;
        
    }
    
    public programme_cl(String date_p, String heure_p, String ville_depart, String ville_arrivee) {
        
        this.date_p = date_p;
        this.heure_p = heure_p;
        this.ville_depart = ville_depart;
        this.ville_arrivee = ville_arrivee;
        
    }

    public programme_cl() {
    }
   public programme_cl(int id) {
       this.idprogramme = id;
    }
   
   
    
    public programme_cl(int id,String date, String heure) {
       this.idprogramme = id;
       this.date_p = date;
       this.heure_p = heure;
      
    }

       public String toString(){
        return ""+date_p+"-"+heure_p;
        
    }
        public int getIdprogramme() {
        return idprogramme;
    }

    public void setIdprogramme(int idprogramme) {
        this.idprogramme = idprogramme;
    }
    
    public String getDate_p() {
        return date_p;
    }

    public void setDate_p(String date_p) {
        this.date_p = date_p;
    }

    public String getHeure_p() {
        return heure_p;
    }

    public void setHeure_p(String heure_p) {
        this.heure_p = heure_p;
    }

    public String getVille_depart() {
        return ville_depart;
    }

    public void setVille_depart(String ville_depart) {
        this.ville_depart = ville_depart;
    }

    public String getVille_arrivee() {
        return ville_arrivee;
    }

    public void setVille_arrivee(String ville_arrivee) {
        this.ville_arrivee = ville_arrivee;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
        
    public void ajoute_programme(){
      
      String req = "insert into programme (date_p,heure_p,ville_depart,ville_arrivee) values "
              + "('"+this.date_p+"','"+this.heure_p+"','"+this.ville_depart+"','"+this.ville_arrivee+"')";
      	
      if(db_Mysql.updateData(req)>0){
          info="Félicitation, operation bien effectuée";
      }else info="Desolé, operation echouée" ;
      
             System.out.println("la requete= "+req);
  } 
    
    public void modifier_programme(){
       
     
        String req1="update programme set date_p = '"+this.date_p+"',heure_p = '"+this.heure_p+"',"
                + " ville_depart = '"+this.ville_depart+"', ville_arrivee = '"+this.ville_arrivee+"' where idprogramme ='"+this.idprogramme+"'";
        
        if(db_Mysql.updateData(req1)>0)
           info="le programme a été modifié avec succes";
        else info="Désolé, le programme n'a pas été modifié";
    }
       
 
     public void supprimer_programme(){
       
        String req = "delete from programme where idprogramme ='"+this.idprogramme+"'";
       
        if(db.db_Mysql.updateData(req)>0) {
           
            info = "Félicitation, l'Operation a été bien effectuée";
          
        }else info = "Désolé, l'Operation n'a pas été bien effectueée";
       
   }
         
   public ArrayList<programme_cl> List_programme(){
       
        ArrayList List_programme = new ArrayList();
        programme_cl prog;

        try {
            String req = "select * from  programme";
            st = db.db_Mysql.extraireData_Prepared(req);
            rs = st.executeQuery(req);

            while (rs.next()) {
              prog = new programme_cl();

                
            prog.setIdprogramme(rs.getInt(1));
             prog.setDate_p(rs.getString(2));
             prog.setHeure_p(rs.getString(3));
             prog.setVille_depart(rs.getString(4));
             prog.setVille_arrivee(rs.getString(5));
                
                List_programme.add(prog);

            }

        } catch (Exception e) {
        }

        return List_programme;
    }
   
    public ArrayList<programme_cl> List_programme_all(){
       
        ArrayList List_programme_all = new ArrayList();
        programme_cl prog_all;

        try {
            String req = "select distinct personne.nom,vehicule.marque,programme.date_p,programme.heure_p"
                    + ",programme.ville_depart,programme.ville_arrivee\n" +
"from personne,vehicule,programme,programme_personnel,vehicule_programme,personnel\n" +
"where personnel.idpersonnel = programme_personnel.idpersonnel\n" +
"and vehicule_programme.idvehicule = vehicule.idvehicule\n" +
"and programme.idprogramme = vehicule_programme.idprogramme\n" +
"and programme.idprogramme = programme_personnel.idprogramme\n" +
"and personne.idpersonne = personnel.idpersonne";
            st = db.db_Mysql.extraireData_Prepared(req);
            rs = st.executeQuery(req);

            while (rs.next()) {
              prog_all = new programme_cl();

                
            prog_all.setNom(new identite(rs.getString("nom")));
             prog_all.setMarque(new vehicule_cl(rs.getString("marque")));
             prog_all.setDate_p(rs.getString(3));
             prog_all.setHeure_p(rs.getString(4));
             prog_all.setVille_depart(rs.getString(5));
             prog_all.setVille_arrivee(rs.getString(6));
                
                List_programme_all.add(prog_all);

            }

        } catch (Exception e) {
        }

        return List_programme_all;
    }
}

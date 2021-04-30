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
public class fonction_cl {
    
    Statement st = null;
    ResultSet rs = null;
    private int idfonction;
    private String nom_fonction , info;
    private Float salaire;

    public fonction_cl(int idfonction, String nom_fonction, Float salaire) {
        this.idfonction = idfonction;
        this.nom_fonction = nom_fonction;  
        this.salaire = salaire;
    }
    
     public fonction_cl(int idfonction, String nom_fonction) {
        this.idfonction = idfonction;
        this.nom_fonction = nom_fonction;
           
    }
    
     public fonction_cl(String nom_fonction, Float salaire) {
        
        this.nom_fonction = nom_fonction;
        
        this.salaire = salaire;
    }
     
     public fonction_cl(int idfonction) {
        this.idfonction = idfonction;
       
    }

    public fonction_cl() {
    }
    
   public String toString(){
       return ""+nom_fonction;
   } 
    
    public int getIdfonction() {
        return idfonction;
    }

    public void setIdfonction(int idfonction) {
        this.idfonction = idfonction;
    }

    public String getNom_fonction() {
        return nom_fonction;
    }

    public void setNom_fonction(String nom_fonction) {
        this.nom_fonction = nom_fonction;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Float getSalaire() {
        return salaire;
    }

    public void setSalaire(Float salaire) {
        this.salaire = salaire;
    }
 
    //**************************************************************************
    
    public void ajouter_fonction(){
        
        String req = "insert into fonction (nom_fonction,salaire) values ('"+this.nom_fonction+"','"+this.salaire+"')";
       
        if(db.db_Mysql.updateData(req)>0) {
           
            info = "Félicitation, l'Operation a été bien effectuée";
          
        }else info = "Désolé, l'Operation n'a pas été bien effectueée";
    }
    
   public void modifier_fonction(){
       
     
        String req1="update fonction set nom_fonction = '"+this.nom_fonction+"',salaire = '"+this.salaire+"' where idfonction ='"+this.idfonction+"'";
        
        if(db_Mysql.updateData(req1)>0)
           info="la fonction a été modifiée avec succes";
        else info="Désolé, la fonction n'a pas été modifiée";
    }
       
 
     public void supprimer_fonction(){
       
        String req = "delete from fonction where idfonction ='"+this.idfonction+"'";
       
        if(db.db_Mysql.updateData(req)>0) {
           
            info = "Félicitation, l'Operation a été bien effectuée";
          
        }else info = "Désolé, l'Operation n'a pas été bien effectueée";
       
   }
     
   public ArrayList<fonction_cl> List_fonction() {
       
        ArrayList List_fonction = new ArrayList();
        fonction_cl fonc;

        try {
            String req = "select * from  fonction";
            st = db.db_Mysql.extraireData_Prepared(req);
            rs = st.executeQuery(req);

            while (rs.next()) {
               fonc = new fonction_cl();

                
             fonc.setIdfonction(Integer.parseInt(rs.getString(1)));
                fonc.setNom_fonction(rs.getString(2));
              fonc.setSalaire(rs.getFloat(3));
               
                
                List_fonction.add(fonc);

            }

        } catch (Exception e) {
        }

        return List_fonction;
    }
   
    public ArrayList<fonction_cl> Recherche_fonction() {

        ArrayList<fonction_cl> List_fonction= new ArrayList();
       fonction_cl fonc;

        try {

            String req1 ="SELECT * FROM fonction WHERE nom_fonction like '%"+this.nom_fonction+"%'";
           
            st = db_Mysql.extraireData_Prepared(req1);
            rs = st.executeQuery(req1);

            while (rs.next()) {
                
                fonc = new fonction_cl();
                fonc.setIdfonction(Integer.parseInt(rs.getString(1)));
                fonc.setNom_fonction(rs.getString(2));
                fonc.setSalaire(rs.getFloat(3));
                
                List_fonction.add(fonc);
               
            }

        } catch (Exception e) {
        }

        return List_fonction;
    }
    
}



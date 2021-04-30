/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import db.db_Mysql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author edmm
 */
public class agence_cl {
   
    Statement st = null;
    ResultSet rs = null;
    private int idagence;
    adresse_cl idAdresse;
    String nom_agence,info;

    public agence_cl() {
    }
  
    public agence_cl(int idagence, adresse_cl idAdresse, String nom_agence) {
        this.idagence = idagence;
        this.idAdresse = idAdresse;
        this.nom_agence = nom_agence;
        
    }
  public agence_cl( adresse_cl idAdresse, String nom_agence) {
        this.idAdresse = idAdresse;
        this.nom_agence = nom_agence;
        
    }   
    
   public agence_cl(int idagence) {
        this.idagence = idagence;
       
    }  

    public int getIdagence() {
        return idagence;
    }

    public void setIdagence(int idagence) {
        this.idagence = idagence;
    }

    public adresse_cl getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(adresse_cl idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getNom_agence() {
        return nom_agence;
    }

    public void setNom_agence(String nom_agence) {
        this.nom_agence = nom_agence;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
   //**************************************************************************
    
    public void ajouter_agence(){
        
        String req = "insert into agences (idAdresse,nom_agence) values ('"+this.idAdresse.getIdadresse()+"','"+this.nom_agence+"')";
       
        if(db.db_Mysql.updateData(req)>0) {
           
            info = "Félicitation, l'Operation a été bien effectuée";
          
        }else info = "Désolé, l'Operation n'a pas été bien effectueée";
    }
    
   public void modifier_agence(){
       
     
        String req1="update agences set idAdresse = '"+this.idAdresse.getIdadresse()+"',nom_agence = '"+this.nom_agence+"' where idagence ='"+this.idagence+"'";
        
        if(db_Mysql.updateData(req1)>0)
           info="l'agence a été modifiée avec succes";
        else info="Désolé, l'agence n'a pas été modifiée";
    }
       
 
     public void supprimer_fonction(){
       
        String req = "delete from agences where idagence ='"+this.idagence+"'";
       
        if(db.db_Mysql.updateData(req)>0) {
           
            info = "Félicitation, l'Operation a été bien effectuée";
          
        }else info = "Désolé, l'Operation n'a pas été bien effectueée";
       
   }
     
   public ArrayList<agence_cl> List_agence() {
       
        ArrayList List_agence = new ArrayList();
        agence_cl agenc;

        try {
            String req = "select * from  agences";
            st = db.db_Mysql.extraireData_Prepared(req);
            rs = st.executeQuery(req);

            while (rs.next()) {
               agenc = new agence_cl();

                
             agenc.setIdagence(rs.getInt(1));
             agenc.setIdAdresse(new adresse_cl(rs.getString("quartier"), rs.getInt(2)));
             agenc.setNom_agence(rs.getString("nom_agence"));
               
                
                List_agence.add(agenc);

            }

        } catch (Exception e) {
        }

        return List_agence;
    }
   
    public static void alimenter_Com_personnel(JComboBox veh){
   
     if(veh!=null){
         try {
          veh.removeAllItems();
            //adre.addItem(new adresse(""));
             ResultSet result=db_Mysql.extraireData("select * from personne p,personnel pl\n" +
                                                    "where p.idpersonne = pl.idpersonne");
             
             if(result!=null)
                 while(result.next()){
                     
   //veh.addItem(new personnel_cl(new identite(result.getString("nom"), Integer.parseInt(result.getString("idpersonne"))), result.getString("matricule")));
    veh.addItem(new personnel_cl(result.getInt(8), new identite(result.getString(3)), result.getString("matricule")));
                 }
         } catch (SQLException m) {
               
        JOptionPane.showMessageDialog(null, ""+m.getMessage());
       System.err.println(m);}
         }
     } 
  
}

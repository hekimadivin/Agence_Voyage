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
public class personnel_fonction {
  
    Statement st = null;
    ResultSet rs = null;
    private int idpersonnel_fonction;	
    personnel_cl idpersonnel;	
    fonction_cl idfonction;
    private String date_entree;
    private String date_sortie,info;

    public personnel_fonction() {
    }
    
   
    public personnel_fonction(int idpersonnel_fonction, personnel_cl idpersonnel, fonction_cl idfonction, String date_entree, String date_sortie) {
        this.idpersonnel_fonction = idpersonnel_fonction;
        this.idpersonnel = idpersonnel;
        this.idfonction = idfonction;
        this.date_entree = date_entree;
        this.date_sortie = date_sortie;
      
    }
    
    public personnel_fonction( personnel_cl idpersonnel, fonction_cl idfonction, String date_entree, String date_sortie) {
        
        this.idpersonnel = idpersonnel;
        this.idfonction = idfonction;
        this.date_entree = date_entree;
        this.date_sortie = date_sortie;
      
    }
    
     public personnel_fonction( personnel_cl idpersonnel, fonction_cl idfonction, String date_entree) {
        
        this.idpersonnel = idpersonnel;
        this.idfonction = idfonction;
        this.date_entree = date_entree;
      
    }
   
    
    public personnel_fonction(int idpersonnel_fonction) {
        this.idpersonnel_fonction = idpersonnel_fonction;
     
    }

    public int getIdpersonnel_fonction() {
        return idpersonnel_fonction;
    }

    public void setIdpersonnel_fonction(int idpersonnel_fonction) {
        this.idpersonnel_fonction = idpersonnel_fonction;
    }

    public personnel_cl getIdpersonnel() {
        return idpersonnel;
    }

    public void setIdpersonnel(personnel_cl idpersonnel) {
        this.idpersonnel = idpersonnel;
    }

    public fonction_cl getIdfonction() {
        return idfonction;
    }

    public void setIdfonction(fonction_cl idfonction) {
        this.idfonction = idfonction;
    }

    public String getDate_entree() {
        return date_entree;
    }

    public void setDate_entree(String date_entree) {
        this.date_entree = date_entree;
    }

    public String getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(String date_sortie) {
        this.date_sortie = date_sortie;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
     public void ajouter_personnel_fonction(){
        
        String req = "insert into personnel_fonction(idpersonnel,idfonction,date_entree,date_sortie) values "
          + "('"+this.idpersonnel.getIdpersonnel()+"','"+this.idfonction.getIdfonction()+"','"+this.date_entree+"','"+this.date_sortie+"')";
       System.out.println("la requete "+req);
        if(db.db_Mysql.updateData(req)>0) {
           
            info = "Félicitation, l'Operation a été bien effectuée";
          
        }else info = "Désolé, l'Operation n'a pas été bien effectueée";
        System.out.println("la requete "+req);
    }
      public void ajouter_personnel_fonction1(){
        
        String req = "insert into personnel_fonction(idpersonnel,idfonction,date_entree,date_sortie) values "
          + "('"+this.idpersonnel.getIdpersonnel()+"','"+this.idfonction.getIdfonction()+"','"+this.date_entree+"',null)";
       System.out.println("la requete "+req);
        if(db.db_Mysql.updateData(req)>0) {
           
            info = "Félicitation, l'Operation a été bien effectuée";
          
        }else info = "Désolé, l'Operation n'a pas été bien effectueée";
        System.out.println("la requete "+req);
    }
    
   public void modifier_personnel_fonction(){
       
     
        String req1="update personnel_fonction set idpersonnel = '"+this.idpersonnel.getIdpersonnel()+"',idfonction = '"+this.idfonction.getIdfonction()+"'"
                + ",date_entree = '"+this.date_entree+"',date_sortie = '"+this.date_sortie+"'"
                + " where idpersonnel_fonction ='"+this.idpersonnel_fonction+"'";
        
        if(db_Mysql.updateData(req1)>0)
           info="le personnel lié à la fonction a été modifié avec succes";
        else info="Désolé, le personnel lié à la fonction n'a pas été modifié";
        System.out.println("la requete "+req1);
    }
       
 
     public void supprimer_personnel_fonction(){
       
        String req = "delete from personnel_fonction where idpersonnel_fonction ='"+this.idpersonnel_fonction+"'";
       
        if(db.db_Mysql.updateData(req)>0) {
           
            info = "Félicitation, l'Operation a été bien effectuée";
          
        }else info = "Désolé, l'Operation n'a pas été bien effectueée";
       
   }  
  
     public ArrayList<personnel_fonction> List_personnel_fonction() {
       
        ArrayList List_personnel_fonction = new ArrayList();
        personnel_fonction perso_fonct;

        try {
            String req = "select * from  personnel_fonction,fonction,personnel,personne\n" +
"where personnel.idpersonnel = personnel_fonction.idpersonnel\n" +
"and fonction.idfonction = personnel_fonction.idfonction\n" +
"and personne.idpersonne = personnel.idpersonne";
            st = db.db_Mysql.extraireData_Prepared(req);
            rs = st.executeQuery(req);

            while (rs.next()) {
              perso_fonct = new personnel_fonction();
              
             perso_fonct.setIdpersonnel_fonction(rs.getInt(1));
             
             perso_fonct.setIdpersonnel(new personnel_cl(new identite(rs.getString("nom"), Integer.parseInt(rs.getString("idpersonne"))),rs.getString("matricule")));
            
             perso_fonct.setIdfonction(new fonction_cl(rs.getInt(3), rs.getString("nom_fonction")));
              perso_fonct.setDate_entree(rs.getString("date_entree"));
              perso_fonct.setDate_sortie(rs.getString("date_sortie"));
             
             
                
                List_personnel_fonction.add(perso_fonct);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return List_personnel_fonction;
    }
     
     
      public ArrayList<personnel_fonction> List_personnel_fonction_all() {
       
        ArrayList List_personnel_fonction_all = new ArrayList();
        personnel_fonction perso_fonct;

        try {
            String req = "select * from  personnel_fonction,fonction,personnel,personne\n" +
"where personnel.idpersonnel = personnel_fonction.idpersonnel\n" +
"and fonction.idfonction = personnel_fonction.idfonction\n" +
"and personne.idpersonne = personnel.idpersonne";
            st = db.db_Mysql.extraireData_Prepared(req);
            rs = st.executeQuery(req);

            while (rs.next()) {
              perso_fonct = new personnel_fonction();
              
             perso_fonct.setIdpersonnel_fonction(rs.getInt(1));
             
             perso_fonct.setIdpersonnel(new personnel_cl(new identite(rs.getString("nom"),rs.getString("prenom"),rs.getString("sexe"), Integer.parseInt(rs.getString("idpersonne"))),rs.getString("matricule")));
            
             perso_fonct.setIdfonction(new fonction_cl(rs.getInt(3), rs.getString("nom_fonction"), rs.getFloat("salaire")));
             perso_fonct.setDate_entree(rs.getString("date_entree"));
              perso_fonct.setDate_sortie(rs.getString("date_sortie"));
             
                
                List_personnel_fonction_all.add(perso_fonct);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return List_personnel_fonction_all;
    }
      
  // fonction pour alimenter combobox
     public static void alimenter_Com_personnel(JComboBox per){
   
     if(per!=null){
         try {
          per.removeAllItems();
            //adre.addItem(new adresse(""));
             ResultSet result=db_Mysql.extraireData("select * from personnel , personne\n" +
"where personnel.idpersonne = personne.idpersonne");
             
             if(result!=null)
                 while(result.next()){
                     
   
    per.addItem(new personnel_cl(result.getInt(1), new identite(result.getString("nom")), result.getString("matricule")));
                 }
         } catch (SQLException m) {
               
        JOptionPane.showMessageDialog(null, ""+m.getMessage());
       System.err.println(m);}
         }
     } 
     
    public static void alimenter_Com_fonction(JComboBox fonct){
   
     if(fonct!=null){
         try {
          fonct.removeAllItems();
            //adre.addItem(new adresse(""));
             ResultSet result=db_Mysql.extraireData("select * from fonction");
             
             if(result!=null)
                 while(result.next()){
                     
                    fonct.addItem(new fonction_cl(result.getInt(1), result.getString("nom_fonction")));
                 }
         } catch (SQLException m) {
               
        JOptionPane.showMessageDialog(null, ""+m.getMessage());
       System.err.println(m);}
         }
     }
}

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class identite {
  
    private int idpersonne;
    adresse_cl idadresse;
    private String nom, prenom,sexe,matricule,CNI,telephone, info;

    public identite(){
        
    }
    
    public identite(int id){
        
        this.idpersonne = id; 
        
    } 
    
    public identite(String no){
        
        this.nom = no; 
        
    }
    public identite(adresse_cl id, String n, String p, String sex, String cni, String tele){
        
        this.idadresse = id;
        this.nom = n;
        this.prenom = p;
        this.sexe = sex;
        this.CNI = cni;
        this.telephone = tele;
        
    }
    
    public identite(String n, String cni, int id){
        
        this.idpersonne = id;
        this.nom = n;
        this.CNI = cni;
      
    }
    
     public identite(String n, String cni){
        
        
      
    }
     public identite(String n, int id){
        this.nom = n;
        this.idpersonne = id;
      
    }
     
     public identite(String n,String pr,String sex, int id){
        this.nom = n;
        this.prenom = pr;
        this.sexe = sex;
        this.idpersonne = id;
      
    }
    
      public identite(String n, String pre, String sex,adresse_cl ida, int id){
       
          this.idadresse = ida;
        this.idpersonne = id;
        this.nom = n;
        this.prenom = pre;
        this.sexe = sex;
     
    }

    public identite(adresse_cl idadresse, String nom, String prenom, String sexe, String CNI, String telephone,int idpersonne) {
        
        this.idadresse = idadresse;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.CNI = CNI;
        this.telephone = telephone;
      this.idpersonne = idpersonne;
    }
    
     public String toString(){
         
        return ""+nom;
        
     }
     
    
     
    public int getIdpersonne() {
        return idpersonne;
    }
    

    public void setIdpersonne(int idpersonne) {
        this.idpersonne = idpersonne;
    }

    public adresse_cl getIdadresse() {
        return idadresse;
    }

    public void setIdadresse(adresse_cl idadresse) {
        this.idadresse = idadresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getCNI() {
        return CNI;
    }

    public void setCNI(String CNI) {
        this.CNI = CNI;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
     public void ajoute_identite(){
      
      String req = "insert into personne (idadresse,nom,prenom,sexe,CNI,telephone) values "
              + "('"+this.idadresse.getIdadresse()+"','"+this.nom+"','"+this.prenom+"',"
              + "'"+this.sexe+"','"+this.CNI+"','"+this.telephone+"')";
      
      if(db_Mysql.updateData(req)>0){
          info="Félicitation, operation bien effectuée";
      }else info="Desolé, operation echouée" ;
  }  
     
     //=======================================================================
     // suppimer l'identité
     
       public void supprimer_identite(){
    
        String req = "delete from personne where idpersonne ='"+this.idpersonne+"'";
       
        if(db.db_Mysql.updateData(req)>0) {
           
            info = "Félicitation, l'Operation a été bien effectuée";
          
        }else info = "Désolé, l'Operation n'a pas été bien effectueée";
           System.out.println("ghghhg" +req);
    }
             
    //=====================================================================================
       // modifier identité
       
    public void modif_identite(){
        
        String req="UPDATE personne SET idAdresse = '"+this.idadresse.getIdadresse()+"',nom = '"+this.nom+"',prenom = '"+this.prenom+"',sexe = '"+this.sexe+"',CNI = '"+this.CNI+"',telephone = '"+this.telephone+"' where idpersonne ='"+this.idpersonne+"'";
           
        if(db_Mysql.updateData(req)>0)
           info="la personne a été modifiée avec succes";
        else info="Désolé, la personne n'a pas été modifiée";
        System.out.println("la requete est : "+req);
    }
   //===========================================================================
   // fonction pour alimenter combobox 
     public static void alimenter_Com_adresse(JComboBox adre){
   
     if(adre!=null){
         try {
           adre.removeAllItems();
           //ici c'est pour voir comment ils seront aficher dans le combobox via la methode toString qui fait la representation de l'objet
            adre.addItem(new adresse_cl(""));
             ResultSet result=db_Mysql.extraireData("select * from adresse");
             
             if(result!=null)
                 while(result.next()){
                     adre.addItem(new adresse_cl(result.getString("quartier"),result.getString("pays"),result.getInt("idadresse")));
                 }
         } catch (SQLException m) {
               
        JOptionPane.showMessageDialog(null, ""+m.getMessage());
       System.err.println(m);}
         }
     }
     
 //===================================================================================================
 //========= Listes des identites =====================================================================
     
     //=============================================================================
     
     public ArrayList<identite> List_Identite() {
        Statement st1 = null;
        ResultSet rs1 = null;

        ArrayList List_identite = new ArrayList();
        identite identite;

        try {
           
           String req1 = "select * from personne, adresse where personne.idAdresse = adresse.idAdresse group by personne.idpersonne";
            st1 = db.db_Mysql.extraireData_Prepared(req1);
            rs1 = st1.executeQuery(req1);
            
            while (rs1.next()) {
               
                identite = new identite();
               
                identite.setIdpersonne(Integer.parseInt(rs1.getString(1)));
               
                identite.setIdadresse(new adresse_cl(rs1.getString("quartier"),rs1.getInt(2)));
                
                identite.setNom(rs1.getString(3));
                identite.setPrenom(rs1.getString(4));
                identite.setSexe(rs1.getString(5));
                identite.setCNI(rs1.getString(6));
                identite.setTelephone(rs1.getString(7));
                
                					
                List_identite.add(identite);   
             
            }

        } catch (Exception e) {
            
            System.out.println(""+e);
            e.printStackTrace();
                  
        }

        return List_identite;
    }    
}

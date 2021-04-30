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
public class personnel_cl {
    
    	private int idpersonnel;
        identite idpersonne;
        private String matricule, info;

    public personnel_cl(int idpersonnel, identite idpersonne, String matricule, String info) {
        this.idpersonnel = idpersonnel;
        this.idpersonne = idpersonne;
        this.matricule = matricule;
        this.info = info;
    }
        
      

    public personnel_cl() {
    }
 
  public personnel_cl(int idpersonnel, identite idpersonne, String matricule) {
        
       this.idpersonnel = idpersonnel;
        this.idpersonne = idpersonne;
        this.matricule = matricule;
        
    }
        
     public personnel_cl(identite idpersonne, String matricule) {
       
        this.idpersonne = idpersonne;
        this.matricule = matricule;
        
    }
      public String toString(){
         
        return ""+idpersonne+"-"+matricule;
     }
     
     public personnel_cl(identite idpersonne) {
       
        this.idpersonne = idpersonne;
      
    }
     
     public personnel_cl(int idpersonnel) {
        this.idpersonnel = idpersonnel;
    }
      
         

    public int getIdpersonnel() {
        return idpersonnel;
    }

    public void setIdpersonnel(int idpersonnel) {
        this.idpersonnel = idpersonnel;
    }

    public identite getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(identite idpersonne) {
        this.idpersonne = idpersonne;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
 public void ajoute_personnel(){
      
      String req = "insert into personnel(idpersonne,matricule) values ('"+this.idpersonne.getIdpersonne()+"','"+this.matricule+"')";
      
      if(db_Mysql.updateData(req)>0){
          info="Félicitation, operation bien effectuée";
      }else info="Desolé, operation echouée" ;
  }  
     
     //=======================================================================
     // suppimer l'identité
     
       public void supprimer_personnel(){
    
        String req = "delete from personnel where idpersonnel ='"+this.idpersonnel+"'";
       
        if(db.db_Mysql.updateData(req)>0) {
           
            info = "Félicitation, l'Operation a été bien effectuée";
          
        }else info = "Désolé, l'Operation n'a pas été bien effectueée";
          
    }
             
    //=====================================================================================
       // modifier identité
       
    public void modifier_personnel(){
        
        String req="UPDATE personnel SET idpersonne = '"+this.idpersonne.getIdpersonne()+"',matricule = '"+this.matricule+"' where idpersonnel ='"+this.idpersonnel+"'";
           
        if(db_Mysql.updateData(req)>0)
           info="l'employé a été modifié avec succes";
        else info="Désolé, l'employé n'a pas été modifié";
      
    }
   //===========================================================================       
   public static void alimenter_Com_identite(JComboBox ident){
   
     if(ident!=null){
         try {
           ident.removeAllItems();
            //ident.addItem(new identite("",""));
             ResultSet result=db_Mysql.extraireData("select * from personne");
             
             if(result!=null)
                 while(result.next()){
                    // ident.addItem(new adresse_cl(result.getString("quartier"),result.getInt("idadresse")));
                     ident.addItem(new identite(result.getString("nom"), result.getString("CNI"), result.getInt("idpersonne")));
                 }
         } catch (SQLException m) {
               
        JOptionPane.showMessageDialog(null, ""+m.getMessage());
       System.err.println(m);}
         }
     }
   
   public ArrayList<personnel_cl> List_personnel() {
        Statement st1 = null;
        ResultSet rs1 = null;

        ArrayList List_personnel = new ArrayList();
        personnel_cl pers;

        try {
            
           
           String req1 = "select * from personne, adresse,personnel\n" +
" where personne.idAdresse = adresse.idAdresse\n" +
"and personnel.idpersonne = personne.idpersonne \n" +
"group by personne.idpersonne";
            st1 = db.db_Mysql.extraireData_Prepared(req1);
            rs1 = st1.executeQuery(req1);
            
            while (rs1.next()) {
               
                personnel_cl perso = new personnel_cl();
               
                perso.setIdpersonnel(rs1.getInt(13));
               
                perso.setIdpersonne(new identite(rs1.getString("nom"), rs1.getString("prenom"),rs1.getString("sexe"),new adresse_cl(rs1.getString("quartier"), rs1.getInt(2)), rs1.getInt(1)));
                
                perso.setMatricule(rs1.getString(15));
                
                
                					
                List_personnel.add(perso);   
             
            }

        } catch (Exception e) {
            
            e.printStackTrace();
                  
        }

        return List_personnel;
    }    
}



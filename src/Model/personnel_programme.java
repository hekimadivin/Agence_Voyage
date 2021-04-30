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
public class personnel_programme {
    
    Statement st = null;
    ResultSet rs = null;
    private int idprogramme_personnel;	
    programme_cl idprogramme;	
    personnel_cl idpersonnel;
    private String info;

    
    
    public int getIdprogramme_personnel() {
        return idprogramme_personnel;
    }

    public void setIdprogramme_personnel(int idprogramme_personnel) {
        this.idprogramme_personnel = idprogramme_personnel;
    }

    public programme_cl getIdprogramme() {
        return idprogramme;
    }

    public void setIdprogramme(programme_cl idprogramme) {
        this.idprogramme = idprogramme;
    }

    public personnel_cl getIdpersonnel() {
        return idpersonnel;
    }

    public void setIdpersonnel(personnel_cl idpersonnel) {
        this.idpersonnel = idpersonnel;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
   public void ajouter_chauffeur_programme(){
        
        String req = "insert into programme_personnel(idpersonnel,idprogramme) values ('"+this.idpersonnel.getIdpersonnel()+"','"+this.idprogramme.getIdprogramme()+"')";
       
        if(db.db_Mysql.updateData(req)>0) {
           
            info = "Félicitation, l'Operation a été bien effectuée";
          
        }else info = "Désolé, l'Operation n'a pas été bien effectueée";
    }
    
   public void modifier_chauffeur_programme(){
       
     
        String req1="update programme_personnel set idpersonnel = '"+this.idpersonnel.getIdpersonnel()+"',idprogramme = '"+this.idprogramme.getIdprogramme()+"'"
                + " where idprogramme_personnel ='"+this.idprogramme_personnel+"'";
        
        if(db_Mysql.updateData(req1)>0)
           info="le chauffeur au programme a été modifié avec succes";
        else info="Désolé, le chauffeur au programme n'a pas été modifié";
    }
       
 
     public void supprimer_vehicule_programme(){
       
        String req = "delete from personnel_programme where idprogramme_personnel ='"+this.idprogramme_personnel+"'";
       
        if(db.db_Mysql.updateData(req)>0) {
           
            info = "Félicitation, l'Operation a été bien effectuée";
          
        }else info = "Désolé, l'Operation n'a pas été bien effectueée";
       
   }  
  
     public ArrayList<personnel_programme> List_chauffeur_programme() {
       
        ArrayList List_personnel_programme = new ArrayList();
        personnel_programme perso_prog;

        try {
            String req = "select * from  programme_personnel,programme,personnel,personne\n" +
"where personnel.idpersonnel = programme_personnel.idpersonnel\n" +
"and programme.idprogramme = programme_personnel.idprogramme\n" +
"and personne.idpersonne = personnel.idpersonne";
            st = db.db_Mysql.extraireData_Prepared(req);
            rs = st.executeQuery(req);

            while (rs.next()) {
              perso_prog = new personnel_programme();
              
             perso_prog.setIdprogramme_personnel(rs.getInt(1));
             
             perso_prog.setIdpersonnel(new personnel_cl(new identite(rs.getString("nom"), Integer.parseInt(rs.getString("idpersonne"))),rs.getString("matricule")));
            
             perso_prog.setIdprogramme(new programme_cl(rs.getInt(3), rs.getString("date_p"), rs.getString("heure_p")));
             
             
                
                List_personnel_programme.add(perso_prog);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return List_personnel_programme;
    }
  // fonction pour alimenter combobox
     public static void alimenter_Com_chauffeur(JComboBox veh){
   
     if(veh!=null){
         try {
          veh.removeAllItems();
            //adre.addItem(new adresse(""));
             ResultSet result=db_Mysql.extraireData("select * from personne,personnel\n" +
"where personnel.idpersonne not in\n" +
" (select personnel.idpersonnel from personne,personnel,fonction,personnel_fonction \n" +
"where personnel.idpersonne = personne.idpersonne\n" +
"and personnel.idpersonnel = personnel_fonction.idpersonnel\n" +
"and fonction.nom_fonction = 'CHAUFFEUR')\n" +
"and personnel.idpersonne = personne.idpersonne");
             
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
     
    public static void alimenter_Com_programme(JComboBox prog){
   
     if(prog!=null){
         try {
          prog.removeAllItems();
            //adre.addItem(new adresse(""));
             ResultSet result=db_Mysql.extraireData("select * from programme");
             
             if(result!=null)
                 while(result.next()){
                     //veh.addItem(new adresse_cl(result.getString("quartier"),result.getInt("idadresse")));
                    prog.addItem(new programme_cl(result.getInt("idprogramme"), result.getString("date_p"), result.getString("heure_p")));
                 }
         } catch (SQLException m) {
               
        JOptionPane.showMessageDialog(null, ""+m.getMessage());
       System.err.println(m);}
         }
     }
}

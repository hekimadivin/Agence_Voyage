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
public class vehicule_programme_cl {
    
    Statement st = null;
    ResultSet rs = null;
    private int idvehicule_programme;
    programme_cl idprogramme;
    vehicule_cl idvehicule;
    private String info;

    public vehicule_programme_cl() {
    }
    
    public vehicule_programme_cl(int idvehicule_programme, programme_cl idprogramme, vehicule_cl idvehicule) {
        this.idvehicule_programme = idvehicule_programme;
        this.idprogramme = idprogramme;
        this.idvehicule = idvehicule;
        
    }
    
     public vehicule_programme_cl( programme_cl idprogramme, vehicule_cl idvehicule) {
      
        this.idprogramme = idprogramme;
        this.idvehicule = idvehicule;  
    }
     
      public vehicule_programme_cl(int idvehicule_programme) {
        this.idvehicule_programme = idvehicule_programme;
       
    }
    
    

    public int getIdvehicule_programme() {
        return idvehicule_programme;
    }

    public void setIdvehicule_programme(int idvehicule_programme) {
        this.idvehicule_programme = idvehicule_programme;
    }

    public programme_cl getIdprogramme() {
        return idprogramme;
    }

    public void setIdprogramme(programme_cl idprogramme) {
        this.idprogramme = idprogramme;
    }

    public vehicule_cl getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(vehicule_cl idvehicule) {
        this.idvehicule = idvehicule;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    
    public void ajouter_vehicule_programme(){
        
        String req = "insert into vehicule_programme (idvehicule,idprogramme) values ('"+this.idvehicule.getIdvehicule()+"','"+this.idprogramme.getIdprogramme()+"')";
       
        if(db.db_Mysql.updateData(req)>0) {
           
            info = "Félicitation, l'Operation a été bien effectuée";
          
        }else info = "Désolé, l'Operation n'a pas été bien effectueée";
    }
    
   public void modifier_vehicule_programme(){
       
     
        String req1="update vehicule_programme set idvehicule = '"+this.idvehicule.getIdvehicule()+"',idprogramme = '"+this.idprogramme.getIdprogramme()+"'"
                + " where idvehicule_programme ='"+this.idvehicule_programme+"'";
        
        if(db_Mysql.updateData(req1)>0)
           info="le vehicule au programe a été modifié avec succes";
        else info="Désolé, le vehicule au programe n'a pas été modifié";
    }
       
 
     public void supprimer_vehicule_programme(){
       
        String req = "delete from vehicule_programme where idvehicule_programme ='"+this.idvehicule_programme+"'";
       
        if(db.db_Mysql.updateData(req)>0) {
           
            info = "Félicitation, l'Operation a été bien effectuée";
          
        }else info = "Désolé, l'Operation n'a pas été bien effectueée";
       
   }
     
   public ArrayList<vehicule_programme_cl> List_vehicule_programme() {
       
        ArrayList List_vehicule_programme = new ArrayList();
        vehicule_programme_cl veh_prog;

        try {
            String req = "select * from  vehicule_programme,programme,vehicule\n" +
"where vehicule.idvehicule = vehicule_programme.idvehicule\n" +
"and programme.idprogramme = vehicule_programme.idprogramme";
            st = db.db_Mysql.extraireData_Prepared(req);
            rs = st.executeQuery(req);

            while (rs.next()) {
               veh_prog = new vehicule_programme_cl();

                
             veh_prog.setIdvehicule_programme(rs.getInt(1));
             veh_prog.setIdvehicule(new vehicule_cl(rs.getInt(2), rs.getString("immatricule"),rs.getString("marque")));
            
             veh_prog.setIdprogramme(new programme_cl(rs.getInt(3), rs.getString("date_p"), rs.getString("heure_p")));
             
               
                
                List_vehicule_programme.add(veh_prog);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return List_vehicule_programme;
    }
   
   // fonction pour alimenter combobox
     public static void alimenter_Com_vehicule(JComboBox veh){
   
     if(veh!=null){
         try {
          veh.removeAllItems();
            veh.addItem(new vehicule_cl("",""));
             ResultSet result=db_Mysql.extraireData("select * from vehicule");
             
             if(result!=null)
                 while(result.next()){
                  
                    veh.addItem(new vehicule_cl(result.getString("marque"), result.getString("immatricule"), result.getInt("idvehicule")));
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

    


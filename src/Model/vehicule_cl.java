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
public class vehicule_cl {
    
    Statement st = null;
    ResultSet rs = null;
    private int idvehicule,nombre_place;
    private String marque, immatricule,info;

    public vehicule_cl() {
    }
    
    public vehicule_cl(int idvehicule) {
       
        this.idvehicule = idvehicule;
    }
    
    public vehicule_cl(int idvehicule,String imm,String m) {
       
        this.idvehicule = idvehicule;
        this.immatricule = imm;
        this.marque = m;
       
    }
   
    
    public vehicule_cl(String imm) {
       
        this.immatricule = imm;
        this.marque=imm;
    }
    
    public String toString(){
        return ""+marque+" "+immatricule;
        
    }
    
     public vehicule_cl( String marque, String immatricule, int nbre) {
        this.marque = marque;
        this.immatricule = immatricule;
        this.nombre_place = nbre;
    }
     
     public vehicule_cl( String marque, String immatricule) {
        this.marque = marque;
        this.immatricule = immatricule;
        
    }

    public vehicule_cl(String marque, String immatricule,int nbre,int idvehicule) {
        
        this.marque = marque;
        this.immatricule = immatricule;
        this.idvehicule = idvehicule;
        this.nombre_place = nbre;
    }

    public int getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(int idvehicule) {
        this.idvehicule = idvehicule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getImmatricule() {
        return immatricule;
    }

    public void setImmatricule(String immatricule) {
        this.immatricule = immatricule;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getNombre_place() {
        return nombre_place;
    }

    public void setNombre_place(int nombre_place) {
        this.nombre_place = nombre_place;
    }
    
    
    
 //==================================================================================================
 //=========== les methodes ========================================================================
    
    public void ajouter_vehicule(){
        
        String req = "insert into vehicule (marque,immatricule,nombre_place) values ('"+this.marque+"','"+this.immatricule+"','"+this.nombre_place+"')";
       
        if(db.db_Mysql.updateData(req)>0) {
           
            info = "Félicitation, l'Operation a été bien effectuée";
          
        }else info = "Désolé, l'Operation n'a pas été bien effectueée";
    }
    
   public void modifier_vehicule(){
       
     
        String req1="update vehicule set marque = '"+this.marque+"',immatricule = '"+this.immatricule+"',"
                + " nombre_place = '"+this.nombre_place+"' where idvehicule ='"+this.idvehicule+"'";
        
        if(db_Mysql.updateData(req1)>0)
           info="le vehicule a été modifiée avec succes";
        else info="Désolé, le vehicule n'a pas été modifié";
    }
       
 
     public void supprimer_vehicule(){
       
        String req = "delete from vehicule where idvehicule ='"+this.idvehicule+"'";
       
        if(db.db_Mysql.updateData(req)>0) {
           
            info = "Félicitation, l'Operation a été bien effectuée";
          
        }else info = "Désolé, l'Operation n'a pas été bien effectueée";
       
   }
     
   public ArrayList<vehicule_cl> List_vehicule() {
       
        ArrayList List_vehicule = new ArrayList();
        vehicule_cl veh;

        try {
            String req = "select * from  vehicule";
            st = db.db_Mysql.extraireData_Prepared(req);
            rs = st.executeQuery(req);

            while (rs.next()) {
               veh = new vehicule_cl();

                
             veh.setIdvehicule(Integer.parseInt(rs.getString(1)));
                veh.setMarque(rs.getString(2));
               veh.setImmatricule(rs.getString(3));
               veh.setNombre_place(Integer.parseInt(rs.getString(4)));
                
                List_vehicule.add(veh);

            }

        } catch (Exception e) {
        }

        return List_vehicule;
    }
   
    public ArrayList<vehicule_cl> Recherche_vehicule() {

        ArrayList<vehicule_cl> List_vehicule= new ArrayList();
        vehicule_cl veh;

        try {

            String req1 ="SELECT * FROM vehicule WHERE immatricule like '%"+this.immatricule+"%'";
           
            st = db_Mysql.extraireData_Prepared(req1);
            rs = st.executeQuery(req1);

            while (rs.next()) {
                
                veh = new vehicule_cl();
                veh.setIdvehicule(Integer.parseInt(rs.getString(1)));
                veh.setMarque(rs.getString(2));
                veh.setImmatricule(rs.getString(3));
                
                List_vehicule.add(veh);
               
            }

        } catch (Exception e) {
        }

        return List_vehicule;
    }
    
     public void affiche_nbr_place() {

        try {

           
            String req1 ="SELECT nombre_place FROM vehicule WHERE immatricule ='"+this.immatricule+"'";
           
            st = db_Mysql.extraireData_Prepared(req1);
            rs = st.executeQuery(req1);

            while (rs.next()) {
                
          
            setNombre_place(Integer.parseInt(rs.getString("nombre_place")));
            
                
            }

        } catch (Exception e) {
        }

        
    }
     
  
}

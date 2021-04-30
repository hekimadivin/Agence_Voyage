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


public class adresse_cl {
    
    private int idAdresse;
    private String pays, province,commune,quartier,info;
    
    
    
      public adresse_cl()
   {
       
   }
    public adresse_cl(String pays, String province, String commune, String quartier)
   {
       this.pays = pays;
       this.province = province;
       this.commune = commune;
       this.quartier = quartier;
   }
    
     public adresse_cl(String pays, String province, String commune, String quartier,int idadresse)
   {
       this.pays = pays;
       this.province = province;
       this.commune = commune;
       this.quartier = quartier;
       this.idAdresse = idadresse;
   }
     
   
    
    public adresse_cl(int idadresse){
        this.idAdresse= idadresse;
    }
    
    public adresse_cl(String q){
        this.quartier= q;
        
    }

    
    public String toString(){
        return ""+quartier;
        
        
    }
    
    
     public adresse_cl(String quar,int id){
        quartier=quar;
       
        this.idAdresse = id;
    }
     
    
     public adresse_cl(String quar,String p,int id){
        quartier=quar;
        pays=p;
        this.idAdresse = id;
    }
     
    
     
    public int getIdadresse() {
        return idAdresse;
    }

    public void setIdadresse(int idadresse) {
        this.idAdresse = idadresse;
    }

   
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
  public void ajoute_adresse(){
      
      String req = "insert into adresse (pays,province,commune,quartier) values "
              + "('"+this.pays+"','"+this.province+"','"+this.commune+"','"+this.quartier+"')";
      
      if(db_Mysql.updateData(req)>0){
          info="Félicitation, operation bien effectuée";
      }else info="Desolé, operation echouée" ;
  }    
   
    public void modifier_Adresse(){
    
        String req="update Adresse set pays = '"+this.pays+"',province = '"+this.province+"',commune = '"+this.commune+"',"
                + "quartier = '"+this.quartier+"' where idAdresse ='"+this.idAdresse+"'";
        
        if(db_Mysql.updateData(req)>0)
           info="l'Adresse a été modifiée avec succes";
        else info="Désolé, l'adresse n'a pas été modifiée";
        System.out.println("JFJFJF" +req);
    }
   public void supprimer_Adresse(){
    
        String req="delete from adresse where idAdresse ='"+this.idAdresse+"'";
        
        if(db_Mysql.updateData(req)>0)
           info="l'Adresse a été supprimée avec succes";
        else info="Désolé, l'adresse n'a pas été supprimée";
    }
   
     public ArrayList<adresse_cl> List_Adresse() {
        Statement st = null;
        ResultSet rs = null;

        ArrayList List_Adresse = new ArrayList();
        adresse_cl adresse_cl;

        try {
            String req = "select * from  adresse";
            st = db.db_Mysql.extraireData_Prepared(req);
            rs = st.executeQuery(req);

            while (rs.next()) {
                adresse_cl = new adresse_cl();

                
                adresse_cl.setIdadresse(Integer.parseInt(rs.getString("idAdresse")));
                adresse_cl.setPays(rs.getString("pays"));
                adresse_cl.setProvince(rs.getString("province"));
                adresse_cl.setCommune(rs.getString("commune"));
                adresse_cl.setQuartier(rs.getString("quartier"));
                
                List_Adresse.add(adresse_cl);

            }

        } catch (Exception e) {
        }

        return List_Adresse;
    }
     
   public ArrayList<adresse_cl> Recherche_adresse() {

        ArrayList<adresse_cl> List_adresse = new ArrayList();
        adresse_cl adresse_cl;

        try {

            Statement st1 = null;
            ResultSet rs1 = null;
            String req1 ="SELECT * FROM adresse WHERE pays like '%"+this.pays+"%'";
               
           
          st1 = db_Mysql.extraireData_Prepared(req1);
            rs1 = st1.executeQuery(req1);

            while (rs1.next()) {
                
                adresse_cl = new adresse_cl();
                adresse_cl.setIdadresse(Integer.parseInt(rs1.getString("idAdresse")));
                adresse_cl.setPays(rs1.getString("pays"));
                adresse_cl.setProvince(rs1.getString("province"));
                adresse_cl.setCommune(rs1.getString("commune"));
                adresse_cl.setQuartier(rs1.getString("quartier"));

                List_adresse.add(adresse_cl);
               
            }

        } catch (Exception e) {
        }

        return List_adresse;

    }
}

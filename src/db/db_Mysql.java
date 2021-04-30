package db;

import java.io.Serializable;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;*/
import javax.sql.DataSource;


public class db_Mysql implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3063784227103785701L;
	/*
	 * transient est utilis� pendant la serialisation. Quand on ne souhaite pas
	 * copier la valeur d'une valiable. L'object serialis� gardera la valeur
	 * par default.
	 */
	private static  Connection con;
	
	private static String rapporteur;
	private static db_Mysql db;
	private static int testing_Ressource=-1;
	private static PreparedStatement pre_Statement=null;
	/*
	 * testing_ressource -- 1  connection obtenue
	 * 					  --(-1) probleme ressource 
	 * 						(-2) probleme de identifiants de la connection 	
	 */
	
	public static db_Mysql getInstance(){
		   
	     if(db==null)
	    	 db=new db_Mysql();
	   
	   return db;
  }
public static String getRapporteur() {
		return rapporteur;
	}


private static void getInstanceConnection(){
    
	String password = "",
	username = "root",
	
	dbname = "agence_voyage2",url="jdbc:mysql://localhost:3306/";
	if(con==null){
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			try {
				
			     
			con = DriverManager.getConnection(url+dbname,username,password);
			System.out.println("Connecté au BD:"+dbname+" "+username);
			rapporteur="successfully";
			testing_Ressource=1;
			} catch (SQLException e) {
				e.printStackTrace();
				
				if(e.getCause() instanceof UnknownHostException){
					
					rapporteur="Quelque chose(UnknownHostException) ne va pas bien car les causes sont l'une des suivantes:R�seau satur�,machine inconnue, le SGB n'est pas d�marr�";
					
				}
				testing_Ressource=-1;
				rapporteur="Donn�es d'identification sont mauvaises ou le SGDB n'est lanc�";
			}
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			rapporteur="Pilote charg� n'est pas bon";
			testing_Ressource=-2;
			System.out.println(rapporteur);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("InstantiationException");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("IllegalAccessException");
		}
	}
	
	
}


public static void main(String[] arg){
	
	getInstanceConnection();
	System.out.println("Data :"+testing_Ressource);
	
	
}

public static PreparedStatement getPreparedStatement(String req_DB,int status){
	  
	  try {
		  
		if(con==null||con.isClosed())
			  //InstanceConnection();
			getInstanceConnection();
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	  if(testing_Ressource!=1)
  	  return null;
	  
	  
	  try {
		  	   
		  
		  if(status==1)
			  pre_Statement=con.prepareStatement(req_DB,Statement.RETURN_GENERATED_KEYS);
		  else pre_Statement=con.prepareStatement(req_DB);
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return pre_Statement;
	
}


public static PreparedStatement extraireData_Prepared(String query){
	
	PreparedStatement ps=null;
	try {
		
		if(con==null||con.isClosed())
			
			getInstanceConnection();
		if(testing_Ressource==1)
			{ps = con.prepareStatement(query);
			 testing_Ressource=1;
			}
	} catch (SQLException e) {
		rapporteur="La requete est male faite!!";
		testing_Ressource=-2;
		e.printStackTrace();
	}
	
	
	return ps;
	
}

public static ResultSet extraireData(String requete){
	
	ResultSet result=null;
	Statement st;

	try {
		
		if(con==null||con.isClosed())
			{
			
			  getInstanceConnection();
		       if(testing_Ressource!=1)
		       { 
		    	   switch(testing_Ressource){
		    	   case -1:
		    		   rapporteur="Probl�me de DataRessource";
		    		   break;
		    	   case -2:
		    		   rapporteur="Probl�me des identifiants";
		    	   }
		    	  return null;
		       
		       }
			   
			}
		
		st = con.createStatement();
		result=st.executeQuery(requete);
		testing_Ressource=1;
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		testing_Ressource=-2;
	}
	
	return result;
}

public static void libererMemoire(ResultSet result){
	  
	  if(result!=null){
		   
	       try {
	    	  
			result.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}						       
	   						   
	   } 
}

public static void liberer_Memory_For_Update(Statement result){
	  	   
    try { 	   
		 if(result!=null)
		 { /*
			 if(result.getConnection()!=null)
				 result.getConnection().close();*/
			 result.close();	
		 
		 }
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}						       
						   




}



public static int updateData(String requete){
	
	
	int result=0;
	Statement st=null;
	try {
		
		if(con==null||con.isClosed())
			// InstanceConnection();
			getInstanceConnection();
		   if(testing_Ressource==1){
			   
				st=con.createStatement();				
				result=st.executeUpdate(requete);
				
				rapporteur="successfully";  
		   } 
		   else {
			   switch(testing_Ressource){
			   
			   case -1:rapporteur="Probl�me dataRessource!!";
				      break;
			   case -2:
				   		rapporteur="Probl�me d'identifiants de connections!!";
				   break;
			   }
		   }
			
	}
	catch (SQLException e1) {
		
		result=-2;
		rapporteur="D�sol�,vous n'avez pas le droit d'utiliser, pour des telles op�rations,cette machine.Utilisez celle de chaire Unisco(Pour plus d'information adressez -vous � l'administrateur du Logiciel) ";
		
		e1.printStackTrace();
		
		
	}
	
	return result;
}





  
}

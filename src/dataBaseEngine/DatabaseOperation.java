/*
 * This is class for managing database connection
 * 8/11/2018
 * Charles Barnabas Njau.
 * */
package dataBaseEngine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOperation {
	
	    //Class variable for connection string
	    private static String ConnectionString="jdbc:mysql://localhost:3306/";//-->a
		private String URL;//-->b
	    private static String DatabaseName;//-->c
		private static String UserName;//-->d
		private static String UserPassword;//-->e
		private static List<String> Table_Names ;

	
	    private static Connection myconn;//Connection object
	    private static DatabaseMetaData DbMd;
	    private static Statement stmnt;
	    private static ResultSet Rslt;
	    
	    //Class constructor
	    public DatabaseOperation(){
         DatabaseOperation.DatabaseName=getDatabaseName();
         DatabaseOperation.UserName=getUserName();
         DatabaseOperation.UserPassword=getUserPassword();
	    }
	    
	    public static String getDatabaseName() {
			return DatabaseName;
		}

		public static void setDatabaseName(String databaseName) {
			DatabaseName = databaseName;
		}

		public String getUserName() {
			return UserName;
		}

		public static void  setUserName(String userName) {
			UserName = userName;
		}

		public static String getUserPassword() {
			return UserPassword;
		}

		public static void setUserPassword(String userPassword) {
			UserPassword = userPassword;
		}

		//Create a full Databse URL
        private static String Db_URL(String DbName){
        	final  String ERR_MSG="Empty parameter";
        	String DbURL=null;
        	if(DbName.isEmpty()==true){
        		return ERR_MSG;
        	}
        	else {
        		DbURL=ConnectionString+DbName;
            	return DbURL;	
        	}
        	
        }
        
        //Database Connection String
	    protected static boolean DbConn()
	    {
	        try{
	            //Connect to Database
	            //1.Get Connection to the database
	             myconn=DriverManager.getConnection(Db_URL(DatabaseName),UserName,UserPassword);
	             //Test Stub 1
	             System.out.println("Succesfully connected as user: "+myconn.getMetaData().getUserName());
	            return true;

	        }
	        catch(Exception ex){
	            //Catch execeptions
	        	//Test  Stub 2
	        	System.out.print("Error"+ex.getMessage().toString());

	            return false;

	        }
	    }
	    /*
	     * 1.Determine the number of tables in database
	     *  1.1. Store table names in an array
	     *  
	     * 2.Get number of columns in a specific table
	     *  2.1. Store the in an array
	     * 
	     * */
	    
	    //Get total Number of tables
	    protected static void GetTable(){
	    	
	    	 try {
				DbMd = myconn.getMetaData();
			
				
	    	
				Rslt = DbMd.getTables(null, null, "%", null);
			
				
				
				Table_Names= new ArrayList();
				
				while (Rslt.next()) {
					
					
					
					Table_Names.add(Rslt.getString(3));
				    //System.out.println("#"+Rslt.getRow());
				    
				  
				  
				} 
				
				
				
	    	 }
				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
	    //Database insert
	    protected static boolean DbInsert(){
	    	
	    	

	        try{
	            if(DbConn()!=false){
	                //#Type 1 General Data into all column 
	            	//#Type 2 Insert Data into specified column
	                return true;


	            }
	        }catch (Exception ex){

	            return false;
	        }
	        return true;
	    }
        
	    //Database Update
	    protected  static boolean DbUpdate(){
	        try{
	            if(DbConn()!=false){
	                //per form database insert
	                return true;


	            }
	        }catch(Exception ex){
	            return false;
	        }
	        return true;
	    }
	    
	    //Database Delete
	    protected  static boolean DbDelete(){
	        try{
	            if(DbConn()!=false){
	                return  true;
	            }
	        }catch (Exception ex){

	        return false;
	        }
	        return true;
	    }





	

}


/*
This is the programs main entry point for processing the database 
manipulation logic

Charles Barnabas Njau.
08/8/2018
*/
package dataBaseEngine;



public class DbMain extends DatabaseOperation {

	
  
	
	public static void main(String[] args) {
		
		
		DatabaseOperation.setDatabaseName("employeerecord");
		DatabaseOperation.setUserName("root");
		DatabaseOperation.setUserPassword("");
		DatabaseOperation.DbConn();
		DatabaseOperation.GetTable();
		

	}

}

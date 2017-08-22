package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Connector {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	
	// --------CONNECTING TO DataBase--------
	public static void Conn() throws ClassNotFoundException, SQLException 
	   {
		   conn = null;
		   Class.forName("org.sqlite.JDBC");
		   conn = DriverManager.getConnection("jdbc:sqlite:trainsData.s3db");
		   
		   System.out.println("DataBase connected!");
	   }
	
	// --------Table creating--------
	public static void CreateDB() throws ClassNotFoundException, SQLException
	   {
		statmt = conn.createStatement();
		statmt.execute("CREATE TABLE if not exists 'passengerTrains' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'number' text, 'cars' INT);");
		
		System.out.println("Table was creating or allready exist");
	   }
	
	// -------- Table output --------
	public static void ReadDB() throws ClassNotFoundException, SQLException
	   {
		resSet = statmt.executeQuery("SELECT * FROM passengerTrains");
		
		while(resSet.next())
		{
			int id = resSet.getInt("id");
			String  number = resSet.getString("number");
			String  cars = resSet.getString("cars");
	         System.out.println( "ID = " + id );
	         System.out.println( "name = " + number );
	         System.out.println( "phone = " + cars );
	         System.out.println();
		}	
		
		System.out.println("Table displayed");
	    }
	
		// --------Closing--------
		public static void CloseDB() throws ClassNotFoundException, SQLException
		   {
			conn.close();
			statmt.close();
			resSet.close();
			
			System.out.println("Connections closed");
		   }

}
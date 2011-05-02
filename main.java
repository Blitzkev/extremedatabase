import java.sql.*;

import gui.MusicGUI;

/* Account info
 * 
 * We get a dedicated CS Account:
 * 
 * Login: p485-70a
 * Pwd: Extreme.Database
 *
 * This is setting up the variables to use Oracle via command-line.
 * 
 * source /usr/local/bin/coraenv
 * <Return Key>
 * 
 * Put this into the .cshrc file: source /usr/local/bin/coraenv
 * 
 * This is for Oracle access via sqlplus in the command-line (queeg):
 * 
 * sqlplus p48570a@csodb10
 * 
 * When prompted for password, enter this:
 * 
 * Enter Password: letmein
 */

public class main {
	//our gui instance
	public static MusicGUI gui = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
		// setup and show the GUI
		gui = new MusicGUI();
	
		// add some fake tabs...
		gui = MusicGUI.addResultTab("people", gui);
		gui = MusicGUI.addResultTab("names", gui);
		gui = MusicGUI.addResultTab("people2", gui);
		
		//log into oracle DB
		String dbUser = "p48570a@csodb10";
		String dbPassword = "letmein";
		
		try {
		    Connection con;
		    Statement stmt;
	            String url = "jdbc:oracle:thin:@queeg:1521:csodb10";
		    // DATABASE CONNECTION MAGIC :-)
	            Class.forName("oracle.jdbc.driver.OracleDriver");
		    con = DriverManager.getConnection(url, dbUser, dbPassword);
		    stmt = con.createStatement();
		}catch(Exception e) {
		    e.printStackTrace();
		}finally {

		}
	}

}

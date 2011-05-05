/** 
 * Crud.java - first cut at Oracle 9i version
 * This program illustrates database CRUD operations.
 * Note. This single main method program gets an F grade from me :-(
 * @author      R K Raj, 2004/01/27. Revised 2008/09/13. Revised 2009/03/18.
 **/ 

import java.io.*;
import java.sql.*;
import java.lang.*;
 
public class Crud {
    public static void main(String args[]) {

	String dbUser = "";
	String dbPassword = "";
	try {
	    InputStreamReader inReader = new InputStreamReader(System.in);
	    BufferedReader bReader = new BufferedReader( inReader );
	    System.out.print("Enter your user id: ");
	    dbUser = bReader.readLine();
	    System.out.print("Enter your passwd (ONLY IF NOBODY IS AROUND!): ");
	    dbPassword = bReader.readLine();
	}
	catch (Exception e) {
	    System.err.println("Error reading password.");
	    e.printStackTrace();
	}

	try {
	    Connection con;
	    Statement stmt;
            String url = "jdbc:oracle:thin:@queeg:1521:csodb10";
	    // DATABASE CONNECTION MAGIC :-)
            Class.forName("oracle.jdbc.driver.OracleDriver");
	    con = DriverManager.getConnection(url, dbUser, dbPassword);
	    stmt = con.createStatement();

	    // ASSUME THE STUDENT TABLE HAS BEEN ALLOCATED PREVIOUSLY
	    // ALSO MAKE SURE TO DEALLOCATE STORAGE FOR THE TABLE WHEN DONE

	    // CREATE NEW STUDENT DATA
	    stmt.executeUpdate(
		"insert into student values('Barack Obama', 2009, '555-1234')");
	    stmt.executeUpdate(
		"insert into student values('George Bush', 2001, '555-1234')");
	    stmt.executeUpdate(
		"insert into student values('George Bush', 1989, '555-1234')");
	    stmt.executeUpdate(
		"insert into student values('George Washington', 1789, '000-0000')");
	    stmt.executeUpdate(
		"insert into student values('John Adams', 1797, '000-0000')");
	    stmt.executeUpdate(
		"insert into student values('John Adams', 1825, '000-0000')");

	    // UPDATE EXISTING STUDENT DATA
	    stmt.executeUpdate(
		"update student set name = 'George W. Bush' where id = 2001");
	    stmt.executeUpdate(
		"update student set name = 'George H. W. Bush' where id = 1989");
	    stmt.executeUpdate(
		"update student set name = 'John Q. Adams' where id = 1825");


	    // RETRIEVE EXISTING STUDENT DATA
	    String query = "select name, id, phone from student";
	    System.out.println("Historical Students:");
	    ResultSet rs = stmt.executeQuery(query);
	    while (rs.next()) {
	        String s = rs.getString("name");
	        int i = rs.getInt("id");
	        String p = rs.getString("phone");
	        System.out.println(s + ", " + i + ", " + p);
	    }

	    // DELETE SOME SOME STUDENT DATA (RARELY USED IN GOOD PRACTICE)
	    stmt.executeUpdate("delete from student where phone = '000-0000'");


	    // DATABASE CLOSE/CLEANUP
	    stmt.close();
	    con.close();
	}
	catch(Exception e) {
	    e.printStackTrace();
	}
	finally {

	}
    }
}


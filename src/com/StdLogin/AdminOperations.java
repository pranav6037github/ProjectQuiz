package com.StdLogin;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdminOperations {
	
	public static void main (String [] args) throws SQLException {
		
		AdminOperations a1 = new AdminOperations ();
		
		
		System.out.println("Select the option : ");
		System.out.println("1.Display all students score as per ascending order ");
		System.out.println("2.Fetch student score by using id ");
		
		
		Scanner sc = new Scanner (System.in);
		int i = sc.nextInt();
		
		switch(i) {
		case 1 : 
			a1.StdScore();
			return;
		case 2 :
			a1.findById();
			return;
		default :
			System.out.println("Invalid Input");
		}
	}
	
	public void StdScore () throws SQLException{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/std_login","root","root");
			
			Statement st = con.createStatement();
			
			
			String query = "select * from std_login.std_info order by Score asc ;";
			
			st.execute(query);
			
			
			
			con.close();
			
			System.out.println("Okay");
			
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void findById() throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/std_login","root","root");
			
			Statement st = con.createStatement();
			
			System.out.println("Enter the Student Id to find the studrnt info : ");
			Scanner sc = new Scanner (System.in);
			int id = sc.nextInt();
			
			String query = " select * from std_info where std_id = '"+id+"' " ;
			
			st.execute(query);
			
			System.out.println("Done");
			
			con.close();
			
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		
	}


}

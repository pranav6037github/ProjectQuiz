package com.StdLogin;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner ;

public class StdAccess {
	
	String firstName;
	String lastName;
	String userName;
	String passWord;
	String cityName;
	String mailId;
	String mobileNum;
	
	
	
	public static void main(String[]args) throws SQLException  {
		
		
		System.out.println("WELCOME TO QUIZ BASED APPLICATION");
		System.out.println("---------------------------------");
		Scanner sc = new Scanner(System.in); 
		System.out.println("select the option :  ");
		System.out.println("1 . Student Registration "+'\n'+"2 . Student Login ");
		
		StdAccess a1 = new StdAccess ();
		
		int i = sc.nextInt() ;
		switch(i) {
		
		case 1 : 
		a1.studentRegistration();
		break;
		
		case 2 :
	    a1.studentLogIn();
	    break;
	    
		default :
			System.out.println("Wrong Input");
		
			
		} ;
		
		System.out.println("---------------------------------");
		
	}

	public void studentRegistration() throws SQLException {
		
		
		
		Scanner sc = new Scanner (System.in); 
		
		try {
			
		
		
		
		System.out.println("Enter the First Name : ");
		 firstName = sc.nextLine();
		
		System.out.println("Enter the Last Name : ");
	    lastName = sc.nextLine();
		
		System.out.println("Enter the Username : ");
	    userName = sc.nextLine();
		
		System.out.println("Set the Password");
	    passWord = sc.nextLine();
		
		System.out.println("Enter the City : ");
		cityName = sc.nextLine();
		
		System.out.println("Enter Mail Id : ");
		mailId = sc.nextLine();
		
		System.out.println("Enter Mobile Number : ");
	     mobileNum = sc.nextLine();
		
		
		}
		catch(Exception e) {
			
			System.out.println("!!Wrong Input!!");
			e.printStackTrace();
			
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/std_login","root","root");
			
			Statement st = con.createStatement();
			
			
			String query = "insert into std_info ( first_name , last_name , user_name , pass_word , city , email_id , mobile_number )"
					+ " values ('"+firstName+"' ,'"+lastName+"' , '"+userName+"' , '"+passWord+"' , '"+cityName+"' , '"+mailId+"' , '"+mobileNum+"') ";
			
			st.execute(query);
			
			System.out.println(" Registration Successful ");
			
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		
		
	}
	
	public void studentLogIn() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Username : ");
		String username =sc.nextLine();
		
		System.out.println("Enter the Password : ");
		String password = sc.nextLine();
		
		System.out.println(username+'\n'+password);
		
	}
	
	
}

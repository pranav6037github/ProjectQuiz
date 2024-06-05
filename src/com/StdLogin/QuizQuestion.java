package com.StdLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class QuizQuestion {

	
	static double total;

	public double question() {
		String answer = "";
		Scanner sc = new Scanner(System.in);
		int currectAnswer = 0;
		int Question = 1;

		System.out.println("Q.1)  Which of the following is not a Java features? ");
		System.out.println("A:  Dynamic");
		System.out.println("B:  Architecture Nutral");
		System.out.println("C:  Use of pointers");
		System.out.println("D:  Object-oriented");
		answer = sc.nextLine();
		if (answer.equals("C")) {
			System.out.println("correct answer");
			currectAnswer = currectAnswer + 1;

		} else {
			System.out.println("oops Wrong answer better luck next time");
		}
		System.out.println("---------------------------------------------------");
		System.out.println("Q.2)   _____ is used to find and fix bugs in the Java programs.");
		System.out.println("A:  JVM");
		System.out.println("B:  JRE");
		System.out.println("C:  JDK");
		System.out.println("D:  JDB");
		answer = sc.nextLine();
		if (answer.equals("D")) {
			System.out.println("correct answer");
			currectAnswer = currectAnswer + 1;

		} else {
			System.out.println("oops Wrong answer better luck next time");
		}
		System.out.println("---------------------------------------------------");

		System.out.println("Q.3)   Which package contains the Random class?");
		System.out.println("A:  java.util.package");
		System.out.println("B:  java.lang.package");
		System.out.println("C:  java.awt.package");
		System.out.println("D:  java.io package");
		answer = sc.nextLine();
		if (answer.equals("A")) {
			System.out.println("correct answer");
			currectAnswer = currectAnswer + 1;

		} else {
			System.out.println("oops Wrong answer better luck next time");
		}
		System.out.println("---------------------------------------------------");

		System.out.println("Q.4)  In java, jar stands for");
		System.out.println("A:  Java Archive Runner");
		System.out.println("B:  Java Application Resource");
		System.out.println("C:  Java Application Runner");
		System.out.println("D:  None of the above");
		answer = sc.nextLine();
		if (answer.equals("D")) {
			System.out.println("correct answer");
			currectAnswer = currectAnswer + 1;

		} else {
			System.out.println("oops Wrong answer better luck next time");
		}
		System.out.println("---------------------------------------------------");
		System.out.println("Q.5)   What is the size of a long variable in Java?");
		System.out.println("A:  4 bytes");
		System.out.println("B:  8 bytes");
		System.out.println("C:  2 bytes");
		System.out.println("D:  16 bytes");
		answer = sc.nextLine();
		if (answer.equals("B")) {
			System.out.println("correct answer");
			currectAnswer = currectAnswer + 1;

		} else {
			System.out.println("oops Wrong answer better luck next time");
		}
		System.out.println("---------------------------------------------------");

		System.out.println("Q.6)  Which data type is used to store a single character in Java?");
		System.out.println("A:  char");
		System.out.println("B:  string");
		System.out.println("C:  letter");
		System.out.println("D:  ch");
		answer = sc.nextLine();
		if (answer.equals("A")) {
			System.out.println("correct answer");
			currectAnswer = currectAnswer + 1;

		} else {
			System.out.println("oops Wrong answer better luck next time");
		}
		System.out.println("---------------------------------------------------");
		System.out.println("Q.7)  What is the maximum value that can be stored in a byte variable in Java?");
		System.out.println("A:  127");
		System.out.println("B:  255");
		System.out.println("C:  32767");
		System.out.println("D:  64");
		answer = sc.nextLine();
		if (answer.equals("A")) {
			System.out.println("correct answer");
			currectAnswer = currectAnswer + 1;

		} else {
			System.out.println("oops Wrong answer better luck next time");
		}
		System.out.println("---------------------------------------------------");
		System.out.println("Q.8)   Which of the following is not an OOPS concept?");
		System.out.println("A:  Encapsulation");
		System.out.println("B:  Polymorphism");
		System.out.println("C:  Exception");
		System.out.println("D:  Abstraction");
		answer = sc.nextLine();
		if (answer.equals("C")) {
			System.out.println("correct answer");
			currectAnswer = currectAnswer + 1;

		} else {
			System.out.println("oops Wrong answer better luck next time");
		}
		System.out.println("---------------------------------------------------");
		System.out.println("Q.9)   Which feature of OOPS derives the class from another class?");
		System.out.println("A:  Inheritance");
		System.out.println("B:  Data Hiding");
		System.out.println("C:  Encapsulation");
		System.out.println("D:  Polymorphism");
		answer = sc.nextLine();
		if (answer.equals("A")) {
			System.out.println("correct answer");
			currectAnswer = currectAnswer + 1;

		} else {
			System.out.println("oops Wrong answer better luck next time");
		}
		System.out.println("---------------------------------------------------");
		System.out.println("Q.10)    How many threads can be executed at a time?");
		System.out.println("A:  Only one Thred");
		System.out.println("B:  Multiple threads");
		System.out.println("C:  Only main(main()method)thread");
		System.out.println("D:  Two Threads");
		answer = sc.nextLine();
		if (answer.equals("B")) {
			System.out.println("correct answer");
			currectAnswer = currectAnswer + 1;

		} else {
			System.out.println("oops Wrong answer better luck next time");
		}
		System.out.println("---------------------------------------------------");
		  double grade= currectAnswer/10.0*100.0;
         System.out.println(grade);
       total=grade;
		return total;
    
	}
	public static void main(String[]args) throws SQLException, ClassNotFoundException {
		
		QuizQuestion quiz= new QuizQuestion();
		quiz.question();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/std_login","root","root");
			java.sql.Statement statement = con.createStatement();
			
			String sqlQuery="insert into std_info(Score)"+
			"values("+total+")";
			int i=statement.executeUpdate(sqlQuery);
			System.out.println("succesful" +i);
			statement.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

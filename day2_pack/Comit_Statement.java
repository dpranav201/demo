package day2_pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class Comit_Statement {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter rno");
		int rno = sc.nextInt();
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter marks");
		float marks = sc.nextFloat();
		System.out.println("Enter dob yyyy-mm-dd");
		String dob = sc.next();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/kalyan?useSSL=false&allowPublicKeyRetrieval=true","root","sept22");
			//Ab tak jitne bhi operation kiye wo sab AutoComit the agar AutoComit band karna hai to use karo line no 28
			con.setAutoCommit(false);
			PreparedStatement s=con.prepareStatement("insert into Student values(?,?,?,?)");
			s.setInt(1,rno);
			s.setString(2, name);
			s.setFloat(3, marks);
			s.setString(4,dob);
			int i=s.executeUpdate();
			//changes to commit karne ke liye use karenge line 36
			con.commit();
			System.out.println("Number of rows affected="+i);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
}



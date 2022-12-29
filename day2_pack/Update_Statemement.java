package day2_pack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update_Statemement {

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
			PreparedStatement s=con.prepareStatement("update Student set name=?,marks=?,dob=? where roll=?");
			s.setString(1, name);
			s.setFloat(2, marks);
			s.setString(3,dob);
			s.setInt(4,rno);
			int i=s.executeUpdate();
			System.out.println("Number of rows affected="+i);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			
			e.printStackTrace();
		}

	}

}

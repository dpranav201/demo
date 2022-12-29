package day2_pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete_Student {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter rno");
		int rno = sc.nextInt();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/kalyan?useSSL=false&allowPublicKeyRetrieval=true","root","sept22");
			PreparedStatement s=con.prepareStatement("delete from Student where roll=?");
			s.setInt(1, rno);
			int i=s.executeUpdate();
			System.out.println("Number of rows affected="+i);
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		

	}

}

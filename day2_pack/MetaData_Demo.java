package day2_pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class MetaData_Demo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/kalyan?useSSL=false&allowPublicKeyRetrieval=true","root","sept22");
			PreparedStatement s = con.prepareStatement("select * from Student");
			//line 17 mai command compile hogi aur line 19 mai execute after execution return hoga resultSet jo ki ek temporary
			//table ki tarah behave karega
			ResultSet rs = s.executeQuery();
			ResultSetMetaData rsmd =rs.getMetaData();
			//getColoumnCount and getColoumnName ye dono ResultSetMetaData class ki methods hai
			for(int i=1;i<=rsmd.getColumnCount();i++)
			{
				System.out.println(rsmd.getColumnName(i));
			}
			System.out.println(rsmd.getColumnCount());
			
			for(int i=1;i<=rsmd.getColumnCount();i++) {
				System.out.print(rsmd.getColumnName(i)+" ");
				
			}
			System.out.println();
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4));
			}
			s.close();
			con.close();

	}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

}

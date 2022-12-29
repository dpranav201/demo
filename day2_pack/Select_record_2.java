package day2_pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select_record_2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/kalyan?useSSL=false&allowPublicKeyRetrieval=true","root","sept22");
			
			PreparedStatement s=con.prepareStatement("select sum(sal) from emp where deptno=1");
		
			ResultSet rs=s.executeQuery();
			while(rs.next())
			{
				//Yaha humne query mai sirf salary hi li hai to print karte samay sirf salry hi aayegi baki kuch nahi
				System.out.print(rs.getFloat(1));
				//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

}

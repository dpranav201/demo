package day2_pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select_Record {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/kalyan?useSSL=false&allowPublicKeyRetrieval=true","root","sept22");
			//ye hume resultset return karega line number 16
			PreparedStatement s=con.prepareStatement("select * from day1");
		//line 17 mai command compile ho gayi ab line 19 mai execute hogi
			ResultSet rs=s.executeQuery();
			while(rs.next())
			{
				//line 23 will print data yaha table ki sabhi rows print hogi one row at a time
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}

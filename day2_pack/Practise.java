package day2_pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Practise 
{
public static Scanner sc;
public static ResultSet rs;
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kalyan?useSSL=false&allowPublicKeyRetrieval=true","root","sept22");
			PreparedStatement s=con.prepareStatement("select * from Student",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=s.executeQuery();
			boolean flag=true;
			do 
			{
				sc=new Scanner(System.in);
				byte ch=sc.nextByte();
				System.out.println("0 for Exit");
				System.out.print("1 to show record");
				System.out.println("2 to show record reve");
				switch(ch)
				{
				case 0:
					flag=false;
					break;
				case 1:
					showRec();
					break;
				case 2:
					showRecRev();
					break;
				case 3:
					firstRecord();
					break;
				case 4:
					lastRecord();
					break;
				case 5:
					insertRecord();
					break;
				case 6:
					updateRecord();
					break;
				case 7:
					deleteRecord();
				}
			}while(flag);
		} catch (ClassNotFoundException | SQLException e)
		{
						e.printStackTrace();
		}

	}
	private static void showRec() throws SQLException
	{
		rs.beforeFirst();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4));
		}
	}
	private static void showRecRev() throws SQLException
	{
		rs.afterLast();
		while(rs.previous())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4));
		}
	}
	private static void firstRecord() throws SQLException
	{
		if(rs.first())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4));
		}
	}
	private static void lastRecord() throws SQLException
	{
		if(rs.last())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4));
		}
	}
	private static void insertRecord() throws SQLException
	{
		System.out.println("Enter the roll");
		int rno=sc.nextInt();
		System.out.println("Enter the name");
		String name=sc.next();
		System.out.println("Enter the marks");
		float marks=sc.nextFloat();
		System.out.println("enter the DOB");
		String dob=sc.next();
		rs.moveToInsertRow();
		rs.updateInt(1, rno);
		rs.updateString(2, name);
		rs.updateFloat(3, marks);
		rs.updateString(4, dob);
		rs.insertRow();
		rs.moveToCurrentRow();
	}
	private static void updateRecord() throws SQLException
	{
		System.out.println("Enter roll");
		int rno=sc.nextInt();
		boolean flag=false;
		while(rs.next())
		{
			if(rs.getInt(1)==rno)
			{
				System.out.println("Enter the name");
				String name=sc.next();
				System.out.println("Enter the marks");
				float marks=sc.nextFloat();
				System.out.println("enter the DOB");
				String dob=sc.next();
				rs.updateString(2, name);
				rs.updateFloat(3, marks);
				rs.updateString(4, dob);
				rs.updateRow();
				rs.moveToCurrentRow();
				flag=true;
				break;
			}
			if(flag==false)
			{
				System.out.println("Record Not Found");
			}
			
		}
	}
	private static void deleteRecord() throws SQLException
	{
		System.out.println("Enter roll");
		int rno=sc.nextInt();
		boolean flag=false;
		while(rs.next())
		{
			if(rs.getInt(1)==rno)
			{
				rs.deleteRow();
				rs.moveToCurrentRow();
				flag=true;
				break;
			}
			if(!flag)
			{
				System.out.println("Record Not Found");
			}
		}
	}
	

}

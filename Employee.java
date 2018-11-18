import java.util.*;
import java.sql.*;
import java.io.*;
class Employee{
	Connection con;
	Scanner scan;
	public Employee()throws Exception{
		this.con=DriverManager.getConnection("jdbc:mysql://localhost/transport", "root", "1234");
		this.scan=new Scanner(System.in);
	}
	public void salesDone()throws Exception{
		PreparedStatement pst=con.prepareStatement("select Name,sale_done from employeeData where id=?");
		System.out.println("Enter the Id");
		int id=scan.nextInt();
		pst.setInt(1,id);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			System.out.println("Name:"+" "+rs.getString(1)+" "+"Sales_Done:"+rs.getInt("sale_done"));
		}
	}
	
	public void incentivesGained() throws Exception{
		PreparedStatement pst=con.prepareStatement("select Name,sale_done, incentives_gained from employeeData where id=?");
		System.out.println("Enter the Id");
		int id=scan.nextInt();
		pst.setInt(1,id);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			System.out.println("Name:"+" "+rs.getString(1)+" "+"Sales_Done:"+rs.getInt("sale_done")+" "+"Incentives:"+rs.getInt("incentives_gained"));
		}
	}
	public void attendance() throws Exception {
		PreparedStatement pst=con.prepareStatement("select Name,attendance from employeeData where id=?");
		System.out.println("Enter the Id");
		int id=scan.nextInt();
		pst.setInt(1,id);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			System.out.println("Name:"+" "+rs.getString(1)+" "+"Attendance:"+rs.getInt("attendance"));
		}
	}
	public void all() throws Exception{
		PreparedStatement pst=con.prepareStatement("select * from employeeData where id=?");
		System.out.println("Enter the Id");
		int id=scan.nextInt();
		pst.setInt(1,id);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			System.out.println("Name:"+" "+rs.getString(1)+" "+"Sales_Done:"+rs.getInt("sale_done")+" "+"Incentives:"+rs.getInt("incentives_gained")+" "+"Id:"+rs.getInt("id")+" "+"Attendance:"+" "+rs.getInt("attendance")+" "+"Salary:"+" "+rs.getInt("salary"));
		}
	}
	


}
import java.sql.*;
import java.io.*;
import java.util.*;
class Manager{
Connection con;
Scanner scan;
public Manager() throws Exception{
	scan=new Scanner(System.in);
	Class.forName("com.mysql.jdbc.Driver");
	this.con=DriverManager.getConnection("jdbc:mysql://localhost/transport", "root", "1234");
	}
	public void addEmployee(){
		try{
		PreparedStatement pst=con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
		System.out.println("Enter name:");
		String name=scan.next();
		System.out.println("Enter Id:");
		int employee_id=scan.nextInt();
		System.out.println("Enter Aadhar_no:");
		int aadhar_no=scan.nextInt();
		System.out.println("Enter Salary:");
		int salary=scan.nextInt();
		System.out.println("Enter Address:");
		String address=scan.next();
		System.out.println("Enter Password in characters:");
		String password=scan.next();
		
		
	pst.setString(1,name);
	pst.setInt(2,employee_id);
	pst.setInt(3,aadhar_no);
	pst.setInt(4,salary);
	pst.setString(5,address);
	pst.setString(6,password);
	pst.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	System.out.println("Records Inserted Successfully");
	}
	
	public void removeEmployee() throws Exception{
		PreparedStatement pst=con.prepareStatement("delete from employee where id=?");
		System.out.println("Please Enter id of employee");
		int id=scan.nextInt();
		pst.setInt(1,id);
		pst.executeUpdate();
		System.out.println("Record Deleted Successfully");
	}
	
	public void detailsEmployee() throws Exception{
		PreparedStatement pst=con.prepareStatement("select * from employee where id=?");
		System.out.println("Please Enter id of employee");
		int id=scan.nextInt();
		pst.setInt(1,id);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			System.out.println("Name:"+" "+rs.getString(1)+" "+"Id:"+" "+rs.getInt(2)+" "+"Aadhar:"+" "+rs.getInt(3)+" "+"Salary:"+" "+rs.getInt(4)+" "+"Address:"+" "+rs.getString(5)+" "+"Password:"+" "+rs.getString(6)+" "+"Location:"+" "+rs.getString(7));
		}
	}
	
	public void transferEmployee() throws Exception{
		PreparedStatement pst=con.prepareStatement("update employee set location=? where id=?");
		System.out.println("Enter Location");
		String location=scan.next();
		pst.setString(1,location);
		System.out.println("Enter ID");
		int id=scan.nextInt();
		pst.setInt(2,id);
		pst.executeUpdate();
		System.out.println("Location Successfully Changed");
	}
	public void saleMonthly() throws Exception{
		PreparedStatement pst=con.prepareStatement("select * from sale where id=?");
		System.out.println("Please Enter id of Product");
		int id=scan.nextInt();
		pst.setInt(1,id);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			System.out.println("PName:"+" "+rs.getString(1)+" "+"PId:"+" "+rs.getString(2)+" "+"Date_In:"+" "+rs.getDate(3)+" "+"Date_Sold:"+" "+rs.getDate(4));
	}
	System.out.println("Successful");
	con.close();
	pst.close();
	}
}
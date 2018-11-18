import java.sql.*;
import java.util.*;
public class TransportManagement{
public static void main(String []args) throws Exception
{
Manager m=new Manager();
Employee em=new Employee();
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/transport","root","1234");
System.out.println("1.Manager 2.Employee");
Scanner scan=new Scanner(System.in);
System.out.println("Enter your choice");
int number=scan.nextInt();
if(number==1){
	System.out.println("Enter your password");
	String password=scan.next();
	PreparedStatement pst=con.prepareStatement("select Name,password from manager where password=?");
	pst.setString(1,password.toString());
	ResultSet rs=pst.executeQuery();
	String name="";
	String pass="";
	while(rs.next()){
	name=rs.getString("Name");
	pass=rs.getString("password");
	}
	if(password.equals(pass)){
	System.out.println("Hello"+" "+"Mr."+name);
	System.out.println("What do you want to do?");
	System.out.println("1.Add Employee   2.Remove Employee    3.Details Employee    4.Transfer Employee   5.Sales Monthly Data ");
	System.out.println("Enter you choice");
	int response=scan.nextInt();
	if(response==1){
		m.addEmployee();
			}
			else if(response==2){
				m.removeEmployee();
			}
			else if(response==3){
				m.detailsEmployee();
			}
			else if(response==4){
				m.transferEmployee();
			}
			else if(response==5){
				m.saleMonthly();
				}
			}
			else{
				System.out.println("Please enter correct password");
			}
		}
		else if(number==2){
			System.out.println("What do you want to do?");
			System.out.println("1. Sale_Done   2. Incentives Gained    3. Attendance   4.All");
			int response=scan.nextInt();
			if(response==1){
				em.salesDone();
			}
			else if(response==2){
				em.incentivesGained();
			}
			else if(response==3){
				em.attendance();
			}
			else if(response==4){
				em.all();
			}
			
		}
	}
}

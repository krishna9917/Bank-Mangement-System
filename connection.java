package BankServices;
import java.sql.*;
public class connection {
	   Connection con;
		Statement Database;
		
		public connection()
		{
			try {
				  Class.forName("com.mysql.cj.jdbc.Driver");
				  con=DriverManager.getConnection("jdbc:mysql://localhost/banksystem","root","");
				  Database=con.createStatement();
              
			}
			catch(Exception e)
			{
				System.out.println("Connection is not established"+e);
			}
		}
}


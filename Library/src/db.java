import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class db {

	public static void main(String[] args) throws Exception {
		  try
			 {
				  Class.forName("com.mysql.cj.jdbc.Driver");
				  
				  Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.11:3325/library?serverTimezone=UTC", "root" , "" );
				  Statement stmt = con.createStatement();
				
				  ResultSet rs = stmt.executeQuery("select * from librarian");

		          System.out.print("Name"+"      |      "+"Password"+"      |      "+"Email"+"      |      "+"Address"+"      |      "+"City"+"      |      "+"Contact");
                  System.out.println();
		             
				  while(rs.next())
				  {
		             System.out.print(rs.getString(2));
		             System.out.print("      |      ");
		             System.out.print(rs.getString(3));
		             System.out.print("      |      ");
			         System.out.print(rs.getString(4));
		             System.out.print("      |      ");
		             System.out.print(rs.getString(5));
		             System.out.print("      |      ");
		             System.out.print(rs.getString(6));
		             System.out.print("      |      ");
		             System.out.print(rs.getString(7));
		             System.out.println();
				  }
				  
				  stmt.close();
				  con.close();

			 }
			  catch(Exception e)
			  {
				  System.out.println(e);
			  }

	}


}



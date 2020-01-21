import java.sql.Connection;
import java.sql.DriverManager;

public class Database_Connection {
	
	Connection connect() {

	try{  
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","");  
		  //here exam is database name,username,password  
		 System.out.println("Database is connected successfully");
		 return con;
		 //con.close();  
		}catch(Exception e){ System.out.println(e);}
	     return null;
        }
}

  


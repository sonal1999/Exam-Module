import java.sql.Connection;
import java.sql.DriverManager;

public class Database_Connection {
	
	Connection connect() {

	try{  
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","");  
		 System.out.println("Database is connected successfully");
		 return con;
		}catch(Exception e){ System.out.println(e);}
	     return null;
        }
}

  


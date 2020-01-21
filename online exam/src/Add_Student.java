import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add_Student extends JFrame  implements ActionListener {
		      
	TextField Roll_No_Field;
    TextField Email_Field;
    Label message;
		void add(JFrame f) {     
	        Label Roll_No_Label = new Label("Roll No.");
	        Label Email_Label = new Label("Email");
	      
	        Roll_No_Field = new TextField("3",100);
	        Email_Field = new TextField("4",100);
	        
	        Button add = new Button("Add");
	        add.addActionListener(this);
	         
	        f.add(Roll_No_Label);
	        f.add(Roll_No_Field);
	        f.add(Email_Label);
	        f.add(Email_Field);

	        f.add(add);        

	        Roll_No_Label.setBounds(75,155,100,30);
	        Roll_No_Field.setBounds(250,165,350,30);
	        Email_Label.setBounds(75,210,100,25);
	        Email_Field.setBounds(250,215,350,25);

	        add.setBounds(300,350,100,50);             
		}
		
	
		public void actionPerformed(ActionEvent ae){
			
			  String roll_No_Text,email;
			
			  
		     
		      roll_No_Text = Roll_No_Field.getText();
		      email =Email_Field.getText();
		     
		      
			 
		      System.out.println(roll_No_Text+"\n"+email);
		 
			  Database_Connection connection = new Database_Connection();
		      Connection conn = connection.connect();
		         
		      String query = " insert into student (rollNo,email)"
		        	        + " values (?, ?)";
		         
		      PreparedStatement preparedStmt = null;
		         
				try {
					 preparedStmt = conn.prepareStatement(query);
		        	 preparedStmt.setString(1,roll_No_Text);
					 preparedStmt.setString (2,email);
					
			         preparedStmt.execute();     
			         conn.close();			         			        
				     } catch (SQLException e) {	
					e.printStackTrace();
				 }
		             
			System.out.println("Hello i am from actionPerformed");
			System.out.println("Now it's done");		
	}

}

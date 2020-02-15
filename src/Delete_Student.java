import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Delete_Student extends JFrame  implements ActionListener {
	
	TextField roll_No_Field ;
	TextField name_Field;
	TextField class_Field;
	TextField email_Field;
    TextField contact_No_Field;
	 Button view;
	 Button delete;
	void remove(JFrame f) {
			   
	        Label name_Label = new Label("Name");
	        Label class_Label = new Label("Class");
	        Label roll_No_Label = new Label("Roll No.");
	        Label email_Label = new Label("Email");
	        Label contact_No_Label = new Label("Contact No");
	        
	        name_Field = new TextField("1",100);
	        class_Field = new TextField("2",100);
	        roll_No_Field = new TextField("3",100);
	        email_Field = new TextField("4",100);
	        contact_No_Field = new TextField("Enter correct answer",100);
	        
	        Button delete = new Button("Remove");
	        delete.addActionListener(this);
	        
	        Button view = new Button("View Student");
	        view.addActionListener(this);
	        
	        f.add(roll_No_Label);
	        f.add(roll_No_Field);
	        f.add(view);
	        f.add(name_Label);
	        f.add(name_Field);
	        f.add(class_Label);
	        f.add(class_Field);
	       
	        
	        f.add(email_Label);
	        f.add(email_Field);
	        f.add(contact_No_Label);
	        f.add(contact_No_Field);
	        f.add(delete);
	        
	       
	        roll_No_Label.setBounds(75,45,100,30);
	        roll_No_Field.setBounds(250,55,350,30);
	        view.setBounds(300,125,100,50);
	        
	        name_Label.setBounds(75,240,100,25);
		    name_Field.setBounds(250,240,300,25);
	        class_Label.setBounds(75,280,100,25);
	        class_Field.setBounds(250,280,350,25);
	        contact_No_Label.setBounds(75,330,100,25);
	        contact_No_Field.setBounds(250,330,350,25);
	        email_Label.setBounds(75,380,100,25);
	        email_Field.setBounds(250,380,350,25);
	        delete.setBounds(300,500,100,50);          
	        
		}
	
		
		public void actionPerformed(ActionEvent ae){
	      String roll_No_Text = roll_No_Field.getText();
		  int roll_No = Integer.parseInt(roll_No_Text);
			  
	      Database_Connection connection = new Database_Connection();
	      Connection conn = connection.connect();
	          
		  if(ae.getActionCommand().equals("View Student")) {
			
			  System.out.println("I am from action performed1111111");
			  
			   try {
				   
				   Statement stmt = conn.createStatement();
		           ResultSet rs=stmt.executeQuery("select * from student where rollNO="+roll_No);
		           rs.next();
		
		           name_Field.setText(rs.getString("name"));
		           class_Field.setText(rs.getString("class"));
		           email_Field.setText(rs.getString("email"));
		           contact_No_Field.setText(rs.getString("contactNo"));
	   
		          
	              } catch (SQLException e) {
		            e.printStackTrace();
	              }
	      }
		  
		 if(ae.getActionCommand().equals("Remove")) {
			  
			  System.out.println("I am from action performed22222"); 
			  int n=0;
			 
			
			  try {
				Statement stm = conn.createStatement();
				n = stm.executeUpdate("delete from student where rollNO="+roll_No);
				n++;
				name_Field.setText("");
		        class_Field.setText("");
		        email_Field.setText("");
		        contact_No_Field.setText("");
				conn.close();
			  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
			  System.out.println(n);   
		  } 
  }
}

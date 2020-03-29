import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Delete_Student extends JFrame{
	
	TextField roll_No_Field ;
	TextField name_Field;
	TextField class_Field;
	TextField email_Field;
    TextField contact_No_Field;
	 Button view;
	 Button delete;
	void remove(JFrame f) {
		 Database_Connection connection = new Database_Connection();
	      Connection conn = connection.connect();
			   
	        Label name_Label = new Label("Name");
	        Label roll_No_Label = new Label("Roll No.");
	        Label email_Label = new Label("Email");
	        Label contact_No_Label = new Label("Contact No");
	        
	        name_Field = new TextField("",100);
	        roll_No_Field = new TextField("",100);
	        email_Field = new TextField("",100);
	        contact_No_Field = new TextField("",100);
	      //  contact_No_Field.setEchoChar("*");
	        
	        Button delete = new Button("Remove");
	        delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 String roll_No_Text = roll_No_Field.getText();
					  int roll_No = Integer.parseInt(roll_No_Text);
					  int n=0;
					 
					  try {
						Statement stm = conn.createStatement();
						n = stm.executeUpdate("delete from student where rollNO="+roll_No);
						n++;
						name_Field.setText("");
				        email_Field.setText("");
				        contact_No_Field.setText("");
				        roll_No_Field.setText("");
						conn.close();
						 JOptionPane.showMessageDialog(f,"Student record is deleted succussfully!!!");
					  } catch (SQLException e11) {
						// TODO Auto-generated catch block
						  JOptionPane.showMessageDialog(f,"Problem raised while deleting record...");
						e11.printStackTrace();
						 
					  }  
				  } 	
	        });
	        
	        Button view = new Button("View Student");
	        view.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 String roll_No_Text = roll_No_Field.getText();
					  int roll_No = Integer.parseInt(roll_No_Text);
						  
					 try {
						   
						   Statement stmt = conn.createStatement();
				           ResultSet rs=stmt.executeQuery("select name,email,contactNo from student where rollNO="+roll_No);
				           rs.next();
				
				           name_Field.setText(rs.getString("name"));
				           email_Field.setText(rs.getString("email"));
				           contact_No_Field.setText(rs.getString("contactNo"));
		   
			              } catch (SQLException e11) {
			            	  JOptionPane.showMessageDialog(f,"Please enter valid roll number...");
				            e11.printStackTrace();
			              }
				}
	        });
	        
	        
	        f.add(roll_No_Label);
	        f.add(roll_No_Field);
	        f.add(view);
	        f.add(name_Label);
	        f.add(name_Field);  
	        f.add(email_Label);
	        f.add(email_Field);
	        f.add(contact_No_Label);
	        f.add(contact_No_Field);
	        f.add(delete);
	        
	       
	        roll_No_Label.setBounds(75,45,100,30);
	        roll_No_Field.setBounds(250,55,350,30);
	        view.setBounds(300,125,100,50);
	     
	        name_Label.setBounds(75,240,100,25);
		    name_Field.setBounds(250,240,350,25);
		    contact_No_Label.setBounds(75,280,100,25);
		    contact_No_Field.setBounds(250,280,350,25);
		    email_Label.setBounds(75,330,100,25);
		    email_Field.setBounds(250,330,350,25);
	        delete.setBounds(300,390,100,50);          
	        
		}	     
}
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

public class Login extends JFrame implements ActionListener {
	
	private Container cp;
	JComboBox user_Type_List;
	 JTextField username_Field;
     JPasswordField password_Field;
    public int roll_No;
     
     Login(){
    	 
     }
	
		Login(String title){
			setVisible(true);
			setLocation(50,50);
			setSize(750,750);
			setTitle(title);
			
			cp=getContentPane();
		         
		        Label user_Type_Label = new Label("Usertype");
		        Label username_Label = new Label("Username");
		        Label Password_Label = new Label("Password");
		       
	 	        user_Type_List = new JComboBox();
		        
		        user_Type_List.addItem("Student"); 
		        user_Type_List.addItem("Teacher");
		        user_Type_List.setSelectedItem(null);
		   
		         username_Field = new JTextField("",100);
		         password_Field = new JPasswordField("",100);
		         password_Field.setEchoChar('*');
		        Button login_Button = new Button("Login");
		        login_Button.addActionListener(this);
		        
		        cp.setLayout(null);
		        cp.setBackground(Color.LIGHT_GRAY);
		        
		        cp.add(user_Type_Label);
		        cp.add(user_Type_List);
		        cp.add(username_Label);
		        cp.add(username_Field);
		        cp.add(Password_Label);
		        cp.add(password_Field);
		        cp.add(login_Button);
		       
		        username_Field.setToolTipText("Enter Username");
		        
		        user_Type_Label.setBounds(200,50,100,50);
		        user_Type_List.setBounds(200,100,280,30);
		        username_Label.setBounds(200,170,100,50);
		        username_Field.setBounds(200,220,300,30);
		        Password_Label.setBounds(200,290,100,30);
		        password_Field.setBounds(200,330,300,30);
		        login_Button.setBounds(200,450,300,45); 
		}
		
		public static void main(String[] args) {		
	        Login login_Frame = new Login("Login"); 
	       	}
		
		public void actionPerformed(ActionEvent ae){
			
			Database_Connection connection = new Database_Connection();
	         Connection conn = connection.connect();
	   
			if(((String) user_Type_List.getSelectedItem()).trim().equals("Teacher")) { 
		     
				if(username_Field.getText().trim().equals("Admin") && 
		           password_Field.getText().trim().equals("Admin@123")) {
		           System.out.println("Admin loged in successfully");
		           Admin_Frame admin_Frame = new Admin_Frame("Admin");
		           this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
				}else {
					 JOptionPane.showMessageDialog(this,"You entered wrong username or password!"); 
				}
				
			}
			else {
		         int index = Integer.parseInt(username_Field.getText());
		         
		         try {
					   
					   Statement stmt = conn.createStatement();
			           ResultSet rs=stmt.executeQuery("select password from student where rollNo="+index);
			           rs.next();
	                   
			           if(password_Field.getText().trim().equals(rs.getString("password"))) {
	                   
			        	   System.out.println("Student logged in successfully");
			 
			        	   JFrame frame = new JFrame();  
			        	   frame.setVisible(true);
			        	   Student window = new Student(frame , index);
			        	   
			        	 this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		                }
			           else {
			        	   JOptionPane.showMessageDialog(this,"You entered wrong username or password!"); 
			           }
			           }catch (SQLException e) {
			            e.printStackTrace();
		              }	
	}
 }	
}

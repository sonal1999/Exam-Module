import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete_Question extends JFrame{
	
	TextField index_Question_Field ;
    TextArea view_Question_Area;
    Button delete_Button;
    Button view_Button;
    
	void delete(JFrame f) {
		         
		 Database_Connection connection = new Database_Connection();
         Connection conn = connection.connect();
         
		        Label index_Question_Label = new Label("Enter a index of question");
		        Label view_Question_Label = new Label("Question is");
		        
		        index_Question_Field = new TextField("",200);
		        view_Question_Area = new TextArea("Enter your password",300,200);
		         
		        delete_Button = new Button("Delete");
		        delete_Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						 String index_Text =index_Question_Field.getText();
						  int index = Integer.parseInt(index_Text);
						  
						 System.out.println("I am from action performed3333"); 
						  int n=0;
						 
						
						try {
							Statement stm = conn.createStatement();
							n = stm.executeUpdate("delete from question_bank where id="+index);
							n++;
							view_Question_Area.setText("");
							index_Question_Field.setText("");
							conn.close();
							JOptionPane.showMessageDialog(f,"Question record is deleted succussfully!!!");
						} catch (SQLException e11) {
							// TODO Auto-generated catch block
							e11.printStackTrace();
							JOptionPane.showMessageDialog(f,"Problem raised while deleting question record...");
						}
						  System.out.println(n); 
					 }
					});

		        
		        view_Button = new Button("View Question");
		        view_Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						 String index_Text =index_Question_Field.getText();
						  int index = Integer.parseInt(index_Text);
						  System.out.println("I am from action performed44444");
						  
						   try {
							   
							   Statement stmt = conn.createStatement();
					           ResultSet rs=stmt.executeQuery("select question from question_bank where id="+index);
					           rs.next();
					
					           view_Question_Area.setText(rs.getString("question"));
					           
				              } catch (SQLException e11) {
				            	  JOptionPane.showMessageDialog(f,"Please enter valid question number...");
					            e11.printStackTrace();
				              }
					}
					});

		        
		        f.setLayout(null);
		        f.setBackground(Color.LIGHT_GRAY);
		        
		        f.add(index_Question_Label);
		        f.add(index_Question_Field);
		        f.add(view_Button);
		        f.add(view_Question_Label);
		        f.add(view_Question_Area);
		       
		        f.add(delete_Button);
		      
		        index_Question_Label.setBounds(200,50,200,50);
		        index_Question_Field.setBounds(200,100,200,30);
		        view_Button.setBounds(200,150,100,35);
		        view_Question_Label.setBounds(200,220,300,30);
		        view_Question_Area.setBounds(200,250,300,200);
		        delete_Button.setBounds(200,500,300,30);
		       		     
		}
}

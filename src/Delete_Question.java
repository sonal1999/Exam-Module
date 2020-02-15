import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete_Question extends JFrame  implements ActionListener{
	
	TextField index_Question_Field ;
    TextArea view_Question_Area;
    Button delete_Button;
    Button view_Button;
    
	void delete(JFrame f) {
		         
		        Label index_Question_Label = new Label("Enter a index of question");
		        Label view_Question_Label = new Label("Question is");
		        
		        index_Question_Field = new TextField("",200);
		        view_Question_Area = new TextArea("Enter your password",300,200);
		         
		        delete_Button = new Button("Delete");
		        delete_Button.addActionListener(this);
		        
		        view_Button = new Button("View Question");
		        view_Button.addActionListener(this);
		        
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
				
		public void actionPerformed(ActionEvent ae){
			
			 String index_Text =index_Question_Field.getText();
			  int index = Integer.parseInt(index_Text);
			  
			  Database_Connection connection = new Database_Connection();
	          Connection conn = connection.connect();
			
			 if(ae.getActionCommand().equals("View Question")) {
					
				  System.out.println("I am from action performed44444");
				  
				   try {
					   
					   Statement stmt = conn.createStatement();
			           ResultSet rs=stmt.executeQuery("select question from question_bank where id="+index);
			           rs.next();
			
			           view_Question_Area.setText(rs.getString("question"));
			           
		              } catch (SQLException e) {
			            e.printStackTrace();
		              }
		      }
			 
			
			 if(ae.getActionCommand().equals("Delete")) {
				  
				  System.out.println("I am from action performed3333"); 
				  int n=0;
				 
				
				try {
					Statement stm = conn.createStatement();
					n = stm.executeUpdate("delete from question_bank where id="+index);
					n++;
					view_Question_Area.setText("");
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  System.out.println(n); 
			 }
	}
}

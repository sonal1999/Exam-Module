import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;

public class Insert_Question extends JFrame
{
	JComboBox select_Subject_List;
	TextArea question_Area;
	TextField option1;
	TextField option2; 
	TextField option3; 
	TextField option4; 
	TextField answer_Field;
	
	Insert_Question(){}
	
	void insert(JFrame f) {         
	        Label select_Subject_Label = new Label("Select Subject");
	        Label question_Label = new Label("Question");
	        Label options_Label = new Label("Options");
	        Label answer_Label = new Label("Answer");
	        
	        select_Subject_List = new JComboBox();
	        
	        select_Subject_List.addItem("Mathematics");
	        select_Subject_List.addItem("Physics");
	        select_Subject_List.addItem("Chemistry");
	        select_Subject_List.addItem("Biology");
	        select_Subject_List.setSelectedItem(null);
	     
	        
	        question_Area = new TextArea("",50,50,TextArea.SCROLLBARS_BOTH);
	        
	        option1 = new TextField("",100);
	        option2 = new TextField("",100);
	        option3 = new TextField("",100);
	        option4 = new TextField("",100);
	        answer_Field = new TextField("",100);
	       
	        
	        Button insert = new Button("Insert");
	        insert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 String question,option11,option12,option13,option14,answer;
				     int subject;
				     
				 	 subject = select_Subject_List.getSelectedIndex();
				 	 question = question_Area.getText();
				     option11 =option1.getText();
					 option12 = option2.getText();
				     option13 = option3.getText();
				     option14 = option4.getText();
					 answer = answer_Field.getText();
					 
				     System.out.println(subject+"\n"+question+"\n"+option11+"\n"+option12+"\n"+option13+"\n"+option14+"\n"+answer+"\n");
				 
						 Database_Connection connection = new Database_Connection();
				         Connection conn = connection.connect();
				         
				         String query = " insert into question_bank (subject,question,option1,option2,option3,option4,answer)"
				        	        + " values (?, ?, ?, ?, ?,?,?)";
				         
				         PreparedStatement preparedStmt = null;
				         
						try {
							 preparedStmt = conn.prepareStatement(query);
				        	 preparedStmt.setInt(1,subject);
							 preparedStmt.setString (2,question);
							 preparedStmt.setString (3,option11);
					         preparedStmt.setString(4,option12);
					         preparedStmt.setString(5,option13);
					         preparedStmt.setString(6,option14);
					         preparedStmt.setString(7,answer);
					         preparedStmt.execute();     
					         conn.close();
					         
					         select_Subject_List.setSelectedItem(null);
						 	 question_Area.setText("");
						     option1.setText("");
							 option2.setText("");
						     option3.setText("");
						     option4.setText("");
							 answer_Field.setText("");
							 
					         JOptionPane.showMessageDialog(f,"Your data is stored succussfully!!!");
						     } catch (SQLException e11) {	
						    	 JOptionPane.showMessageDialog(f,"Problem raised while storing data...");
							e11.printStackTrace();
						 }
				             
					System.out.println("Hello i am from actionPerformed");
					System.out.println("Now it's done");	
				  }

				});

	   
	       
	        f.add(select_Subject_Label);
	        f.add(select_Subject_List);
	        f.add(question_Label);
	        f.add(question_Area);
	        f.add(options_Label);
	        f.add(option1);
	        f.add(option2);
	        f.add(option3);
	        f.add(option4);
	        f.add(answer_Label);
	        f.add(answer_Field);
	        f.add(insert);
	        
	        select_Subject_Label.setBounds(75,55,100,50);
	        select_Subject_List.setBounds(250,75,271, 40);
	        question_Label.setBounds(75,100,100,115);
	        question_Area.setBounds(250,150,450,150);
	        options_Label.setBounds(75,315,100,50);
	        option1.setBounds(250,325,250,25);
	        option2.setBounds(250,365,250,25);
	        option3.setBounds(250,405,250,25);
	        option4.setBounds(250,445,250,25);
	        answer_Label.setBounds(75,485,100,50);
	        answer_Field.setBounds(250,500,250,25);
	        insert.setBounds(330,600,100,50);
	}	
   }

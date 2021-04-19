
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class update_Question extends JFrame{   
	JComboBox select_Subject_List;
	TextArea question_Area;
	TextField index_question_to_delete__Field;
    TextField option1;
    TextField option2;
    TextField option3;
    TextField option4;
    TextField answer_Field;
    Button insert;
    Button view_Question;
	String question,option11,option12,option13,option14,answer;
    int subject;
    Database_Connection connection = new Database_Connection();
    Connection conn = connection.connect();
    String index;
	
   
   
	void update(JFrame f) {
	        Label index_question_to_delete_Label = new Label("Enter question index");
	        Label Question_details_Label = new Label("Question details are as follow update it as per your requirement");	        
	        Label select_Subject_Label = new Label("Select Subject");
	        Label question_Label = new Label("Question");
	        Label options_Label = new Label("Options");
	        Label answer_Label = new Label("Answer");
	        
	        select_Subject_List = new JComboBox();
	        
	        select_Subject_List.addItem("Physics");
	        select_Subject_List.addItem("Chemistry");
	        select_Subject_List.addItem("Biology");
	        select_Subject_List.addItem("Mathematics");
	        select_Subject_List.setSelectedItem(null);
	        
	        question_Area = new TextArea("TextAera is as given",50,50,TextArea.SCROLLBARS_BOTH);
	        
	        index_question_to_delete__Field = new TextField("",100);
	        option1 = new TextField("",100);
	        option2 = new TextField("",100);
	        option3 = new TextField("",100);
	        option4 = new TextField("",100);
	        answer_Field = new TextField("",100);
	        
	        insert = new Button("Update");
	        insert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 index=index_question_to_delete__Field.getText();
					 System.out.println("I am from action performed3333"); 
					  int n=0;
					 
					  subject = select_Subject_List.getSelectedIndex();
					 	 question = question_Area.getText();
					     option11 =option1.getText();
						 option12 = option2.getText();
					     option13 = option3.getText();
					     option14 = option4.getText();
						 answer = answer_Field.getText();
					try {
						PreparedStatement stm = conn.prepareStatement("update question_bank set subject=? , question=? , option1=? , option2=? , option3=? , option4=? , answer=? where id="+index);
						stm.setInt(1,subject);
						stm.setString(2,question);
						stm.setString(3,option11);
						stm.setString(4,option12);
						stm.setString(5,option13);
						stm.setString(6,option14);
						stm.setString(7,answer);
						
						stm.executeUpdate();
						n++;
						conn.close();
						
						select_Subject_List.setSelectedItem(null);
					 	 question_Area.setText("");
					     option1.setText("");
						 option2.setText("");
					     option3.setText("");
					     option4.setText("");
						 answer_Field.setText("");
						 index_question_to_delete__Field.setText("");
						 
						JOptionPane.showMessageDialog(f,"Your question is updated succussfully!!!");
					} catch (SQLException e11) {
						JOptionPane.showMessageDialog(f,"Problem raised while updating question record...");
						e11.printStackTrace();
					}
					  System.out.println(n); 
				 }	    

				});

	        
	        view_Question = new Button("View Question");
	        view_Question.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 index=index_question_to_delete__Field.getText();
					 System.out.println("I am from action performed555555");
					  
					   try {
						   
						   Statement stmt = conn.createStatement();
				           ResultSet rs=stmt.executeQuery("select * from question_bank where id="+index);
				           rs.next();
				
				           question_Area.setText(rs.getString("question"));
				           select_Subject_List.setSelectedIndex(rs.getInt("subject"));
				           option1.setText((rs.getString("option1")));
				           option2.setText((rs.getString("option2")));
				           option3.setText((rs.getString("option3")));
				           option4.setText((rs.getString("option4")));
				           answer_Field.setText((rs.getString("answer")));		           
			              } catch (SQLException e11) {
			            	  JOptionPane.showMessageDialog(f,"Please enter valid question number...");
				            e11.printStackTrace();
			              }
				}
				});
	       
	        f.add(index_question_to_delete_Label);
	        f.add(index_question_to_delete__Field);
	        f.add( view_Question);
	        f.add( Question_details_Label);
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
	        
	        index_question_to_delete_Label.setBounds(75,30,150,25);
	        index_question_to_delete__Field.setBounds(250,30,100,25);
	        view_Question.setBounds(500,30,100,25);
	        Question_details_Label.setBounds(75,55,500,50);
	        select_Subject_Label.setBounds(75,85,100,50);
	        select_Subject_List.setBounds(250,105,271, 40);
	        question_Label.setBounds(75,130,100,115);
	        question_Area.setBounds(250,180,450,150);
	        options_Label.setBounds(75,345,100,50);
	        option1.setBounds(250,355,250,25);
	        option2.setBounds(250,395,250,25);
	        option3.setBounds(250,435,250,25);
	        option4.setBounds(250,475,250,25);
	        answer_Label.setBounds(75,515,100,50);
	        answer_Field.setBounds(250,530,250,25);
	        insert.setBounds(330,620,100,50);
	}
}



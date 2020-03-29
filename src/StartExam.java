import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Button;
import java.awt.Label;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class StartExam {

    final ButtonGroup buttonGroup = new ButtonGroup();
	Button button_1;
	Button button_2;
	Button button_3;
	Label roll_No_Label;
	Label question_Label;
	JRadioButton ans_1,ans_2,ans_3,ans_4;
	Statement stmt;
	ResultSet rs;
	int count = 0;
	String name;
	
	void getData(int number) {
		Database_Connection connection = new Database_Connection();
	    Connection conn = connection.connect();
		try {
			stmt = conn.createStatement();
			rs=stmt.executeQuery("select * from question_bank where subject="+number);
			//name = rs.getString('name')
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
    
	public StartExam(JFrame frame,int index,int number) {
		getData(number);
	
		try {
			Button button = new Button("Previous");			
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 try {
					       
						 try {
						 System.out.println(buttonGroup.getSelection().getActionCommand()); 
						 if(buttonGroup.getSelection().getActionCommand().equals(rs.getString("answer"))) {
							count++;
						 }
						 
						 buttonGroup.clearSelection();
						 }
						 catch(Exception e11) {
							 System.out.println(e11);
						 }
						
					        rs.previous();

					        question_Label.setText(rs.getString("question"));
					     
					     
					        ans_1.setText(rs.getString("option1"));
					         ans_1.setActionCommand(rs.getString("option1"));
					         
					         ans_2.setText(rs.getString("option2"));
					         ans_2.setActionCommand(rs.getString("option2"));
					         
					         ans_3.setText(rs.getString("option3"));
					         ans_3.setActionCommand(rs.getString("option3"));
					         
					         ans_4.setText(rs.getString("option4"));
					         ans_4.setActionCommand(rs.getString("option4"));       
						 
						 
					         		           
					       } catch (SQLException e3) {
					    	   JOptionPane.showMessageDialog(frame,"You are at first question !!!");
					         e3.printStackTrace();
					       }

				}		
			});
			

			button.setFont(new Font("Dialog", Font.BOLD, 15));
			button.setBackground(Color.ORANGE);
			button.setBounds(0, 591, 137, 38);
			frame.getContentPane().add(button);
			
			button_1 = new Button("Next");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 try {
						 try {
							 System.out.println(buttonGroup.getSelection().getActionCommand()); 
							 if(buttonGroup.getSelection().getActionCommand().equals(rs.getString("answer"))) {
								 count++;	 
							 }
							
							 buttonGroup.clearSelection();
							 }
							 catch(Exception e11) {
								 System.out.println(e11);
							 }
					       
					        rs.next();

					        question_Label.setText(rs.getString("question"));
					    
					        ans_1.setText(rs.getString("option1"));
					         ans_1.setActionCommand(rs.getString("option1"));
					         
					         ans_2.setText(rs.getString("option2"));
					         ans_2.setActionCommand(rs.getString("option2"));
					         
					         ans_3.setText(rs.getString("option3"));
					         ans_3.setActionCommand(rs.getString("option3"));
					         
					         ans_4.setText(rs.getString("option4"));
					         ans_4.setActionCommand(rs.getString("option4"));  
					         		           
					       } catch (SQLException e3) {
					    	   JOptionPane.showMessageDialog(frame,"You are at last question !!!");
					         e3.printStackTrace();
					       }
				}		
			});
			button_1.setBackground(SystemColor.textHighlight);
			button_1.setFont(new Font("Dialog", Font.BOLD, 15));
			button_1.setBounds(192, 591, 137, 38);
			frame.getContentPane().add(button_1);
			//button_1.addActionListener((ActionListener) this);
			
			button_2 = new Button("End Exam");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 JOptionPane.showMessageDialog(frame,"Your hava scored "+count+" marks.");
					 Database_Connection connection = new Database_Connection();
					    Connection conn = connection.connect();
						try {
							String query = " insert into record (rollNo , subject , marks) values ( ? , ? , ?);";
							PreparedStatement preparedStmt = null;
							 preparedStmt = conn.prepareStatement(query);
							
							 preparedStmt.setInt(1,index);
							 preparedStmt.setInt(3,count);
							 
							if(number == 0) {
								 preparedStmt.setString(2,"Mathmatics");
								
							}else if(number == 1){
								 preparedStmt.setString(2,"Physics");
							}else if(number == 2){
								 preparedStmt.setString(2,"Chemistry");
							}else {
								preparedStmt.setString(2,"Biology");
							}
						         preparedStmt.execute();     
						} 
						 catch (SQLException e11) {
							// TODO Auto-generated catch block
							e11.printStackTrace();
						}
					frame.getContentPane().removeAll();  
				    new Student(frame,index);
					frame.revalidate();
					frame.repaint();
			}
			});
			button_2.setBackground(Color.RED);
			button_2.setFont(new Font("Dialog", Font.BOLD, 15));
			button_2.setBounds(576, 591, 137, 38);
			frame.getContentPane().add(button_2);
			
			roll_No_Label = new Label("RollNo:", Label.LEFT);
			roll_No_Label.setFont(new Font("Dialog", Font.PLAIN, 14));
			roll_No_Label.setBounds(0, 50, 72, 21);
			frame.getContentPane().add(roll_No_Label);
			
			Label label_2 = new Label("Subject:", Label.LEFT);
			label_2.setFont(new Font("Dialog", Font.PLAIN, 14));
			label_2.setBounds(266, 50, 72, 21);
			frame.getContentPane().add(label_2);
			
			Label label_3 = new Label("Time:", Label.LEFT);
			label_3.setFont(new Font("Dialog", Font.PLAIN, 14));
			label_3.setBounds(520, 50, 56, 21);
			frame.getContentPane().add(label_3);
			
			Label label_4 = new Label("Que : ", Label.LEFT);
			label_4.setFont(new Font("Dialog", Font.PLAIN, 14));
			label_4.setBounds(0, 110, 48, 51);
			frame.getContentPane().add(label_4);
					
			ans_1 = new JRadioButton(rs.getString("option1"));
	         ans_1.setActionCommand(rs.getString("option1"));
			buttonGroup.add(ans_1);
			ans_1.setVerticalAlignment(SwingConstants.BOTTOM);
			ans_1.setBounds(70, 250, 500, 33);
			frame.getContentPane().add(ans_1);
			
			ans_2 = new JRadioButton(rs.getString("option2"));
	         ans_2.setActionCommand(rs.getString("option2"));
			buttonGroup.add(ans_2);
			ans_2.setVerticalAlignment(SwingConstants.BOTTOM);
			ans_2.setBounds(70, 320, 500, 33);
			frame.getContentPane().add(ans_2);
			
			ans_3 = new JRadioButton(rs.getString("option3"));
	         ans_3.setActionCommand(rs.getString("option3"));
			buttonGroup.add(ans_3);
			ans_3.setVerticalAlignment(SwingConstants.BOTTOM);
			ans_3.setBounds(70, 390, 500, 33);
			frame.getContentPane().add(ans_3);
			
			ans_4 = new JRadioButton(rs.getString("option4"));
	         ans_4.setActionCommand(rs.getString("option4"));
			buttonGroup.add(ans_4);
			ans_4.setVerticalAlignment(SwingConstants.BOTTOM);
			ans_4.setBounds(70, 460, 500, 33);
			frame.getContentPane().add(ans_4);
			
			Label label_5 = new Label("Options:");
			label_5.setFont(new Font("Dialog", Font.PLAIN, 14));
			label_5.setBounds(0, 200, 82, 38);
			frame.getContentPane().add(label_5);
			
			Label label_6 = new Label();
			label_6.setText(""+index);
			label_6.setBounds(83, 50, 191, 21);
			frame.getContentPane().add(label_6);
			
			Label label_7 = new Label();
			if(number == 0) {
				label_7.setText("Mathmatics");
			}else if(number == 1) {
				label_7.setText("Physics");
			}else if(number == 2) {
				label_7.setText("Chemistry");
			}else {
				label_7.setText("Biology");
			}
			label_7.setBounds(356, 50, 148, 21);
			frame.getContentPane().add(label_7);
			
			Label label_8 = new Label("10:00");
			label_8.setBounds(580, 50, 133, 21);
			frame.getContentPane().add(label_8);
			
			question_Label = new Label(rs.getString("question"));
			question_Label.setBounds(54, 110, 659, 51);
			frame.getContentPane().add(question_Label);
		}
		catch(Exception e) {
			System.out.println("Ohhhh No...Don't come again");
		}
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class StartExam {

	//private JFrame frame;
	//private final JPanel panel = new JPanel();
	//private Button button;
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
	/**
	 * Create the application.
	 */
	void getData() {
		Database_Connection connection = new Database_Connection();
	    Connection conn = connection.connect();
		try {
			stmt = conn.createStatement();
			rs=stmt.executeQuery("select * from question_bank where subject="+0);
			//name = rs.getString('name')
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
    
	public StartExam(JFrame frame,int index) {
		getData();
		//	frame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		  //  frame.setLocation(50, 50);
		//	frame.setSize(750,750);
			//frame.setBounds(100, 100, 450, 300);
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//frame.getContentPane().setLayout(null);
		//	panel.setBounds(0, 0, 0, 0);
			//frame.getContentPane().setLayout(new CardLayout(0, 0));
			//frame.getContentPane().add(panel);
		try {
		
			
			Button button = new Button("Previous");
			//button.setAlignment(button.left); 
			
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
					         e3.printStackTrace();
					       }
				}		
			});
			button_1.setBackground(Color.BLUE);
			button_1.setFont(new Font("Dialog", Font.BOLD, 15));
			button_1.setBounds(192, 591, 137, 38);
			frame.getContentPane().add(button_1);
			//button_1.addActionListener((ActionListener) this);
			
			button_2 = new Button("End Exam");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(index);
					
					
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
			
			button_3 = new Button("View");
			button_3.setBackground(Color.GREEN);
			button_3.setFont(new Font("Dialog", Font.BOLD, 15));
			button_3.setBounds(384,591, 137, 38);
			frame.getContentPane().add(button_3);
			
			Label label = new Label("TEST", Label.CENTER);
			label.setFont(new Font("Dialog", Font.BOLD, 20));
			label.setBackground(SystemColor.textHighlight);
			label.setBounds(308, 10, 113, 61);
			frame.getContentPane().add(label);
			
			roll_No_Label = new Label("RollNo:", Label.LEFT);
			roll_No_Label.setFont(new Font("Dialog", Font.PLAIN, 14));
			roll_No_Label.setBounds(0, 96, 72, 21);
			frame.getContentPane().add(roll_No_Label);
			
			Label label_2 = new Label("Subject:", Label.LEFT);
			label_2.setFont(new Font("Dialog", Font.PLAIN, 14));
			label_2.setBounds(266, 96, 72, 21);
			frame.getContentPane().add(label_2);
			
			Label label_3 = new Label("Time:", Label.LEFT);
			label_3.setFont(new Font("Dialog", Font.PLAIN, 14));
			label_3.setBounds(520, 96, 56, 21);
			frame.getContentPane().add(label_3);
			
			Label label_4 = new Label("Q No:", Label.LEFT);
			label_4.setFont(new Font("Dialog", Font.PLAIN, 14));
			label_4.setBounds(0, 158, 48, 51);
			frame.getContentPane().add(label_4);
					
			ans_1 = new JRadioButton(rs.getString("option1"));
	         ans_1.setActionCommand(rs.getString("option1"));
			buttonGroup.add(ans_1);
			ans_1.setVerticalAlignment(SwingConstants.BOTTOM);
			ans_1.setBounds(0, 280, 500, 33);
			frame.getContentPane().add(ans_1);
			
			ans_2 = new JRadioButton(rs.getString("option2"));
	         ans_2.setActionCommand(rs.getString("option2"));
			buttonGroup.add(ans_2);
			ans_2.setVerticalAlignment(SwingConstants.BOTTOM);
			ans_2.setBounds(0, 350, 500, 33);
			frame.getContentPane().add(ans_2);
			
			ans_3 = new JRadioButton(rs.getString("option3"));
	         ans_3.setActionCommand(rs.getString("option3"));
			buttonGroup.add(ans_3);
			ans_3.setVerticalAlignment(SwingConstants.BOTTOM);
			ans_3.setBounds(0, 420, 500, 33);
			frame.getContentPane().add(ans_3);
			
			ans_4 = new JRadioButton(rs.getString("option4"));
	         ans_4.setActionCommand(rs.getString("option4"));
			buttonGroup.add(ans_4);
			ans_4.setVerticalAlignment(SwingConstants.BOTTOM);
			ans_4.setBounds(0, 490, 500, 33);
			frame.getContentPane().add(ans_4);
			
			Label label_5 = new Label("Options:");
			label_5.setFont(new Font("Dialog", Font.PLAIN, 14));
			label_5.setBounds(0, 224, 82, 38);
			frame.getContentPane().add(label_5);
			
			Label label_6 = new Label("1001");
			label_6.setBounds(83, 96, 191, 21);
			frame.getContentPane().add(label_6);
			
			Label label_7 = new Label("physics");
			label_7.setBounds(356, 96, 148, 21);
			frame.getContentPane().add(label_7);
			
			Label label_8 = new Label("10:00");
			label_8.setBounds(580, 96, 133, 21);
			frame.getContentPane().add(label_8);
			
			question_Label = new Label(rs.getString("question"));
			question_Label.setBounds(54, 158, 659, 51);
			frame.getContentPane().add(question_Label);
		}
		catch(Exception e) {
			System.out.println("Ohhhh No...Don't come again");
		}
	}
}

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;



import java.awt.Label;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.Color;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

public class ChangePassword {

	private JFrame frame;
	
	private JPasswordField password;
	private JPasswordField newpassword;
	private JPasswordField conpassword;

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword window = new ChangePassword();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	*/

	/**
	 * Create the application.
	 */
	public ChangePassword(JFrame frame) {
		//initialize(JFrame frame);
	
	/**
	 * Initialize the contents of the frame.
	 */
	
		//frame = new JFrame();
		//frame.getContentPane().setBackground(UIManager.getColor("Button.light"));
		//frame.setLocation(50, 50);
		//frame.setSize(750,750);
		//frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(null);
		
		Label label = new Label("Username");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setBounds(104, 113, 180, 33);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Current Password");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(104, 180, 180, 33);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("New Password");
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		label_2.setBounds(104, 249, 180, 33);
		frame.getContentPane().add(label_2);
		
		Label label_3 = new Label("Confirm Password");
		label_3.setFont(new Font("Dialog", Font.BOLD, 12));
		label_3.setBounds(104, 317, 180, 33);
		frame.getContentPane().add(label_3);
		
		TextField username = new TextField();
		username.setBounds(419, 113, 159, 33);
		frame.getContentPane().add(username);
		
		password = new JPasswordField();
		password.setBounds(419, 180, 159, 33);
		frame.getContentPane().add(password);
		
			
		
		Label nlab = new Label(" ");
		nlab.setForeground(Color.red);
		nlab.setBounds(419, 280, 288, 33);
		frame.getContentPane().add(nlab);
		
		newpassword = new JPasswordField();
		newpassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String PATTERN="((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
				 
				Pattern patt=Pattern.compile(PATTERN);
				Matcher match=patt.matcher(newpassword.getText());
				if(!match.matches())
				{
					nlab.setText("Please Enter Valid Password");
					
				}
				else
				{
					nlab.setText(null);
				}
			}
		});
		
		newpassword.setBounds(419, 249, 159, 33);
		frame.getContentPane().add(newpassword);
		

		
		conpassword = new JPasswordField();
		conpassword.setBounds(419, 317, 159, 33);
		frame.getContentPane().add(conpassword);
		
		
		
		
		JCheckBox checkbox = new JCheckBox("Show Password");
		checkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkbox.isSelected())
				{
				 password.setEchoChar((char)0);	
				 newpassword.setEchoChar((char)0);
				 conpassword.setEchoChar((char)0);
				}
				else
				{
					 password.setEchoChar('*');
					 newpassword.setEchoChar('*');
					 conpassword.setEchoChar('*');
				}
				
			}
		});
		checkbox.setBounds(419, 398, 159, 33);
		frame.getContentPane().add(checkbox);
		
	
		
		
		JButton changepassword = new JButton("Change Password");
		changepassword.setBackground(Color.GREEN);
		changepassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Validation validation=new Validation();
				
				Database_Connection connection = new Database_Connection();
		        Connection conn = connection.connect();
		        
		        int index = Integer.parseInt(username.getText());
				  try {
					   
					   Statement stmt = conn.createStatement();
			           ResultSet rs=stmt.executeQuery("select password from student where rollNo="+index);
			           rs.next();
			
			          if(password.getText().equals(rs.getString("password"))){
			        	  if(newpassword.getText().equals(conpassword.getText())) {
			        		  
			        		  PreparedStatement stm = conn.prepareStatement("update student set password=? where rollNo="+index);	
			  				stm.setString(1,conpassword.getText());
			  				stm.executeUpdate();
			  				
			  				frame.getContentPane().removeAll();  
			  				Student student = new Student(frame);
			  				frame.revalidate();
			  				frame.repaint();
			  				
			  			
			        	  }
			        	  
			          }
			            
			         
			            
			          
				      
				           
			           //.select(rs.getInt("subject"));
			          
			           
			           
			           
			          // answer_Field.setText((rs.getString("answer")));		           
		              } catch (SQLException e3) {
			            e3.printStackTrace();
		              }
			

			}
		});
        changepassword.setBounds(400, 497, 178, 47);
		frame.getContentPane().add(changepassword);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();  
		Student student = new Student(frame);
		frame.revalidate();
		frame.repaint();
			}
		});
		
		back.setBackground(Color.CYAN);
		back.setBounds(104, 497, 180, 47);
		frame.getContentPane().add(back);
	}
}

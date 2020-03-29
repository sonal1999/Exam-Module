import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Color;

public class Student {
		public Student(JFrame frame,  int index) {
		initialize(frame,index);
	}
	private void initialize(JFrame frame,int index) {
		//frame = new JFrame();
		frame.setBounds(100, 100, 600, 467);
		frame.setLocation(50, 50);
		frame.setSize(750,750);
		frame.getContentPane().setBackground(new Color(240, 240, 240));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel(); 
		panel.setBounds(0, 0, 736, 10);
		frame.getContentPane().add(panel);
	
		JLabel lblNewLabel = new JLabel(" ");
		Image image=new ImageIcon(this.getClass().getResource("user_image.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(300, 56, 199, 240);
		frame.getContentPane().add(lblNewLabel);
		
		Label label = new Label("Roll No.");
		label.setBounds(181, 345, 132, 34);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Name");
		label_1.setBounds(181, 415, 132, 34);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("Email");
		label_2.setBounds(181, 497, 132, 34);
		frame.getContentPane().add(label_2);
		
		Database_Connection connection = new Database_Connection();
	    Connection conn = connection.connect();
	    try {
	    Statement stmt = conn.createStatement();
        ResultSet rs=stmt.executeQuery("select rollNo,name,email from student where rollNo="+index);
        rs.next();
        	
       

		
		Label label_3 = new Label(rs.getInt("rollNo")+"");
		label_3.setBounds(355, 345, 315, 34);
		frame.getContentPane().add(label_3);
		
		Label label_4 = new Label(rs.getString("name"));
		label_4.setBounds(355, 415, 315, 34);
		frame.getContentPane().add(label_4);
		
		Label label_5 = new Label(rs.getString("email"));
		label_5.setBounds(355, 497, 315, 34);
		frame.getContentPane().add(label_5);
	    }catch(Exception e11) {
	      System.out.println(e11);
	    }
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu home = new JMenu("Home");
		menuBar.add(home);
		JMenuItem profile = new JMenuItem("Profile");
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    frame.getContentPane().removeAll();  
			Student s1 = new Student(frame , index);
			frame.revalidate();;
			frame.repaint();	
			}
		});
		home.add(profile);
		
		JMenu mnProfile = new JMenu("Profile");
		menuBar.add(mnProfile);
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Update");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();  
			Update update=new Update();
			update.initialize(frame,index);
			frame.revalidate();;
			frame.repaint();
				
				
			}
		});
		mnProfile.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Change Password");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();  
				ChangePassword changepassword =new ChangePassword(frame,index);
				frame.revalidate();
				frame.repaint();
			}
		});
		mnProfile.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu = new JMenu("Exam");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Start Exam");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
			Exam exam=new Exam(frame,index);
			frame.revalidate();
			frame.repaint();
				//exam.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Records");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				Records records=new Records(frame,index);
				frame.revalidate();
				frame.repaint();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
	}
}

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JFrame frame = new JFrame();
//					frame.setVisible(true);
//					Student window = new Student(frame);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Student(JFrame frame) {
		initialize(frame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frame) {
		//frame = new JFrame();
		frame.setBounds(100, 100, 600, 467);
		frame.setLocation(50, 50);
		frame.setSize(750,750);
		frame.getContentPane().setBackground(new Color(240, 240, 240));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//		Panel panel = new Panel();
//		panel.setBounds(0, 0, 736, 10);
//		frame.getContentPane().add(panel);
//		
		JLabel lblNewLabel = new JLabel(" ");
		//Image image=new ImageIcon(this.getClass().getResource("user_image1.png")).getImage();
		//lblNewLabel.setIcon(new ImageIcon(image));
		//lblNewLabel.setBounds(265, 56, 199, 240);
		//frame.getContentPane().add(lblNewLabel);
		
		Label label = new Label("Name");
		label.setBounds(181, 345, 132, 34);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Class");
		label_1.setBounds(181, 415, 132, 34);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("Roll No");
		label_2.setBounds(181, 497, 132, 34);
		frame.getContentPane().add(label_2);
		
		Label label_3 = new Label(" ABC");
		label_3.setBounds(355, 345, 315, 34);
		frame.getContentPane().add(label_3);
		
		Label label_4 = new Label("XSD ");
		label_4.setBounds(355, 415, 315, 34);
		frame.getContentPane().add(label_4);
		
		Label label_5 = new Label(" ASD");
		label_5.setBounds(355, 497, 315, 34);
		frame.getContentPane().add(label_5);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnProfile = new JMenu("Profile");
		menuBar.add(mnProfile);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Update");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();  
			Update update=new Update(frame);
			frame.revalidate();
			frame.repaint();
				
				
			}
		});
		mnProfile.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Change Password");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();  
				ChangePassword changepassword =new ChangePassword(frame);
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
			Exam exam=new Exam();
				exam.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Records");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Records records=new Records();
				records.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
	}
}

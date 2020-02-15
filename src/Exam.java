
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class Exam {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Exam window = new Exam();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Exam(JFrame f) {
		initialize(f);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frame) {
		//frame = new JFrame();
		//frame.setBounds(100, 100, 450, 300);
		//frame.setLocation(50, 50);
		//frame.setSize(750,750);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
        comboBox.addItem("Mathematics");
		comboBox.addItem("Physics");
		comboBox.addItem("Chemistry");
		comboBox.addItem("Biology");
		comboBox.setBounds(213, 226, 271, 40);
		comboBox.setSelectedItem(null);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Start Exam");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				StartExam startexam=new StartExam(frame);  
				
				frame.revalidate();
				frame.repaint();//startexam.main(null);
				
			}
			
		});
		btnNewButton.setBounds(403, 337, 171, 40);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Welcome To Online Exam",JLabel.CENTER);
		lblNewLabel.setBackground(Color.BLUE);
	
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(213, 101, 279, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();  
				Student student = new Student(frame);
				frame.revalidate();
				frame.repaint();
				
			}
		});
		btnNewButton_1.setBounds(102, 337, 171, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}
}

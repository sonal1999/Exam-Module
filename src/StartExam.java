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
import java.awt.event.ActionEvent;

public class StartExam {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private Button button;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartExam window = new StartExam();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartExam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frame.setLocation(50, 50);
		frame.setSize(750,750);
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBounds(0, 0, 0, 0);
		//frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.getContentPane().add(panel);
		
		button = new Button("Previous");
		//button.setAlignment(button.left);  
		button.setFont(new Font("Dialog", Font.BOLD, 15));
		button.setBackground(Color.ORANGE);
		button.setBounds(0, 591, 137, 38);
		frame.getContentPane().add(button);
		
		Button button_1 = new Button("Next");
		button_1.setBackground(Color.BLUE);
		button_1.setFont(new Font("Dialog", Font.BOLD, 15));
		button_1.setBounds(192, 591, 137, 38);
		frame.getContentPane().add(button_1);
		
		Button button_2 = new Button("End Exam");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();  
				Student student = new Student(frame);
				frame.revalidate();
				frame.repaint();
			}
		});
		button_2.setBackground(Color.RED);
		button_2.setFont(new Font("Dialog", Font.BOLD, 15));
		button_2.setBounds(576, 591, 137, 38);
		frame.getContentPane().add(button_2);
		
		Button button_3 = new Button("View");
		button_3.setBackground(Color.GREEN);
		button_3.setFont(new Font("Dialog", Font.BOLD, 15));
		button_3.setBounds(384,591, 137, 38);
		frame.getContentPane().add(button_3);
		
		Label label = new Label("TEST", Label.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBackground(SystemColor.textHighlight);
		label.setBounds(308, 10, 113, 61);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("RollNo:", Label.LEFT);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_1.setBounds(0, 96, 72, 21);
		frame.getContentPane().add(label_1);
		
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
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton(" ");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton.setBounds(0, 280, 29, 33);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(" ");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_1.setBounds(0, 350, 29, 33);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton(" ");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_2.setBounds(0, 420, 29, 33);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton(" ");
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_3.setBounds(0, 490, 29, 33);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
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
		
		Label label_9 = new Label("Question 1");
		label_9.setBounds(54, 158, 659, 51);
		frame.getContentPane().add(label_9);
		
		Label label_10 = new Label("1st answer");
		label_10.setBounds(26, 280, 687, 33);
		frame.getContentPane().add(label_10);
		
		Label label_11 = new Label("2nd answer");
		label_11.setBounds(26, 350, 687, 33);
		frame.getContentPane().add(label_11);
		
		Label label_12 = new Label("3rd answer");
		label_12.setBounds(35, 420, 687, 33);
		frame.getContentPane().add(label_12);
		
		Label label_13 = new Label("4th answer");
		label_13.setBounds(35, 493, 687, 33);
		frame.getContentPane().add(label_13);
		
		
	}
}

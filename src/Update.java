 
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;

import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;


import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;

public class Update {
	public Update() {}
public void initialize(JFrame frame,int index) {
	Database_Connection connection = new Database_Connection();
    Connection conn = connection.connect();
    
	ButtonGroup buttonGroup = new ButtonGroup();
	
	Label label = new Label("Roll No:");
	label.setFont(new Font("Dialog", Font.BOLD, 12));
	label.setBounds(47, 20, 180, 33);
	frame.getContentPane().add(label);
			
	Label label_1 = new Label("Name");
	label_1.setFont(new Font("Dialog", Font.BOLD, 12));
	label_1.setBounds(47, 200, 180, 33);
	frame.getContentPane().add(label_1);
	
	/*Label label_2 = new Label("Date of Birth");
	label_2.setFont(new Font("Dialog", Font.BOLD, 12));
	label_2.setBounds(47, 200, 180, 33);
	frame.getContentPane().add(label_2);*/

	Label label_3 = new Label("Gender");
	label_3.setFont(new Font("Dialog", Font.BOLD, 12));
	label_3.setBounds(47, 260, 180, 33);
	frame.getContentPane().add(label_3);
	
	Label label_4 = new Label("Contact No");
	label_4.setFont(new Font("Dialog", Font.BOLD, 12));
	label_4.setBounds(47, 320, 180, 33);
	frame.getContentPane().add(label_4);
	
	Label label_8 = new Label("Address");
	label_8.setFont(new Font("Dialog", Font.BOLD, 12));
	label_8.setBounds(47, 480, 180, 33);
	frame.getContentPane().add(label_8);
	
	Label rlab = new Label(" ");
	rlab.setForeground(Color.red);
	rlab.setBounds(251, 110, 288, 33);
	frame.getContentPane().add(rlab);
	
    TextField rollno = new TextField(); 
  /*  rollno.addKeyListener(new KeyAdapter() {

		public void keyTyped(KeyEvent e) {
			String PATTERN="^[0-9]{0,15}$";
			Pattern patt=Pattern.compile(PATTERN);
			Matcher match=patt.matcher(rollno.getText());
			if(!match.matches())
			{
				rlab.setText("Only Numbers Are Required");
				
			}
			else
			{
				rlab.setText(null);
			}
			
		}
	}); */
    
	rollno.setBounds(251, 20, 200, 33);
	frame.getContentPane().add(rollno);
	
	Label nlab = new Label(" ");
	nlab.setForeground(Color.red);
	nlab.setBounds(251, 170, 288, 33);
	frame.getContentPane().add(nlab);
	
	TextField name = new TextField();
	/*name.addKeyListener(new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent e) {
			String PATTERN="^[a-zA-Z0-9]{0,30}$";
			Pattern patt=Pattern.compile(PATTERN);
			Matcher match=patt.matcher(name.getText());
			if(!match.matches())
			{
				nlab.setText("Invalid Name");
				
			}
			else
			{
				nlab.setText(null);
			}
		}
	}); */
	name.setBounds(251, 200, 288, 33);
	frame.getContentPane().add(name);
	
/*	TextField dob = new TextField();
	dob.setBounds(251, 200, 288, 33);
	frame.getContentPane().add(dob); */
	
	JRadioButton male = new JRadioButton("Male");
	male.setActionCommand("Male");
	male.setFont(new Font("Dialog", Font.BOLD, 12));
	buttonGroup.add(male);
	male.setBounds(251, 260, 96, 33);
	frame.getContentPane().add(male);
	
	JRadioButton female = new JRadioButton("Female");
	female.setActionCommand("Female");
	female.setFont(new Font("Dialog", Font.BOLD, 12));
	buttonGroup.add(female);
	female.setBounds(359, 260, 88, 33);
	frame.getContentPane().add(female);
	
	
	Label plab = new Label(" ");
	plab.setForeground(Color.red);
	plab.setBounds(251, 350, 288, 33);
	frame.getContentPane().add(plab);
	
	
	TextField phoneno = new TextField();
	/* phoneno.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				String PATTERN="^[0-9]{0,10}$";
				Pattern patt=Pattern.compile(PATTERN);
				Matcher match=patt.matcher(phoneno.getText());
				if(!match.matches())
				{
					plab.setText("Invalid Phone Number");
					
				}
				else
				{
					plab.setText(null);
				}
				
			}
		}); */
	phoneno.setBounds(251, 320, 288, 33);
	frame.getContentPane().add(phoneno);
	
	Label label_5 = new Label("Email");
	label_5.setFont(new Font("Dialog", Font.BOLD, 12));
	label_5.setBounds(47, 392, 180, 33);
	frame.getContentPane().add(label_5);
	
	Label elab = new Label(" ");
	elab.setForeground(Color.red);
	elab.setBounds(251, 433, 288, 33);
	frame.getContentPane().add(elab);
	
	
	TextField email = new TextField();
	/*email.addKeyListener(new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent e) {
			String PATTERN="^[a-zA-Z0-9]{0,30}@[a-zA-Z0-9]{0,5}[.][a-zA-Z]{0,5}$";
			Pattern patt=Pattern.compile(PATTERN);
			Matcher match=patt.matcher(email.getText());
			if(!match.matches())
			{
				elab.setText("Please Enter Valid Email");
				
			}
			else
			{
				elab.setText(null);
			}
		}
	}); */
	email.setBounds(251, 403, 288, 33);
	frame.getContentPane().add(email);
	

	
	TextArea address = new TextArea();
	address.setBounds(251, 468, 288, 65);
	frame.getContentPane().add(address);
	
	
	 
	
	Button update = new Button("Update");
	update.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String gender = buttonGroup.getSelection().getActionCommand();
			int index = Integer.parseInt(rollno.getText());
			
	/*	try {
			File image = new File(path);
	        FileInputStream fis = null;
			try {
				fis = new FileInputStream(image);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} */
			
			PreparedStatement stm;
			try {
				stm = conn.prepareStatement("update student set name=? , address=? , email=? , contactNo=? , gender=? where rollNo="+index);
				stm.setString(1,name.getText());
				stm.setString(2,address.getText());
				stm.setString(3,email.getText());
				stm.setString(4,phoneno.getText());
				stm.setString(5,gender);
//				stm.setBinaryStream(6,fis,(int) path.length());
				
				stm.executeUpdate();
				JOptionPane.showMessageDialog(frame,"Your record is updated Successfully!!!");

				frame.getContentPane().removeAll();  
				Student student = new Student(frame,index);
				frame.revalidate();
				frame.repaint();

				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
		
				e1.printStackTrace();
				JOptionPane.showMessageDialog(frame,"Problem is raised while updating your record !!!");
			}	
		
			
			
		
			//view_Question_Area.setText("");
			
	}
	
		});
	update.setBounds(47, 615, 180, 33);
	frame.getContentPane().add(update);
	
	
/*	lblNewLabel.setBounds(560, 80, 165, 165);
    frame.getContentPane().add(lblNewLabel); */
	
	Button back = new Button("Back");
	back.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			frame.getContentPane().removeAll();  
			Student student = new Student(frame,index);
			frame.revalidate();
			frame.repaint();
			
			
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//Student.main(null);
		}
	});
	back.setBounds(374, 615, 165, 33);
	frame.getContentPane().add(back);
	
	
/*	JButton browse = new JButton("Browse");
	browse.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JFileChooser file=new JFileChooser();
			file.setCurrentDirectory(new File(System.getProperty("user.home")));
			FileNameExtensionFilter filter=new FileNameExtensionFilter("*.Images","jpg","gif","png");
			file.addChoosableFileFilter(filter);
			int result=file.showSaveDialog(null);
			if(result==JFileChooser.APPROVE_OPTION)
			{
				File selectedFile=file.getSelectedFile();
				path=selectedFile.getAbsolutePath();
				lblNewLabel.setIcon(ResizeImage(path));
				
			}
			else if(result==JFileChooser.CANCEL_OPTION)
			{
				System.out.println("No File Select");
			}
			
		}
	});    
	
		
	browse.setBounds(554, 280, 172, 33);
	frame.getContentPane().add(browse); */
   
	Button view = new Button("View");
	view.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			int index = Integer.parseInt(rollno.getText());
			  try {
				   
				   Statement stmt = conn.createStatement();
		           ResultSet rs=stmt.executeQuery("select * from student where rollNo="+index);
		           rs.next();
	               	
		            name.setText(rs.getString("name"));
		            address.setText((rs.getString("address")));
		            email.setText((rs.getString("email")));
		            phoneno.setText((rs.getString("contactno")));
		            
		          
			           if(rs.getString("gender").equals("Male")){
			        	   male.setSelected(true);
			           }
			           else if(rs.getString("gender").equals("Female")){
			        	   female.setSelected(true);
			           }
			        /*  
			           
			         String filePath = "F:/photo.jpg";
			           Blob blob = rs.getBlob("image");
			           try {
		                InputStream inputStream = blob.getBinaryStream();
		                OutputStream outputStream = new FileOutputStream(filePath);
		                int length = inputStream.available();
		                System.out.println(length);
		 
		                int bytesRead = -1;
		                byte[] buffer = new byte[length];
		                while ((bytesRead = inputStream.read(buffer)) != -1) {
		                    outputStream.write(buffer, 0, bytesRead);
		                }
		                inputStream.close();
		                outputStream.close();
		                
			           }catch(Exception e11) {
			        	   System.out.println(e11);
			           }
			           
		           //.select(rs.getInt("subject"));
		           System.out.println("Done");  
		           
			           lblNewLabel.setIcon(ResizeImage(filePath));  //*/
		           
		           //answer_Field.setText((rs.getString("answer")));		           
	              } catch (SQLException e3) {
		            e3.printStackTrace();
	              }
			
		}
	});
	
	view.setBounds(554,20, 172, 33);
	frame.getContentPane().add(view);	
}
	
/*	public ImageIcon ResizeImage(String ImagePath)
	{
		ImageIcon MyImage=new ImageIcon(ImagePath);
		Image img=MyImage.getImage();
		Image newImg=img.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image=new ImageIcon(newImg);
		return image;
	}  
}
*/

}
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.event.*;
import javax.swing.*;

public class Admin_Frame extends JFrame implements ActionListener{

	 JMenuBar navigation;
     JMenu question_navigation;
     JMenu student_navigation;
     JMenu home;
     
     JMenuItem insert_Item ;
     JMenuItem update_Item ;
     JMenuItem delete_Item;
     
     
     JMenuItem add_Student_Item;
     JMenuItem delete_Student_Item;
     
     JMenuItem profile;
     
     Label title_Label;
     
     void render() {
    	 title_Label = new Label("Welcome to admin panel"); 
    	 this.add(title_Label);
 	     title_Label.setBounds(300,300,300,50);	
     }
     
     
	Admin_Frame(String title){
		setVisible(true);
		setLocation(50,50);
		setSize(750,750);
		setTitle(title);
		
		//title_Label = new Label("Welcome to admin panel");
		navigation = new JMenuBar();
	    question_navigation = getQuestionMenu();
	    student_navigation = getStudentMenu();
	    home=getHomeMenu();
	    this.setLayout(null);
	        
	    this.setJMenuBar(navigation);
	    navigation.add(home);
	    navigation.add(student_navigation);
	    navigation.add(question_navigation);
	    render();
	}        
	
	    JMenu getQuestionMenu() {
		JMenu question= new JMenu("Question");
		
		insert_Item = new JMenuItem("Insert");
		insert_Item.addActionListener(this);
		  
	    update_Item = new JMenuItem("Update");
	    update_Item.addActionListener(this);
	        
	    delete_Item = new JMenuItem("Delete");
	    delete_Item.addActionListener(this);
	         
	    question.add(insert_Item);
	    question.addSeparator();
		question.add(update_Item);
		question.addSeparator();
		question.add(delete_Item);        
		
		return question;
	   }
	 
	 JMenu getHomeMenu() {
			JMenu home= new JMenu("Home");
			profile = new JMenuItem("Profile");
			profile.addActionListener(this);   
		    home.add(profile);      
			return home;
		   }
	
	private JMenu getStudentMenu() {
		JMenu student= new JMenu("Student");
		
		add_Student_Item = new JMenuItem("Add");
		add_Student_Item.addActionListener(this);
		
	    delete_Student_Item = new JMenuItem("Remove");
	    delete_Student_Item.addActionListener(this);
	      
	    student.add(add_Student_Item);
	    student.addSeparator();
	    student.add(delete_Student_Item);
	        
	    return student;
	   }
	       
	
	 public void actionPerformed(ActionEvent e) {
		 if(e.getActionCommand()=="Insert") 
		 {
			 System.out.println(e.getActionCommand());
		     this.getContentPane().removeAll();
			 Insert_Question insert_Question_Frame = new Insert_Question();
			 insert_Question_Frame.insert(this);
		     this.revalidate();
		     this.repaint();		 
		 }
		 
		 if(e.getActionCommand()=="Update") 
		 {
			 System.out.println(e.getActionCommand());
		     this.getContentPane().removeAll();
		     update_Question update_Question_Frame = new update_Question();
		     update_Question_Frame.update(this);
		     this.revalidate();
		     this.repaint();		 
		 }
		 
		 if(e.getActionCommand()=="Delete") 
		 {
			 System.out.println(e.getActionCommand());
		     this.getContentPane().removeAll();
		     Delete_Question delete_Question_Frame = new Delete_Question();
		     delete_Question_Frame.delete(this);
		     this.revalidate();
		     this.repaint();		 
		 }
		 
		 if(e.getActionCommand()=="Add") 
		 {
			 System.out.println(e.getActionCommand());
		     this.getContentPane().removeAll();
		     Add_Student Add_Student_Frame = new Add_Student();
		     Add_Student_Frame.add(this);
		     this.revalidate();
		     this.repaint();		 
		 }
		 
		 if(e.getActionCommand()=="Remove") 
		 {
			 System.out.println(e.getActionCommand());
		     this.getContentPane().removeAll();
		     Delete_Student remove_Student_Frame = new Delete_Student();
		     remove_Student_Frame.remove(this);
		     this.revalidate();
		     this.repaint();		 
		 }
		 
		 if(e.getActionCommand()=="Profile") 
		 {
			 System.out.println(e.getActionCommand());
		     this.getContentPane().removeAll();
		     render();
		     this.revalidate();
		     this.repaint();		 
		 }
	 }
}

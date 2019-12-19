import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.JFrame;

public class Home extends JFrame  implements ActionListener
{
	
	Home(String title){
		setVisible(true);
		setLocation(50,50);
		setSize(750,700);
		setTitle(title);
		 MenuBar navigation = new MenuBar();
	        Menu question_navigation = new Menu("Question");
	        MenuItem insert_Item = new MenuItem("Insert");
	        MenuItem update_Item = new MenuItem("Update");
	        MenuItem delete_Item = new MenuItem("Delete");
	        
	         
	        Label select_Subject_Label = new Label("Select Subject");
	        Label question_Label = new Label("Question");
	        Label options_Label = new Label("Options");
	        Label answer_Label = new Label("Answer");
	        
	        List select_Subject_List = new List(3);
	        
	        select_Subject_List.add("Physics");
	        select_Subject_List.add("Chemistry");
	        select_Subject_List.add("Biology");
	        select_Subject_List.add("Mathematics");
	        
	        TextArea question_Area = new TextArea("TextAera is as given",50,50,TextArea.SCROLLBARS_BOTH);
	        
	        TextField option1 = new TextField("1",100);
	        TextField option2 = new TextField("2",100);
	        TextField option3 = new TextField("3",100);
	        TextField option4 = new TextField("4",100);
	        TextField answer_Field = new TextField("Enter correct answer",100);
	        
	        Button insert = new Button("Insert");
	        insert.addActionListener(this);
	        
	        this.setLayout(null);
	        
	        this.setMenuBar(navigation);
	        navigation.add(question_navigation);
	        question_navigation.add(insert_Item);
	        question_navigation.add(update_Item);
	        question_navigation.add(delete_Item);
	        
	        this.add(select_Subject_Label);
	        this.add(select_Subject_List);
	        this.add(question_Label);
	        this.add(question_Area);
	        this.add(options_Label);
	        this.add(option1);
	        this.add(option2);
	        this.add(option3);
	        this.add(option4);
	        this.add(answer_Label);
	        this.add(answer_Field);
	        this.add(insert);
	        
	        select_Subject_Label.setBounds(75,55,100,50);
	        select_Subject_List.setBounds(250,75,100,50);
	        question_Label.setBounds(75,100,100,115);
	        question_Area.setBounds(250,150,450,150);
	        options_Label.setBounds(75,315,100,50);
	        option1.setBounds(250,325,250,25);
	        option2.setBounds(250,365,250,25);
	        option3.setBounds(250,405,250,25);
	        option4.setBounds(250,445,250,25);
	        answer_Label.setBounds(75,485,100,50);
	        answer_Field.setBounds(250,500,250,25);
	        insert.setBounds(330,600,100,50);
	                  

	}
	
	public static void main(String[] args) {		
         Home H1 = new Home("Admin");
         
       	}
	
	public void actionPerformed(ActionEvent ae){
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","");  
			//here exam is database name,username,password  
			System.out.println("Database is connected successfully");
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		
	}

}













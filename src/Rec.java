import java.sql.*;
import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Rec extends JFrame{
	
	 Rec(/*JFrame frame , int index*/){
		 setVisible(true);
			setLocation(50,50);
			setSize(750,750);
			JTable t1= new JTable();
			
			getContentPane().add(t1);
			Database_Connection connection = new Database_Connection();
		    Connection conn = connection.connect();
		    String sql="select * from record";
		    PreparedStatement ps;
			try {
				ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		   
	 }

	public static void main(String[] args) {	
		Rec r1 = new Rec();
	    
	}

}

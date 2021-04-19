

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Records {


	Records(JFrame frame ,int index){
		Database_Connection connection = new Database_Connection();
	    Connection conn = connection.connect();
	    String sql="select * from record where rollNo="+index;
	    PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.last();
			String data[][] = new String[rs.getRow()][2];
			rs.beforeFirst();
			String column[]={"Subject","Score"}; 
		
			int i=-1, j=0;
			while(rs.next()){
				i++;
				j=0;
				data[i][j]=rs.getString("subject");
				j++;
				data[i][j]=Integer.toString(rs.getInt("marks"));
			}
		JTable t1= new JTable(data,column);
		t1.setBounds(20,20,700,645); 
		frame.getContentPane().add(t1);	
	}catch(Exception e11) {
		 System.out.println(e11);
	}
}
}

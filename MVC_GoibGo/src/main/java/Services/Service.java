package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Service {
	public static double price(String from,String to,int noTick) {
		double dataPrice= database(from,to);
		return dataPrice*noTick;
		
	}

	private static double database(String from, String to) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		String qery="select from_,to_,price from goibgodata";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql@123");
		    stmt=con.createStatement();
		    rs=stmt.executeQuery(qery);
		    while(rs.next()) {
		    	if(from.equals(rs.getString(1)) && to.equals(rs.getString(2))) {
		    		return rs.getDouble(3);
		    	}
		    }
		    
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}

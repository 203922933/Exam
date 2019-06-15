package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String dbpath = "jdbc:mysql://localhost:3306/db_exam"
			+"?useUnicode=true&characterEncoding=utf-8"
			+"&useSSL=false&serverTimezone=UTC&";
	private static String dbusername = "root";
	private static String dbpassword = "czl990914.";
	
	private static Connection con;
	
	public static Connection getConnection() {
		if(con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(dbpath, dbusername, dbpassword);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static void closeConnection() {
		if(con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
//	public static void main(String[] args) {
//		Connection con = null;
//		ResultSet rl = null;
//		Statement st = null;
//		try {
//			con = DBConnection.getConnection();
//			st = con.createStatement();
//			rl = st.executeQuery("SELECT * FROM t_manager");
//			while(rl.next()) {
//				System.out.println(rl.getInt(1));
//				System.out.println(rl.getString(2));
//				System.out.println(rl.getString(3));
//			}
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			if (con != null) {
//				DBConnection.closeConnection();
//			}
//		}
//	}
}

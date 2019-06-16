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
}

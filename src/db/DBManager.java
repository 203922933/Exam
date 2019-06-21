package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Manager;
import bean.Student;

public class DBManager {
	
	public Manager getManager(String name) {
		Manager manager = new Manager();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pStmt = null;
		try {
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("SELECT * FROM manager WHERE name = ?");
			pStmt.setString(1, name);
			rs = pStmt.executeQuery();
			if(rs.next()) {
				manager.setId(rs.getInt("id"));
				manager.setName(rs.getString("name"));
				manager.setPassword(rs.getString("password"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				DBConnection.closeConnection();
			}
		}
		return manager;
	}
}

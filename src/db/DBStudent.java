package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Student;

public class DBStudent {
	
	/**
	 * 学生注册
	 * 返回值说明:
	 * -1 添加失败
	 *  1 添加成功
	 * @param student
	 */
	@SuppressWarnings("finally")
	public int register(Student student) {
		PreparedStatement prs = null;
		Connection con = DBConnection.getConnection();
		int result = -1;
		
		try {
			prs = con.prepareStatement("INSERT INTO t_student "
					+ "(username, password, usermail, usertel, address) "
					+ "value (?,?,?,?,?)");
			prs.setString(0, student.getUsername());
			prs.setString(1, student.getPassword());
			prs.setString(2, student.getUsermail());
			prs.setString(3, student.getUsertel());
			prs.setString(4, student.getAddress());
			prs.executeQuery();
			result = 1;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeConnection();
			return result;
		}
	}
	
	
	
}

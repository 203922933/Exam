package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Score;
import bean.Student;

public class DBStudent {
	
	/**
	 * 学生注册
	 * 返回值说明:
	 * -1 添加失败
	 *  1 添加成功
	 * @param student
	 */
	public int register(Student student) {
		PreparedStatement prs = null;
		Connection con = null;
		int result = -1;
		
		try {
			con = DBConnection.getConnection();
			prs = con.prepareStatement("INSERT INTO t_student "
					+ "(username, password, usermail, usertel, address) "
					+ "value (?,?,?,?,?)");
			prs.setString(1, student.getUsername());
			prs.setString(2, student.getPassword());
			prs.setString(3, student.getUsermail());
			prs.setString(4, student.getUsertel());
			prs.setString(5, student.getAddress());
			prs.executeQuery();
			result = 1;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				DBConnection.closeConnection();
			}
		}
		return result;
	}
	
	/**
	 * 获取student实例
	 * @param username
	 * @return
	 */
	public Student getStudent(String username) {
		Student student= new Student();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pStmt = null;
		try {
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("SELECT * FROM student WHERE username = ?");
			pStmt.setString(1, username);
			rs = pStmt.executeQuery();
			while(rs.next()) {
				student.setId(rs.getInt("id"));
				student.setUsername(rs.getString("username"));
				student.setPassword(rs.getString("password"));
				student.setUsermail(rs.getString("usermail"));
				student.setUsertel(rs.getString("usertel"));
				student.setAddress(rs.getString("address"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				DBConnection.closeConnection();
			}
		}
		return student;
	}
	
	/**
	 * 添加分数
	 * @param score
	 */
	public void AddScore(Score score) {
		PreparedStatement pStmt = null;
		Connection con = null;
		
		try {
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("INSERT scores (username, subjectname, score, endtime) "
					+ "values (?,?,?,?)");
			pStmt.setString(1, score.getUsername());
			pStmt.setString(2, score.getSubjectname());
			pStmt.setFloat(3, score.getScore());
			pStmt.setString(4, score.getEndtime());
			pStmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				DBConnection.closeConnection();
			}
		}
	}
	
}

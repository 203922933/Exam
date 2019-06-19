package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			prs = con.prepareStatement("INSERT INTO student "
					+ "(username, password, usermail, usertel, address) "
					+ "values (?,?,?,?,?)");
			prs.setString(1, student.getUsername());
			prs.setString(2, student.getPassword());
			prs.setString(3, student.getUsermail());
			prs.setString(4, student.getUsertel());
			prs.setString(5, student.getAddress());
			prs.executeUpdate();
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
	 * 获取学生列表
	 * @return
	 */
	public List<Student> getStudentList(){
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		List<Student> stuList = new ArrayList<>();
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM student");
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setUsername(rs.getString("username"));
				student.setPassword(rs.getString("password"));
				student.setUsermail(rs.getString("usermail"));
				student.setUsertel(rs.getString("usertel"));
				student.setAddress(rs.getString("address"));
				
				stuList.add(student);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				DBConnection.closeConnection();
			}
		}
		
		return stuList;
	}
	
	
	/**
	 * 检查学生是否存在
	 * @param username
	 * @return
	 */
	public boolean checkusername(String username) {
		int type = 0;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pStmt = null;
		try {
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("SELECT * FROM student WHERE username = ?");
			pStmt.setString(1, username);
			rs = pStmt.executeQuery();
			while(rs.next()) {
				type = 1;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				DBConnection.closeConnection();
			}
		}
		if (type == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	
}

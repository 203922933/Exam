package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Score;
import bean.Student;

public class DBScore {
	
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
	/*
	 *修改成绩
	 */
	public void UpdateScore(int score,String endtime, int id) {
		PreparedStatement pStmt = null;
		Connection con = null;
		
		try {
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("UPDATE scores SET score=?, endtime=? "
					+ "WHERE id=?");
			pStmt.setInt(1, score);
			pStmt.setString(2, endtime);
			pStmt.setInt(3, id);
			pStmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				DBConnection.closeConnection();
			}
		}
	}
	
	/**
	 * 获取成绩
	 * @param student
	 * @return
	 */
	public List<Score> getScoreList(Student student){
		List<Score> scList = new ArrayList<>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("SELECT * FROM scores WHERE username = ?");
			pStmt.setString(1, student.getUsername());
			rs = pStmt.executeQuery();
			while(rs.next()) {
				Score score = new Score();
				score.setId(rs.getInt("id"));
				score.setUsername(rs.getString("username"));
				score.setSubjectname(rs.getString("subjectname"));
				score.setScore(rs.getFloat("score"));
				score.setEndtime(rs.getString("endtime"));
				
				scList.add(score);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				DBConnection.closeConnection();
			}
		}
		return scList;
	}
	
	
	/**
	 * 获取所有学生的成绩列表
	 * @return
	 */
	public List<Score> getScoreAllList(){
		List<Score> scList = new ArrayList<>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("SELECT * FROM scores");
			rs = pStmt.executeQuery();
			while(rs.next()) {
				Score score = new Score();
				score.setId(rs.getInt("id"));
				score.setUsername(rs.getString("username"));
				score.setSubjectname(rs.getString("subjectname"));
				score.setScore(rs.getFloat("score"));
				score.setEndtime(rs.getString("endtime"));
				
				scList.add(score);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				DBConnection.closeConnection();
			}
		}
		return scList;
	}
}

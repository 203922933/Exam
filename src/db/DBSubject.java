package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import bean.Subject;

public class DBSubject {
	
	/**
	 * 添加试卷
	 * @param subject
	 */
	public void insertSub(Subject subject) {
		Connection con = null;
		PreparedStatement pStmt = null;
		
		try {
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("INSERT INTO subject "
					+ "(subjectname,singleper,singlenumber,testtime) "
					+ "VALUES (?,?,?,?)");
			pStmt.setString(1, subject.getSubjectname());
			pStmt.setInt(2, subject.getSingleper());
			pStmt.setInt(3, subject.getSinglenumber());
			pStmt.setInt(4, subject.getTesttime());
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
	 * 修改问试卷
	 * @param subject
	 */
	public void alterSub(Subject subject) {
		Connection con = null;
		PreparedStatement pStmt = null;
		
		try {
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("UPDATE subject SET "
					+ "subjectname = ? "
					+ "singleper = ? "
					+ "singlenumber = ? "
					+ "testtime = ? "					
					+ "WHERE id = ?");
			pStmt.setString(1, subject.getSubjectname());
			pStmt.setInt(2, subject.getSingleper());
			pStmt.setInt(3, subject.getSinglenumber());
			pStmt.setInt(4, subject.getTesttime());
			pStmt.setInt(5, subject.getId());
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
	 * 删除试卷
	 * @param id
	 */
	public void delSub(int id) {
		Connection con = null;
		PreparedStatement pStmt = null;
		
		try {
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("DELETE FROM subject WHERE id = ?");
			pStmt.setInt(1, id);
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
	 * 按id查找试卷
	 */
	public Subject getSubject(int id) {
		Subject subject = null;
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("SELECT * FROM subject WHERE id=?");
			pStmt.setInt(1, id);
			rs = pStmt.executeQuery();
			if(rs.next()) {
				subject = new Subject();
				subject.setId(rs.getInt("id"));
				subject.setSubjectname(rs.getString("subjectname"));
				subject.setSinglenumber(rs.getInt("singlenumber"));
				subject.setSingleper(rs.getInt("singleper"));
				subject.setTesttime(rs.getInt("testtime"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				DBConnection.closeConnection();
			}
		}
		return subject;
	}
}

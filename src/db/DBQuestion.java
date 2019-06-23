package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Question;

public class DBQuestion {
	
	/**
	 * 获取问题列表
	 * @return
	 */
	public List<Question> getQuesList(){
		List<Question> quesList = new ArrayList<>();
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM question");
			while(rs.next()) {
				Question question = new Question();
				question.setId(rs.getInt("id"));
				question.setQuestion(rs.getString("question"));
				question.setSubjectname(rs.getString("subjectname"));
				question.setA(rs.getString("A"));
				question.setB(rs.getString("B"));
				question.setC(rs.getString("C"));
				question.setD(rs.getString("D"));
				question.setAnswer(rs.getString("answer"));
				question.setWeight(rs.getInt("weight"));
				
				quesList.add(question);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				DBConnection.closeConnection();
			}
		}
		
		return quesList;
	}
	
	
	/**
	 * 添加问题
	 * @param question
	 */
	public void insertQues(Question question) {
		Connection con = null;
		PreparedStatement pStmt = null;
		
		try {
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("INSERT INTO question "
					+ "(question,A,B,C,D,answer,weight,subjectname) "
					+ "VALUES (?,?,?,?,?,?,?,?)");
			pStmt.setString(1, question.getQuestion());
			pStmt.setString(2, question.getA());
			pStmt.setString(3, question.getB());
			pStmt.setString(4, question.getC());
			pStmt.setString(5, question.getD());
			pStmt.setString(6, question.getAnswer());
			pStmt.setInt(7, question.getWeight());
			pStmt.setString(8, question.getSubjectname());
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
	 * 修改问题
	 * @param question
	 */
	public void alterQues(Question question) {
		Connection con = null;
		PreparedStatement pStmt = null;
		
		try {
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("UPDATE question SET "
					+ "question = ? ,"
					+ "A = ? ,"
					+ "B = ? ,"
					+ "C = ? ,"
					+ "D = ? ,"
					+ "answer = ? ,"
					+ "weight = ? ,"
					+ "subjectname = ? "
					+ "WHERE id = ?");
			pStmt.setString(1, question.getQuestion());
			pStmt.setString(2, question.getA());
			pStmt.setString(3, question.getB());
			pStmt.setString(4, question.getC());
			pStmt.setString(5, question.getD());
			pStmt.setString(6, question.getAnswer());
			pStmt.setInt(7, question.getWeight());
			pStmt.setString(8, question.getSubjectname());
			pStmt.setInt(9, question.getId());
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
	 * 删除问题
	 * @param id
	 */
	public void delQues(int id) {
		Connection con = null;
		PreparedStatement pStmt = null;
		
		try {
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("DELETE FROM question WHERE id = ?");
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
	
	public Question getQuestionById(int id) {
		Question question = null;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement("SELECT * FROM question WHERE id=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				question = new Question();
				question.setId(rs.getInt("id"));
				question.setQuestion(rs.getString("question"));
				question.setSubjectname(rs.getString("subjectname"));
				question.setA(rs.getString("A"));
				question.setB(rs.getString("B"));
				question.setC(rs.getString("C"));
				question.setD(rs.getString("D"));
				question.setAnswer(rs.getString("answer"));
				question.setWeight(rs.getInt("weight"));
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				DBConnection.closeConnection();
			}
		}
		
		return question;
	}
	
	/*
	 * 根据题库名字查找所有题
	 */
	public List<Question> getAllQuestionsByName(String name){
		List<Question> quesList = new ArrayList<>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement("SELECT * FROM question WHERE subjectname=?");
			pst.setString(1, name);
			rs = pst.executeQuery();
			while(rs.next()) {
				Question question = new Question();
				question.setId(rs.getInt("id"));
				question.setQuestion(rs.getString("question"));
				question.setSubjectname(rs.getString("subjectname"));
				question.setA(rs.getString("A"));
				question.setB(rs.getString("B"));
				question.setC(rs.getString("C"));
				question.setD(rs.getString("D"));
				question.setAnswer(rs.getString("answer"));
				question.setWeight(rs.getInt("weight"));
				quesList.add(question);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				DBConnection.closeConnection();
			}
		}
		return quesList;
	}
}

package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Question;
import bean.Subject;

public class DBCommon {
	private int type = -1;			//登陆类型 -1登陆失败 1管理员登陆 2学生登陆
	private String[] loginCheckSQL = {
			"SELECT password FROM manager WHERE name = ?",
			"SELECT password FROM student WHERE username = ?"};
	
	private String paperListSQL = "SELECT * FROM subject";
	
	
	/**
	 * 登陆验证
	 * 返回值说明：
	 * -1:查询失败
	 * 0 :管理员登陆
	 * 1 :学生登陆
	 * @param username
	 * @param password
	 * @return
	 */
	public int check(String username, String password) {
		for (int i=0; i<loginCheckSQL.length; i++) {
			if (isuser(username, password, loginCheckSQL[i])) {
				type = i;
				break;
			}
		}
		return type;
	}
	
	public static void main(String[] args) {
		System.out.println(new DBCommon().check("mrpresident", "root123"));
	}
	
	private boolean isuser(String username, String password, String sql) {
		ResultSet rs = null;
		PreparedStatement st = null;
		Connection con =null;
		try {
			con = DBConnection.getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, username);
			rs = st.executeQuery();
			while (rs.next()) {
				if (password.equals(rs.getString("password"))) {
					st.close();
					rs.close();
					DBConnection.closeConnection();
					return true;
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				DBConnection.closeConnection();
			}
		}
		return false;
	}
	
	
	/**
	 * 获取考试列表
	 * 返回值说明:
	 * 返回一个paper类型的list 
	 * @return
	 */
	public List<Subject> getSubList() {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection con = null;
		List<Subject> subList = new ArrayList<>();

		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(paperListSQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				Subject subject = new Subject();
				subject.setId(rs.getInt("id"));
				subject.setSinglenumber(rs.getInt("singlenumber"));
				subject.setSingleper(rs.getInt("singleper"));
				subject.setSubjectname(rs.getString("subjectname"));
				subject.setTesttime(rs.getInt("testtime"));
				subList.add(subject);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				DBConnection.closeConnection();
			}
		}

		return subList;
	}
	
	
	/**
	 * 获取考试题目
	 * @param subjectname
	 * @return
	 */
	public List<Question> getQues(String subjectname){
		List<Question> ques = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pStmt = null;
		Connection con = null;
		try {
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("SELECT * FROM question WHERE subjectname = ?");
			pStmt.setString(1, subjectname);
			rs = pStmt.executeQuery();
			while(rs.next()) {
				Question question = new Question();
				question.setId(rs.getInt("id"));
				question.setSubjectname(rs.getString("subjectname"));
				question.setQuestion(rs.getString("question"));
				question.setWeight(rs.getInt("weight"));
				question.setA(rs.getString("A"));
				question.setB(rs.getString("B"));
				question.setC(rs.getString("C"));
				question.setD(rs.getString("D"));
				question.setAnswer(rs.getString("answer"));
				ques.add(question);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				DBConnection.closeConnection();
			}
		}
		return ques;
	}
	
	
	/**
	 * 获取某一科目信息
	 * @param id
	 * @return
	 */
	public Subject getSubject(int id) {
		Subject subject = new Subject();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection con = null;
		try {
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("SELECT * FROM subject WHERE id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				subject.setId(rs.getInt("id"));
				subject.setSubjectname(rs.getString("subjectname"));
				subject.setSingleper(rs.getInt("singleper"));
				subject.setSinglenumber(rs.getInt("singlenumber"));
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

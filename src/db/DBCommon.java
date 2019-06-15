package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;

public class DBCommon {
	private int type = -1;			//登陆类型 -1登陆失败 1管理员登陆 2学生登陆
	private String[] loginCheckSQL = {
			"SELECT password FROM manager WHERE name = ",
			"SELECT password FROM student WHERE username = "};
	
	private String paperListSQL = "SELECT * FROM subject";
	
	
	/**
	 * 登陆验证
	 * 返回值说明：
	 * -1:查询失败
	 * 1 :管理员登陆
	 * 2 :学生登陆
	 * 3 :老师登陆
	 * @param username
	 * @param password
	 * @return
	 */
	public int check(String username, String password) {
		System.out.println(type);
		for (int i=0; i<loginCheckSQL.length; i++) {
			if (isuser(username, password, loginCheckSQL[i])) {
				type = i;
				break;
			}
		}
		return type;
	}
	
	private boolean isuser(String username, String password, String sql) {
		ResultSet rs = null;
		Statement st = null;
		Connection con = DBConnection.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql+username);
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
		}
		return false;
	}
	
	

	/**
	 * 获取考试列表
	 * 参数说明:
	 * username: 用户名
	 * type: 0 通过学生用户名获取 1 通过教师用户名获取
	 * 返回值说明:
	 * 返回一个paper类型的list 
	 * @param username
	 * @param type
	 * @return
	 */
	public List<Subject> getPaperList(String username, int type) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Subject> subList = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();
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
			DBConnection.closeConnection();
		}

		return subList;
	}
}

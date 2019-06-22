package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Manager;
import bean.Student;
import db.DBCommon;
import db.DBManager;
import db.DBStudent;

/**
 * Servlet implementation class LoginAction
 * 登陆验证接口
 * 参数:
 * 参数名
 * username
 * password
 * 返回参数:
 * 无
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String path = request.getContextPath();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username +"+"+ password);
		int type = new DBCommon().check(username, password);
		
		System.out.println(type);
		request.getSession().setAttribute("type", type);

		switch (type) {
		case -1:
			/**
			 * 登陆失败
			 */
			request.getSession().setAttribute("message", "-1");
			response.sendRedirect(path+"/User/Login.jsp");
			break;
		case 0:
			/**
			 * 管理员老师登陆
			 */
			Manager manager = new DBManager().getManager(username);
			request.getSession().setAttribute("manager", manager);
			response.sendRedirect(path+"/Manager/ManagerMain.jsp");
			break;
		case 1:
			Student student = new DBStudent().getStudent(username);
			request.getSession().setAttribute("student", student);
			/**
			 * 学生登陆
			 */
			response.sendRedirect(path+"/User/Main.jsp");
			break;
		}
	}

}

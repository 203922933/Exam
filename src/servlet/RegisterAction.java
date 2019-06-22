package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import db.DBStudent;

/**
 * Servlet implementation class RegisterAction
 */
@WebServlet("/RegisterAction")
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		DBStudent db_stu = new DBStudent();
		String path = request.getContextPath();
		if (!db_stu.checkusername(request.getParameter("username"))) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String passwordagin = request.getParameter("passagin");
			if(!password.equals(passwordagin)) {
				request.getSession().setAttribute("message", 0);
				response.sendRedirect(path+"/User/Register.jsp");
			}
			String usermail = request.getParameter("usermail");
			String usertel = request.getParameter("usertel");
			String address = request.getParameter("province")+"-"+request.getParameter("city");
			
			Student student = new Student();
			student.setUsername(username);
			student.setPassword(password);
			student.setUsermail(usermail);
			student.setUsertel(usertel);
			student.setAddress(address);
			
			db_stu.register(student);
			/**
			 * 注册成功跳转
			 */
			response.sendRedirect(path+"/User/Login.jsp");
		}else {
			/**
			 * 注册失败跳转
			 */
			request.getSession().setAttribute("message", 1);
			response.sendRedirect(path+"/User/Register.jsp");
		}
		
	}

}

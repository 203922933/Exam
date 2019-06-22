package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import db.DBSubject;

/**
 * Servlet implementation class SubjectAlterAction
 */
@WebServlet("/SubjectAlterAction")
public class SubjectAlterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectAlterAction() {
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
		/*
		 * 获取subject参数
		 * id
		 * subjectname
		 * singleper
		 * singlenumber
		 * testtime
		 */
		request.setCharacterEncoding("utf-8");
		String path = request.getContextPath();
		int id = Integer.parseInt(request.getParameter("id"));
		Subject subject = new DBSubject().getSubject(id);
		/*
		 * 设置set()
		 */
		subject.setSingleper(Integer.parseInt(request.getParameter("fenzhi")));
		subject.setSinglenumber(Integer.parseInt(request.getParameter("num")));
		subject.setTesttime(Integer.parseInt(request.getParameter("time")));
		
		new DBSubject().alterSub(subject);
		/*
		 * 跳转
		 */
		response.sendRedirect(path+"/ExamListAction");
	}

}

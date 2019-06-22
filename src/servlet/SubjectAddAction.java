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
 * Servlet implementation class SubjectAddAction
 */
@WebServlet("/SubjectAddAction")
public class SubjectAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectAddAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * 获取数据 
		 * subjectname
		 * singleper
		 * singlenuber
		 * testtime
		 */
		String path = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		Subject subject = new Subject();
		subject.setSubjectname(request.getParameter("name"));
		subject.setSingleper(Integer.parseInt(request.getParameter("fenzhi")));
		subject.setSinglenumber(Integer.parseInt(request.getParameter("num")));
		subject.setTesttime(Integer.parseInt(request.getParameter("time")));
		
		new DBSubject().insertSub(subject);
		
		/*
		 * 跳转
		 */
		response.sendRedirect(path+"/ExamListAction");
	}

}

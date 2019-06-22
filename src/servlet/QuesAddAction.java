package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Question;
import db.DBQuestion;

/**
 * Servlet implementation class QuesAddAction
 */
@WebServlet("/QuesAddAction")
public class QuesAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuesAddAction() {
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
		String path = request.getContextPath();
		Question question = new Question();
		/*
		 * set()
		 */
		question.setQuestion(request.getParameter("question"));
		question.setA(request.getParameter("selectA"));
		question.setB(request.getParameter("selectB"));
		question.setC(request.getParameter("selectC"));
		question.setD(request.getParameter("selectD"));
		question.setAnswer(request.getParameter("answer"));
		question.setWeight(0);
		question.setSubjectname(request.getParameter("name"));
		System.out.println("testxxxx    "+question.getSubjectname());
		new DBQuestion().insertQues(question);
		
		/*
		 * 跳转
		 */
		response.setCharacterEncoding("utf-8");
		response.sendRedirect(path+"/GetAllQuesitionAction");
	}

}

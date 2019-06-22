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
 * Servlet implementation class QuesDelAction
 */
@WebServlet("/QuesDelAction")
public class QuesDelAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuesDelAction() {
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
		 * 获取参数
		 * id
		 */
		String path = request.getContextPath();
		int id = Integer.parseInt(request.getParameter("id"));
		Question que = new DBQuestion().getQuestionById(id);
		new DBQuestion().delQues(id);
		/*
		 * 跳转
		 */
		response.sendRedirect(path+"/GetAllQuesitionAction?name="+que.getSubjectname());
	}

}

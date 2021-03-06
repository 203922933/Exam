package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Question;
import bean.Subject;
import db.DBQuestion;
import db.DBSubject;

/**
 * Servlet implementation class GetAllQuesitionAction
 */
@WebServlet("/GetAllQuesitionAction")
public class GetAllQuesitionAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllQuesitionAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = request.getContextPath();
		String subname = request.getParameter("name");
		if(subname == null) {
			subname = (String)request.getSession().getAttribute("subName");
		}
		System.out.println(subname);
		List<Question>list = new  DBQuestion().getAllQuestionsByName(subname);
		request.getSession().setAttribute("subName", subname);
		request.getSession().setAttribute("queListByName", list);
		response.sendRedirect(path+"/Manager/QuestionList.jsp");
	}

}

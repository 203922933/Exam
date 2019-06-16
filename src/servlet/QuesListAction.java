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
import db.DBCommon;

/**
 * Servlet implementation class QuesListAction
 * 
 */
@WebServlet("/QuesListAction")
public class QuesListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuesListAction() {
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
		Subject subject = (Subject) request.getSession().getAttribute("subject");
		int type  = (int) request.getSession().getAttribute("type");
		
		List<Question> db_ques = new DBCommon().getQues(subject.getSubjectname());
		if(type == 1) {
			request.getSession().setAttribute("quesList", db_ques);
			
			/**
			 * 跳转
			 */
		}else if(type == 2) {
			
		}
	}

}

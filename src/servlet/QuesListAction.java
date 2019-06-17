package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;

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
 * 获取考试科目的问题
 * 参数说明:
 * id:subject.id选中考试科目的id值
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
		int id = Integer.parseInt(request.getParameter("id"));
		
		Subject subject = new DBCommon().getSubject(id);
		request.getSession().setAttribute("selsub", subject);
		
		int type  = (int) request.getSession().getAttribute("type");
		
		List<Question> db_ques = new DBCommon().getQues(subject.getSubjectname());
		if(type == 1) {
			request.getSession().setAttribute("quesList", db_ques);
			/**
			 * 跳转管理员老师界面
			 */
		}else if(type == 2) {
			Random random = new Random();
			for (int i=0; i<db_ques.size()-subject.getSinglenumber(); i++) {
				db_ques.remove(random.nextInt(db_ques.size()));
			}
			request.getSession().setAttribute("quesList", db_ques);
			/**
			 * 跳转学生界面
			 */
		}
	}

}

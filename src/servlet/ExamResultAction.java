package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Question;
import bean.Score;
import bean.Student;
import bean.Subject;
import db.DBScore;

/**
 * Servlet implementation class ExamResultAction
 *  提交考试获取考试结果
 *  答案
 */

@WebServlet("/ExamResultAction")
public class ExamResultAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamResultAction() {
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
		HttpSession session = request.getSession();
		Subject subject = (Subject)session.getAttribute("selsub");
		Student student = (Student)session.getAttribute("student");
		List<Question> quesList = (List<Question>)session.getAttribute("quesList");
		int scoreid = (int)session.getAttribute("scoreid"); 
		
		
		int sum = 0;
		int singleper = subject.getSingleper();
		for(int i=0; i<quesList.size(); i++) {
			String ans = request.getParameter("question"+i);
			if(ans == null) {
				continue;
			}
			if(quesList.get(i).getAnswer().equals(ans)) {
				sum += singleper;
			}
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String endtime = df.format(new Date()).toString();
		new DBScore().UpdateScore(sum, endtime, scoreid);
		/**
		 * 跳转
		 */
		response.sendRedirect(path+"/GetScoreAction");
	}

}

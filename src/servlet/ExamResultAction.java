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
		Subject subject = (Subject) request.getSession().getAttribute("selsub");
		Student student = (Student) request.getSession().getAttribute("student");
		List<Question> quesList = (List<Question>) request.getSession().getAttribute("quesList");
		
		int sum = 0;
		int singleper = subject.getSingleper();
		
		/**
		 * 
		 */
		Map<Integer, String> ansMap = new HashMap<>(); //id 答案
		/**
		 * 
		 * 
		 */
		
		for (Question ques : quesList) {
			if(ansMap.get(ques.getId()).equals(ques.getAnswer())) {
				sum += singleper;
			}
		}
		
		Score score = new Score();
		score.setUsername(student.getUsername());
		score.setSubjectname(subject.getSubjectname());
		score.setScore(sum);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
		df.format(new Date());
		score.setEndtime(df.toString());
		
		new DBScore().AddScore(score);
		
		request.getSession().setAttribute("result", score);
		/**
		 * 跳转
		 */
	}

}

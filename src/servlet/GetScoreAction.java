package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Score;
import bean.Student;
import db.DBScore;

/**
 * Servlet implementation class GetScoreAction
 * 说明:
 * 学生登陆查看自己的历史分数
 * 返回参数:
 * 参数名	参数类型
 * scList	List<Score>
 */
@WebServlet("/GetScoreAction")
public class GetScoreAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetScoreAction() {
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
		String path = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		Student student = (Student) request.getSession().getAttribute("student");
		List<Score> scList = new DBScore().getScoreList(student);
		
		request.getSession().setAttribute("scList", scList);
		/**
		 * 跳转
		 */
		response.sendRedirect(path+"/User/History.jsp");
	}

}

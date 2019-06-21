package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import db.DBCommon;

/**
 * Servlet implementation class ExamListAction
 * 获取考试列表
 * 参数:
 * 无
 * 返回参数:
 * 参数名	参数类型
 * subList	List<Subject>
 */
@WebServlet("/ExamListAction")
public class ExamListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamListAction() {
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
		int type = (int) request.getSession().getAttribute("type");
		List<Subject>  subList = new DBCommon().getSubList();
		request.getSession().setAttribute("subList", subList);
		
		if(type == 0) {
			
			response.sendRedirect(path+"/Manager/ExamList.jsp");
			/**
			 * 跳转管理员老师考试列表界面
			 */
		}else if(type == 1) {
			
			response.sendRedirect(path+"/User/Chiose.jsp");
			/**
			 * 跳转学生考试列表的界面
			 */
		}
		
	}

}

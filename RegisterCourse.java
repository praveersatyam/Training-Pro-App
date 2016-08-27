package in.ciat.vidya.controller;

import in.ciat.vidya.dao.Dao;
import in.ciat.vidya.model.Course;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterCourse
 */
@WebServlet("/RegisterCourse")
public class RegisterCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String courseId = request.getParameter("courseId");
		String code = request.getParameter("code");
		String version = request.getParameter("version");
		String revision = request.getParameter("revision");
		String title = request.getParameter("title");
		String type = request.getParameter("type");
		String url = request.getParameter("url");
		String activeFlag = request.getParameter("courseId");
		Course course = new Course(courseId,code,version,revision,title,type,url,activeFlag);
		if(course.insertCourseValidate(course)){
			HttpSession session = request.getSession(false);
			request.setAttribute("course",course);
			RequestDispatcher rd = request.getRequestDispatcher("adminConsole.jsp");
			rd.forward(request, response);
		}
		else{
			response.sendRedirect("courseRegistration.jsp");
		}
	}

}

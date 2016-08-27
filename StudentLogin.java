package in.ciat.vidya.controller;

import in.ciat.vidya.dao.Dao;
import in.ciat.vidya.model.Student;
import in.ciat.vidya.model.VerifyStudent;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * HttpServlet implementation class StudentLogin
 */
@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLogin() {
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
		String studentId = request.getParameter("studentId");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		VerifyStudent vs = new VerifyStudent();
		Dao dao = new Dao();
		Student student;
		
		if(vs.verifyLoginInput(studentId, email, password).equals("email")){
			student=dao.showProfileByEmail(email);
			HttpSession session = request.getSession(false);
			session.setAttribute("student",student);
			RequestDispatcher rd = request.getRequestDispatcher("showProfile.jsp");
			rd.forward(request, response);
		}
		else if (vs.verifyLoginInput(studentId, email, password).equals("studentId")){
			student=dao.showProfileById(studentId);
			HttpSession session = request.getSession(false);
			session.setAttribute("student",student);
			RequestDispatcher rd = request.getRequestDispatcher("showProfile.jsp");
			rd.forward(request, response);
		}
		else{
			response.sendRedirect("Login.jsp");
		}
		
	}

}

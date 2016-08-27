package in.ciat.vidya.controller;

import in.ciat.vidya.model.Course;
import in.ciat.vidya.model.Institute;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterInstitute
 */
@WebServlet("/RegisterInstitute")
public class RegisterInstitute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterInstitute() {
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
		String instituteId=request.getParameter("instituteId");
		String name=request.getParameter("name");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String activeFlag=request.getParameter("activeFlag");
		Institute institute = new Institute(instituteId,name,city,state,country ,activeFlag);
		if(institute.insertInstituteValidate(institute)){
			HttpSession session = request.getSession(false);
			request.setAttribute("institute",institute);
			RequestDispatcher rd = request.getRequestDispatcher("adminConsole.jsp");
			rd.forward(request, response);
		}
		else{
			response.sendRedirect("instituteRegistration.jsp");
		}
	}

}

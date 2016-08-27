package in.ciat.vidya.controller;

import in.ciat.vidya.model.ProgramDetail;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * HttpServlet implementation class RegisterProgramDetails
 */
@WebServlet("/RegisterProgramDetails")
public class RegisterProgramDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterProgramDetail() {
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
		String programId=request.getParameter("programId");
		String lineId=request.getParameter("lineId");
		String description=request.getParameter("description");
		ProgramDetail programdetail=new ProgramDetail(programId,lineId,description);
		if(programdetail.insertProgramDetailValidate(programdetail)){
			HttpSession session = request.getSession(false);
			session.setAttribute("programdetail",programdetail);
			RequestDispatcher rd = request.getRequestDispatcher("adminConsole.jsp");
			rd.forward(request, response);
		}
		else{
			response.sendRedirect("programDetailsRegistration.jsp");
		}
		
	}

}

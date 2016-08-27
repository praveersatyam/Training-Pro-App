package in.ciat.vidya.controller;

import in.ciat.vidya.model.Program;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * HttpServlet implementation class UpdateProgram
 */
@WebServlet("/UpdateProgram")
public class UpdateProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProgram() {
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
		String courseId=request.getParameter("courseId");
		String instituteId=request.getParameter("instituteId");
	    String type=request.getParameter("type");
	    String confirmedFlag=request.getParameter("confirmedFlag");
	    String startDate=request.getParameter("startDate");
	    String endDate=request.getParameter("endDate");
	    String duration=request.getParameter("duration");
	    String courseFee=request.getParameter("courseFee");
	    String registrationFee=request.getParameter("registrationFee");
	    String vendorFee=request.getParameter("vendorFee");
	    String showVendorFee=request.getParameter("showVendorFee");
	    String instituteReferenceFlag=request.getParameter("instituteReferenceFlag");
	    SimpleDateFormat sdf= new SimpleDateFormat("MMM dd, yyyy");
	    
	    try {
	    	System.out.println(confirmedFlag);
	    	System.out.println(showVendorFee);
	    	System.out.println(instituteReferenceFlag);
			Program program = new Program(programId,courseId,instituteId,type,confirmedFlag,sdf.parse(startDate),sdf.parse(endDate),duration,courseFee,registrationFee,vendorFee,showVendorFee,instituteReferenceFlag);
			if(program.updateProgramValidate(program)){
				HttpSession session = request.getSession(false);
				request.setAttribute("program",program);
				RequestDispatcher rd = request.getRequestDispatcher("adminConsole.jsp");
				rd.forward(request, response);
			}
			else{
				response.sendRedirect("adminConsole.jsp");
			}
	    } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}

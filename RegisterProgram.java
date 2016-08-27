package in.ciat.vidya.controller;

import in.ciat.vidya.model.Program;
import in.ciat.vidya.model.ProgramDetail;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * HttpServlet implementation class RegisterProgram
 */
@WebServlet("/RegisterProgram")
public class RegisterProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterProgram() {
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
	    int count=Integer.parseInt(request.getParameter("count"));
	    ArrayList<ProgramDetail> list= new ArrayList<ProgramDetail>();
	    for(int i=0;i<count;i++){
	    	String lineId=request.getParameter("lineId"+i);
	    	System.out.println(lineId);
	    	String description=request.getParameter("description"+i);
	    	ProgramDetail pd= new ProgramDetail(programId,lineId,description);
	    	list.add(pd);
	    }
	    try {
			Program program = new Program(programId,courseId,instituteId,type,confirmedFlag,startDate,endDate,duration,courseFee,registrationFee,vendorFee,showVendorFee,instituteReferenceFlag);
			program.setProgramDetailArray(list);
			if(program.insertProgramValidate(program)){
				HttpSession session = request.getSession(false);
				request.setAttribute("program",program);
				RequestDispatcher rd = request.getRequestDispatcher("adminConsole.jsp");
				rd.forward(request, response);
			}
			else{
				response.sendRedirect("programRegistration.jsp");
			}
	    } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}

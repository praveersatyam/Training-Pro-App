package in.ciat.vidya.controller;



import in.ciat.vidya.model.Student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * HttpServlet implementation class RegisterStudent
 */
@WebServlet("/RegisterStudent")

public class RegisterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterStudent() {
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
		String studentId=request.getParameter("studentId");
		String firstName=request.getParameter("firstName");
		String middleName=request.getParameter("middleName");
		String lastName=request.getParameter("lastName");
		String sex=request.getParameter("sex");
		String dob =request.getParameter("dob");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String pin=request.getParameter("pin");
		String email=request.getParameter("email");
		String mobileNo=request.getParameter("mobileNo");
		String alternateNo=request.getParameter("alternateNo");
		String instituteId=request.getParameter("instituteId");
		String discipline=request.getParameter("discipline");
		String semester=request.getParameter("semester");
		String password=request.getParameter("password");
		String emergencyContactName=request.getParameter("emergencyContactName");
		String emergencyContactNo=request.getParameter("emergencyContactNo");
		String emergencyContactRelation=request.getParameter("emergencyContactRelation");
		Student student = new Student(studentId,firstName,middleName,lastName,sex,dob, address,city,state, country,pin,email,mobileNo, alternateNo,instituteId, discipline,semester,password, emergencyContactName,emergencyContactNo,emergencyContactRelation);
		
		if(student.insertStudentValidate(student)){
			HttpSession session = request.getSession(false);
			request.setAttribute("student",student);
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		}
		
		else{
			response.sendRedirect("studentRegistration.jsp");
		}
	}

}

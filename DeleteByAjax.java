package in.ciat.vidya.controller;

import in.ciat.vidya.dao.Dao;
import in.ciat.vidya.model.Course;
import in.ciat.vidya.model.Institute;
import in.ciat.vidya.model.Program;
import in.ciat.vidya.model.ProgramDetail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * HttpServlet implementation class DeleteByAjax
 */
@WebServlet("/DeleteByAjax")
public class DeleteByAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteByAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String buttonID = request.getParameter("buttonId");
		System.out.println(buttonID);
		Dao dao = new Dao();
		char type=buttonID.charAt(6);
		long id;
		PrintWriter out = response.getWriter();
		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
	    Gson gson = new Gson();
	    Course course= new Course();
	    Program program= new Program();
	    Institute institute= new Institute();
	    ProgramDetail programDetail= new ProgramDetail();
	    StringTokenizer stz;
	    String temp="";
		switch (type) {
        case 'C':
        	id=Long.parseLong(buttonID.substring(7));
        	out.write(course.deleteCourseValidateByAjax(id));
        	break;
        case 'P':
        	id=Long.parseLong(buttonID.substring(7));
        	out.write(program.deleteProgramValidateByAjax(id));
        	break;
        case 'I':
        	id=Long.parseLong(buttonID.substring(7));
        	out.write(institute.deleteInstituteValidateByAjax(id));
        	break;
        case 'D':
        	stz=new StringTokenizer(buttonID);
        	temp=stz.nextToken();
        	System.out.println(temp);
        	out.write(programDetail.deleteProgramDetailValidateByAjax(Long.parseLong(stz.nextToken()),Long.parseLong(stz.nextToken())));
        	break;	
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

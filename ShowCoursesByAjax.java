package in.ciat.vidya.controller;

import in.ciat.vidya.dao.Dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;

/**
 * HttpServlet implementation class ShowCoursesByAjax
 */
@WebServlet("/ShowCoursesByAjax")
public class ShowCoursesByAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCoursesByAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Dao dao = new Dao();
		PrintWriter out = response.getWriter();
		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
		JsonArray jarr= new JsonArray();
		
		jarr=dao.showCourses();	
    	out.write(jarr.toString());
    	System.out.println(jarr.toString());
    	
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

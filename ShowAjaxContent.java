package in.ciat.vidya.controller;

import in.ciat.vidya.dao.Dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;

/**
 * HttpServlet implementation class ShowCourses
 */
@WebServlet("/ShowAjaxContent")
public class ShowAjaxContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAjaxContent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String buttonId=request.getParameter("buttonId");
		ArrayList<Long> array;
		System.out.println(buttonId);
		Dao dao = new Dao();
		array=dao.showProgramsId();
		HttpSession session = request.getSession(false);
		request.setAttribute("array",array);
		System.out.println(buttonId+"array");
		RequestDispatcher rd = request.getRequestDispatcher("programDetailsRegistration.jsp");
		System.out.println(buttonId+"array");
		rd.forward(request, response);
		System.out.println(buttonId+"array");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}

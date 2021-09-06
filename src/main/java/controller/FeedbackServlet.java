package controller;

import java.sql.*;
import java.util.*; 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name= "FeedbackServlet", urlPatterns = {"/FeedbackServlet"})
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FeedbackServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Feedback.html").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int rating = Integer.parseInt(request.getParameter("rating"));
		String feedback = request.getParameter("feedback"); 
	 
		 final String USER = "root";
		 final String PASSWORD = "mysql";
		 
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement insertStatement = null; 
		ResultSet resy = null; 
	    response.sendRedirect("LoginServlet");
		
			
			
			
			
		

		
	}

}

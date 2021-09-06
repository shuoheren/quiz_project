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

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(name= "ExamServlet", urlPatterns = {"/ExamServlet"})
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ExamServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("Exam.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int choice = Integer.parseInt(request.getParameter("choice"));
		HttpSession session = request.getSession(false);
		session.setAttribute("selection", choice);
		response.sendRedirect("QuizServlet");
			
		}
		

}

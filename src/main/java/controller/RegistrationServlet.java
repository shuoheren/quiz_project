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

@WebServlet(name= "RegistrationServlet", urlPatterns = {"/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegistrationServlet() {
        super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("Registration.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int uID_new = Integer.parseInt(request.getParameter("uID_new"));
		String userName_new = request.getParameter("userName_new");
				
		 final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		 final String DB_URL = "jdbc:mysql://127.0.0.1:3306/Test";
		 final String USER = "root";
		 final String PASSWORD = "mysql";
		 
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement insertStatement = null; 
		ResultSet resy = null; 
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		String queryStr = "SELECT * FROM userT"; 
		Map<Integer, String> map = new HashMap<>(); 
		try {
			preparedStatement = conn.prepareStatement(queryStr);
			resy = preparedStatement.executeQuery();
			while(resy.next()) {
				map.put(resy.getInt("uID"), resy.getString("userName"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if (!map.containsKey(uID_new)) {
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}
			
			// write to database and proceed
			HttpSession newSession = request.getSession();
			
			String insertStr = "INSERT INTO userT(uID,userName) VALUES (?,?)"; 
			try {
				insertStatement = conn.prepareStatement(insertStr);
				insertStatement.setInt(1,uID_new);
				insertStatement.setString(2, userName_new);
				insertStatement.execute(); 
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
			System.out.println("finished registration, jumping to exam page"); 
			
			// session setting, expires in 5 minutes
			//newSession.setMaxInactiveInterval(5 * 60);
			
			// store answer in session
//			newSession.setAttribute("uID_new", uID0);
//			newSession.setAttribute("userName_new", uID0);
			
			System.out.println("Registration Successful, Please Proceed to Exam"); 
			response.sendRedirect("ExamServlet");
		}
		else {
			System.out.println("UserID duplicate, resubmit"); 
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}

			HttpSession newSession = request.getSession();
			
			response.sendRedirect("RegistrationServlet");
		}
		
		
		
		

	}

}

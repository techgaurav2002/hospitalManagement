package com.user.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.userDao;
import com.db.ConnectionProvider;
import com.entity.user;

/**
 * Servlet implementation class userLogin
 */
public class userLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		userDao dao = new userDao(ConnectionProvider.getConnection());
		user User = dao.login(email, password);
		
		
		if(User!=null){
			
			session.setAttribute("userObj", User);
			response.sendRedirect("index.jsp");
		}else {
			session.setAttribute("errorMsg", "invalid email & password");
			response.sendRedirect("user_login.jsp");
		}
	}

}

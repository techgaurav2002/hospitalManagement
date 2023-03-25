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
 * Servlet implementation class register
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		con = ConnectionProvider.getConnection();
		//p.println(con);
		
		try {
			String name = request.getParameter("fullname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			user u = new user(name,email,password);
			
			userDao dao=new userDao(ConnectionProvider.getConnection());
			
			HttpSession session=request.getSession();
			
			boolean f = dao.userRegister(u);
			if(f == true) {
				session.setAttribute("sucMsg", "register Sucessfull");
				response.sendRedirect("signup.jsp");
				//System.out.println("sucessful");
			}else {
				session.setAttribute("errMsg", "Something wrong on server");
				response.sendRedirect("signup.jsp");
				//System.out.println("unsucessful");
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		}
    

}

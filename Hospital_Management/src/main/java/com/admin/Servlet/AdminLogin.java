package com.admin.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.user;


public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			HttpSession session = request.getSession();
			
			if("admin@gmail.com".equals(email) && "admin".equals(password)){
				
				session.setAttribute("adminObj", new user());
				response.sendRedirect("admin/index.jsp");
			}else {
				session.setAttribute("errMsg", "invalid email & password");
				response.sendRedirect("admin_login.jsp");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

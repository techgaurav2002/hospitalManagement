package com.admin.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.specialistDao;
import com.db.ConnectionProvider;
import com.entity.user;

/**
 * Servlet implementation class AddSpeacialist
 */
public class AddSpeacialist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String specName = request.getParameter("specName");
		
		specialistDao dao = new specialistDao(ConnectionProvider.getConnection());
		boolean f = dao.addSpecialist(specName);
		
		HttpSession session = request.getSession();
		
		if(f == true){
			
			session.setAttribute("succMsg", "Specialist Added");
			response.sendRedirect("admin/index.jsp");
			
		}else {
			session.setAttribute("errorMsg", "Something wrong on server");
			response.sendRedirect("admin_login.jsp");
			
		}
	}

}

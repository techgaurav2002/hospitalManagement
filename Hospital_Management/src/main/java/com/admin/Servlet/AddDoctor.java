package com.admin.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.doctorDao;
import com.db.ConnectionProvider;
import com.entity.Doctor;

/**
 * Servlet implementation class AddDoctor
 */
public class AddDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			String fullName = request.getParameter("fullname");
			String dob = request.getParameter("dob");
			String Qualification = request.getParameter("qualification");
			String spec = request.getParameter("spec");
			String email = request.getParameter("email");
			String mobno = request.getParameter("mobno");
			String password = request.getParameter("password");
			
			
			Doctor d = new Doctor(fullName,dob,Qualification,spec,email,mobno,password);
			
			doctorDao dao = new doctorDao(ConnectionProvider.getConnection());
			HttpSession session = request.getSession();
			
			if(dao.registerDoctor(d)) {
				session.setAttribute("succMsg", "Doctor added Sucessfully");
				response.sendRedirect("admin/doctor.jsp");
				
				
			}else {
				session.setAttribute("errorMsg", "something wrong on server");
				response.sendRedirect("admin/doctor.jsp");
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

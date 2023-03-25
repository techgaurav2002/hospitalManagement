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
 * Servlet implementation class updateDoctor
 */
public class updateDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateDoctor() {
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
			int id = Integer.parseInt(request.getParameter("id"));
			
			
			Doctor d = new Doctor(id,fullName,dob,Qualification,spec,email,mobno,password);
			
			doctorDao dao = new doctorDao(ConnectionProvider.getConnection());
			HttpSession session = request.getSession();
			
			if(dao.updateDoctor(d)) {
				session.setAttribute("succMsg", "Doctor updated Sucessfully");
				response.sendRedirect("admin/view_doctor.jsp");
				
				
			}else {
				session.setAttribute("errorMsg", "something wrong on server");
				response.sendRedirect("admin/view_doctor.jsp");
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

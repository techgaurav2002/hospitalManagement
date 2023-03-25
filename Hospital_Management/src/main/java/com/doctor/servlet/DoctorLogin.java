package com.doctor.servlet;

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
 * Servlet implementation class DoctorLogin
 */
public class DoctorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		doctorDao dao = new doctorDao(ConnectionProvider.getConnection());
		Doctor d = dao.login(email, password);
		
		
		if(d!=null){
			
			session.setAttribute("doctorObj", d);
			response.sendRedirect("doctor/index.jsp");
		}else {
			session.setAttribute("errorMsg", "invalid email & password");
			response.sendRedirect("doctor_login.jsp");
		}
	}

}

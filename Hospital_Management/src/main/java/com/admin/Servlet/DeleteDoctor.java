package com.admin.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.doctorDao;
import com.db.ConnectionProvider;

/**
 * Servlet implementation class DeleteDoctor
 */
public class DeleteDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDoctor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));

		doctorDao dao = new doctorDao(ConnectionProvider.getConnection());
		HttpSession session = request.getSession();
		
		if(dao.deleteDoctor(id)) {
			session.setAttribute("succMsg", "Doctor delete Sucessfully");
			response.sendRedirect("admin/view_doctor.jsp");
			
			
		}else {
			session.setAttribute("errorMsg", "something wrong on server");
			response.sendRedirect("admin/view_doctor.jsp");
			
		}
	}

}

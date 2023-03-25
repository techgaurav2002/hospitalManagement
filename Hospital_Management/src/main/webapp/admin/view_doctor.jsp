<%@ page import="com.entity.Doctor" %>
<%@ page import="com.dao.doctorDao" %>
<%@ page import="com.entity.specalist" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dao.specialistDao" %>
<%@ page import="com.db.ConnectionProvider" %>
<%@ page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../component/allcss.jsp" %>

<style type="text/css">
.paint-card{
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
	}
</style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-success">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><i class="fa-sharp fa-solid fa-hospital"></i> GAURAV'S MEDICAL+</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="home.jsp">HOME</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="doctor.jsp">DOCTOR</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="patient.jsp">PATIENT</a>
        </li>
        
        
         </ul>
         
         <form class="d-files">
         <div class="dropdown">
  <button class="btn btn-Light dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">Admin
  </button>
  <ul class="dropdown-menu">
   
    <li><a class="dropdown-item" href="../AdminLogout">Logout</a></li>
  </ul>
</div>
         
         </form>
      
    </div>
  </div>
</nav>

<!-- table -->


<div class="container-fluid p-3">
		<div class="row">

			
	
	
	<div class="col-md-12">
		<div class="card point-card">
			<div class="card-body">
				<p class ="fs-3 text-center">Doctor Details</p>
				<table class="table">
					<thead>
					<tr>
						<th scope="col">Full Name</th>
						<th scope="col">DOB</th>
						<th scope="col">Qualification</th>
						<th scope="col">Specialist</th>
						<th scope="col">email</th>
						<th scope="col">Mob No</th>
						<th scope="col">Action</th>
						</tr>
						</thead>
						<tbody>
					<%
					doctorDao dao2 = new doctorDao(ConnectionProvider.getConnection());
					List<Doctor> list2 = dao2.getAllDoctor();
					for(Doctor d:list2){%>
					<tr>
					<td><%=d.getFullName() %></td>
					<td><%=d.getDob() %></td>
					<td><%=d.getQualification() %></td>
					<td><%=d.getSpecialist() %></td>
					<td><%=d.getEmail() %></td>
					<td><%=d.getMobNo() %></td>
					<td><%=d.getPassword() %></td>
					              <!-- url rewriting -->
					<td>
					<a href="edit_doctor.jsp?id=<%=d.getId() %>" class="btn btn-sm btn-primary">Edit</a>
					<a href="../DeleteDoctor?id=<%=d.getId()%>" class="btn btn-sm btn-danger">Delete</a>
					</td>
					</tr>
						
					<%}
					%>	
						
						</tbody>
				</table>
				
			
			</div>
		</div>
	</div>
</div>
</div>




</body>
</html>
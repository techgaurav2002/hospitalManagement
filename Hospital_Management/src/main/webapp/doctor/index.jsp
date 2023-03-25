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
</head>
<body>
<c:if test="${empty doctorObj}">
<c:redirect url="../doctor_login.jsp"></c:redirect>

</c:if>



<nav class="navbar navbar-expand-lg navbar-dark bg-success">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><i class="fa-sharp fa-solid fa-hospital"></i> GAURAV'S MEDICAL+</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
      	<ul class="navbar-nav me-auto mb-2 mb-lg-0">
        	<li><a class="nav-link active" aria-current="page" href="#">Home</a></li>
        	<li><a class="nav-link" href="#">PATIENT</a></li>
        </ul>
        
        <form class="d-files">
         <div class="dropdown">
  <button class="btn btn-Light dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
  <i class="fas fa-user-circle"></i>${doctorObj.fullName}
  </button>
  <ul class="dropdown-menu" aria-labelleby="dropdownMenuButton1">
   
    <li><a class="dropdown-item" href="#t">Edit Profile</a></li>
    <li><a class="dropdown-item" href="../DoctorLogout">LogOut</a></li>
  </ul>
</div>
         
         </form>
        
      </div>
    </div>
  </div>
</nav>
<h1>Doctor dashbord</h1>

</body>
</html>
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

<!-- navbar -->
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
          <a class="nav-link active" aria-current="page" href="view_doctor.jsp">VIEW DOCTOR</a>
          
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

<c:if test="${empty adminObj}">
<c:redirect url="../admin_login"></c:redirect>

</c:if>


<div class="container p-5">
		<p class="text-center fs-3">Admin Dashboard</p>
		<c:if test="${not empty succMsg}">
			<p class="fs-3 text-center text-danger">${succMsg}</p>
			<c:remove var="succMsg" scope="session" />
		</c:if>
		<c:if test="${not empty errorMdg}">
			<div class="fs-3 text-center text-success" role="alert">${errorMsg}</div>
			<c:remove var="errorMsg" scope="session" />
		</c:if>
		
<div class="row">
			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-user-md fa-3x"></i><br>
						<p class="fs-4 text-center">
							Doctor <br>30
						</p>
					</div>
				</div>
			</div>
			
			



			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-user-circle fa-3x"></i><br>
						<p class="fs-4 text-center">
							User <br>100
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="far fa-calendar-check fa-3x"></i><br>
						<p class="fs-4 text-center">
							Total Appointment <br>455
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-4 mt-2">

				<div class="card paint-card " data-bs-toggle="modal"
					data-bs-target="#exampleModal">
					<div class="card-body text-center text-success">
						<i class="far fa-calendar-check fa-3x"></i><br>
						<p class="fs-4 text-center">
							Specialist <br>25
						</p>
					</div>
				</div>

			</div>

		</div>
	</div>


<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      <form action="../AddSpeacialist" method="post">
      <div class="form-group">
      <label>Enter Specialist Name</label>
      <input type="text" name="specName" class="form-control">
      </div>
      <div class ="text-center mt-3">
      <button type="submit" class ="btn-btn-primary">Add</button>
      </div>
      
      </form>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>





</body>
</html>
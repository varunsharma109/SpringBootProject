<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.jumbotron {
    padding:70px 30px 70px 30px;
    margin:40px auto;
    background: #9575CD ;
    color:floralwhite;
}
</style>
<body style="text-align:center;">


    <p><header class="jumbotron">
        <div class="container">
            <div class="row row-header">
                <div class="col-12 col-sm-6">
                    <h1>Welcome Admin</h1>
                </div>
                <div class="col-12 col-sm">
                </div>
            </div>
        </div>
    </header> </p>
	<table border="2" width="70%" cellpadding="2" align="center">
	<tr><th>BookId</th><th>DoctorName</th><th>PatientName</th><th>Payment</th><th>Status</th><th>DateTime</th></tr>
    <c:forEach var="admin" items="${list}"> 
    <tr>
    <td>${admin.bookId}</td>
    <td>${admin.doctorName}</td>
    <td>${admin.patientName}</td>
    <td>${admin.payment}</td>
    <td>${admin.status}</td>
    <td>${admin.dateTime}</td>
    <td><a href="http://localhost:8080/admin/changestatus/${admin.bookId}" >Change Status</a></td>
    </tr>
    </c:forEach> 
    </table>
    <br/>

</body>
</html>
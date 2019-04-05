<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="UserHeader.jsp"/>


<c:if test="${not empty msg}">
<div class="alert alert-warning">
	 ${msg} 
	
</div>
</c:if>
<div class="container table-responsive">          
  <table class="table table-striped">
      <tr>
      	<td>Email </td>
      	<td>${sessionScope.user1.email}</td>
      </tr>
      <tr>
      	<td>First Name </td>
      	<td>${sessionScope.user1.firstName}</td>
      </tr>
      <tr>
      	<td>Last Name </td>
      	<td>${sessionScope.user1.lastName}</td>
      </tr>
      <tr>
      	<td>Gender </td>
      	<td>${sessionScope.user1.gender}</td>
      </tr>
      <tr>
      	<td>Date of Birth </td>
      	<td>${sessionScope.user1.dateOfBirth}</td>
      </tr>
  </table>

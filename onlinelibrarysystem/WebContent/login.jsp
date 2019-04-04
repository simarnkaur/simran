<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="background-image:url(images/m3.jpg);height:100%">

<jsp:include page="Navbar.jsp"/>

<div class="container">
<%--
 <%
	Object msg=request.getAttribute("errorMsg");
   if(msg!=null){
	   %>
	   		<div class="alert alert-danger">
	   			Email or Password is incorrect...
	   		</div>
	   <%
   }
 %>	
  --%>

<c:if test="${not empty errorMsg}">
	<div class="alert alert-danger">
		${errorMsg}
	</div>
</c:if>  	
<div class="container" style="margin-left:250px;border-radius: 25px;">
<img src="images/m4.jpg" class="rounded" style="align:center">
</div>

<br>
	<div class="container" style="margin-left:150px">
			<div class="row justify-content-center"  style="background-color:white;margin-left:100px;margin-right:200px"> 
				<div class="col-md-12">
					<div class="row justify-content-center">
						<div class="col-md-4">
							<img src="images/m.jp.jpg" style="padding:30px">
							
							</div>
							
							<div class="col-md-8"style= "width:40%;flot-left;margin-left:100px">
							<form action="Login" method="post">
							<h3> Login</h3>
  							<div class="form-group">
   							 <label for="email">Email address:</label>
   								 <input type="email" class="form-control" id="email" name="email">
 						 </div>
 				 <div class="form-group">
  			  <label for="pwd">Password:</label>
   			 <input type="password" class="form-control" id="pwd" name="pass">
  		</div>
 			 <div class="checkbox">
   	 <label><input type="checkbox"> Remember me</label>
  </div>
  <button type="submit" class="btn btn-default">login</button>
</form>
							
							
							
							</div>
								
						</div>
					</div>
				</div>
			</div>
					
<br></br>					
<p/>

</div>
</div>

<jsp:include page="Footer.jsp"/>
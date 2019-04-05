<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="background-image:url(images/m3.jpg);height:100%">

<jsp:include page="UserHeader.jsp"/>
	<br/>
<!-- Content -->
<div class="container">
<form class="form-horizontal" action="studentUpdate" method="post" style="width:50%;margin-left:270px">
<div class="form-group">
    <label class="control-label col-sm-2" for="email">Email address:</label>
    <div class="col-sm-10">
    <input type="email" class="form-control" id="email" name="email" value="${sessionScope.user1.email}" required>
    </div>
  </div>
   <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Password:</label>
    <div class="col-sm-10">
    <input type="password" class="form-control" id="pwd" name="pwd" value="${sessionScope.user1.password}">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="fname">First Name:</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="fname" name="fName" value="${sessionScope.user1.firstName}">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="lname">Last Name:</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="lname" name="lName" value="${sessionScope.user1.lastName}">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="gender">Gender:</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="gender" name="gender" value="${sessionScope.user1.gender}">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="dob">Date Of Birth:</label>
    <div class="col-sm-10">
    <input type="date" class="form-control" id="dob" name="dob" value="${sessionScope.user1.dateOfBirth}" pattern="dd-MM-yyyy">
    </div>
  </div> 
    
  <button type="submit" class="btn btn-default">Update</button>
</form>

 </div>


<br/><br/><br/>
	
</div>
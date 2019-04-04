<!DOCTYPE html>
<html lang="en">
<head>
  <title>Online Library</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid" style="font-size:17px;">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Library </a>
    </div>
    <ul class="nav navbar-nav">
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      
      <li><a href="#">Contact_Us</a></li>
      <li><a href="#">About_Us</a></li>
    </ul>
    
    <div class="container">
   		<div class="dark">
   			<form role="Product Search" style="width:250px; margin-top:10px; margin-left:600px;">
  			 <div class ="input-group">
   			<input type="text" class="form-control" placeholder="Search"/>
   			<div class="input-group-btn">
   		<button type="submit" class="btn btn-default">
   			<span class="glyphicon glyphicon-search"></span>
   		</button>
   			</div>
   			</div>
   		</form>
   	</div>
   </div>
      <ul class="nav navbar-nav navbar-right">
    <li class="dropdown" style="margin-top:-50px;"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Welcome :${sessionScope.user1.firstName}${sessionScope.user1.lastName}<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="StudentViewProfile.jsp">View Profile</a></li>
          <li><a href="StudentUpdate.jsp">Update Profile</a></li>
          <li><a href="ChangePassword.jsp">Change Password</a></li>
        </ul>
      </li>
      <li style="margin-top:-50px; margin-left:200px; margin-right:-125px;"><a href="Homepage.jsp"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
    </ul>
  </div>
</nav>
 
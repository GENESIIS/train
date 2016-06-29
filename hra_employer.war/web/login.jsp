<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HRA Login</title>
<!-- Bootstrap core CSS -->
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<link href="dist/css/dataTables.bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="dist/assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="dist/css/dashboard.css" rel="stylesheet">
<!-- <link href="dist/css/sidebar.css" rel="stylesheet"> -->

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="dit/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="dist/assets/js/ie-emulation-modes-warning.js"></script>
<script src="dist/js/jquery-1.11.1.js" type="text/javascript"></script>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- <script src="dist/js/jquery-1.11.1.js" type="text/javascript"></script> -->
<script src="dist/editablesearch/source/jquery-latest.min.js"></script>
</head>
<body>
	<center>
		<div class="row">
			<div class="col-sm-6 col-md-4">
				<h2>HRA System</h2>
				<form class="form-signin">
					<label for="inputUserName" class="sr-only">Email Address
						No</label> <input type="email" id="inputUserName" class="form-control"
						placeholder="User Name or EPF No" required="" autofocus="">
					<label for="inputPassword" class="sr-only">Password</label> <input
						type="password" id="inputPassword" class="form-control"
						placeholder="Password" required="" autofocus="">
					<div>
						<button class="btn btn-lg btn-primary btn-block" onclick= "userLogin()" 
							href="index.jsp">Sign in</button>
					</div>

				</form>
			</div>

		</div>
	</center>

</body>
</html>
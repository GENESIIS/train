<!DOCTYPE html>
<!-- 20160407 PN HRA-1 created index.jsp class -->
<!-- 20160519 PN HRA-31 updated index.jsp class with Payroll tab -->


<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Human Resources Dashboard</title>

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

<!-- Importing hra.helper.js file -->
<script src="dist/js/hra/hra.helper.js"></script>
<script src="dist/js/hra/hra.payroll.helper.js"></script>
<script src="dist/js/hra/hra.validation.js"></script>
<script src="dist/js/hra/hra.dynamictable.js"></script>
<script src="dist/js/hra/hra.serch.js"></script>
<script src="dist/js/hra/hra.employeehistory.js"></script>
<script src="dist/js/hra/hra.medicalhistory.js"></script>
<script src="dist/js/hra/hra.loan.js"></script>
<script src="dist/js/hra/hra.department.js"></script>
<script src="dist/js/hra/hra.employer.js"></script>
<script src="dist/js/hra/hra.familydetails.js"></script>
<script src="dist/js/hra/hra.payroll.helper.js"></script>
<script src="dist/js/hra/hra.education.js"></script>
<script src="dist/js/hra/hra.study.js"></script>

<style type="text/css">
/* label { */
/* 	font-weight: normal !important; */
/* } */
input {
	font-weight: normal !important;
}

select {
	font-weight: normal !important;
}
</style>




</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><h4>
						<i class="glyphicon glyphicon-gift"></i> HRIS
					</h4></a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><i class="glyphicon glyphicon-envelope"
							title="Messages"></i></a></li>
					<li><a href="#"><i class="glyphicon glyphicon-flag"
							title="Notifications"></i></a></li>
					<li><a href="#"><i class="glyphicon glyphicon-cog"
							title="Settings"></i></a></li>
					<li><a href="#"><i class="glyphicon glyphicon-user"
							title="Profile"></i> Admin</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-log-out"
							title="Logout"></i></a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav>


	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#dashboard"
						class="list-group-item list-group-item-success"
						data-toggle="collapse" data-parent="#MainMenu"
						onclick="loadContentDashboard()">Dashboard</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="#employee"
						class="list-group-item list-group-item-primary"
						data-toggle="collapse" data-parent="#MainMenu"
						onclick="loadContentEmployee()"> Employee</a></li>
					<li><a href="#department"
						class="list-group-item list-group-item-primary"
						data-toggle="collapse" data-parent="#MainMenu"
						onclick="loadContentDepartment()"> Department</a></li>

					<li><a href="#salarycomponent"
						class="list-group-item list-group-item-primary"
						data-toggle="collapse" data-parent="#MainMenu"
						onclick="loadSalarycomponentdetails()"> Salary Component</a></li>
					<li><a href="#salarycomponent"
						class="list-group-item list-group-item-primary"
						data-toggle="collapse" data-parent="#MainMenu"
						onclick="loadSalaryschemedetails()"> Salary Scheme</a></li>
					<!-- 					<li><a href="#payroll" -->
					<!-- 						class="list-group-item list-group-item-primary" -->
					<!-- 						data-toggle="collapse" data-parent="#MainMenu"> Pay Roll <i -->
					<!-- 							class="glyphicon glyphicon-menu-down"></i></a> -->
					<!-- 						<div class="collapse list-group-submenu list-group-submenu-1" -->
					<!-- 							id="payroll"> -->
					<!-- 							<a href="" class="list-group-item list-group-item-primary" -->
					<!-- 								onclick="loadContentDepartment()"> Salary Component <i -->
					<!-- 								class="fa fa-caret-down"></i> -->
					<!-- 							</a> <a href="" class="list-group-item list-group-item-primary"> -->
					<!-- 								Salary Scheme</a> <a href="" -->
					<!-- 								class="list-group-item list-group-item-primary"> Employee -->
					<!-- 								Salary</a> -->
					<!-- 						</div></li> -->
				</ul>
			</div>

			<div id="mainContent"></div>
		</div>
	</div>



	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
	<script>
		window.jQuery
				|| document
						.write('<script src="dist/assets/js/vendor/jquery.min.js"><\/script>');
	</script>
	<script src="dist/js/bootstrap.min.js"></script>
	<script src="dist/js/bootstrap-datepicker.js"></script>
	<script src="dist/js/dataTables.bootstrap.min.js"></script>
	<script src="dist/js/jquery.dataTables.min.js"></script>

	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="dist/assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="dist/assets/js/ie10-viewport-bug-workaround.js"></script>




</body>
</html>
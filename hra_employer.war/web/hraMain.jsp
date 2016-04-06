<!DOCTYPE html>
<html lang="en">
<head>
<!--/
*H**********************************************************************
* FILENAME :        hraMain.jsp
*
* DESCRIPTION :
*       Landing file of the "Human Resources Application."
*
* NOTES :
*       These functions are a part of the FM suite;
*       See IMS FM0121 for detailed description.  
* 
* AUTHOR :    Pabodha Narmadani        START DATE :    2016-04-06
*
* CHANGES : Removed AdminLTE files. Created only with the Bootstrap.
*

*
*H*
/-->

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Human Resoursed Dashboard</title>

<!-- Bootstrap core CSS -->
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<link href="dist/css/dataTables.bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="../../assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="dashboard.css" rel="stylesheet">

<script src="../../assets/js/ie-emulation-modes-warning.js"></script>
</head>

<body>
	<!--Top right Navigation tab.-->
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
				<a class="navbar-brand" href="#">Project name</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Dashboard</a></li>
					<li><a href="#">Settings</a></li>
					<li><a href="#">Profile</a></li>
					<li><a href="#">Help</a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav>

	<!--Main content of the Page-->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#"><b>Dashboard <span
								class="sr-only">(current)</span></a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">Configuration</a></li>
					<li><a href="">- Employee</a></li>
					<li><a href="">- Department</a></li>
				</ul>
				<ul class="nav nav-sidebar">
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<!--<h1 class="page-header">Dashboard</h1>-->
				<h2 class="sub-header">Employee Managemenrt</h2>
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#addEmployeeDetailsForm">
					<i class="glyphicon glyphicon-user"></i> Create Employee
				</button>
				<br></br>
				<div class="table-responsive">
					<table id="example"
						class="table table-striped table-bordered table-responsive"
						cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>Employee Number</th>
								<th>Employee Name</th>
								<th>Designation</th>
								<th>Contact Details</th>
								<th>View</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Employee Number</th>
								<th>Employee Name</th>
								<th>Designation</th>
								<th>Contact Details</th>
								<th>Viewiew</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</tfoot>
						<tbody>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td align="center"><button type="button"
										class="btn btn-info">
										<i class="glyphicon glyphicon-modal-window"></i>
									</button></td>
								<td align="center"><button type="button"
										class="btn btn-success">
										<i class="glyphicon glyphicon-edit"></i>
									</button></td>
								<td align="center"><button type="button"
										class="btn btn-danger">
										<i class="glyphicon glyphicon-trash"></i>
									</button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>



	<!--"Add Employee Details Form" Modal -->
	<div class="modal fade" id="addEmployeeDetailsForm" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title">
						<i class="glyphicon glyphicon-user"></i> Add Employee Details
					</h3>

				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeNumber">Employee Number</label> <input
									type="text" class="form-control" id="employeeNumber"
									name="employeeNumber" placeholder="">
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="employeeName">Name</label> <input type="text"
							class="form-control" id="employeeName" name="employeeName"
							placeholder="">
					</div>

					<div class="form-group">
						<label for="employeeDesignation">Designation</label> <input
							type="text" class="form-control" id="employeeDesignation"
							name="employeeDesignation" placeholder="">
					</div>

					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeDateofBoth">Date Of Birth</label> <input
									type="date" class="form-control" id="employeeDateofBoth"
									name="employeeDateofBoth" placeholder="">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeGender">Gender</label> <select
									class="form-control" id="employeeGender" name="employeeGender">
									<option>-Select-</option>
									<option>Female</option>
									<option>Male</option>
								</select>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeAddress">Address</label> <input type="text"
									class="form-control" id="employeeAddress"
									name="employeeAddress" placeholder="">
							</div>
							<div class="form-group">
								<label for="employeeMobileNumber">Mobile Number</label> <input
									type="text" class="form-control" id="employeeMobileNumber"
									name="employeeMobileNumber" placeholder="">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeOtherNumber">Other Number</label> <input
									type="text" class="form-control" id="employeeOtherNumber"
									name="employeeOtherNumber" placeholder="">
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="employeeEmail">Email</label> <input type="text"
							class="form-control" id="employeeEmail" name="employeeEmail"
							placeholder="">
					</div>

					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeDepartment">Department</label> <select
									class="form-control" id="employeeDepartment"
									name="employeeDepartment">
									<option>-Select-</option>
								</select>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeJoinDate">Join Date</label> <input
									type="date" class="form-control" id="employeeJoinDate"
									name="employeeJoinDate" placeholder="">
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success pull-left"
						data-dismiss="modal">Add Details</button>
					<button type="button" class="btn btn-danger pull-side"
						data-dismiss="modal">Cancel</button>
				</div>
			</div>

		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="dist/js/bootstrap.min.js"></script>
	<script src="dist/js/dataTables.bootstrap.min.js"></script>
	<script src="dist/js/jquery.dataTables.min.js"></script>


	<script type="text/javascript">
		$(document).ready(function() {
			$('#example').DataTable();
		});
	</script>

	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="../../assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

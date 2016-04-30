<!-- 20160407 PN HRA-2 created manageEmployee.jsp class -->
<!-- 20160412 PN HRA-2 edited the design. -->
<!-- 20160419 PN HRA-2 edited the design. -->
<!-- 20160419 PN HRA-2 edited the design. -->

<!-- JavaScripts to help to load  -->

<script type="text/javascript">
	//To load the Datatable
	$(document).ready(function() {
		$('#employeeDetails').DataTable();
	});

	getDepartment();
</script>


<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="sub-header">Employee Management</h2>

	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#addEmployeedetails">
		<i class="glyphicon glyphicon-plus"></i> New Employee
	</button>


	<br></br>
	<div class="table-responsive">
		<table id="employeeDetails"
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
					<th>View</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td>EMP001</td>
					<td>Dammika Nawarathna</td>
					<td>AGM - HR</td>
					<td>0711111111<br> 0112222222<br> dammika@gmail.com
					</td>
					<td align="center"><button type="button" class="btn btn-info"
							data-toggle="modal" data-target="#viewEmployeeDetailsForm">
							<i class="glyphicon glyphicon-modal-window"></i>
						</button></td>
					<td align="center"><button type="button"
							class="btn btn-warning" data-toggle="modal"
							data-target="#editEmployeeDetailsForm">
							<i class="glyphicon glyphicon-edit"></i>
						</button></td>
					<td align="center"><button type="button"
							class="btn btn-danger" data-toggle="modal"
							data-target="#deleteEmployeeDetailsForm">
							<i class="glyphicon glyphicon-trash"></i>
						</button></td>
				</tr>
			</tbody>
		</table>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="addEmployeedetails" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title">
						<i class="glyphicon glyphicon-user"></i> Add Employee Details
					</h3>
				</div>
				<div class="modal-body">
					<div class="well">
						<h3 class="">General Details</h3>
						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<label for="employeeFirstname">First Name</label><input
										type="text" class="form-control" id="employeeFirstname"
										name="employeeFirstname" placeholder="">
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="employeeMiddlename">Middle Name</label> <input
										type="text" class="form-control" id="employeeMiddlename"
										name="employeeMiddlename" placeholder=""> -
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="employeeLastname">Last Name</label> <input
										type="text" class="form-control" id="employeeLastname"
										name="employeeLastname" placeholder=""> -
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="employeeDateofbirth">Date of Birth</label> <input
										type="date" class="form-control" id="employeeDateofbirth"
										name="employeeDateofbirth" placeholder="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="employeeNic">NIC</label> <input type="text"
										class="form-control" id="employeeNic" name="employeeNic"
										placeholder="">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="employeeGender">Gender</label> <select
										class="form-control" id="employeeGender" name="employeeGender">
										<option value="">--Select--</option>
										<option value="Female">Female</option>
										<option value="Male">Male</option>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="employeeMaritalstatus">Marital Status</label> <select
										class="form-control" id="employeeMaritalstatus"
										name="employeeMaritalstatus">
										<option value="">--Select--</option>
										<option value="Married">Married</option>
										<option value="Single">Single</option>
										<option value="Divorced">Divorced</option>
										<option value="Widowed">Widowed</option>
										<option value="Separated">Separated</option>
									</select>
								</div>
							</div>
						</div>
					</div>

					<div class="well">
						<h3 class="">Job Details</h3>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="employeeEpf">EPF Number</label> <input type="text"
										class="form-control" id="employeeEpf" name="employeeEpf"
										placeholder="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="employeeBasis">Employment Basis</label> <select
										class="form-control" id="employeeBasis" name="employeeBasis">
										<option value="">--Select--</option>
										<option value="Permanent">Permanent</option>
										<option value="Contract">Contract</option>
										<option value="Trainee">Trainee</option>

									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="employeeDesignation">Designation</label> <input
										type="text" class="form-control" id="employeeDesignation"
										name="employeeDesignation" placeholder="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="employeeDepartment">Department</label> <select
										class="form-control" id="employeeDepartment"
										name="employeeDepartment">
										<option value="">--Select--</option>
									</select>
								</div>
							</div>
						</div>
					</div>

					<div class="well">
						<h3 class="">Contact Details</h3>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="employeePermenetaddress">Permanent Address</label>
									<textarea class="form-control" id="employeePermenetaddress"
										name="employeePermenetaddress" placeholder=""></textarea>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="employeeTemporaryaddress">Temporary Address</label>
									<textarea class="form-control" id="employeeTemporaryaddress"
										name="employeeTemporaryaddress" placeholder=""></textarea>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="employeeTelephone">Telephone</label> <input
										type="text" class="form-control" id="employeeTelephone"
										size="10" name="employeeTelephone" placeholder="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="employeeMobile">Mobile Number</label> <input
										type="text" class="form-control" id="employeeMobile"
										name="employeeMobile" size="10">
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="employeeEmail">Email</label> <input type="text"
								class="form-control" id="employeeEmail" name="employeeEmail"
								placeholder="">
						</div>
					</div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-success pull-right"
						onclick="addedAlert()" data-dismiss="">
						<i class="glyphicon glyphicon-floppy-disk"></i> Save
					</button>
					<button type="button" class="btn btn-info pull-left"
						id="moredetails" name="moredetails" onclick=""
						data-dismiss="modal" disabled="true" data-toggle="modal"
						data-target="#addmoreEmployeedetails">
						<i class="glyphicon glyphicon-file"></i> More Details
					</button>
					<button type="button" class="btn btn-warning pull-left" onclick="">
						<i class="glyphicon glyphicon-refresh"></i> Clear
					</button>
					<button type="button" class="btn btn-danger pull-left"
						data-dismiss="modal" onclick="">
						<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
					</button>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- Modal -->
<div class="modal fade" id="addmoreEmployeedetails" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-user"></i>More Employee Details
				</h3>
			</div>
			<div class="modal-body">

				<div class="btn-group btn-group-justified">
					<a href="#" onclick="loadContentqualifications()"
						class="btn btn-primary">Educaional Data</a> <a
						onclick="loadContentstudyprograms()" href="#"
						class="btn btn-primary">Study Programs</a> <a href="#"
						onclick="loadContentloandetails()" class="btn btn-primary">Loan
						Details</a> <a href="#" onclick="loadContentfamilydetails()"
						class="btn btn-primary">Family Details</a>
				</div>
				<div id="modelrest" name="modelrest"></div>

			</div>
			<!-- 			<div class="modal-footer"> -->
			<!-- 				<button type="button" class="btn btn-success pull-side" -->
			<!-- 					onclick="updatedAlert()" data-dismiss=""> -->
			<!-- 					<i class="glyphicon glyphicon-floppy-disk"></i> Save -->
			<!-- 				</button> -->
			<!-- 				<button type="button" class="btn btn-warning " id="moredetails" -->
			<!-- 					name="moredetails" onclick="" data-dismiss="modal" disabled="true"> -->
			<!-- 					<i class="glyphicon glyphicon-file"></i> More Details -->
			<!-- 				</button> -->
			<!-- 			</div> -->
		</div>
	</div>
</div>
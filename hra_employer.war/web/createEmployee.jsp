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
						<i class="glyphicon glyphicon-user"></i> Employee Details
					</h3>
				</div>
				<div class="modal-body">
					<div class="well">
						<h3 class="">General Details</h3>
						<!-- 						<div class="row"> -->
						<!-- 							<div class="col-md-6"> -->
						<div class="form-group">
							<label for="editemployeeId">Name</label> <input type="text"
								class="form-control" id="editemployeeId" name="editemployeeId"
								placeholder="">
						</div>
						<!-- 							</div> -->
						<!-- 							<div class="col-md-6"> -->
						<!-- 								<div class="form-group"> -->
						<!-- 									<label for="editemployeeId">Middle Name</label> <input -->
						<!-- 										type="text" class="form-control" id="editemployeeId" -->
						<!-- 										name="editemployeeId" placeholder=""> -->
						<!-- 								</div> -->
						<!-- 							</div> -->
						<!-- 							<div class="col-md-6"> -->
						<!-- 								<div class="form-group"> -->
						<!-- 									<label for="editemployeeId">Last Name</label> <input -->
						<!-- 										type="text" class="form-control" id="editemployeeId" -->
						<!-- 										name="editemployeeId" placeholder=""> -->
						<!-- 								</div> -->
						<!-- 							</div> -->
						<!-- 						</div> -->

						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">Date of Birth</label> <input
										type="text" class="form-control" id="editemployeeId"
										name="editemployeeId" placeholder="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">NIC</label> <input type="text"
										class="form-control" id="editemployeeId" name="editemployeeId"
										placeholder="">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">Gender</label> <input type="text"
										class="form-control" id="editemployeeId" name="editemployeeId"
										placeholder="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">Marital Status</label> <input
										type="text" class="form-control" id="editemployeeId"
										name="editemployeeId" placeholder="">
								</div>
							</div>
						</div>
					</div>

					<div class="well">
						<h3 class="">Job Details</h3>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">EPF Number</label> <input
										type="text" class="form-control" id="editemployeeId"
										name="editemployeeId" placeholder="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">Employment Status</label> <input
										type="text" class="form-control" id="editemployeeId"
										name="editemployeeId" placeholder="">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="form-group">

									<label for="editemployeeId">Designation</label> <input
										type="text" class="form-control" id="editemployeeId"
										name="editemployeeId" placeholder="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">Department</label> <input
										type="text" class="form-control" id="editemployeeId"
										name="editemployeeId" placeholder="">
								</div>
							</div>
						</div>
					</div>

					<div class="well">
						<h3 class="">Contact Details</h3>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">Permanent Address</label>
									<textarea class="form-control" id="editemployeeId"
										name="editemployeeId" placeholder=""></textarea>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">Temporary Address</label>
									<textarea class="form-control" id="editemployeeId"
										name="editemployeeId" placeholder=""></textarea>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">Telephone</label> <input
										type="text" class="form-control" id="editemployeeId"
										name="editemployeeId" placeholder="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">Mobile Number</label> <input
										type="text" class="form-control" id="editemployeeId"
										name="editemployeeId" placeholder="">
								</div>
							</div>
						</div>


						<div class="form-group">
							<label for="editemployeeId">Email</label> <input type="text"
								class="form-control" id="editemployeeId" name="editemployeeId"
								placeholder="">
						</div>
					</div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-success pull-side"
						onclick="addedAlert()" data-dismiss="">
						<i class="glyphicon glyphicon-floppy-disk"></i> Save
					</button>
					<button type="button" class="btn btn-warning " id="moredetails"
						name="moredetails" onclick="" data-dismiss="modal" disabled="true"
						data-toggle="modal" data-target="#addmoreEmployeedetails">
						<i class="glyphicon glyphicon-file"></i> More Details
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
					<a href="#" onclick="loadContentqualifications()" class="btn btn-primary">Educaional Data</a> 
					<a onclick="loadContentstudyprograms()" href="#" class="btn btn-primary">Study Programs</a>
					<a href="#" onclick="loadContentloandetails()" class="btn btn-primary">Loan Details</a> 
					<a href="#" onclick="loadContentfamilydetails()" class="btn btn-primary">Family Details</a>
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


<!--"View Employee Details Form" Modal -->
<div class="modal fade" id="viewEmployeeDetailsForm" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-modal-window"></i> View Employee Details
				</h3>

			</div>
			<div class="modal-body">
			<img src="dist/demoimages/photo.jpg" class="img-thumbnail"
									alt="User" width="150" height="150">
            <p>ID                 : <input type="text" id="userid"></input></p>
            <p>Name               : <input type="text" id="username"></input></p>
            <p>Disignation        : <input type="text" id="disignation"></input></p>
            <p>Salary             : <input type="text" id="salary"></input></p>
			<p>Email              : <input type="text" id="email"></input></p>
            <p>Date of Birth      : <input type="text" id="dob"></input></p>
            <p>NIC Number         : <input type="text" id="Nic"></input></p>
			<p>Gender             : <input type="text" id="gender"></input></p>
			<p>Address            : <input type="text" id="adress"></input></p>
            <p>Mobile Number      : <input type="text" id="MobNumber"></input></p>
            <p>Other Number       : <input type="text" id="OthNumber"></input></p>
			<p>Departmentpartment : <input type="text" id="depid"></input></p>
			<p>Date of Join       : <input type="text" id="doj"></input></p>
            

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger pull-side"
					data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<!--"Edit Employee Details Form" Modal -->
<div class="modal fade" id="editEmployeeDetailsForm" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-edit"></i> Edit Employee Details
				</h3>

			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="employeeNumberEdit">Employee Number</label> <input
								type="text" class="form-control" id="employeeNumberEdit"
								name="employeeNumberEdit" placeholder="">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="employeeNameEdit">Name</label> <input type="text"
						class="form-control" id="employeeNameEdit" name="employeeNameEdit"
						placeholder="">
				</div>

				<div class="form-group">
					<label for="employeeDesignationEdit">Designation</label> <input
						type="text" class="form-control" id="employeeDesignationEdit"
						name="employeeDesignationEdit" placeholder="">
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="employeeDateofBothEdit">Date Of Birth</label> <input
								type="date" class="form-control" id="employeeDateofBothEdit"
								name="employeeDateofBothEdit" placeholder="">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="employeeGenderEdit">Gender</label> <select
								class="form-control" id="employeeGenderEdit"
								name="employeeGenderEdit">
								<option>-Select-</option>
								<option>Female</option>
								<option>Male</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="employeeAddressEdit">Address</label> <input type="text"
						class="form-control" id="employeeAddressEdit"
						name="employeeAddressEdit" placeholder="">
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="employeeMobileNumberEdit">Mobile Number</label> <input
								type="text" class="form-control" id="employeeMobileNumberEdit"
								name="employeeMobileNumberEdit" placeholder="">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="employeeOtherNumberEdit">Other Number</label> <input
								type="text" class="form-control" id="employeeOtherNumberEdit"
								name="employeeOtherNumberEdit" placeholder="">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="employeeEmailEdit">Email</label> <input type="text"
						class="form-control" id="employeeEmailEdit"
						name="employeeEmailEdit" placeholder="">
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="employeeDepartmentEdit">Department</label> <select
								class="form-control" id="employeeDepartmentEdit"
								name="employeeDepartmentEdit">
								<option>-Select-</option>
								<option>HR</option>
								<option>IT</option>
								<option>Marketing</option>
								<option>Legal</option>
							</select>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="employeeJoinDateEdit">Join Date</label> <input
								type="date" class="form-control" id="employeeJoinDateEdit"
								name="employeeJoinDateEdit" placeholder="">
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-side"
					onclick="updatedAlert()" data-dismiss="modal">Save Details</button>
				<button type="button" class="btn btn-danger pull-left"
					data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>


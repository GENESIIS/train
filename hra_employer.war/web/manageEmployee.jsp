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
		data-target="#addEmployeeDetailsForm">
		<i class="glyphicon glyphicon-user"></i> Create Employee
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
				<tr>
					<td>EMP002</td>
					<td>Chamara Withanachchi</td>
					<td>DGM - IT</td>
					<td>0712222222<br> 0113333333<br> chamaraw@gmail.com
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
</div>


<!--"Add Employee Details Form" Modal -->
<div class="modal fade" id="addEmployeeDetailsForm" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-user"></i> Employee Details
				</h3>

			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="employeeNumber">Employee Number</label> <input
								type="text" class="form-control" id="employeeNumber"
								name="employeeNumber" placeholder="" value="">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="">Name</label>
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label for="employeeFirstname">First Name</label><input
									type="text" class="form-control" id="employeeFirstname"
									name="employeeFirstname" placeholder="" value="">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="employeeMiddlename">Middle Name</label><input
									type="text" class="form-control" id="employeeMiddlename"
									name="employeeMiddlename" placeholder="" value="">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="employeeLastname">Last Name</label><input
									type="text" class="form-control" id="employeeLastname"
									name="employeeLastname" placeholder="" value="">
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="employeeDateofbirth">Date Of Birth</label> <input
								type="date" class="form-control" id="employeeDateofbirth"
								name="employeeDateofbirth" placeholder="">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="employeeGender">Gender</label> <select
								class="form-control" id="employeeGender" name="employeeGender">
								<option value="">-Select-</option>
								<option value="F">Female</option>
								<option value="M">Male</option>
							</select>
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeePermenetaddress">Address (Permanent)</label>
								<textarea class="form-control" id="employeePermenetaddress"
									name="employeePermenetaddress"></textarea>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeTemporaryaddress">Address
									(Temporary)</label>
								<textarea class="form-control" id="employeeTemporaryaddress"
									name="employeeTemporaryaddress" placeholder=""></textarea>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label for="employeeMobileNumber">Mobile Number</label> <input
								type="text" class="form-control" id="employeeMobileNumber"
								name="employeeMobileNumber" placeholder="" value="">
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="employeeTelephonepermanent">Telephone
								(Permanent)</label> <input type="text" class="form-control"
								id="employeeTelephonepermanent"
								name="employeeTelephonepermanent" placeholder="" value="">
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="employeeTelephonetemporary">Telephone
								(Temporary)</label> <input type="text" class="form-control"
								id="employeeTelephonetemporary"
								name="employeeTelephonetemporary" placeholder="" value="">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="employeeEmail">Email</label> <input type="text"
						class="form-control" id="employeeEmail" name="employeeEmail"
						placeholder="" value="">
				</div>



				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="employeeNic">National Identity Card</label> <input
								type="text" class="form-control" id="employeeNic"
								name="employeeNic" placeholder="" value="">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="employeeMaritalstatus">Marital Status</label> <select
								class="form-control" id="employeeMaritalstatus"
								name="employeeMaritalstatus">
								<option value="">-Select-</option>
								<option value="Single">Single</option>
								<option value="Married">Married</option>
								<option value="Widowed">Widowed</option>
								<option value="Separated">Separated</option>
								<option value="Divorced">Divorced</option>
							</select>
						</div>
					</div>
				</div>


				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="employeeDepartment">Department</label> <select
								class="form-control" id="employeeDepartment"
								name="employeeDepartment">
								<option>-Select-</option>
								<option value="HR">HR</option>
								<option value="IT">IT</option>
								<option value="Marketing">Marketing</option>
								<option value="Legal">Legal</option>
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


				<div class="form-group">
					<label for="employeeDesignation">Designation</label> <input
						type="text" class="form-control" id="employeeDesignation"
						name="employeeDesignation" placeholder="" value="">
				</div>


				<!-- 				<div class="form-group"> -->
				<!-- 					<label for="employeeI">User Image</label> <input id="file-0a" -->
				<!-- 						class="file" type="file" multiple data-min-file-count="1"> -->
				<!-- 				</div> -->

				<button type="button" class="btn btn-warning" data-toggle="modal"
					data-target="#moreEmployeeDetailsForm">
					<i class="	glyphicon glyphicon-info-sign"></i> More Info
				</button>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-side"
					onclick="deleteAlert()" data-dismiss="modal">Delete</button>
				<button type="button" class="btn btn-danger pull-left"
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

<!--"View Employee Details Form" Modal -->
<div class="modal fade" id="viewEmployeeDetailsForm" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-modal-window"></i> View Employee
					Details
				</h3>

			</div>
			<div class="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger pull-side"
					data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<!-- Delete Employee Details -->
<div class="modal fade bs-example-modal-sm"
	id="deleteEmployeeDetailsForm" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-trash"></i> Delete Employee Details
				</h3>

			</div>
			<div class="modal-body">Are you sure to delete this Employee?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-side"
					onclick="deleteAlert()" data-dismiss="modal">Delete</button>
				<button type="button" class="btn btn-danger pull-left"
					data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>


<!-- More Employee Details -->
<div class="modal fade" id="moreEmployeeDetailsForm" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-user"></i> Employee Details
				</h3>

			</div>
			<div class="modal-body">
				<div class="">
					<div class="panel-group" id="accordion">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse1">EDUCATIONAL & PROFESSIONAL QUALIFICATION</a>
								</h4>
							</div>
							<div id="collapse1" class="panel-collapse collapse">
								<div class="panel-body">
									<div class="table-responsive">
										<table id="educationalAndprofessionalqualification"
											class="table table-striped table-bordered table-responsive"
											cellspacing="0" width="100%">
											<tr class="info">
												<th></th>
												<th>School/College/University attended</th>
												<th>Year of Admission</th>
												<th>Year of Leaving</th>
												<th>Medium Studied</th>
												<th>Name of Qualification Obtained</th>
											</tr>
											<tr>
												<td>1</td>
												<td><input type="text" name="schoolAttended"
													id="schoolAttended" onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="yearAdmission"
													id="yearAdmission" onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="yearLeaving"
													id="yearLeaving" onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="mediumStudied"
													id="mediumStudied" onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="qualification"
													id="qualification" onkeypress="keyPressTest(event, this);" /></td>
											</tr>
										</table>
									</div>
									<p>
										<input class="btn btn-default" type="button" value=" + "
											onclick="addRowToTable('5','educationalAndprofessionalqualification');" />
										<input class="btn btn-default" type="button" value=" - "
											onclick="removeRowFromTable('educationalAndprofessionalqualification');" />
									</p>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse2">CURRENT INVOLVED STUDY PROGRAMMMES</a>
								</h4>
							</div>
							<div id="collapse2" class="panel-collapse collapse">
								<div class="panel-body">
									<div class="table-responsive">
										<table id="currentInvolvedstudyprogram"
											class="table table-striped table-bordered table-responsive"
											cellspacing="0" width="100%">
											<tr class="info">
												<th></th>
												<th>Name of Institiution</th>
												<th>Type of Course</th>
												<th>Date of Admission</th>
												<th>Duration</th>
												<th>Classes are On</th>
											</tr>
											<tr>
												<td>1</td>
												<td><input type="text" name="nameOfinstitiution"
													id="nameOfinstitiution"
													onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="typeOfcourse"
													id="typeOfcourse" onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="dateOfddmission"
													id="dateOfddmission"
													onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="duration" id="duration"
													onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="classesAreon"
													id="classesAreon" onkeypress="keyPressTest(event, this);" /></td>
											</tr>
										</table>
									</div>
									<p>
										<input class="btn btn-default" type="button" value=" + "
											onclick="addRowToTable('5','currentInvolvedstudyprogram');" />
										<input class="btn btn-default" type="button" value=" - "
											onclick="removeRowFromTable('currentInvolvedstudyprogram');" />
									</p>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse3">EMPLOYEEMENT HISTORY</a>
								</h4>
							</div>
							<div id="collapse3" class="panel-collapse collapse">
								<div class="panel-body">

									<div class="table-responsive">
										<table id="employeementHistory"
											class="table table-striped table-bordered table-responsive"
											cellspacing="0" width="100%">
											<tr class="info">
												<th></th>
												<th>Name of Employee</th>
												<th>Started Year</th>
												<th>End Year</th>
												<th>Designation</th>
												<th>Contract/Permenet</th>
											</tr>
											<tr>
												<td>1</td>
												<td><input type="text" name="nameOfemployee"
													id="nameOfemployee" onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="startedYear"
													id="startedYear" onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="endYear" id="endYear"
													onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="designation"
													id="designation" onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="basis" id="basis"
													onkeypress="keyPressTest(event, this);" /></td>
											</tr>
										</table>
									</div>
									<p>
										<input class="btn btn-default" type="button" value=" + "
											onclick="addRowToTable('5','employeementHistory');" /> <input
											class="btn btn-default" type="button" value=" - "
											onclick="removeRowFromTable('employeementHistory');" />
									</p>

								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse4">OUTSTANDING LOAN DETAILS</a>
								</h4>
							</div>
							<div id="collapse4" class="panel-collapse collapse">
								<div class="panel-body">

									<div class="table-responsive">
										<table id="employeeLoan"
											class="table table-striped table-bordered table-responsive"
											cellspacing="0" width="100%">
											<tr class="info">
												<th></th>
												<th>Total Outstanding Amount</th>
												<th>Borrowers</th>
												<th>Monthly Payment</th>
												<th>Due Date</th>
											</tr>
											<tr>
												<td>1</td>
												<td><input type="text" name="outstandingAmount"
													id="outstandingAmount"
													onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="borrowers" id="borrowers"
													onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="monthlyPayment"
													id="monthlyPayment" onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="dueDate"
													id="dueDate" onkeypress="keyPressTest(event, this);" /></td>
											</tr>
										</table>
									</div>
									<p>
										<input class="btn btn-default" type="button" value=" + "
											onclick="addRowToTable('4','employeeLoan');" /> <input
											class="btn btn-default" type="button" value=" - "
											onclick="removeRowFromTable('employeeLoan');" />
									</p>

								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse5">FAMILY DETAILS</a>
								</h4>
							</div>
							<div id="collapse5" class="panel-collapse collapse">
								<div class="panel-body">

									<div class="table-responsive">
										<table id="employeeFamilydetails"
											class="table table-striped table-bordered table-responsive"
											cellspacing="0" width="100%">
											<tr class="info">
												<th></th>
												<th>Relationship</th>
												<th>Name</th>
												<th>Date of Birth</th>
												<th>Occupation</th>
												<th>Place</th>
											</tr>
											<tr>
												<td>1</td>
												<td><input type="text" name="relationship"
													id="relationship"
													onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="relationName" id="relationName"
													onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="relationDateofbirth"
													id="relationDateofbirth" onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name="relationOccupation"
													id="relationOccupation" onkeypress="keyPressTest(event, this);" /></td>
												<td><input type="text" name=""workingPlace"" id=""workingPlace""
													onkeypress="keyPressTest(event, this);" /></td>
											</tr>
										</table>
									</div>
									<p>
										<input class="btn btn-default" type="button" value=" + "
											onclick="addRowToTable('5','employeeFamilydetails');" /> <input
											class="btn btn-default" type="button" value=" - "
											onclick="removeRowFromTable('employeeFamilydetails');" />
									</p>

								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse6">PARTICULARS ABOUT YOUR HEALTH</a>
								</h4>
							</div>
							<div id="collapse6" class="panel-collapse collapse">
								<div class="panel-body"></div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse7">OTHER DETAILS</a>
								</h4>
							</div>
							<div id="collapse7" class="panel-collapse collapse">
								<div class="panel-body"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-side"
					onclick="deleteAlert()" data-dismiss="modal">Delete</button>
				<button type="button" class="btn btn-danger pull-left"
					data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<script>
	function myCreateFunction() {
		int
		count = 0;
		var table = document.getElementById("myTable");
		var row = table.insertRow(count);
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		cell1.innerHTML = "NEW CELL1";
		cell2.innerHTML = "NEW CELL2";

	}

	function myDeleteFunction() {
		document.getElementById("myTable").deleteRow(0);
	}
</script>

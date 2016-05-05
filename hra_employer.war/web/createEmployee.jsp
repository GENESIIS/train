<!-- 20160407 PN HRA-2 created manageEmployee.jsp class -->

<!-- JavaScripts to help to load  -->


<script type="text/javascript">
	//To load the Datatable
</script>
<script src="dist\js\jquery-2.2.3.min.js"
    type="text/javascript"></script>
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
					<td>0711111111<br>
					0112222222<br>
					dammika@gmail.com
					</td>
					<td align="center"><button id="vbutton" type="button" class="btn btn-info"
							 data-toggle="modal" data-target="#viewEmployeeDetailsForm" >
							<i class="glyphicon glyphicon-modal-window"></i>
						</button></td>
					<td align="center"><button  id="ebutton" type="button"
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
					<td>0712222222<br>
					0113333333<br>
					chamaraw@gmail.com
					</td>
					<td align="center"><button id = "vbutton1" type="button" class="btn btn-info"
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
							<label for="employeeId">Employee Number</label> <input
								type="text" class="form-control" id="employeeId"
								name="employeeNumber" placeholder="" value="EMP003">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="employeeName">Name</label> <input type="text"
						class="form-control" id="employeeName" name="employeeName"
						placeholder="" value="Lakmal Baalasooriya">
				</div>

				<div class="form-group">
					<label for="employeeDesignation">Designation</label> <input
						type="text" class="form-control" id="employeeDesignation"
						name="employeeDesignation" placeholder="" value="Junior Executive">
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

				<div class="form-group">
					<label for="employeeAddress">Address</label> <input type="text"
						class="form-control" id="employeeAddress" name="employeeAddress"
						value="53/A, Temple Road, Nugegoda.">
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="employeeMobileNumber">Mobile Number</label> <input
								type="text" class="form-control" id="employeeMobileNumber"
								name="employeeMobileNumber" placeholder="" value="0713967259">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="employeeOtherNumber">Other Number</label> <input
								type="text" class="form-control" id="employeeOtherNumber"
								name="employeeOtherNumber" placeholder="" value="0117411411">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="employeeEmail">Email</label> <input type="text"
						class="form-control" id="employeeEmail" name="employeeEmail"
						placeholder="" value="lakmalu@gmail.com">
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="employeeDepartment">Department</label> <select
								class="form-control" id="employeeDepartment"
								name="employeeDepartment">
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
							<label for="employeeJoinDate">Join Date</label> <input
								type="date" class="form-control" id="employeeJoinDate"
								name="employeeJoinDate">
						</div>
					</div>
				</div>

<!-- 				<div class="form-group"> -->
<!-- 					<label for="employeeI">User Image</label> <input id="file-0a" -->
<!-- 						class="file" type="file" multiple data-min-file-count="1"> -->
<!-- 				</div> -->



			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-left"
					data-dismiss="modal" onclick="addEmployeeDetails()">Add Details</button>
				<button type="button" class="btn btn-danger pull-side"
					data-dismiss="modal">Cancel</button>
			</div>
		</div>

	</div>
</div>

<!--"Edit Employee Details Form" Modal -->
<!--//////////////////////////////////////////////// new edit/////////////////////////////////////////////////////// -->

<!-- Modal -->
	<div class="modal fade" id="editEmployeeDetailsForm" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title">
						<i class="glyphicon glyphicon-user"></i>Edit Employee Details
					</h3>
				</div>
				<div class="modal-body">
					<div class="well">
						<h3 class="">General Details</h3>
						<!-- 						<div class="row"> -->
						<!-- 							<div class="col-md-6"> -->
						<div class="form-group">
							<label for="editemployeeId">Name</label> <input type="text"
								class="form-control" id="employeeNameEdit" name="editemployeeId"
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
										type="date" class="form-control" id="employeeDateofBothEdit"
										name="employeeDateofBothEdit" placeholder="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">NIC</label> <input type="text"
										class="form-control" id="employeeNICEdit" name="editemployeeNIC"
										placeholder="">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">Gender</label> <input type="text"
										class="form-control" id="employeeGenderEdit" name="employeeGenderEdit"
										placeholder="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">Marital Status</label> <input
										type="text" class="form-control" id="employeeMaritalEdit"
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
										type="text" class="form-control" id="employeeEPFEdit"
										name="employeeEPFEdit" placeholder="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">Employment Status</label> <input
										type="text" class="form-control" id="employeeStatusEdit"
										name="employeeStatusEdit" placeholder="">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="form-group">

									<label for="editemployeeId">Designation</label> <input
										type="text" class="form-control" id="employeeDesignationEdit"
										name="employeeDesignationEdit" placeholder="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">Department</label> <input
										type="text" class="form-control" id="employeeDepartmentEdit"
										name="employeeDepartmentEdit" placeholder="">
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
									<textarea class="form-control" id="employeeAddressEdit"
										name="employeeAddressEdit" placeholder=""></textarea>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">Temporary Address</label>
									<textarea class="form-control" id="employeeTempADDEdit"
										name="employeeTempADDEdit" placeholder=""></textarea>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">Telephone</label> <input
										type="text" class="form-control" id="employeeOtherNumberEdit"
										name="employeeOtherNumberEdit" placeholder="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="editemployeeId">Mobile Number</label> <input
										type="text" class="form-control" id="employeeMobileNumberEdit"
										name="employeeMobileNumberEdit" placeholder="">
								</div>
							</div>
						</div>


						<div class="form-group">
							<label for="editemployeeId">Email</label> <input type="text"
								class="form-control" id="employeeEmailEdit" name="editemployeeId"
								placeholder="">
						</div>
					</div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-success pull-right"
						onclick="updateEmployeeDetails()" data-dismiss="">
						<i class="glyphicon glyphicon-floppy-disk"></i> Update
					</button>
					<button type="button" class="btn btn-warning pull-right" id="moredetails"
						name="moredetails" onclick="" data-dismiss="modal" 
						data-toggle="modal" data-target="#editmoreEmployeedetails">
						<i class="glyphicon glyphicon-file"></i>Edit More Details
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

<!--////////////////////////////////////////-->

<div class="modal fade" id="editmoreEmployeedetails" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-user"></i>Edit More Employee Details
				</h3>
			</div>
			<div class="modal-body">

				<div class="btn-group btn-group-justified">
					<a href="#" onclick="loadEditContentqualifications()"
						class="btn btn-primary">Educaional Data</a> <a
						onclick="loadEditContentstudyprograms()" href="#"
						class="btn btn-primary">Study Programs</a> <a href="#"
						onclick="loadEditContentloandetails()" class="btn btn-primary">Loan
						Details</a> <a href="#" onclick="loadEditContentfamilydetails()"
						class="btn btn-primary">Family Details</a>
				</div>
				<div id="Editmodelrest" name="Editmodelrest"></div>

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

<!--////////////////////////////////////////-->


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
			<div id ="view">  
           <!-- <img src="dist/demoimages/photo.jpg" class="img-thumbnail"
									alt="User" width="150" height="150">
            <p id="userid"></p>
            <p id="username"></p>
            <p id="disignation"></p>
            <p id="salary"></p>
			<p id="email"></p>
            <p id="dob"></p>
            <p id="Nic"></p>
		 	<p id="gender"></p>
			<p id="adress"></p>
            <p id="MobNumber"></p>
            <p id="OthNumber"></p>
			<p id="depid"></p>
			<p id="doj"></p> -->
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger pull-side"
					data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-warning " id="moredetails"
						name="moredetails" onclick="" data-dismiss="modal" 
						data-toggle="modal" data-target="#viewmoreEmployeedetails">
						<i class="glyphicon glyphicon-file"></i> More Details
				</button>
	
			</div>
		</div>
	</div>
</div>

<!-- group byn model-->
<div class="modal fade" id="viewmoreEmployeedetails" role="dialog">
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
					<a href="#" onclick="loadviewqlifications()" class="btn btn-primary">Educaional Data</a> 
					<a onclick="loadviewstudyprograms()" href="#" class="btn btn-primary">Study Programs</a>
					<a href="#" onclick="loadviewloandetails()" class="btn btn-primary">Loan Details</a> 
					<a href="#" onclick="loadviewfamilydetails()" class="btn btn-primary">Family Details</a>
				</div>
				<div id="viewmodelrest" name="viewmodelrest"></div>

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


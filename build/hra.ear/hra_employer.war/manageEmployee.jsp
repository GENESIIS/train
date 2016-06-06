<!-- 20160407 PN HRA-2 created manageEmployee.jsp class -->
<!-- 20160412 PN HRA-2 edited the design. -->
<!-- 20160419 PN HRA-2 edited the design. -->
<!-- 20160419 PN HRA-2 edited the design. -->
<!-- 20160505 PN HRA-2 edited the design. -->
<!-- 20160530 PC HRA-30 edited the design. -->
<!-- JavaScripts to help to load  -->


<script type="text/javascript">
	//To load the Datatable
	$(document).ready(function() {
		loadBasicTable();
		//listEmployee(empData); 
	});
</script>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="sub-header">Employee Management</h2>


	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#addEmployeedetails">
		<i class="glyphicon glyphicon-plus"></i> New Employee
	</button>
	<br></br>
	<div class="row">
		<div class="col-sm-4">
			<!-- <select class="selectpicker">
      <option value="Basic" selected="selected">Basic detail</option>
      <option value="Family">Department detail</option>
      <option value="medical"></option>
      <option value="Education"></option>
     </select> -->
		</div>
		<div class="col-sm-8" align="right">
			<div class="input-group add-on">
				<input class="form-control" placeholder="Search"
					id="serchEmployeeText" type="text">
				<div class="input-group-btn">
					<button class="btn btn-default" onclick="serchEmployee()"
						type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
		</div>
	</div>
	<div id="basicTable"></div>
</div>

<!-- Modal ADD EMPLOYEE DETAILS-->
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
								<label for="employeeNumber">Employee Number</label><input
									type="text" class="form-control" id="employeeNumber"
									name="employeeNumber" placeholder="" maxlength="6" size="6">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label for="employeeFirstname">First Name</label><input
									type="text" class="form-control" id="employeeFirstname"
									name="employeeFirstname" placeholder=""
									onkeypress="return isLetter(event);">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="employeeMiddlename">Middle Name</label> <input
									type="text" class="form-control" id="employeeMiddlename"
									name="employeeMiddlename" placeholder=""
									onkeypress="return isLetter(event);">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="employeeLastname">Last Name</label> <input
									type="text" class="form-control" id="employeeLastname"
									name="employeeLastname" placeholder=""
									onkeypress="return isLetter(event);">
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
									placeholder="" maxlength="10" size="10">
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
						<div class="col-md-4">
							<div class="form-group">
								<label for="employeeEpf">EPF Number</label> <input type="text"
									class="form-control" id="employeeEpf" name="employeeEpf"
									placeholder="" onkeypress="return isNumberKey(event)">
							</div>
						</div>
						<div class="col-md-4">
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
						<div class="col-md-4">
							<div class="form-group">
								<label for="employeeJoindate">Joined Date</label> <input
									type="date" class="form-control" id="employeeJoindate"
									name="employeeJoindate" placeholder="">
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
									maxlength="10" size="10" name="employeeTelephone"
									placeholder="" onkeypress="return isNumberKey(event);">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeMobile">Mobile Number</label> <input
									type="text" class="form-control" id="employeeMobile"
									name="employeeMobile" maxlength="10" size="10"
									onkeypress="return isNumberKey(event)">
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
					onclick="addEmployeeDetails()" data-dismiss="">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save
				</button>
				<button type="button" class="btn btn-info pull-left"
					id="moredetails" name="moredetails" data-toggle="modal"
					data-target="#addmoreEmployeedetails">
					<i class="glyphicon glyphicon-file"></i> More Details
				</button>
				<button type="button" class="btn btn-warning pull-left"
					onclick="clearAddemployeeform()">
					<i class="glyphicon glyphicon-refresh"></i> Clear
				</button>
				<button type="button" class="btn btn-danger pull-left"
					data-dismiss="modal" onclick="clearAddemployeeform()">
					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
				</button>
			</div>
		</div>
	</div>
</div>


<!-- Modal ADD MORE DETAILS-->
<div class="modal fade" id="addmoreEmployeedetails" role="dialog">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-user">More Employee Details</i>
				</h3>
			</div>
			<div class="modal-body" onload="ready()">

				<div class="btn-group btn-group-justified">
					<a href="#" onclick="loadContentqualifications()"
						class="btn btn-primary">Educaional Data</a> <a
						onclick="loadContentstudyprograms()" href="#"
						class="btn btn-primary">Study Programs</a> <a href="#"
						onclick="loadlonedetails()" class="btn btn-primary">Loan
						Details</a> <a href="#" onclick="loadfamilydetails()"
						class="btn btn-primary">Family Details</a> <a id="btnEmpHisDet"
						href="#" onclick="loadAddEmployementHIstoryDetails()"
						class="btn btn-primary">Employee History Details</a> <a
						id="btnMedicalHistory" href="#"
						onclick="loadAddMedicalHIstoryDetails()" class="btn btn-primary">Medical
						History</a>
				</div>
				<div class="modal-body1" style="overflow-y: auto;">
					<div id="modelrest" style="overflow-y: auto;"></div>
				</div>

			</div>

		</div>

	</div>
</div>






<!-- Modal EDIT EMPLOYEE DETAILS -->
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
					<div class="form-group">
						<label for="employeeNameEdit">Name</label> <input type="text"
							class="form-control" id="employeeNameEdit"
							name="employeeNameEdit" placeholder="">
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeDateofBothEdit">Date of Birth</label> <input
									type="date" class="form-control" id="employeeDateofBothEdit"
									name="employeeDateofBothEdit" placeholder="">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="editemployeeId">NIC</label> <input type="text"
									class="form-control" id="employeeNICEdit"
									name="editemployeeNIC" placeholder="">
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeGenderEdit">Gender</label> <input
									type="text" class="form-control" id="employeeGenderEdit"
									name="employeeGenderEdit" placeholder="">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeMaritalEdit">Marital Status</label> <input
									type="text" class="form-control" id="employeeMaritalEdit"
									name="employeeMaritalEdit" placeholder="">
							</div>
						</div>
					</div>
				</div>

				<div class="well">
					<h3 class="">Job Details</h3>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeEPFEdit">EPF Number</label> <input
									type="text" class="form-control" id="employeeEPFEdit"
									name="employeeEPFEdit" placeholder="">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeStatusEdit">Employment Status</label> <input
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
								<label for="employeeDesignationEdit">Department</label> <input
									type="text" class="form-control" id="employeeDepartmentEdit"
									name="employeeDesignationEdit" placeholder="">
							</div>
						</div>
					</div>
				</div>

				<div class="well">
					<h3 class="">Contact Details</h3>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeAddressEdit">Permanent Address</label>
								<textarea class="form-control" id="employeeAddressEdit"
									name="employeeAddressEdit" placeholder=""></textarea>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeTempADDEdit">Temporary Address</label>
								<textarea class="form-control" id="employeeTempADDEdit"
									name="employeeTempADDEdit" placeholder=""></textarea>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeOtherNumberEdit">Telephone</label> <input
									type="Number" class="form-control" id="employeeOtherNumberEdit"
									name="employeeOtherNumberEdit" placeholder="">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="employeeMobileNumberEdit">Mobile Number</label> <input
									type="Number" class="form-control"
									id="employeeMobileNumberEdit" name="employeeMobileNumberEdit"
									placeholder="">
							</div>
						</div>
					</div>


					<div class="form-group">
						<label for="employeeEmailEdit">Email</label> <input type="text"
							class="form-control" id="employeeEmailEdit"
							name="employeeEmailEdit" placeholder="">
					</div>
				</div>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-right"
					onclick="updateEmployeeDetails()" data-dismiss="">
					<i class="glyphicon glyphicon-floppy-disk"></i> Update
				</button>
				<button type="button" class="btn btn-warning pull-right"
					id="moredetails" name="moredetails" onclick="" data-dismiss="modal"
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


<!-- Modal EDIT MORE EMPLOYEE DETAILS -->
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

					<a onclick="loadEditContentqualifications()"
						class="btn btn-primary">Educaional Data</a> <a
						onclick="loadEditContentstudyprograms()" class="btn btn-primary">Study
						Programs</a> <a onclick="loadEditContentloandetails()"
						class="btn btn-primary">Loan Details</a> <a
						onclick="loadEditContentfamilydetails()" class="btn btn-primary">Family
						Details</a> <a id="btnEmployeeHistory"
						onclick="loadEditEmployementHIstoryDetails()"
						class="btn btn-primary">Employee History Details</a> <a
						id="btnMedicalHistory" onclick="loadEditMedicalHIstoryDetails()"
						class="btn btn-primary">Medical History</a>

				</div>

				<div id="Editmodelrest" name="Editmodelrest"></div>
			</div>
		</div>
	</div>
</div>
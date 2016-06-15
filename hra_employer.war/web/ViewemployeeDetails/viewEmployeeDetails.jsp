<!-- 20160521 AS HRA-32 created ViewEmployeeDetails.jsp class -->

<script src="dist/js/hra/hra.education.js"></script>
<script src="dist/js/hra/hra.loan.js"></script>
<script src="dist/js/hra/hra.medicalhistory.js"></script>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="sub-header">EMPLOYEES</h2>

	<!-- 	<div class="modal-body"> -->


	<!-- 				<div class="col-xs-12" style="text-align: center;"> -->

	<!-- 	<div class="tab-content"> -->
	<div class="tab-pane active" id="tabPageEmployee">
		<div id="Employee" class="reviewBlock" data-content="List"
			style="padding-left: 5px;">
			<div class="well" style="">
				<div class="row">

					<div class="col-xs-12 col-md-2">
						<div class="row-fluid">
							<div class="col-xs-12" style="text-align: center;">
								<img id="profile_image_2" src="./dist/demoimages/Avatar.jpg"
									class="img-polaroid img-thumbnail"
									style="max-width: 140px; max-height: 140px;">

								<button id="employeeUploadProfileImage" onclick=""
									class="btn btn-small btn-primary" type="button"
									style="margin-right: 10px;">
									<i class="fa fa-upload"></i> Upload Profile Image
								</button>

							</div>

						</div>
					</div>
					<div class="col-xs-12 col-md-10">
						<div class="row-fluid">
							<div class="col-md-12">
								<h2 id="name">Ruwan wikramanayake</h2>
							</div>
						</div>
						<div class="row-fluid">
							<div class="col-md-12"
								style="font-size: 18px; border-bottom: 1px solid #DDD; margin-bottom: 10px; padding-bottom: 10px;">
								<p>
									<i class="glyphicon glyphicon-earphone"></i> <span
										id="mobilenumber">+94779952998</span>&nbsp;&nbsp; <i
										class="glyphicon glyphicon-phone-alt"></i> <span
										id="landnumber">011245671</span>&nbsp;&nbsp; <i
										class="glyphicon glyphicon-envelope"></i> <span
										id="work_email">Ruwan@genesis.com</span>
								</p>
							</div>
						</div>

						<div class="row-fluid" style="border-top: 1px;">
							<div class="col-xs-6 col-md-4" style="font-size: 16px;">
								<label class="control-label col-xs-12"
									style="font-size: 13px; font-size: 13px;">Employee EPF
									Number</label> <label class="control-label col-xs-12 iceLabel"
									style="font-size: 13px; font-weight: bold;" id="employee_id">EMP002</label>
							</div>
							<div class="col-xs-6 col-md-4" style="font-size: 16px;">
								<label class="control-label col-xs-12" style="font-size: 13px;">NIC</label>
								<label class="control-label col-xs-12 iceLabel"
									style="font-size: 13px; font-weight: bold;" id="nic_num">459456754V</label>
							</div>

						</div>
					</div>
				</div>
			</div>

			<ul class="nav nav-tabs" id="subModTab"
				style="margin-bottom: 0px; margin-left: 5px; border-bottom: none;">
				<li onclick="loademployeeDetails()" class="active"><a
					id="tabBasic" href="#tabPageBasic" role="tab" data-toggle="tab"
					aria-controls="basic" aria-expanded="false">Basic Information</a></li>

				<li onclick="loadDataEducationalDetails()" class=""><a
					id="tabQualifications" href="#tabPageQualifications" role="tab"
					data-toggle="tab" aria-controls="qualifications"
					aria-expanded="false">Qualifications</a></li>
				<li onclick="viewStudyDetails()" class=""><a id="tabStudy"
					href="#tabPageStudy" role="tab" data-toggle="tab"
					aria-controls="study" aria-expanded="false">Study Programmes </a></li>

				<li class=""><a id="tabEmployementHistory"
					href="#tabEmployement" role="tab" data-toggle="tab"
					aria-controls="employementHistorytab" aria-expanded="false">Employement
						History</a></li>

				<li onclick="loadFamilyDetails()" class=""><a id="tabFamily"
					href="#tabfamily" role="tab" data-toggle="tab"
					aria-controls="familytab" aria-expanded="false">Family Details</a></li>

				<li onclick="loadLoanDetails()" class=""><a id="tabloan"
					href="#tabloandetails" role="tab" data-toggle="tab"
					aria-controls="loan" aria-expanded="false">Loan Details</a></li>

				<li onclick="viewMedicalDetails()" class=""><a id="tabmedical"
					href="#tabMedical" role="tab" data-toggle="tab"
					aria-controls="medicalDetailstab" aria-expanded="false">Medical
						History Details</a></li>
			</ul>

			<div class="tab-content">
				<div class="tab-pane active" id="tabPageBasic" role="tabpanel"
					class="tab-pane fade" aria-labelledby="basic-tab"
					style="border: 1px solid #DDD;">
					<div class="row" style="margin-left: 10px; margin-top: 20px;">
						<div class="panel panel-default" style="width: 97.5%;">
							<div class="panel-heading">
								<h4>Personal Information</h4>
							</div>
							<div class="panel-body">
								<div class="row-fluid">
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">National Identity card
											Number </label> <label class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="nic_num1">
											970980613V </label>
									</div>

									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Date of Birth</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="birthday">1984-02-05</label>
									</div>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Gender</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="gender">Male</label>
									</div>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Marital Status</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="marital_status">Single</label>
									</div>
								</div>

							</div>
						</div>
					</div>

					<div class="row" style="margin-left: 10px; margin-top: 20px;">
						<div class="panel panel-default" style="width: 97.5%;">
							<div class="panel-heading">
								<h4>Contact Information</h4>
							</div>
							<div class="panel-body">
								<div class="row-fluid">
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Permenant Address</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="address1">109,
											Galle RD, colombo07 sgfsdfgsdfg sgfdsfgsdf</label>
									</div>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Temporary Address</label><label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="address2">
											rtsertsertg serftawertaer gertgerg srg ergerg wrg ergergerg
											---</label>
									</div>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Private Email</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="work_email1">Ruwan@genesis.com</label>
									</div>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Mobile Number</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="mobilenumber1">+94779952998</label>
									</div>
								</div>
								<hr>
								<div class="row-fluid">
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Land Number</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="landnumber1">0112567181</label>
									</div>

								</div>
							</div>
						</div>
					</div>

					<div class="row" style="margin-left: 10px; margin-top: 20px;">
						<div class="panel panel-default" style="width: 97.5%;">
							<div class="panel-heading">
								<h4>Job Details</h4>
							</div>
							<div class="panel-body">
								<div class="row-fluid">
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Job Title</label> <label
											id="job_title" class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;">Pre-Sales
											Executive</label>
									</div>
									<div class="row-fluid">
										<div class="col-xs-6 col-md-3" style="font-size: 16px;">
											<label class="control-label col-xs-12"
												style="font-size: 13px;">Department</label> <label
												class="control-label col-xs-12 text-primary"
												style="font-size: 12px; font-weight: normal;"
												id="department_Name">Head Office</label>
										</div>
										<div class="col-xs-6 col-md-3" style="font-size: 16px;">
											<label class="control-label col-xs-12"
												style="font-size: 13px;">Employment Basis</label> <label
												id="bassis" class="control-label col-xs-12 text-primary"
												style="font-size: 12px; font-weight: normal;">Full
												Time Contract</label>
										</div>
										<div class="col-xs-6 col-md-3" style="font-size: 16px;">
											<label class="control-label col-xs-12"
												style="font-size: 13px;">Join Date</label> <label
												class="control-label col-xs-12 text-primary"
												style="font-size: 12px; font-weight: normal;" id="joindate">2016-05-01</label>
										</div>

									</div>


								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 								 tabbasic model end -->

				<div class="tab-pane fade" id="tabPageQualifications"
					role="tabpanel" aria-labelledby="qualifications-tab"
					style="border: 1px solid #DDD;">
					<div class="row" style="margin-left: 10px; margin-top: 20px;">
						<div class="panel panel-default" style="width: 97.5%;">
							<div class="panel-heading">
								<h4>Qualification Details</h4>
							</div>
							<div class="panel-body">
								<div class="row-fluid">
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Qualification </label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="qualificationName">BSc. in Information
											Technologies </label>
									</div>

									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">University | College |
											School </label> <label class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="educatedPlace">UCSC</label>
									</div>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Medium</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="mediumStudied">Eng</label>
									</div>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;"> Started On</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="startedOn">2000-02-05</label>
									</div>
									<hr>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;"> Completed On</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="compleatedOn">2004-02-05</label>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
				<!-- 						   tabPageQualifications model end  -->

				<div class="tab-pane fade" id="tabPageStudy" role="tabpanel"
					aria-labelledby="study-tab" style="border: 1px solid #DDD;">
					<div class="row" style="margin-left: 10px; margin-top: 20px;">
						<div class="panel panel-default" style="width: 97.5%;">
							<div class="panel-heading">
								<h4>Study Programmes Details</h4>
							</div>
							<div class="panel-body">
								<div class="row-fluid">
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Institution </label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="Institution">Institution </label>
									</div>

									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Type of Course</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="CourseType">Type
											of Course</label>
									</div>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Admission Date</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="AdmissionDate">Admission Date</label>
									</div>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">End Date</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="ProgramEndDate">Date</label>
									</div>
									<hr>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Duration (In months)</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="Duration">Duration</label>
									</div>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Study Time</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"> <input
											type="checkbox" value="" id="StWeekdays" disabled>
											Weekdays
										</label> <label class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"> <input
											type="checkbox" value="" id="StWeekends" disabled>
											Weekends
										</label>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
				<!-- 						   tabPageStudy details model end  -->

				<div class="tab-pane fade" id="tabEmployement" role="tabpanel"
					aria-labelledby="employementHistory"
					style="border: 1px solid #DDD;">
					<div class="row" style="margin-left: 10px; margin-top: 20px;">
						<div class="panel panel-default" style="width: 97.5%;">
							<div class="panel-heading">
								<h4>Employment History Details</h4>
							</div>
							<div class="panel-body">
								<div class="row-fluid">
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Qualification </label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="Qualification">BSc. in Information Technologies </label>
									</div>

									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">University | College |
											School </label> <label class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="university">UCSC</label>
									</div>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Medium</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="medium">English</label>
									</div>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;"> Started On</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="startedon">2000-02-05</label>
									</div>
									<hr>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;"> Completed On</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="startedon">2004-02-05</label>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>


				<!-- 	tabEmployement History model end -->

				<div class="tab-pane fade" id="tabfamily" role="tabpanel"
					aria-labelledby="family" style="border: 1px solid #DDD;">
					<div class="row" style="margin-left: 10px; margin-top: 20px;">
						<div class="panel panel-default" style="width: 97.5%;">
							<div class="panel-heading">
								<h4>Family Details</h4>
							</div>
							<div class="panel-body">
								<div class="row-fluid">
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Relation Name</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="relationName">relationName</label>
									</div>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Relationship </label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="relationship">Singel</label>
									</div>

									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Relation Date of birth </label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="relationDateofbirth">relationDateofbirth</label>
									</div>

									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;"> Occupation</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="occupation">occupation</label>
									</div>
									<hr>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;"> WorkingPlace</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="workingPlace">workingPlace</label>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>

				<!-- 				tabFamily Details End -->

				<div class="tab-pane fade" id="tabloandetails" role="tabpanel"
					aria-labelledby="loanDetailstab" style="border: 1px solid #DDD;">
					<div class="row" style="margin-left: 10px; margin-top: 20px;">
						<div class="panel panel-default" style="width: 97.5%;">
							<div class="panel-heading">
								<h4>Loan Details</h4>
							</div>
							<div class="panel-body">
								<div class="row-fluid">
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Total Outstanding amount</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="amount">amount</label>
									</div>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Guarantor 1 </label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="guarantor1">guarantor
											1</label>
									</div>

									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Guarantor 2 </label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="guarantor2">guarantor
											2</label>
									</div>

									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;"> Monthly Payment</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="payment">payment
										</label>
									</div>
									<hr>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;"> Due Date</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="dueDate">due
											date</label>
									</div>
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;"> End Date</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="endDate">end
											date</label>

									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
				<!-- 						   tabLoanDetails model end  -->


				<div class="tab-pane fade" id="tabMedical" role="tabpanel"
					aria-labelledby="medicalHistory" style="border: 1px solid #DDD;">
					<div class="row" style="margin-left: 10px; margin-top: 20px;">
						<div class="panel panel-default" style="width: 97.5%;">
							<div class="panel-heading">
								<h4>Medical History Details</h4>
							</div>
							<div class="panel-body">
								<div class="row-fluid">
									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Ailment Type </label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;" id="ailment">Ailment
										</label>
									</div>

									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;">Ailment Description </label>
										<p class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="ailmentDescription">Description</p>
									</div>


									<div class="col-xs-6 col-md-3" style="font-size: 16px;">
										<label class="control-label col-xs-12"
											style="font-size: 13px;"> Report Description</label> <label
											class="control-label col-xs-12 text-primary"
											style="font-size: 12px; font-weight: normal;"
											id="reportDescription">Report Description</label>
									</div>

									<div class="col-xs-6 col-md-3" style="font-size: 16px;">

										<label class="control-label col-xs-12"
											style="font-size: 13px;"> Medical Report</label> <a
											id="report" href="" target="_blank"> <img
											id="imagereport" alt="" src=""> <span
											class="glyphicon glyphicon-folder-open"> </span> Report
										</a>
									</div>
									<hr>
								</div>

							</div>
						</div>
					</div>
				</div>

				<!-- 	end medical history details  -->
				<!-- 				<div id="pdfView" class="modal fade" role="dialog"> -->
				<!-- 					<div class="modal-dialog"> -->

				<!-- 						Modal content -->
				<!-- 						<div class="modal-content"> -->
				<!-- 							<div class="modal-header"> -->
				<!-- 								<button type="button" class="close" data-dismiss="modal">&times;</button> -->
				<!-- 								<h4 class="modal-title">Modal Header</h4> -->
				<!-- 							</div> -->
				<!-- 							<div class="modal-body"> -->
				<!-- 								<p>Some text in the modal.</p> -->
				<!-- 							</div> -->
				<!-- 							<div class="modal-footer"> -->
				<!-- 								<button type="button" class="btn btn-default" -->
				<!-- 									data-dismiss="modal">Close</button> -->
				<!-- 							</div> -->
				<!-- 						</div> -->

				<!-- 					</div> -->
				<!-- 				</div> -->
				<!-- 			end image and pdf load modal  -->

			</div>
		</div>
	</div>
	<!-- 	</div> -->
</div>
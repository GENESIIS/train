<!-- 20160407 PN HRA-2 created manageEmployee.jsp class -->
<!-- 20160412 PN HRA-2 edited the design. -->
<!-- 20160419 PN HRA-2 edited the design. -->
<!-- 20160419 PN HRA-2 edited the design. -->

<!-- JavaScripts to help to load  -->

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="sub-header">Employee Management</h2>

	<div class="dropdown">
		<button class="btn btn-primary dropdown-toggle" type="button"
			data-toggle="dropdown">
			<i class="glyphicon glyphicon-user"></i> Create Employee <span
				class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#" onclick="loadContentbasicdata()">Basic Data</a></li>
			<li class="divider"></li>
			<li><a href="#" onclick="loadContentqualifications()">Educational
					Qualifications</a></li>
			<li class="divider"></li>
			<li><a href="#" onclick="loadContentstudyprograms()">Study
					Programs</a></li>
			<li class="divider"></li>
			<li><a href="#" onclick="loadContentstudyprograms()">Employment
					History</a></li>
			<li class="divider"></li>
			<li><a href="#" onclick="loadContentlanguages()">Language
					Proficiency</a></li>
			<li class="divider"></li>
			<li><a href="#" onclick="loadContentloandetails()">Loan
					Details</a></li>
			<li class="divider"></li>
			<li><a href="#" onclick="loadContentfamilydetails()">Family
					Details</a></li>
			<li class="divider"></li>
			<li><a href="#" onclick="loadContentemergencycontacts()">Emergency
					Contacts</a></li>
			<li class="divider"></li>
			<li><a href="#" onclick="loadContentmoreDetails()">More
					Details</a></li>
		</ul>
	</div>
	<br />
	<div class="well" id="employeeContent"></div>
</div>


<!-- 20160407 PN HRA-2 created manageEmployee.jsp class -->
<!-- 20160412 PN HRA-2 edited the design. -->
<!-- 20160419 PN HRA-2 edited the design. -->
<!-- 20160419 PN HRA-2 edited the design. -->
<!-- 20160505 PN HRA-2 edited the design. -->
<!-- 20160530 PC HRA-30 edited the design. -->
<!-- JavaScripts to help to load  -->


<!-- Importing hra.helper.js file -->
<script src="dist/js/jasny-bootstrap-js/jasny-bootstrap.js"></script>
<script src="dist/js/jasny-bootstrap-js/jasny-bootstrap.min.js"></script>
<script src="dist/js/jasny-bootstrap-js/jquery.form.js"></script>

<!-- Styles for this template -->
<link href="dist/css/jasny-bootstrap-css/jasny-bootstrap.css"
	rel="stylesheet">
<link href="dist/css/jasny-bootstrap-css/jasny-bootstrap.css.map"
	rel="stylesheet">
<link href="dist/css/jasny-bootstrap-css/jasny-bootstrap.min.css"
	rel="stylesheet">



<style>
.lable-space {
	margin-right: 5px;
}
</style>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="sub-header">Medical Scheme Management</h2>


	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#addEmployeedetails" onclick="disableButton()">
		<i class="glyphicon glyphicon-plus"></i> New Employee
	</button>
	<br></br>

	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#addMedicalBillForm" onclick="disableButton()">
		<i class="glyphicon glyphicon-plus"></i> Upload Medical Bill
	</button>
	<br></br>


	<!-- add medical bill modal-->
	<div class="modal fade" id="addMedicalBillForm" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title">
						<i class="glyphicon glyphicon-user"></i>Upload Medical Bills
					</h3>
				</div>
				<div class="modal-body">


					<div class="well">

						<div class="row">
							<div class="col-md-6">

								<div class="form-group">
									<label for="employeeId">Employee ID</label> <input type="text"
										class="form-control" id="employeeId" name="employeeId"
										placeholder="" maxlength="10" value="2" readonly>
								</div>
								<div class="form-group">
									<label for="billDescription">Bill Description</label> <input
										type="text" class="form-control" id="billDescription"
										name="billDescription" placeholder="Bill Description"
										maxlength="100">
								</div>

							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label" for="billUpload"
										style="vertical-align: top;">Bill Upload</label>

									<div class="fileinput fileinput-new" data-provides="fileinput">

										<div class="fileinput-new thumbnail"
											style="width: 200px; height: 150px;">
											<img data-src="holder.js/100%x100%"
												src="dist/demoimages/images.jpg">
										</div>

										<div class="fileinput-preview fileinput-exists thumbnail"
											style="max-width: 200px; max-height: 150px;"></div>

										<div>
											<span class="btn btn-default btn-file"> <span
												class="fileinput-new">Select image</span> <span
												class="fileinput-exists">Change</span> <input type="file"
												id="avatar" name="file">
											</span> <a href="#" class="btn btn-default fileinput-exists"
												data-dismiss="fileinput">Remove</a>

										</div>


									</div>

								</div>
							</div>
						</div>

					</div>

				</div>


				<div class="modal-footer">

					<input type="hidden" class="form-control" id="ehReferencecrtby"
						name="ehReferencecrtby" value="ADMIN_USER_TR">

					<!-- FILE UPLOAD -->
					<!-- 	<button type="button"
						class="btn btn-success full pull-right btn-space"
						onclick="addMedicalbill();" >
						<i class="glyphicon glyphicon-floppy-disk"></i> Upload Report
					</button>
					-->
					<button type="button" class="btn btn-success pull-right"
						onclick="" id="billUpload">
						<i class="glyphicon glyphicon-floppy-disk"></i> Upload
					</button>

					<!-- CLEAR -->
					<button type="button" class="btn btn-warning pull-left"
						onclick="clearMedicalHisory()" id="reset">
						<i class="glyphicon glyphicon-refresh"></i> Clear
					</button>

					<!-- CANCEL -->
					<button type="button" id="buttonCancelemployee"
						class="btn btn-danger pull-left" data-dismiss="modal"
						onclick="clearMedicalHisory()">
						<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
					</button>


				</div>
			</div>
		</div>
	</div>



</div>







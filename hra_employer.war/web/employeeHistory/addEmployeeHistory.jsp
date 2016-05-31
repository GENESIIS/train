<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.genesiis.hra.validation.BasisEnum"%>




<!--Add Employee History Modal -->
<div>
	<div>
		<!-- Modal content-->
		<div class="modal-body">

			<div>
				<label><h3 class="modal-title">
						<i class="glyphicon glyphicon-check"></i>Employment History
					</h3></label>
			</div>

			<div class="well">

				<div class="row">

					<div class="col-md-6">
						<div class="form-group">
							<label for="employeeId">Employee ID</label> <input type="text"
								class="form-control" id="employeeId" name="employeeId"
								placeholder="" maxlength="10" value="2">
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label for="employer">Employer Name</label> <input type="text"
								class="form-control" id="employer" name="employer"
								placeholder="" maxlength="100">
						</div>
					</div>

				</div>

				<div class="row">

					<div class="col-md-6">
						<div class="form-group">
							<label for="designation">Designation</label> <input type="text"
								class="form-control" id="designation" name="designation"
								placeholder="" maxlength="20">
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<div class="form-group">
								<label for="basis">Employment Basis
									(Contract/Intern/Permanent)</label> <select class="form-control"
									id="basis" name="basis">
									<option value="">--Select--</option>
									<c:forEach items="<%=BasisEnum.values()%>" var="entry">
										<option>${entry.key}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>

				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="startedOn">Started On</label> <input type="date"
								class="form-control" id="startedOn" name="startedOn"
								placeholder="">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="compleatedOn">Completed On</label> <input type="date"
								class="form-control" id="compleatedOn" name="compleatedOn"
								placeholder="">
						</div>
					</div>
				</div>
				
				
				<div class="row">

					<div class="col-md-6">

						<div class="form-group">
							<label for="ehEmail">E-mail Address</label> <input type="text"
								class="form-control" id="ehEmail" name="ehEmail" placeholder=""
								maxlength="100">
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label for="ehComments">Comments</label> <input type="text"
								class="form-control" id="ehComments" name="ehComments"
								placeholder="" maxlength="200">
						</div>
					</div>

				</div>
				
				
				

			</div>

			<div class="well">

				<!-- refreee 1-->

				<div class="row">

					<div class="col-md-6">
						<div class="form-group">
							<label for="ehReferenceonename">Reference Name</label> <input
								type="text" class="form-control" id="ehReferenceonename"
								name="ehReferenceonename" placeholder="" maxlength="300">
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label for="ehReferenceonecomments">Reference Comments</label>
							<textarea type="text" class="form-control"
								id="ehReferenceonecomments" name="ehReferenceonecomments"
								placeholder="" maxlength="300"></textarea>
						</div>
					</div>

				</div>




				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="ehReferenceonephone">Reference Phone</label> <input
								type="text" class="form-control" id="ehReferenceonephone"
								name="ehReferenceonephone" placeholder=""
								onkeypress="return isNumber(event)" maxlength="30">
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label for="ehReferenceonemobile">Reference Mobile</label> <input
								type="text" class="form-control" id="ehReferenceonemobile"
								name="ehReferenceonemobile" placeholder=""
								onkeypress="return isNumber(event)" maxlength="30"></input>
						</div>
					</div>
				</div>

				<div class="row">

					<div class="col-md-6">

						<div class="form-group">
							<label for="ehReferenceoneaddress">Reference Address</label> <input
								type="text" class="form-control" id="ehReferenceoneaddress"
								name="ehReferenceoneaddress" placeholder="" maxlength="500">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="ehReferenceonedesignation">Reference
								Designation</label> <input type="text" class="form-control"
								id="ehReferenceonedesignation" name="ehReferenceonedesignation"
								placeholder="" maxlength="100"></input>
						</div>
					</div>
				</div>
			</div>
			<div class="well">
				<!-- refreee 2-->
				<div class="row">

					<div class="col-md-6">
						<div class="form-group">
							<label for="ehReferencetwoname">Reference Name</label> <input
								type="text" class="form-control" id="ehReferencetwoname"
								name="ehReferencetwoname" placeholder="" maxlength="300">
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label for="ehReferencetwocomments">Reference Comments</label>
							<textarea type="text" class="form-control"
								id="ehReferencetwocomments" name="ehReferencetwocomments"
								placeholder="" maxlength="300"></textarea>
						</div>
					</div>

				</div>




				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="ehReferencetwophone">Reference Phone</label> <input
								type="text" class="form-control" id="ehReferencetwophone"
								name="ehReferencetwophone" placeholder=""
								onkeypress="return isNumber(event)" maxlength="30">
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label for="ehReferencetwomobile">Reference Mobile</label> <input
								type="text" class="form-control" id="ehReferencetwomobile"
								name="ehReferencetwomobile" placeholder=""
								onkeypress="return isNumber(event)" maxlength="30"></input>
						</div>
					</div>
				</div>

				<div class="row">

					<div class="col-md-6">

						<div class="form-group">
							<label for="ehReferencetwoaddress">Reference Address</label> <input
								type="text" class="form-control" id="ehReferencetwoaddress"
								name="ehReferencetwoaddress" placeholder="" maxlength="500">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="ehReferencetwodesignation">Reference
								Designation</label> <input type="text" class="form-control"
								id="ehReferencetwodesignation" name="ehReferencetwodesignation"
								placeholder="" maxlength="100"></input>
						</div>
					</div>

				</div>

				
			</div>

			<div class="modal-footer">
				<input type="hidden" class="form-control" id="ehReferencemodby"
					name="ehReferencemodby">
					
					
				<button type="button" class="btn btn-success full pull-right"
					onclick="addEmployeeHistoryDetails();">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save
				</button>


				<button type="button" class="btn btn-warning pull-left"
					onclick="clearEmployeeHistoryDetails()">
					<i class="glyphicon glyphicon-refresh"></i> Clear
				</button>
				
				
				<button type="button" id="buttonCancelemployee"
					class="btn btn-danger pull-left" data-dismiss="modal"
					onclick="clearEmployeeHistoryDetails()">
					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
				</button>


				<button type="button" class="btn btn-success full pull-right"
					id=btn3>
					<i class="glyphicon glyphicon-floppy-disk"></i> Test
				</button>


			</div>



		</div>

	</div>

</div>

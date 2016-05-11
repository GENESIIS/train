<!--Edit Family Modal -->

<div class="">
	<div class="">
		<h3 class="">
			<i class="glyphicon glyphicon-edit"></i> Family Details
		</h3>
		<div class="form-group">
			<label for="editfmemployeeId">Employee</label>&nbsp;&nbsp;<span
				style="color: red; font-weight: normal !important;"
				id="editfmemployeeidError" name="editfmemployeeidError"></span> <input
				type="text" class="form-control" id="editfmemployeeId"
				name="editfmemployeeId" placeholder="">
		</div>
		<div class="form-group">
			<label for="editrelationship">Relationship</label>&nbsp;&nbsp;<span
				id="editrelationshipError" name="editrelationshipError"
				style="color: red; font-weight: normal !important;"></span> <select
				class="form-control" id="editrelationship" name="editrelationship">
				<option value="" selected="selected">--Select--</option>
				<option value="Father">Father</option>
				<option value="Mother">Mother</option>
				<option value="Sister">Sister</option>
				<option value="Brother">Brother</option>
				<option value="Husband">Husband</option>
				<option value="Wife">Wife</option>
				<option value="Son">Son</option>
				<option value="Daughter">Daughter</option>
			</select>
		</div>
		<div class="form-group">
			<label for="editrelationName">Name</label>&nbsp;&nbsp;<span
				id="editrelationnameError" name="editrelationnameError"
				style="color: red; font-weight: normal !important;"></span> <input
				type="text" class="form-control" id="editrelationName"
				name="editrelationName" placeholder=""
				onkeypress="return isLetter(event);">
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label for="editrelationDateofbirth">Date of Birth</label>&nbsp;&nbsp;<span
						id="editrelationbirthdateError" name="editrelationbirthdateError"
						style="color: red; font-weight: normal !important;"></span> <input
						type="date" class="form-control" id="editrelationDateofbirth"
						name="editrelationDateofbirth" placeholder="">
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="editoccupation">Occupation</label>&nbsp;&nbsp;<span
				id="occupationError" name="editoccupationError"
				style="color: red; font-weight: normal !important;"></span><input
				type="text" class="form-control" id="editoccupation"
				name="editoccupation" placeholder=""
				onkeypress="return isLetter(event);">
		</div>

		<div class="form-group">
			<label for="editworkingPlace">Working Place/School</label>&nbsp;&nbsp;<span
				id="editworkingplaceError" name="editworkingplaceError"
				style="color: red; font-weight: normal !important;"></span> <input
				type="text" class="form-control" id="editworkingPlace"
				name="editworkingPlace" placeholder=""
				onkeypress="return isLetter(event);">
		</div>

		<div class="modal-footer">
			<button type="button" class="btn btn-success pull-right"
				onclick="editFamilyDetails()">
				<i class="glyphicon glyphicon-floppy-disk"></i> Update
			</button>
			<button type="button" class="btn btn-warning pull-left"
				onclick="editclearFamilydetails()">
				<i class="glyphicon glyphicon-refresh"></i> Clear
			</button>
			<button type="button" class="btn btn-danger pull-left"
				data-dismiss="modal">
				<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
			</button>
		</div>

	</div>
</div>
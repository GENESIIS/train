<!--Add Family Modal -->

<div class=""> 
	<div class="">
		<h3 class="">
			<i class="glyphicon glyphicon-edit"></i> Family Details
		</h3>
		<div class="form-group">
			<label for="fmemployeeId">Employee</label>&nbsp;&nbsp;<span
				style="color: red; font-weight: normal !important;"
				id="fmemployeeidError" name="fmemployeeidError"></span> <input
				type="text" class="form-control" id="fmemployeeId" value="2" readonly
				name="fmemployeeId" placeholder="">
		</div>
		<div class="form-group">
			<label for="relationship">Relationship</label>&nbsp;&nbsp;<span
				id="relationshipError" name="relationshipError"
				style="color: red; font-weight: normal !important;"></span> <select
				class="form-control" id="relationship" name="relationship"
				onchange="resetLabels()">
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
			<label for="relationName">Name</label>&nbsp;&nbsp;<span
				id="relationnameError" name="relationnameError"
				style="color: red; font-weight: normal !important;"></span> <input
				type="text" class="form-control" id="relationName"
				name="relationName" placeholder=""
				onkeypress="return isLetter(event);" onblur="resetLabels()">
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label for="relationDateofbirth">Date of Birth</label>&nbsp;&nbsp;<span
						id="relationbirthdateError" name="relationbirthdateError"
						style="color: red; font-weight: normal !important;"></span> <input
						type="date" class="form-control" id="relationDateofbirth"
						name="relationDateofbirth" placeholder="" onblur="resetLabels()">
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="occupation">Occupation</label>&nbsp;&nbsp;<span
				id="occupationError" name="occupationError"
				style="color: red; font-weight: normal !important;"></span><input
				type="text" class="form-control" id="occupation" name="occupation"
				placeholder="" onkeypress="return isLetter(event);"
				onblur="resetLabels()">
		</div>

		<div class="form-group">
			<label for="workingPlace">Working Place/School</label>&nbsp;&nbsp;<span
				id="workingplaceError" name="workingplaceError"
				style="color: red; font-weight: normal !important;"></span> <input
				type="text" class="form-control" id="workingPlace"
				name="workingPlace" placeholder=""
				onkeypress="return isLetter(event);" onblur="resetLabels()">
		</div>

		<div class="modal-footer">
			<button type="button" class="btn btn-success pull-right"
				onclick="addFamilyDetails()">
				<i class="glyphicon glyphicon-floppy-disk"></i> Save
			</button>
			<button type="button" class="btn btn-warning pull-left"
				onclick="clearFamilydetails()">
				<i class="glyphicon glyphicon-refresh"></i> Clear
			</button>
			<button type="button" class="btn btn-danger pull-left"
				data-dismiss="modal">
				<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
			</button>
		</div>

	</div>
</div>
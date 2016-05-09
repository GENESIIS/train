<!--Add Family Modal -->

<h3 class="">
	<i class="glyphicon glyphicon-edit"></i> Family Details
</h3>
<div class="form-group">
	<label for="fmemployeeId">Employee</label> <input type="text"
		class="form-control" id="fmemployeeId" name="fmemployeeId"
		placeholder="">
</div>
<div class="form-group">
	<label for="relationship">Relationship</label> <select
		class="form-control" id="relationship" name="relationship">
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
	<label for="relationName">Name</label> <input type="text"
		class="form-control" id="relationName" name="relationName"
		placeholder="">
</div>
<div class="row">
	<div class="col-md-6">
		<div class="form-group">
			<label for="relationDateofbirth">Date of Birth</label> <input
				type="date" class="form-control" id="relationDateofbirth"
				name="relationDateofbirth" placeholder="">
		</div>
	</div>
</div>

<div class="form-group">
	<label for="occupation">Occupation</label> <input type="text"
		class="form-control" id="occupation" name="occupation" placeholder="">
</div>

<div class="form-group">
	<label for="workingPlace">Working Place/School</label> <input
		type="text" class="form-control" id="workingPlace"
		name="occupationPlace" placeholder="">
</div>

<div class="">
	<button type="button" class="btn btn-success pull-right"
		onclick="updatedAlert()" data-dismiss="modal">
		<i class="glyphicon glyphicon-floppy-disk"></i> Save
	</button>
	<button type="button" class="btn btn-danger pull-left"
		data-dismiss="modal">
		<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
	</button>
</div>



<script type="text/javascript">
	//To load the Datatable
	$(document).ready(function() {
		$('#employeeDetails').DataTable();
		loadeditEducationalDetails();
	});
</script>
<div class="">
	<div class="">
		<h3 class="">
			<i class="glyphicon glyphicon-edit"></i> Educational & Professional
			Qualifications
		</h3>
		<div class="form-group">
			<label for="employeeId">Employee</label> <input type="text"
				class="form-control" id="employeeId" name="employeeId"
				placeholder="" onkeypress="return isNumberKey(event)">
		</div>
		<div class="form-group">
			<label for="qualificationName">Qualification</label> <input
				type="text" class="form-control" id="qualificationName"
				name="qualificationName" placeholder=""
				onkeypress="return isLetter(event)">
		</div>
		<div class="form-group">
			<label for="educatedPlace">University/College/School</label> <input
				type="text" class="form-control" id="educatedPlace"
				name="educatedPlace" placeholder=""
				onkeypress="return isLetter(event)">
		</div>
		<div class="form-group">
			<label for="mediumStudied">Medium</label> <input type="text"
				class="form-control" id="mediumStudied" name="mediumStudied"
				placeholder="" onkeypress="return isLetter(event)">
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
			<div class="col-md-6">
				<div class="form-group">
					<label for="studyTime">Study Time</label><br> <label
						for="weekdays"><input type="checkbox" class="form-control"
						id="weekdays" name="weekdays" placeholder="">Weekdays </label> <label
						for=weekends> <input type="checkbox" class="form-control"
						id="weekends" name="weekends" placeholder="">Weekends
					</label>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-success pull-left"
				onclick="EditEducationDetails()" data-dismiss="modal">
				<i class="glyphicon glyphicon-floppy-disk"></i> Save
			</button>
			<button type="button" class="btn btn-danger pull-right"
				data-dismiss="modal">
				<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
			</button>
		</div>
	</div>
</div>
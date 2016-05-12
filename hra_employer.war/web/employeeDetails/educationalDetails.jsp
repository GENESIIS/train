<!--Add Educational Modal -->
<div class="">
	<div class="well">
		<h3 class="">
			<i class="glyphicon glyphicon-edit"></i> Educational & Professional
			Qualifications
		</h3>
		<div class="form-group">
			<label for="employeeId">Employee</label> <input type="text"
				class="form-control" id="employeeId" name="employeeId"
				placeholder="">
		</div>

		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label for="qualificationName">Qualification</label> <input
						type="text" class="form-control" id="qualificationName"
						name="qualificationName" placeholder=""
						onkeypress="return isLetter(event)">
				</div>
			</div>
			<!-- <div class="col-md-6">
				<div class="form-group">
					<label for="completed"><input type="checkbox"
						class="form-control" id="completed" name="completed"
						placeholder="">Completed</label>
				</div>
			</div> -->
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
						placeholder="" onselect="">
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label for="compleatedOn">Completed On</label> <input type="date"
						class="form-control" id="compleatedOn" name="compleatedOn"
						placeholder="">
				</div>
			</div>
			<div class="col-md-6" >
				<div class="form-group">
					<label for="studyTime">Study Time</label><br> <label for="weekdays"><input
						type="checkbox" class="form-control" id="weekdays" name="weekdays"
						placeholder="">Weekdays </label> <label for=weekends> <input
						type="checkbox" class="form-control" id="weekends" name="weekends"
						placeholder="">Weekends
					</label>
				</div>
			</div>
		</div>

	</div>
<!-- 	<div class="well">
		<h3 class="">
			<i class="glyphicon glyphicon-edit"></i> Study Program Details
		</h3>


		<div class="form-group">
			<label for="institution">Institution</label> <input type="text"
				class="form-control" id="institution" name="institution"
				placeholder="" onkeypress="return isLetter(event)">
		</div>
		<div class="form-group">
			<label for="courseType">Type of Course</label> <input type="text"
				class="form-control" id="courseType" name="courseType"
				placeholder="" onkeypress="return isLetter(event)">
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label for="admissionDate">Admission Date</label> <input
						type="date" class="form-control" id="admissionDate"
						name="admissionDate" placeholder="">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label for="duration">Duration (In months)</label> <input
						type="text" class="form-control" id="duration" name="duration"
						placeholder="" onkeypress="return isNumberKey(event)">
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label for="studyTime">Study Time</label> <label for="weekdays"><input
						type="checkbox" class="form-control" id="weekdays" name="weekdays"
						placeholder="">Weekdays </label> <label for=weekends> <input
						type="checkbox" class="form-control" id="weekends" name="weekends"
						placeholder="">Weekends
					</label>
				</div>
			</div>

		</div>

		
	</div> -->
	<div class="modal-footer">
			<button type="button" class="btn btn-danger pull-left"
				data-dismiss="modal">
				<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
			</button>
			<button type="button" class="btn btn-success pull-right"
				onclick="AddEducationDetails()" >
				<i class="glyphicon glyphicon-floppy-disk"></i> Save
			</button>

		</div>
</div>
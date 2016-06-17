<!--Add Study program Modal -->
<div class="">
	<div class="well">
		<h3 class="">
			<i class="glyphicon glyphicon-edit"></i> Study Program Details
		</h3>

		<div class="form-group">
			<label for="employeeId">Employee</label> <input type="text"
				class="form-control" id="employeEpf" name="employeeId"
				placeholder="" maxlength="16" >
		</div>
		<div class="form-group">
			<label for="institution">Institution</label> <input type="text"
				class="form-control" id="institution" name="institution"
				placeholder="" maxlength="200">
		</div>
		<div class="form-group">
			<label for="courseType">Type of Course</label> <input type="text"
				class="form-control" id="courseType" name="courseType"
				placeholder="" maxlength="50">
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label for="admissionDate">Admission Date</label> <input
						type= "date" class="form-control" id="admissionDate"
						name="admissionDate" placeholder="">
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label for="admissionDate">End Date</label> <input
						type= "date" class="form-control" id="ProgramEndDate"
						name="ProgramEndDate" placeholder="">
				</div>
			</div>
		</div>
		<div class="row">
		  <div class="col-md-6">
		      <div class="form-group">
			      <label for="duration">Duration (In months)</label> <input type="number"
				   class="form-control" id="duration" name="duration" placeholder="" maxlength="16">
		     </div>
		 </div>
		 <div class="col-md-6" >
				<div class="form-group">
					<label for="studyTime">Study Time</label><br> <label for="stWeekdays"><input
						type="checkbox" class="form-control" id="stWeekdays" name="stWeekdays"
						placeholder="">Weekdays </label> <label for=stWeekends> <input
						type="checkbox" class="form-control" id="stWeekends" name="stWeekends"
						placeholder="">Weekends
					</label>
				</div>
			</div>
		</div>

		<div class="modal-footer">
			<button type="button" class="btn btn-success pull-right"
				onclick="addStudyProgram()" data-dismiss="modal">
				<i class="glyphicon glyphicon-floppy-disk"></i> Save
			</button>
			<button type="button" class="btn btn-danger pull-left"
				data-dismiss="modal">
				<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
			</button>
		</div>
	</div>
</div>
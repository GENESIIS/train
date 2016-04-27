<!--Add Study program Modal -->
<div class="">
	<div class="">
		<h3 class="">
			<i class="glyphicon glyphicon-edit"></i> Study Program Details
		</h3>

		<div class="form-group">
			<label for="employeeId">Employee</label> <input type="text"
				class="form-control" id="employeeId" name="employeeId"
				placeholder="">
		</div>
		<div class="form-group">
			<label for="institution">Institution</label> <input type="text"
				class="form-control" id="institution" name="institution"
				placeholder="">
		</div>
		<div class="form-group">
			<label for="courseType">Type of Course</label> <input type="text"
				class="form-control" id="courseType" name="courseType"
				placeholder="">
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label for="admissionDate">Admission Date</label> <input
						type="text" class="form-control" id="admissionDate"
						name="admissionDate" placeholder="">
				</div>
			</div>
		</div>
						<div class="row">
							<div class="col-md-6">
		<div class="form-group">
			<label for="duration">Duration (In months)</label> <input type="text"
				class="form-control" id="duration" name="duration" placeholder="">
		</div>
							</div>
							<div class="col-md-6">
		<div class="form-group">
			<label for="studyTime">Study Time</label> <input type="date"
				class="form-control" id="studyTime" name="studyTime" placeholder="">
		</div>
							</div>
						</div>

		<div class="modal-footer">
			<button type="button" class="btn btn-success pull-left"
				onclick="updatedAlert()" data-dismiss="modal">
				<i class="glyphicon glyphicon-floppy-disk"></i> Save
			</button>
			<button type="button" class="btn btn-danger pull-right"
				data-dismiss="modal">
				<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
			</button>
		</div>
	</div>
</div>
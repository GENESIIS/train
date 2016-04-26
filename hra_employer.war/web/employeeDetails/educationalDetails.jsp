<!--Add Educational Modal -->

<br/>
<!-- Modal content-->
<br></br>
<div class="">
	<div class="">
		<h3 class="">
			<i class="glyphicon glyphicon-edit"></i> Educational & Professional
			Qualifications
		</h3>
		<div class="form-group">
			<label for="employeeId">Employee</label> <input type="text"
				class="form-control" id="employeeId" name="employeeId"
				placeholder="">
		</div>
		<div class="form-group">
			<label for="qualificationName">Qualification</label> <input
				type="text" class="form-control" id="qualificationName"
				name="qualificationName" placeholder="">
		</div>
		<div class="form-group">
			<label for="educatedPlace">University/College/School</label> <input
				type="text" class="form-control" id="educatedPlace"
				name="educatedPlace" placeholder="">
		</div>
		<div class="form-group">
			<label for="mediumStudied">Medium</label> <input type="text"
				class="form-control" id="mediumStudied" name="mediumStudied"
				placeholder="">
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
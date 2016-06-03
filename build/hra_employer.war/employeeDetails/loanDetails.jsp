<!--Add loan Modal -->
<div class="">
	<div class="">
		<h3 class="">
			<i class="glyphicon glyphicon-edit"></i> Loan Details
		</h3>
		<div class="form-group">
			<label for="employeeId">Employee</label> <input type="text"
				class="form-control" id="employeeId" name="employeeId"
				placeholder="">
		</div>
		<div class="form-group">
			<label for="totalOutstanding">Total Outstanding Amount</label> <input
				type="number" class="form-control" id="totalOutstanding"
				name="totalOutstanding" placeholder="">
		</div>
		<div class="form-group">
			<label for="borrowers">Guarantor1</label> <input type="text"
				class="form-control" id="guarantor1" name="guarantor1" placeholder="">
			<label for="borrowers">Guarantor2</label> <input type="text"
				class="form-control" id="guarantor2" name="guarantor2" placeholder="">
		</div>
		
		<div class="form-group">
			<label for="monthlyPayment">Monthly Payment</label> <input
				type="number" class="form-control" id="monthlyPayment"
				name="monthlyPayment" placeholder="">
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label for="dueDate">Due Date</label> <input type="date"
						class="form-control" id="dueDate" name="dueDate" placeholder="">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label for="dueDate">End Date</label> <input type="date"
						class="form-control" id="endDate" name="dueDate" placeholder="">
				</div>
			</div>
		</div>
				<div class="modal-footer">
			<button type="button" class="btn btn-success pull-right"
				onclick="addLoanDetailes()" data-dismiss="modal">
				<i class="glyphicon glyphicon-floppy-disk"></i> Save
			</button>
			<button type="button" class="btn btn-danger pull-left"
				data-dismiss="modal">
				<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
			</button>
		</div>
	</div>

</div>
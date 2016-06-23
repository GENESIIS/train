<!--Add loan Modal -->
<div class="" id ="loan">
	<div class="">
		<h3 class="">
			<i class="glyphicon glyphicon-edit"></i> Loan Details
		</h3>
		<div class="form-group">
			<label for="employeeEPFEdit">Employee</label> <input type="text" 
				class="form-control" id="employeeEPFEdit" name="employeeEPFEdit"
				placeholder="" readonly>
		</div>
		<div class="form-group">
			<label for="totalOutstanding">Total Outstanding Amount</label> <input
				type="number" class="form-control" id="totalOutstandingEdit"
				name="totalOutstanding" placeholder="">
		</div>
		<div class="form-group">
			<label for="borrowers">Guarantor1</label> <input type="text"
				class="form-control" id="guaranter1Edit" name="Gauranter1Edit" placeholder="">
				<label for="borrowers">Guarantor2</label>
				<input type="text"
				class="form-control" id="guaranter2Edit" name="Guaranter2Edit" placeholder="">
		</div>
		<div class="form-group">
			<label for="monthlyPayment">Monthly Payment</label> <input
				type="number" class="form-control" id="monthlyPaymentEdit"
				name="monthlyPayment" placeholder="">
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label for="dueDate">Payment Due Date</label> <input type="date"
						class="form-control" id="dueDateEdit" name="dueDate" placeholder="">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label for="dueDate">End Date</label> <input type="date"
						class="form-control" id="endDateEdit" name="endDateEdit" placeholder="">
				</div>
			</div>
		</div>
				<div class="modal-footer">
			<button type="button" class="btn btn-success pull-left"
				onclick="updateLoanDetailes()" data-dismiss="modal">
				<i class="glyphicon glyphicon-floppy-disk"></i> Update
			</button>
			<button type="button" class="btn btn-danger pull-right"
				data-dismiss="modal">
				<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
			</button>
		</div>
	</div>

</div>
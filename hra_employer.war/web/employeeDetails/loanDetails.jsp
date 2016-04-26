<script type="text/javascript">
	//To load the Datatable
	$(document).ready(function() {
		$('#loanDetails').DataTable();
	});
</script>

<div>
	<label><h2>Loan Details</h2> </label>

	<button type="button" class="btn btn-primary pull-side"
		data-toggle="modal" data-target="#addLoandetails">
		<i class="glyphicon glyphicon-plus"></i> Add New
	</button>
</div>

<br></br>
<div class="table-responsive">
	<table id="loanDetails"
		class="table table-striped table-bordered table-responsive"
		cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Employee</th>
				<th>Total Outstanding Amount</th>
				<th>Borrowers</th>
				<th>Monthly Payment</th>
				<th>Due Date</th>
				<th>View</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>Employee</th>
				<th>Total Outstanding Amount</th>
				<th>Borrowers</th>
				<th>Monthly Payment</th>
				<th>Due Date</th>
				<th>View</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</tfoot>
		<tbody>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td align="center"><button type="button" class="btn btn-info"
						data-toggle="modal" data-target="#viewEmployeeDetailsForm">
						<i class="glyphicon glyphicon-modal-window"></i>
					</button></td>
				<td align="center"><button type="button"
						class="btn btn-warning" data-toggle="modal"
						data-target="#editLoandetails">
						<i class="glyphicon glyphicon-edit"></i>
					</button></td>
				<td align="center"><button type="button" class="btn btn-danger"
						data-toggle="modal" data-target="#deleteEmployeeDetailsForm">
						<i class="glyphicon glyphicon-trash"></i>
					</button></td>
			</tr>
		</tbody>
	</table>
</div>

<!--Add loan Modal -->
<div class="modal fade" id="addLoandetails" name="addLoandetails"
	role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-edit"></i> Loan Details
				</h3>
				<h4 class="modal-title"></h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label for="employeeId">Employee</label> <input type="text"
						class="form-control" id="employeeId" name="employeeId"
						placeholder="">
				</div>
				<div class="form-group">
					<label for="totalOutstanding">Total Outstanding Amount</label> <input
						type="text" class="form-control" id="totalOutstanding"
						name="totalOutstanding" placeholder="">
				</div>
				<div class="form-group">
					<label for="borrowers">Borrowers</label> <input type="text"
						class="form-control" id="borrowers" name="borrowers"
						placeholder="">
				</div>
				<div class="form-group">
					<label for="monthlyPayment">Monthly Payment</label> <input
						type="text" class="form-control" id="monthlyPayment"
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
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-side"
					onclick="updatedAlert()" data-dismiss="modal">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save
				</button>
				<button type="button" class="btn btn-danger pull-left"
					data-dismiss="modal">
					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
				</button>
			</div>
		</div>

	</div>
</div>

<!--edit loan Modal -->
<div class="modal fade" id="editLoandetails" name="editLoandetails"
	role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-edit"></i> Loan Details
				</h3>
				<h4 class="modal-title"></h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label for="editemployeeId">Employee</label> <input type="text"
						class="form-control" id="editemployeeId" name="editemployeeId"
						placeholder="">
				</div>
				<div class="form-group">
					<label for="edittotalOutstanding">Total Outstanding Amount</label>
					<input type="text" class="form-control" id="edittotalOutstanding"
						name="edittotalOutstanding" placeholder="">
				</div>
				<div class="form-group">
					<label for="editborrowers">Borrowers</label> <input type="text"
						class="form-control" id="editborrowers" name="editborrowers"
						placeholder="">
				</div>
				<div class="form-group">
					<label for="editmonthlyPayment">Monthly Payment</label> <input
						type="text" class="form-control" id="editmonthlyPayment"
						name="editmonthlyPayment" placeholder="">
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="editdueDate">Due Date</label> <input type="date"
								class="form-control" id="editdueDate" name="editdueDate"
								placeholder="">
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-side"
					onclick="updatedAlert()" data-dismiss="modal">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save
				</button>
				<button type="button" class="btn btn-danger pull-left"
					data-dismiss="modal">
					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
				</button>
			</div>
		</div>

	</div>
</div>

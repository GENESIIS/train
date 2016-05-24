<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="sub-header">Salary Component</h2>
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#addSalarycomponent">
		<i class="glyphicon glyphicon-plus"></i> New Component
	</button>
	<br></br>
	<div class="table-responsive">
		<table id="salarycomponents"
			class="table table-striped table-bordered table-responsive"
			cellspacing="0" width="100%">
			<thead>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td align="center"><button id="vbutton" type="button"
							class="btn btn-info" data-toggle="modal"
							data-target="#viewEmployeeDetailsForm">
							<i class="glyphicon glyphicon-modal-window"></i>
						</button></td>
					<td align="center"><button id="ebutton" type="button"
							class="btn btn-warning" data-toggle="modal"
							data-target="#editEmployeeDetailsForm">
							<i class="glyphicon glyphicon-edit"></i>
						</button></td>
					<td align="center"><button type="button"
							class="btn btn-danger" data-toggle="modal"
							data-target="#deleteEmployeeDetailsForm">
							<i class="glyphicon glyphicon-trash"></i>
						</button></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="addSalarycomponent" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-user"></i> Add Salary Component
				</h3>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label for="salaryComponenttype">Type</label><select
								class="form-control" id="salaryComponenttype"
								name="salaryComponenttype"
								onchange="setEmptyerrormessage('#salaryComponenttype','salaryComponenttypeerror','Type')">
								<option value="">--Select--</option>
								<option value="Basic">Basic</option>
								<option value="Allowance">Allowance</option>
								<option value="Bonus">Bonus</option>
								<option value="Deduction">Deduction</option>
								<option value="Other">Other</option>
							</select>&nbsp;&nbsp;<span id="salaryComponenttypeerror"
								name="salaryComponenttypeerror"
								style="color: red; font-weight: normal !important;"></span>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="salaryComponenttitle">Title</label>&nbsp;&nbsp;<span
						id="salaryComponenttitleerror" name="salaryComponenttitleerror"
						style="color: red; font-weight: normal !important;"></span><input
						type="text" class="form-control" id="salaryComponenttitle"
						name="salaryComponenttitle" placeholder=""
						onkeypress="return isLetter(event);"
						onblur="setEmptyerrormessage('#salaryComponenttitle','salaryComponenttitleerror','Title')">
				</div>

				<div class="form-group">
					<label for="salaryComponentdescription">Description</label>
					<textarea type="text" class="form-control"
						id="salaryComponentdescription" name="salaryComponentdescription"
						placeholder="" onkeypress="return isLetter(event);"></textarea>
				</div>

				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label for="salaryCurrency">Currency</label><select
								class="form-control" id="salaryCurrency"
								name="salaryCurrency"
								onchange="setEmptyerrormessage('#salaryCurrency','salaryCurrencyerror','Type')">
						
							</select>&nbsp;&nbsp;<span id="salaryCurrencyerror"
								name="salaryCurrencyerror"
								style="color: red; font-weight: normal !important;"></span>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="radio-inline"><input type="radio"
						name="salaryComponentamount" id="salaryComponentamount"
						value="Rate"><b>Rate</b></label> <label class="radio-inline"><input
						type="radio" name="salaryComponentamount"
						id="salaryComponentamount" value="Amount"><b>Amount</b></label> <label
						class="radio-inline">&nbsp;&nbsp;<span
						id="salaryComponentamounterror" name="salaryComponentamounterror"
						style="color: red; font-weight: normal !important;"></span></label>
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="salaryComponentmin">Minimum Value</label>&nbsp;&nbsp;<span
								id="salaryComponentminerror" name="salaryComponentminerror"
								style="color: red; font-weight: normal !important;"></span> <input
								type="text" class="form-control" id="salaryComponentmin"
								name="salaryComponentmin" placeholder=""
								onblur="setEmptyerrormessage('#salaryComponentmin','salaryComponentminerror','Minimum Value')">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="salaryComponentmax">Maximum Value</label>&nbsp;&nbsp;<span
								id="salaryComponentmaxerror" name="salaryComponentmaxerror"
								style="color: red; font-weight: normal !important;"></span> <input
								type="text" class="form-control" id="salaryComponentmax"
								name="salaryComponentmax" placeholder=""
								onblur="setLargevalueerror('salaryComponentmin','salaryComponentmax','salaryComponentmaxerror');">
						</div>
					</div>
				</div>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-right"
					onclick="addSalarycomponent()" data-dismiss="">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save
				</button>
				<button type="button" class="btn btn-warning pull-left" onclick="">
					<i class="glyphicon glyphicon-refresh"></i> Clear
				</button>
				<button type="button" class="btn btn-danger pull-left"
					data-dismiss="modal" onclick="">
					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
				</button>
			</div>
		</div>
	</div>
</div>
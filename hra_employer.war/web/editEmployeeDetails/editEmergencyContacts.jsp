<div>
	<label><h2>Emergency Contact Details</h2> </label>

	<button type="button" class="btn btn-primary pull-side"
		data-toggle="modal" data-target="#addEmployeeDetailsForm">
		<i class="glyphicon glyphicon-plus"></i> Add New
	</button>
</div> 

<br></br>
<div class="table-responsive">
	<table id="employeeDetails"
		class="table table-striped table-bordered table-responsive"
		cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Employee Number</th>
				<th>Employee Name</th>
				<th>Designation</th>
				<th>Contact Details</th>
				<th>View</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>Employee Number</th>
				<th>Employee Name</th>
				<th>Designation</th>
				<th>Contact Details</th>
				<th>View</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</tfoot>
		<tbody>
			<tr>
				<td>EMP001</td>
				<td>Dammika Nawarathna</td>
				<td>AGM - HR</td>
				<td>0711111111<br> 0112222222<br> dammika@gmail.com
				</td>
				<td align="center"><button type="button" class="btn btn-info"
						data-toggle="modal" data-target="#viewEmployeeDetailsForm">
						<i class="glyphicon glyphicon-modal-window"></i>
					</button></td>
				<td align="center"><button type="button"
						class="btn btn-warning" data-toggle="modal"
						data-target="#editEmployeeDetailsForm">
						<i class="glyphicon glyphicon-edit"></i>
					</button></td>
				<td align="center"><button type="button" class="btn btn-danger"
						data-toggle="modal" data-target="#deleteEmployeeDetailsForm">
						<i class="glyphicon glyphicon-trash"></i>
					</button></td>
			</tr>
			<tr>
				<td>EMP002</td>
				<td>Chamara Withanachchi</td>
				<td>DGM - IT</td>
				<td>0712222222<br> 0113333333<br> chamaraw@gmail.com
				</td>
				<td align="center"><button type="button" class="btn btn-info"
						data-toggle="modal" data-target="#viewEmployeeDetailsForm">
						<i class="glyphicon glyphicon-modal-window"></i>
					</button></td>
				<td align="center"><button type="button"
						class="btn btn-warning" data-toggle="modal"
						data-target="#editEmployeeDetailsForm">
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

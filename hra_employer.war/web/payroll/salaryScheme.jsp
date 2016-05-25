<script type="text/javascript">
	loadModel();
</script>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="sub-header">Salary Scheme</h2>
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#addSalaryscheme">
		<i class="glyphicon glyphicon-plus"></i> New Salary Scheme
	</button>
	<br></br>
	<!-- 	<div class="table-responsive"> -->
	<!-- 		<table id="salarycomponents" -->
	<!-- 			class="table table-striped table-bordered table-responsive" -->
	<!-- 			cellspacing="0" width="100%"> -->
	<!-- 			<thead> -->
	<!-- 				<tr> -->
	<!-- 					<th></th> -->
	<!-- 					<th></th> -->
	<!-- 					<th></th> -->
	<!-- 					<th></th> -->
	<!-- 					<th></th> -->
	<!-- 					<th></th> -->
	<!-- 				</tr> -->
	<!-- 			</thead> -->
	<!-- 			<tfoot> -->
	<!-- 				<tr> -->
	<!-- 					<th></th> -->
	<!-- 					<th></th> -->
	<!-- 					<th></th> -->
	<!-- 					<th></th> -->
	<!-- 					<th></th> -->
	<!-- 					<th></th> -->
	<!-- 				</tr> -->
	<!-- 			</tfoot> -->
	<!-- 			<tbody> -->
	<!-- 				<tr> -->
	<!-- 					<td></td> -->
	<!-- 					<td></td> -->
	<!-- 					<td></td> -->
	<!-- 					<td align="center"><button id="vbutton" type="button" -->
	<!-- 							class="btn btn-info" data-toggle="modal" -->
	<!-- 							data-target="#viewEmployeeDetailsForm"> -->
	<!-- 							<i class="glyphicon glyphicon-modal-window"></i> -->
	<!-- 						</button></td> -->
	<!-- 					<td align="center"><button id="ebutton" type="button" -->
	<!-- 							class="btn btn-warning" data-toggle="modal" -->
	<!-- 							data-target="#editEmployeeDetailsForm"> -->
	<!-- 							<i class="glyphicon glyphicon-edit"></i> -->
	<!-- 						</button></td> -->
	<!-- 					<td align="center"><button type="button" -->
	<!-- 							class="btn btn-danger" data-toggle="modal" -->
	<!-- 							data-target="#deleteEmployeeDetailsForm"> -->
	<!-- 							<i class="glyphicon glyphicon-trash"></i> -->
	<!-- 						</button></td> -->
	<!-- 				</tr> -->
	<!-- 			</tbody> -->
	<!-- 		</table> -->
	<!-- 	</div> -->

</div>

<script type="text/javascript">
	load();
	function addRow() {
		var table = document.getElementById("salarySchemetbl");
		var salaryComponenttype = document
				.getElementById("salaryComponenttype");
		var salaryComponenttitle = document
				.getElementById("salaryComponenttitle");
		var salaryComponentdescription = document
				.getElementById("salaryComponentdescription");
		var salaryComponentamount = document
				.getElementById("salaryComponentamount");
		var salaryComponentmin = document.getElementById("salaryComponentmin");
		var salaryComponentmax = document.getElementById("salaryComponentmax");

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		row.insertCell(0).innerHTML = salaryComponenttype.value;
		row.insertCell(1).innerHTML = salaryComponenttitle.value;
		row.insertCell(2).innerHTML = salaryComponentdescription.value;
		row.insertCell(3).innerHTML = salaryComponentamount.value;
		row.insertCell(4).innerHTML = salaryComponentmin.value;
		row.insertCell(5).innerHTML = salaryComponentmax.value;
		row.insertCell(6).innerHTML = '<button type="button" class="btn btn-danger" onClick="Javacsript:deleteRow(this)"><i class="glyphicon glyphicon-trash"></i></button>';
	}

	function deleteRow(obj) {
		var index = obj.parentNode.parentNode.rowIndex;
		var table = document.getElementById("salarySchemetbl");
		table.deleteRow(index);
	}

	function addTable() {
		var myTableDiv = document.getElementById("myDynamicTable");

		var table = document.createElement('TABLE');
		table.border = '1';

		var tableBody = document.createElement('TBODY');
		table.appendChild(tableBody);

		for (var i = 0; i < 3; i++) {
			var tr = document.createElement('TR');
			tableBody.appendChild(tr);

			for (var j = 0; j < 4; j++) {
				var td = document.createElement('TD');
				td.width = '75';
				td.appendChild(document.createTextNode("Cell " + i + "," + j));
				tr.appendChild(td);
			}
		}
		myTableDiv.appendChild(table);
	}

	function load() {
		console.log("Page load finished");
	}
</script>



<!-- Modal Scheme -->
<div class="modal fade" id="addSalaryscheme" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-list-alt"></i> Add Salary Scheme
				</h3>
			</div>
			<div class="modal-body">
				<div class="row">
					<span id="salarySchemetitleerror" name="salarySchemetitleerror"
						style="color: red; font-weight: normal !important;"></span>
					<div class="col-md-4">
						<div class="form-group">
							<label for="salarySchemetitle">Title</label><input type="text"
								class="form-control" id="salarySchemetitle"
								name="salarySchemetitle" placeholder=""
								onkeypress="return isLetter(event);"
								onblur="setEmptyerrormessage('#salarySchemetitle','salarySchemetitleerror','Title')">
						</div>
					</div>
				</div>



				<div class="row">
					<span id="salaryCriteriaerror" name="salaryCriteriaerror"
						style="color: red; font-weight: normal !important;"></span>
					<div class="col-md-4">
						<div class="form-group">
							<label for="salaryCriteria">Criteria</label><select
								class="form-control" id="salaryCriteria" name="salaryCriteria"
								onchange="setEmptyerrormessage('#salaryCriteria','salaryCriteriaerror','Criteria')">
								<option value="">--Select--</option>
								<option value="Basic">Grade</option>
								<option value="Allowance">Working Experience</option>
								<option value="Bonus">Qualification</option>
								<option value="Other">Other</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="salarySchemedescription">Description</label>
					<textarea type="text" class="form-control"
						id="salarySchemedescription" name="salarySchemedescription"
						placeholder="" onkeypress="return isLetter(event);"></textarea>
				</div>

				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label for="salaryComponent">Add Component</label>
							<div class="inner-addon right-addon">
								<i class="glyphicon glyphicon-search"></i> <input type="text"
									class="form-control" id="salaryComponent"
									name="salaryComponent" placeholder="" onkeypress="loadModel();">
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div id="componentLinknew" name="componentLinknew">
							<p>
								<a href="" data-toggle="modal" data-target="#addSalarycomponent"><i
									class="glyphicon glyphicon-plus"></i> New Component</a>
							</p>
						</div>
						<div id="componentLinkadd" name="componentLinkadd">
							<p>
								<a href=""><i class="glyphicon glyphicon-ok"></i> Add to
									Scheme</a>
							</p>
						</div>
					</div>
				</div>


				<div>
					<div class="table-responsive">
						<table id="salarySchemetbl"
							class="table table-striped table-bordered table-responsive"
							cellspacing="0" width="100%">
							<tr>
								<td><b>Type</b></td>
								<td><b>Description</b></td>
								<td><b>Description</b></td>
								<td><b>Rate/Amount</b></td>
								<td><b>Min. Value</b></td>
								<td><b>Max. Value</b></td>
								<td>&nbsp;</td>
							</tr>
						</table>
						&nbsp;<br />
					</div>
				</div>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-right" onclick=""
					data-dismiss="modal">
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



<!-- Modal Component -->
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
							<label for="salaryComponenttype">Type</label> &nbsp;&nbsp;<span
								id="salaryComponenttypeerror" name="salaryComponenttypeerror"
								style="color: red; font-weight: normal !important;"></span> <select
								class="form-control" id="salaryComponenttype"
								name="salaryComponenttype"
								onchange="setEmptyerrormessage('#salaryComponenttype','salaryComponenttypeerror','Type')">
								<option value="">--Select--</option>
								<option value="Basic">Basic</option>
								<option value="Allowance">Allowance</option>
								<option value="Bonus">Bonus</option>
								<option value="Deduction">Deduction</option>
								<option value="Other">Other</option>
							</select>
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

				<div class="form-group">
					<label class="radio-inline"><input type="radio"
						name="salaryComponentamount" id="salaryComponentamount"><b>Rate</b></label>
					<label class="radio-inline"><input type="radio"
						name="salaryComponentamount" id="salaryComponentamount"><b>Amount</b></label>
					<label class="radio-inline">&nbsp;&nbsp;<span
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
								name="salaryComponentmin" placeholder="">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="salaryComponentmax">Maximum Value</label>&nbsp;&nbsp;<span
								id="salaryComponentmaxerror" name="salaryComponentmaxerror"
								style="color: red; font-weight: normal !important;"></span> <input
								type="text" class="form-control" id="salaryComponentmax"
								name="salaryComponentmax" placeholder="">
						</div>
					</div>
				</div>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-right"
					onclick="Javascript:addRow()" data-dismiss="modal">
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


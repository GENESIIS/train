<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery Editable Select Plugin Examples</title>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="dist/editablesearch/source/jquery.editable-select.min.css"
	rel="stylesheet" />
<link href="dist/editablesearch/source/jquerysctipttop.css"
	rel="stylesheet" type="text/css">
</head>
<body>

	<div class="container" style="margin-top: 150px;">
		<h2>jQuery Editable Select Plugin Examples</h2>
		<hr />

		<div class="row-fluid">
			<div class="span6">
				<h3>Basic example</h3>
				<div class="row-fluid">
					<div class="span4">Into this</div>
					<div class="span7">
						<select id="basic">
							<option>Alfa Romeo</option>
							<option>Audi</option>
							<option>BMW</option>
							<option>Citroen</option>
							<option>Fiat</option>
							<option>Ford</option>
							<option>Jaguar</option>
							<option>Jeep</option>
							<option>Lancia</option>
							<option>Land Rover</option>
							<option>Mercedes</option>
							<option>Mini</option>
							<option>Nissan</option>
							<option>Opel</option>
							<option>Peugeot</option>
							<option>Porsche</option>
							<option>Renault</option>
							<option selected="selected">Smart</option>
							<option>Volkswagen</option>
							<option>Volvo</option>
						</select>
					</div>
				</div>
			</div>
		</div>


		<script src="dist/editablesearch/source/jquery-latest.min.js"></script>
		<script src="dist/editablesearch/source/jquery.editable-select.js"></script>
		<script>
			$.ajaxPrefilter(function(options, originalOptions, jqXHR) {
				options.async = true;
			});
			window.onload = function() {
				$('#basic').editableSelect();
			}
		</script>
	</div>
</body>
</html>


<!-- 
Model here
 -->


<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="dist/editablesearch/source/jquery.editable-select.min.css"
	rel="stylesheet" />
<link href="dist/editablesearch/source/jquerysctipttop.css"
	rel="stylesheet" type="text/css">


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



	<div class="container" style="margin-top: 150px;">
		<h2>jQuery Editable Select Plugin Examples</h2>
		<hr />

		<div class="row-fluid">
			<div class="span6">
				<h3>Basic example</h3>
				<div class="row-fluid">
					<div class="span4">Into this</div>
					<div class="span7">
						<select id="basic">
							<option>Alfa Romeo</option>
							<option>Audi</option>
							<option>BMW</option>
							<option>Citroen</option>
							<option>Fiat</option>
							<option>Ford</option>
							<option>Jaguar</option>
							<option>Jeep</option>
							<option>Lancia</option>
							<option>Land Rover</option>
							<option>Mercedes</option>
							<option>Mini</option>
							<option>Nissan</option>
							<option>Opel</option>
							<option>Peugeot</option>
							<option>Porsche</option>
							<option>Renault</option>
							<option selected="selected">Smart</option>
							<option>Volkswagen</option>
							<option>Volvo</option>
						</select>
					</div>
				</div>
			</div>
		</div>

		<script src="dist/editablesearch/source/jquery-latest.min.js"></script>
		<script src="dist/editablesearch/source/jquery.editable-select.js"></script>
		<script>
			window.onload = function() {
				$('#basic').editableSelect();
			}
		</script>
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
				<button type="button" class="btn btn-success pull-right" onclick=""
					data-dismiss="">
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





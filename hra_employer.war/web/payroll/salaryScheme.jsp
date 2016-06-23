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
							<label for="salarySchemetitle">Scheme Title</label><input
								type="text" class="form-control" id="salarySchemetitle"
								name="salarySchemetitle" placeholder=""
								onkeypress="return isLetter(event);"
								onblur="setEmptyerrormessage('#salarySchemetitle','salarySchemetitleerror','Title')"
								maxlength="499" size="499">
						</div>
					</div>
				</div>



				<div class="row">
					<span id="salaryCriteriaerror" name="salaryCriteriaerror"
						style="color: red; font-weight: normal !important;"></span>
					<div class="col-md-4">
						<div class="form-group">
							<label for="salaryCriteria">Scheme Criteria</label><select
								class="form-control" id="salaryCriteria" name="salaryCriteria"
								onchange="setEmptyerrormessage('#salaryCriteria','salaryCriteriaerror','Criteria')">
								<option value="" selected="selected">--Select--</option>
								<option value="Grade">Grade</option>
								<option value="Working Experience">Working Experience</option>
								<option value="Qualification">Qualification</option>
								<option value="Other">Other</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="salarySchemedescription">Scheme Description</label>
					<textarea type="text" class="form-control"
						id="salarySchemedescription" name="salarySchemedescription"
						placeholder="" onkeypress="return isLetter(event);"
						maxlength="499" size="499"></textarea>
				</div>

				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label for="salaryComponent">Add Component</label>
							<div class="inner-addon right-addon">
								<!-- <i class="glyphicon glyphicon-search"></i> <input type="text"
									class="form-control" id="salaryComponent"
									name="salaryComponent" placeholder="" onkeypress="loadModel();"> -->
									
									<select class="selectpicker" data-style="btn-info" id="selectsalaryComponenttype" onchange="selectComponent()">
									 <option value="0" selected="selected" >Component</option>
									 <option value="Basic">Basic</option>
									 <option value="Allowance">Allowance</option>
									 <option value="Bonus">Bonus</option>
									 <option value="Deduction">Deduction</option>
									 <option value="Other">Other</option>
									</select>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div id="componentLink" name="componentLink"></div>

					</div>
				</div>


				<div>
					<div class="table-responsive">
						<table id="salarySchemetbl"
							class="table table-striped table-bordered table-responsive"
							cellspacing="0" width="100%">
							<tr>
								<td><b>Type</b></td>
								<td><b>Title</b></td>
								<td><b>Currency</b></td>
								<td><b>Description</b></td>
								<td><b>Rate/Amount</b></td>
								<td><b>Min.Value</b></td>
								<td><b>Max.Value</b></td>
								<td>&nbsp;</td>
							</tr>
						</table>
						<table id="salaryComTbl"
							class="table table-striped table-bordered table-responsive"
							cellspacing="0" width="100%">
							<thead>
							<tr>
								<td><b>Type</b></td>
								<td><b>Title</b></td>
								<td><b>Currency</b></td>
								<td><b>Description</b></td>
								<td><b>Rate/Amount</b></td>
								<td><b>Min.Value</b></td>
								<td><b>Max.Value</b></td>
								<td><b>&nbsp;</b></td>
							</tr>
							</thead>
						</table>
						&nbsp;<br />
					</div>
				</div>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-right"
					onclick="addSalaryscheme()" data-dismiss="">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save
				</button>
				<button type="button" class="btn btn-warning pull-left"
					onclick="clearSalaryscheme()">
					<i class="glyphicon glyphicon-refresh"></i> Clear
				</button>
				<button type="button" class="btn btn-danger pull-left"
					data-dismiss="modal" onclick="clearSalaryscheme()">
					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
				</button>
			</div>
		</div>
	</div>
</div>



<!-- Modal -->
<div class="modal fade" id="addSalarycomponent" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<i class="glyphicon glyphicon-usd"></i> Add Salary Component
				</h3>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label for="salaryComponenttype">Salary Type</label><select
								class="form-control" id="salaryComponenttype"
								name="salaryComponenttype"
								onchange="setEmptyerrormessage('#salaryComponenttype','salaryComponenttypeerror','Type')">
								<option value="" selected="selected">--Select--</option>
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
					<label for="salaryComponenttitle">Salary Title</label>&nbsp;&nbsp;<span
						id="salaryComponenttitleerror" name="salaryComponenttitleerror"
						style="color: red; font-weight: normal !important;"></span><input
						type="text" class="form-control" id="salaryComponenttitle"
						name="salaryComponenttitle" placeholder=""
						onkeypress="return isLetter(event);"
						onblur="setEmptyerrormessage('#salaryComponenttitle','salaryComponenttitleerror','Title')"
						maxlength="499" size="499">
				</div>

				<div class="form-group">
					<label for="salaryComponentdescription">Salary Description</label>
					<textarea type="text" class="form-control"
						id="salaryComponentdescription" name="salaryComponentdescription"
						placeholder="" onkeypress="return isLetter(event);"
						maxlength="499" size="499"></textarea>
				</div>

				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label for="salaryCurrency">Salary Currency</label><select
								class="form-control" id="salaryCurrency" name="salaryCurrency"
								onchange="setEmptyerrormessage('#salaryCurrency','salaryCurrencyerror','Currency')">
								<option value="" selected="selected">--Select--</option>
								<option value="USD">USD</option>
								<option value="LKR">LKR</option>
							</select>&nbsp;&nbsp;<span id="salaryCurrencyerror"
								name="salaryCurrencyerror"
								style="color: red; font-weight: normal !important;"></span>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label>Payment Type</label><br /> <label class="radio-inline">
						<input type="radio" name="salaryComponentamount"
						id="salaryComponentamount" value="Rate"><b>Rate</b>
					</label> <label class="radio-inline"><input type="radio"
						name="salaryComponentamount" id="salaryComponentamount"
						value="Amount"><b>Amount</b></label> <label class="radio-inline">&nbsp;&nbsp;<span
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
								onblur="setEmptyerrormessage('#salaryComponentmin','salaryComponentminerror','Minimum Value')"
								onkeyup="setLargevalueerror('#salaryComponentmin','#salaryComponentmax','salaryComponentmaxerror');"
								onkeypress="return isNumberKey(event);" maxlength="9" size="9">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="salaryComponentmax">Maximum Value</label>&nbsp;&nbsp;<span
								id="salaryComponentmaxerror" name="salaryComponentmaxerror"
								style="color: red; font-weight: normal !important;"></span> <input
								type="text" class="form-control" id="salaryComponentmax"
								name="salaryComponentmax" placeholder=""
								onkeyup="setLargevalueerror('#salaryComponentmin','#salaryComponentmax','salaryComponentmaxerror');"
								onkeypress="return isNumberKey(event);" maxlength="9" size="9">
						</div>
					</div>
				</div>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-success pull-right"
					onclick="addSalarycomponent(2)" data-dismiss="">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save
				</button>
				<button type="button" class="btn btn-warning pull-left"
					onclick="clearComponent()">
					<i class="glyphicon glyphicon-refresh"></i> Clear
				</button>
				<button type="button" class="btn btn-danger pull-left"
					data-dismiss="modal" onclick="clearComponent()">
					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
				</button>
			</div>
		</div>
	</div>
</div>
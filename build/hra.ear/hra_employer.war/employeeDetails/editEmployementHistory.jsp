<script type="text/javascript">

	//To load the Datatable
	$(document).ready(function() {

		
		
		$('#editEmployeeDetailsTable').DataTable();

		$("#btn4").click(function() {

			$("#employeeId").val("001");
			$("#employer").val("employer name");
			$("#designation").val("designation");
			$("#ehComments").val("ehComments");
			$("#ehEmail").val("ehEmail@gmail.com");
			
			$("#ehReferenceonename").val("Referenceonename 1");
			$("#ehReferenceonecomments").val("Referenceonecomments1");
			$("#ehReferenceonephone").val("Referenceonephone 1");
			$("#ehReferenceonemobile").val("Referenceonemobile1");
			$("#ehReferenceoneaddress").val("Referenceoneaddress1");
			$("#ehReferenceonedesignation").val("Referenceonedesignation1");

			$("#ehReferencetwoname").val("Referenceonename2");
			$("#ehReferencetwocomments").val("Referencetwocomments2");
			$("#ehReferencetwophone").val("Referencetwophone2");
			$("#ehReferencetwomobile").val("referenceTwocomments 22222");
			$("#ehReferencetwoaddress").val("referenceTwo 22222");
			$("#ehReferencetwodesignation").val("referenceTwocomments 22222");

			$("#ehReferencemodby").val("ADMIN_USER_TR");
			$("#ehEmpid").val("7");
		});

		
	});
	

	function isNumber(evt) {
	    evt = (evt) ? evt : window.event;
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	        return false;
	    }
	    return true;
	}
	
</script>


<!--Edit Employee History Modal -->	
<div>
	<div>
		<!-- Modal content-->
		<div class="modal-body">

			<div>
				<label><h3 class="modal-title">
						<i class="glyphicon glyphicon-check"></i>Edit Employment History
					</h3></label>
			</div>

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<label for="employeeId">Employee ID</label> 
						<input type="text" class="form-control" id="employeeId" name="employeeId" placeholder="" maxlength="10">
					</div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
						<label for="employer">Employer Name</label> 
						<input type="text" class="form-control" id="employer" name="employer" placeholder="" maxlength="100">
					</div>
				</div>
			
			</div>

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<label for="designation">Designation</label> 
						<input type="text"	class="form-control" id="designation" name="designation" placeholder="" maxlength="20">
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<div class="form-group">
								<label for="basis">Employment Basis (Contract/Intern/Permanent)</label> <select
									class="form-control" id="basis" name="basis">
									<option value="">--Select--</option>
									<option value="Permanent">Permanent</option>
									<option value="Contract">Contract</option>
									<option value="Trainee">Trainee</option>
								</select>
							</div>
					</div>
				</div>

			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="startedOn">Started On</label> 
						<input type="date" class="form-control" id="startedOn" name="startedOn" placeholder="">
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="compleatedOn">Completed On</label> 
						<input type="date" class="form-control" id="compleatedOn" name="compleatedOn" placeholder="">
					</div>
				</div>
			</div>
			<!-- refreee 1-->

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferenceonename">Reference Name</label> 
						<input
							type="text" class="form-control" id="ehReferenceonename" name="ehReferenceonename" placeholder="" maxlength="300">
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferenceonecomments">Reference Comments</label>
						<textarea type="text" class="form-control" 	id="ehReferenceonecomments" name="ehReferenceonecomments" placeholder="" maxlength="300"></textarea>
					</div>
				</div>

			</div>




			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferenceonephone">Reference Phone</label>
						<input type="text" class="form-control" id="ehReferenceonephone" name="ehReferenceonephone" placeholder="" onkeypress="return isNumber(event)" maxlength="30">
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferenceonemobile">Reference Mobile</label>
						<input type="text" class="form-control"  id="ehReferenceonemobile" name="ehReferenceonemobile" placeholder="" onkeypress="return isNumber(event)" maxlength="30"></input>
					</div>
				</div>
			</div>

			<div class="row">

				<div class="col-md-6">

					<div class="form-group">
						<label for="ehReferenceoneaddress">Reference Address</label>
						<input type="text" class="form-control" id="ehReferenceoneaddress" name="ehReferenceoneaddress" placeholder="" maxlength="500">
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferenceonedesignation">Reference Designation</label>
						<input type="text" class="form-control" id="ehReferenceonedesignation" name="ehReferenceonedesignation" placeholder="" maxlength="100"></input>
					</div>
				</div>
			</div>


				<!-- refreee 2-->

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferencetwoname">Reference Name</label> 
						<input type="text" class="form-control" id="ehReferencetwoname" name="ehReferencetwoname" placeholder="" maxlength="300">
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferencetwocomments">Reference Comments</label>
						<textarea type="text" class="form-control" 	id="ehReferencetwocomments" name="ehReferencetwocomments" placeholder="" maxlength="300"></textarea>
					</div>
				</div>

			</div>
			
			
			

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferencetwophone">Reference Phone</label>
						<input type="text" class="form-control" id="ehReferencetwophone" name="ehReferencetwophone" placeholder="" onkeypress="return isNumber(event)" maxlength="30">
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferencetwomobile">Reference Mobile</label>
						<input type="text" class="form-control" 	id="ehReferencetwomobile" name="ehReferencetwomobile" placeholder="" onkeypress="return isNumber(event)" maxlength="30"></input>
					</div>
				</div>
			</div>

			<div class="row">

				<div class="col-md-6">

					<div class="form-group">
						<label for="ehReferencetwoaddress">Reference Address</label>
						<input type="text" class="form-control" id="ehReferencetwoaddress" name="ehReferencetwoaddress" placeholder="" maxlength="500">
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="ehReferencetwodesignation">Reference Designation</label>
						<input type="text" class="form-control" id="ehReferencetwodesignation" name="ehReferencetwodesignation" placeholder="" maxlength="100"></input>
					</div>
				</div>
				
			</div>

			<div class="row">

				<div class="col-md-6">

					<div class="form-group">
						<label for="ehEmail">E-mail Address</label> <input type="text" class="form-control" id="ehEmail" name="ehEmail" placeholder="" maxlength="100">
					</div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
						<label for="ehComments">Comments</label> <input type="text" class="form-control" id="ehComments" name="ehComments" placeholder="" maxlength="200">
					</div>
				</div>

			</div>


			<div class="modal-footer">
				<input type="hidden" class="form-control" id="ehReferencemodby" name="ehReferencemodby" value="ADMIN_USER_TR" >
				<input type="hidden" class="form-control" id="ehEmpid" name="ehEmpid" value="7">
				<button type="button" class="btn btn-success full pull-right"
					onclick="editEmployeeHistoryDetails();">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save
				</button>

				<button type="button" class="btn btn-warning pull-left"
					onclick="clearEmployeeHistoryDetails()">
					<i class="glyphicon glyphicon-refresh"></i> Clear
				</button>
				<button type="button" id="buttonCancelemployee"
					class="btn btn-danger pull-left" data-dismiss="modal" onclick="clearEmployeeHistoryDetails()">
					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
				</button>
				
				<button type="button" class="btn btn-success full pull-right" id=btn4>
					<i class="glyphicon glyphicon-floppy-disk"></i> Test
				</button>

				
			</div>

		</div>

	</div>

</div>

<br></br>
	<div class="table-responsive">
		<table id="editEmployeeDetailsTable" class="table table-striped table-bordered table-responsive"
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
					<td>1</td>
					<td>Dammika Nawarathna</td>
					<td>AGM - HR</td>
					<td>0711111111<br> 0112222222<br> dammika@gmail.com
					</td>
					<td align="center"><button type="button" class="btn btn-info" data-toggle="modal" data-target="#viewEmployeeDetailsForm"><i class="glyphicon glyphicon-modal-window"></i></button></td>
					<td align="center"><button type="button" class="btn btn-warning" data-toggle="modal" data-target="#editEmployeedetails1" onclick="editEmployeeHistoryDetails()" > <i class="glyphicon glyphicon-edit" ></i></button></td>
					<td align="center"><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteEmployeeDetailsForm"> <i class="glyphicon glyphicon-trash"></i> </button></td>
				</tr>
				<tr>
					<td>2</td>
					<td>Dammika Nawarathna</td>
					<td>AGM - HR</td>
					<td>0711111111<br> 0112222222<br> dammika@gmail.com
					</td>
					<td align="center"><button type="button" class="btn btn-info" data-toggle="modal" data-target="#viewEmployeeDetailsForm"><i class="glyphicon glyphicon-modal-window"></i></button></td>
					<td align="center"><button type="button" class="btn btn-warning" data-toggle="modal" data-target="#editEmployeedetails" onclick="" > <i class="glyphicon glyphicon-edit" ></i></button></td>
					<td align="center"><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteEmployeeDetailsForm"> <i class="glyphicon glyphicon-trash"></i> </button></td>
				</tr>
			</tbody>
		</table>
	</div>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<<script type="text/javascript">
<!--

//-->.
// $("tr.table").click(function() {
//     var tableData = $(this).children("td").map(function() {
//         return $(this).text();
//     }).get();

//     alert($.trim(tableData[0]) + " , " + $.trim(tableData[1]));
//     //Here, Make a Ajax call to your Servlet payCheckInfo 
// });


$("#table tr").click(function(){
	   $(this).addClass('selected').siblings().removeClass('selected');    
	   var value=$(this).find('td:first').html();
	   alert(value);    
	});
</script>
<table>
           <tr class="table">
                <td class="table">
                     ID1
                </td>
                <td>
                    Month1
                </td>
            </tr>
            <tr class="table">
                <td class="table">
                     ID2
                </td>
                <td>
                    Month2
                </td>
            </tr>
</table>

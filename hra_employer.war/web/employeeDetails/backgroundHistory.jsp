<script type="text/javascript">

	function isNumber(evt) {
	    evt = (evt) ? evt : window.event;
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	        return false;
	    }
	    return true;
	}
	
</script>


<script>
$(document).on('ready', function() {
    $("#input-6").fileinput({
        showUpload: false,
        maxFileCount: 10,
        mainClass: "input-group-lg"
    });
});
</script>




<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.genesiis.hra.validation.AilmentEnum"%>

<!--Edit Employee History Modal -->	
<div>
	<div>
		<!-- Modal content-->
		<div class="modal-body">

			<div>
				<label><h3 class="modal-title">
						<i class="glyphicon glyphicon-check"></i>Add Medical History
					</h3></label>
			</div>

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<label for="employeeId">Employee ID</label> 
						<input type="text" class="form-control" id="employeeId" name="employeeId" placeholder="" maxlength="10" value="2" readonly >
					</div>
				</div>
				
			
			</div>

			<div class="row">

				<div class="col-md-6">
					<div class="form-group">
						<div class="form-group">
								<label for="employeeAilment">Ailment</label> 
								<select class="form-control" id="employeeAilment" name="employeeAilment" >
									<option value="">--Select--</option>
									<c:forEach items="<%=AilmentEnum.values()%>" var="entry">
									    <option>${entry.key}</option>
									</c:forEach>
								</select>
							</div>
					</div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
						<label for="ailmentDescription">Description</label> 
						<input type="text"	class="form-control" id="ailmentDescription" name="ailmentDescription" placeholder="" maxlength="100" >
					</div>
				</div>

			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="reportDescription">Report Description</label> 
						<input type="text" class="form-control" id="reportDescription" name="reportDescription" placeholder="Report Description" >
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label" for="reportUpload">Report Upload</label>
						<input id="input-6" name="input6[]" type="file" multiple class="file-loading" placeholder="Select Files">					
					</div>
				</div>
			</div>
			


			<div class="modal-footer">
				<input type="hidden" class="form-control" id="ehReferencemodby" name="ehReferencemodby" value="ADMIN_USER_TR" >
				<!-- SAVE -->
				<button type="button" class="btn btn-success full pull-right" onclick="addMedicalHistoryDetails();">
					<i class="glyphicon glyphicon-floppy-disk"></i> Save 
				</button>
				<!-- CLEAR -->
				<button type="button" class="btn btn-warning pull-left"
					onclick="clearEmployeeHistoryDetails()">
					<i class="glyphicon glyphicon-refresh"></i> Clear
				</button>
				<!-- CANCEL -->
				<button type="button" id="buttonCancelemployee"
					class="btn btn-danger pull-left" data-dismiss="modal" onclick="clearEmployeeHistoryDetails()">
					<i class="glyphicon glyphicon-floppy-remove"></i> Cancel
				</button>
				
<!-- 				<button type="button" class="btn btn-success full pull-right" id=btn4> -->
<!-- 					<i class="glyphicon glyphicon-floppy-disk"></i> Test -->
<!-- 				</button> -->

				
			</div>

		</div>

	</div>

</div>



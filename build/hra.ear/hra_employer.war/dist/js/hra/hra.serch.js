/**
 * 20160518 PC HRA-30 created hra.anguleruse.js 
 */

function serchEmployee() {
	var serchContent = $("#serchEmployeeText").val();
	var jsonData = {
		"serchContent" : serchContent
	};
	$.ajax({
		type : "POST",
		url : 'EmployeeController',
		data : {
			jsonData : JSON.stringify(jsonData),
			serchVlaue : serchContent,
			task : "SE"
		},
		dataType : "json",
		success : function(responseText) {			
			listEmployee(responseText);
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});	
} 

function listEmployee(empData) {		
			json = JSON.parse(empData);	
			jsonData : JSON.stringify(empData);
			//////Check whether Table is Initialize or not 
			if($.fn.dataTable.isDataTable( '#employeeDetails' )){
				////////Destroy table
				eTable.destroy();				
			}			
			eTable = $('#employeeDetails').DataTable({
				data: json,
				paging: false, 
				"aoColumns": [ 
                          {
                        	  "mDataProp": "employeeEpf",
                              className: "center"	                     
                          },
		                  {
                        	  "mDataProp": "employeeName",
		                      className: "center"	                      
		                  },		                  
		                  
		                  {
		                	  "mDataProp": "employeeDesignation",
		                      className: "center"
		                  },
		                  {
		                	  "mDataProp": "employeeMobile",
		                      className: "center"		                    
		                  },
		                          
		                  {
		                	  "name": "Add",
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-info" '+
		                    	  'data-toggle="modal" id = "add" ><i class="glyphicon glyphicon-modal-window"></i></button>'
		                  },
		                  {
		                	  "name": "Edit",
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-warning" '+
		                    	  'data-toggle="modal" id = "edit"><i class="glyphicon glyphicon-edit"></i></button>'
		                  },
		                  {
		                	  "name": "Delete",
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-danger" '+
		                    	  'data-toggle="modal" id = "delete"><i class="glyphicon glyphicon-trash"></i></button>'
		                  }
		              ]  
		      
		    } ); 
			
			$("#employeeDetails_filter").css("display","none");  // hiding global search box
			eTable = $('#employeeDetails').DataTable();  
			$('#serchEmployeeText').keyup(function(){
			      eTable.search($(this).val()).draw() ;
			});
			
             ///////////////Add Button click event//////////////
			 $('#employeeDetails tbody').on( 'click', '#add', function () {
			        var data = eTable.row( $(this).parents('tr') ).data();
			      //  eTable.row( $(this).parents('tr') ).remove().draw();	
			        alert('Add button click' +data.employeeName);
			    } );
			 
              ///////////////Edit Button click event//////////////
			 $('#employeeDetails tbody').on( 'click', '#edit', function () {
			        var data = eTable.row( $(this).parents('tr') ).data();
			      //  eTable.row( $(this).parents('tr') ).remove().draw();	
			        alert('Edit button click' +data.employeeName);
			    } );
			 
             ///////////////Delete Button click event//////////////
			 $('#employeeDetails tbody').on( 'click', '#delete', function () {
			        var data = eTable.row( $(this).parents('tr') ).data();
			        eTable.row( $(this).parents('tr') ).remove().draw();	
			        alert('Delete button click' +data.employeeName);
			    } );
}
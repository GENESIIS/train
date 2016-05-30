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
			alert(responseText);
			json = JSON.parse(responseText);
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
			jsonData : JSON.stringify(empData),
			eTable = $('#employeeDetails').DataTable({
				data: json,
				//"aaData" : empData, 
				"aoColumns": [ 
                          {
                        	  "mDataProp": "employeeId",
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
		                    	  'data-toggle="modal" ><i class="glyphicon glyphicon-modal-window"></i></button>'
		                  },
		                  {
		                	  "name": "Edit",
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-warning" '+
		                    	  'data-toggle="modal"><i class="glyphicon glyphicon-edit"></i></button>'
		                  },
		                  {
		                	  "name": "Delete",
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-danger" '+
		                    	  'data-toggle="modal" data-target=" "><i class="glyphicon glyphicon-trash"></i></button>'
		                  }
		              ]  
		      
		    } );
			
			eTable = $('#employeeDetails').DataTable();  
			$('#serchEmployeeText').keyup(function(){
			      eTable.search($(this).val()).draw() ;
			});
			
///////////////Add Button click event//////////////
			 $('#employeeDetails tbody').on( 'click', 'button', function () {
			        var data = eTable.row( $(this).parents('tr') ).data();
			      
			        var datacolom = eTable.columns( $(this)).header();
			      //  eTable.row( $(this).parents('tr') ).remove().draw();
			        alert('you clicked on the column with the name '+JSON.stringify(datacolom) +" "+ $(this).index());
			        
			    } );
}






function serchFamily() {
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
			alert(responseText);
			json = JSON.parse(responseText);
			listFamily(responseText);
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});	
} 

function listFamily(empData) {		
			json = JSON.parse(empData);	
			jsonData : JSON.stringify(empData),
			$('#familyDetails').DataTable({
				data: json,
				//"aaData" : empData, 
				"aoColumns": [ 
                          {
                        	  "mDataProp": "employeeEpf",
                              className: "center"	                     
                          },
		                  {
                        	  "mDataProp": "fmName",
		                      className: "center"	                      
		                  },		                  
		                  
		                  {
		                	  "mDataProp": "fmRelationship",
		                      className: "center"
		                  },
		                  {
		                	  "mDataProp": "fmDateofbirth",
		                      className: "center"		                    
		                  },
		                          
		                  {
		                      data: null,
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-info" '+
		                    	  'data-toggle="modal" data-target="#viewEmployeeDetailsForm"><i class="glyphicon glyphicon-modal-window"></i></button>'
		                  },
		                  {
		                      data: null,
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-warning" '+
		                    	  'data-toggle="modal" data-target="#editEmployeeDetailsForm"><i class="glyphicon glyphicon-edit"></i></button>'
		                  },
		                  {
		                      data: null,
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-danger" '+
		                    	  'data-toggle="modal" data-target=" "><i class="glyphicon glyphicon-trash"></i></button>'
		                  }
		              ]  		      
		    } );
}

function serchLoan() {
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
			alert(responseText);
			json = JSON.parse(responseText);
			listLoan(responseText);
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});	
} 

function listLoan(empData) {		
			json = JSON.parse(empData);	
			jsonData : JSON.stringify(empData),
			$('#familyDetails').DataTable({
				data: json,
				//"aaData" : empData, 
				"aoColumns": [ 
                          {
                        	  "mDataProp": "employeeEpf",
                              className: "center"	                     
                          },
		                  {
                        	  "mDataProp": "loanAmount",
		                      className: "center"	                      
		                  },		                  
		                  
		                  {
		                	  "mDataProp": "loanGuarantor1",
		                      className: "center"
		                  },
		                  {
		                	  "mDataProp": "loanGuarantor2",
		                      className: "center"		                    
		                  },
		                          
		                  {
		                      data: null,
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-info" '+
		                    	  'data-toggle="modal" data-target="#viewEmployeeDetailsForm"><i class="glyphicon glyphicon-modal-window"></i></button>'
		                  },
		                  {
		                      data: null,
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-warning" '+
		                    	  'data-toggle="modal" data-target="#editEmployeeDetailsForm"><i class="glyphicon glyphicon-edit"></i></button>'
		                  },
		                  {
		                      data: null,
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-danger" '+
		                    	  'data-toggle="modal" data-target=" "><i class="glyphicon glyphicon-trash"></i></button>'
		                  }
		              ]  		      
		    } );
}

function serchHistory() {
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
			alert(responseText);
			json = JSON.parse(responseText);
			listHistory(responseText);
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});	
} 

function listHistory(empData) {		
			json = JSON.parse(empData);	
			jsonData : JSON.stringify(empData),
			$('#familyDetails').DataTable({
				data: json,
				//"aaData" : empData, 
				"aoColumns": [ 
                          {
                        	  "mDataProp": "employeeEpf",
                              className: "center"	                     
                          },
		                  {
                        	  "mDataProp": "ehEmployername",
		                      className: "center"	                      
		                  },		                  
		                  
		                  {
		                	  "mDataProp": "ehDesignation",
		                      className: "center"
		                  },
		                  {
		                	  "mDataProp": "ehBasis",
		                      className: "center"		                    
		                  },
		                          
		                  {
		                      data: null,
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-info" '+
		                    	  'data-toggle="modal" data-target="#viewEmployeeDetailsForm"><i class="glyphicon glyphicon-modal-window"></i></button>'
		                  },
		                  {
		                      data: null,
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-warning" '+
		                    	  'data-toggle="modal" data-target="#editEmployeeDetailsForm"><i class="glyphicon glyphicon-edit"></i></button>'
		                  },
		                  {
		                      data: null,
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-danger" '+
		                    	  'data-toggle="modal" data-target=" "><i class="glyphicon glyphicon-trash"></i></button>'
		                  }
		              ]  		      
		    } );
}

function serchEduaction() {
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
			alert(responseText);
			json = JSON.parse(responseText);
			listEduaction(responseText);
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});	
} 

function listEduaction(empData) {		
			json = JSON.parse(empData);	
			jsonData : JSON.stringify(empData),
			$('#familyDetails').DataTable({
				data: json,
				//"aaData" : empData, 
				"aoColumns": [ 
                          {
                        	  "mDataProp": "employeeEpf",
                              className: "center"	                     
                          },
		                  {
                        	  "mDataProp": "eduQualification",
		                      className: "center"	                      
		                  },		                  
		                  
		                  {
		                	  "mDataProp": "eduUniversity",
		                      className: "center"
		                  },
		                  {
		                	  "mDataProp": "eduStudytime",
		                      className: "center"		                    
		                  },
		                          
		                  {
		                      data: null,
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-info" '+
		                    	  'data-toggle="modal" data-target="#viewEmployeeDetailsForm"><i class="glyphicon glyphicon-modal-window"></i></button>'
		                  },
		                  {
		                      data: null,
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-warning" '+
		                    	  'data-toggle="modal" data-target="#editEmployeeDetailsForm"><i class="glyphicon glyphicon-edit"></i></button>'
		                  },
		                  {
		                      data: null,
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-danger" '+
		                    	  'data-toggle="modal" data-target=" "><i class="glyphicon glyphicon-trash"></i></button>'
		                  }
		              ]  		      
		    } );
}


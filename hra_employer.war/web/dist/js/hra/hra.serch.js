/**
 * 20160518 PC HRA-30 created hra.anguleruse.js 
 */


var dataSet = [
 {"employeeId":"1","employeeName":"Namal Ahangama","employeeDesignation":"Manager","employeeMobile":"5046218927"},
 {"employeeId":"2","employeeName":"Nalaka Suranga","employeeDesignation":"Ass. Manager","employeeMobile":"8566368749"},
 {"employeeId":"3","employeeName":"Saman Joy","employeeDesignation":"Supp. Manager","employeeMobile":"5135701893"},
 {"employeeId":"4","employeeName":"James Smith","employeeDesignation":"Supp. Human Resource Manager","employeeMobile":"7735736914"},
 {"employeeId":"5","employeeName":"Mary Johnson","employeeDesignation":"Supp. Vice Manager","employeeMobile":"6054142147"},
 {"employeeId":"6","employeeName":"John Williams","employeeDesignation":"Supp. Manager","employeeMobile":"2158741229"},
 {"employeeId":"7","employeeName":"Lisa Walker","employeeDesignation":"Supp. Accountant","employeeMobile":"3104985651"},
 {"employeeId":"8","employeeName":"Larry West","employeeDesignation":"Supp. Manager","employeeMobile":"9565376195"},
 {"employeeId":"9","employeeName":"Karen Scott","employeeDesignation":"Supp. Human Resource Manager","employeeMobile":"9313139635"},
 {"employeeId":"10","employeeName":"Lawrence Sperry","employeeDesignation":"Supp. Manager","employeeMobile":"3132887937"},
 {"employeeId":"11","employeeName":"Lawrence Sperry","employeeDesignation":"Supp. Manager","employeeMobile":"3132887937"}];
   /* [ "Tiger Nixon", "System Architect", "Edinburgh", "5421" ],
    [ "Garrett Winters", "Accountant", "Tokyo", "8422"],
    [ "Ashton Cox", "Junior Technical Author", "San Francisco", "1562"],
    [ "Cedric Kelly", "Senior Javascript Developer", "Edinburgh", "6224" ],
    [ "Airi Satou", "Accountant", "Tokyo", "5407"],
    [ "Brielle Williamson", "Integration Specialist", "New York", "4804"],
    [ "Herrod Chandler", "Sales Assistant", "San Francisco", "9608"],
    [ "Rhona Davidson", "Integration Specialist", "Tokyo", "6200" ],
    [ "Colleen Hurst", "Javascript Developer", "San Francisco"],
    [ "Sonya Frost", "Software Engineer", "Edinburgh", "1667"],
    [ "Jena Gaines", "Office Manager", "London", "3814"],
    [ "Quinn Flynn", "Support Lead", "Edinburgh", "9497"],
    [ "Charde Marshall", "Regional Director", "San Francisco", "6741"],
    [ "Haley Kennedy", "Senior Marketing Designer", "London", "3597"],
    [ "Tatyana Fitzpatrick", "Regional Director", "London", "1965" ],
    [ "Michael Silva", "Marketing Designer", "London", "1581" ],
    [ "Paul Byrd", "Chief Financial Officer (CFO)", "New York", "3059" ],
    [ "Gloria Little", "Systems Administrator", "New York", "1721" ],
    [ "Bradley Greer", "Software Engineer", "London", "2558"],
    [ "Dai Rios", "Personnel Lead", "Edinburgh", "2290"],
    [ "Jenette Caldwell", "Development Lead", "New York" ],
    [ "Yuri Berry", "Chief Marketing Officer (CMO)", "New York" ],
    [ "Caesar Vance", "Pre-Sales Support", "New York", "8330"],
    [ "Doris Wilder", "Sales Assistant", "Sidney", "3023" ],
    [ "Angelica Ramos", "Chief Executive Officer (CEO)", "London", "5797"],
    [ "Gavin Joyce", "Developer", "Edinburgh", "8822"],
    [ "Jennifer Chang", "Regional Director", "Singapore", "9239" ],
    [ "Brenden Wagner", "Software Engineer", "San Francisco", "1314"],
    [ "Fiona Green", "Chief Operating Officer (COO)", "San Francisco", "2947" ],
    [ "Shou Itou", "Regional Marketing", "Tokyo", "8899"],
    [ "Michelle House", "Integration Specialist", "Sidney", "2769" ],
    [ "Suki Burks", "Developer", "London", "6832" ],
    [ "Prescott Bartlett", "Technical Author", "London", "3606"],
    [ "Gavin Cortez", "Team Leader", "San Francisco", "2860"],
    [ "Martena Mccray", "Post-Sales support", "Edinburgh", "8240"],
    [ "Unity Butler", "Marketing Designer", "San Francisco", "5384" ]
];*/

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
	//eTable = $('#employeeDetails').DataTable();
	 //eTable.fnClearTable();
			var json = JSON.parse(empData);			
			$('#employeeDetails').DataTable({
				data: json,
				paging: false,
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
		                      data: null,
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-info" data-toggle="modal" data-target="#viewEmployeeDetailsForm">'
		                    	             +'<i class="glyphicon glyphicon-modal-window"></i></button>'
		                  },
		                  {
		                      data: null,
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#editEmployeeDetailsForm"><i class="glyphicon glyphicon-modal-window"></i></button>'
		                  },
		                  {
		                      data: null,
		                      className: "center",
		                      defaultContent: '<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteEmployeeDetailsForm"><i class="glyphicon glyphicon-modal-window"></i></button>'
		                  }
		              ]  
		      
		    } );
			$("#employeeDetails_filter").css("display","none");  // hiding global search box
			eTable = $('#employeeDetails').DataTable();
			$('#serchEmployeeText').keyup(function(){
			      eTable.search($(this).val()).draw();
			});

}


/**
 * 20160518 PC HRA-30 created hra.anguleruse.js 
 */


var dataSet = [
    [ "Tiger Nixon", "System Architect", "Edinburgh", "5421" ],
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
];

function serchEmployee() {
	var serchContent = $("#serchEmployeeText").val();
	var jsonData = {
		"serchContent" : serchContent
	};
	alert("ajax"+serchContent),
	$.ajax({
		type : "POST",
		url : 'EmployeeController',
		data : {
			jsonData : JSON.stringify(jsonData),
			serchVlaue : serchContent,
			task : "SE"
		},
		dataType : "json",
		success : function(data) {
			alert("ajax"+responseText);
			json = JSON.parse(responseText);			
			$('#employeeDetails').DataTable({
//				"data": responseText,				
				"aaData": [
                            responseText
				           ]	      
		    } );	
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});
	/*$.ajax({ 
		type : "POST",
		url : 'EmployeeController',
		data : {
			jsonData : JSON.stringify(jsonData),
			serchVlaue : serchContent,
			task : "SE"
		},
		dataType : "json",
		contentType :"application/json ",
		success : function(responseText) {
			alert("ajax"+responseText);
			json = JSON.parse(responseText);			
			$('#employeeDetails').DataTable({
//				"data": responseText,				
				"aaData": [
                            responseText
				           ]	      
		    } );			
		},
		error : function(e) {
			alert("Error " + e);
			console.log(e);
		}
	});*/
} 

function listEmployee(empData) {		
			json = JSON.parse(empData);	
			alert(empData+".................................."+json.employeeName);	
			/* editor = new $.fn.dataTable.Editor( {
			        ajax: "json",
			        table: "#employeeDetails",
			        fields: [ {
			                label: "employeeId:",
			                name: "employeeId"
			            }, {
			                label: "employeeName:",
			                name: "employeeName"
			            }, {
			                label: "employeeDesignation:",
			                name: "employeeDesignation"
			            }, {
			                label: "employeeMobile:",
			                name: "employeeMobile"
			            }, 
			        ]
			    } );*/
			$('#employeeDetails').DataTable({
				//"data": empData
				//ajax: "EmployeeController",
				"aaData" : empData,
				"aoColumns": [ 
                          {
                        	  "mDataProp": "employeeEpf"
                              //className: "center"	                     
                          },
		                  {
                        	  "mDataProp": "employeeEpf"
		                      //className: "center"	                      
		                  },		                  
		                  
		                  {
		                	  "mDataProp": "employeeDesignation"
		                     // className: "center"
		                  },
		                  {
		                	  "mDataProp": "employeeMobile"
		                      //className: "center"		                    
		                  },
		                          
		                  {
		                      data: null,
		                      className: "center",
		                      defaultContent: '<a href="" class="editor_edit">Add</a>'
		                  },
		                  {
		                      data: null,
		                      className: "center",
		                      defaultContent: '<a href="" class="editor_edit">Edit</a>'
		                  },
		                  {
		                      data: null,
		                      className: "center",
		                      defaultContent: '<a href="" class="editor_edit">Delete</a>'
		                  }
		              ]  
		      
		    } );
	

}

eTable = $('#employeeDetails').dataTable();   //pay attention to capital D, which is mandatory to retrieve "api" datatables' object, as @Lionel said
$('#serchEmployeeText').keyup(function(){
      eTable.search($(this).val()).draw() ;
});

/**
 * 20160518 PC HRA-30 created hra.anguleruse.js 
 */

var editor; // use a global for the submit and return data rendering in the examples

$(document).ready(function() {
	 alert("a");
    editor = new $.fn.dataTable.Editor( {
        ajax: "EmployeeController",
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
                label: "Extension:",
                name: "extn"
            }, {
                label: "employeeMobile:",
                name: "employeeMobile"
            }
        ]
    } );
 
    var table = $('#employeeDetails').DataTable( {
        lengthChange: false,
        ajax: "EmployeeController",
        columns: [            
            { data: "employeeId" },
            { data: "employeeName" },
            { data: "employeeDesignation" },
            { data: "employeeMobile" },
           // { data: "salary", render: $.fn.dataTable.render.number( ',', '.', 0, '$' ) }
        ],
        select: true
    } );
 
    // Display the buttons
    new $.fn.dataTable.Buttons( table, [
        { extend: "create", editor: editor },
        { extend: "edit",   editor: editor },
        { extend: "remove", editor: editor }
    ] );
 
    table.buttons().container()
        .appendTo( $('.col-sm-6:eq(0)', table.table().container() ) );
} );
/**
 * 20160420 PN HRA-2 created hra.dynamictable.js class
 */

function addRowToTable(columnCount,tableId) {
	var tbl = document.getElementById(tableId);
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);

	// left cell
	var cellLeft = row.insertCell(0);
	var textNode = document.createTextNode(iteration);
	cellLeft.appendChild(textNode);

	// right cell
	var element = {};

	for (var i = 0; i < columnCount; i++) {
		var cellRight = row.insertCell(1 + i);
		element[i] = document.createElement('input');
		element[i].type = 'text';
		element[i].name = 'txtRow' + i + iteration;
		element[i].id = 'txtRow' + i + iteration;

		element[i].onkeypress = keyPressTest;
		cellRight.appendChild(element[i]);
	}
}

function keyPressTest(e, obj) {
	var validateChkb = document.getElementById('chkValidateOnKeyPress');
	if (validateChkb.checked) {
		var displayObj = document.getElementById('spanOutput');
		var key;
		if (window.event) {
			key = window.event.keyCode;
		} else if (e.which) {
			key = e.which;
		}
		var objId;
		if (obj != null) {
			objId = obj.id;
		} else {
			objId = this.id;
		}
		displayObj.innerHTML = objId + ' : ' + String.fromCharCode(key);
	}
}

function removeRowFromTable(tableId) {
	var tbl = document.getElementById(tableId);
	var lastRow = tbl.rows.length;
	if (lastRow > 2)
		tbl.deleteRow(lastRow - 1);
}

function openInNewWindow(frm) {
	// open a blank window
	var aWindow = window
			.open('', 'TableAddRowNewWindow',
					'scrollbars=yes,menubar=yes,resizable=yes,toolbar=no,width=400,height=400');

	// set the target to the blank window
	frm.target = 'TableAddRowNewWindow';

	// submit
	frm.submit();
}

function validateRow(frm) {
	var chkb = document.getElementById('chkValidate');
	if (chkb.checked) {
		var tbl = document.getElementById('tblSample');
		var lastRow = tbl.rows.length - 1;
		var i;
		for (i = 1; i <= lastRow; i++) {
			var aRow = document.getElementById('txtRow' + i);
			if (aRow.value.length <= 0) {
				alert('Row ' + i + ' is empty');
				return;
			}
		}
	}
	openInNewWindow(frm);
}
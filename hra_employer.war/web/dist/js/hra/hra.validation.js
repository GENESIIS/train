/**
 * 20160509 PN HRA -14 created the class.
 */


function isNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
		return false;

	return true;
}

function isLetter(evt) {
	var inputValue = evt.charCode;
	if (!(inputValue >= 65 && inputValue <= 120)
			&& (inputValue != 32 && inputValue != 0)) {
		evt.preventDefault();
	}
}


function isLetter(evt) {
	var inputValue = evt.charCode;
	if (!(inputValue >= 65 && inputValue <= 120)
			&& (inputValue != 32 && inputValue != 0)) {
		evt.preventDefault();
	}
}

function isEmptyfield(field) {
	if ((field == "") || (field.length = 0) || (field == null)) {
		return false;
	} else {
		return true;
	}
}

function isValidemail(email) {
	var x = email;
	var atpos = x.indexOf("@");
	var dotpos = x.lastIndexOf(".");
	if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
		return false;
	} else {
		return true;
	}
}

function isPastdate(day) {
	var selectedText = day;
	var selectedDate = new Date(selectedText);
	var now = new Date();
	if (selectedDate < now) {
		return true;
	} else {
		return false;
	}
}

function isFuturedate(day) {
	var selectedText = day;
	var selectedDate = new Date(selectedText);
	var now = new Date();
	if (selectedDate > now) {
		return true;
	} else {
		return false;
	}
}
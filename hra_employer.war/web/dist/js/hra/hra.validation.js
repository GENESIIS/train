/**
 * 20160509 PN HRA -14 created the class.
 */

function isEmptyfield(field) {
	if ((field == "") || (field.length == 0) || (field == null)) {
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
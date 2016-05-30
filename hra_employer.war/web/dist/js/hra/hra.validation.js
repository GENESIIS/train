/**
 * 20160509 PN HRA -14 created the class.
 */

/**
 * To validate empty fields.
 * **/
function isEmptyfield(field) {
	if ((field == "") || (field.length = 0) || (field == null)) {
		return false;
	} else {
		return true;
	}
}

/**
 * To validate email address.
 * **/
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

/**
 * To validate is the entered date past.
 * **/
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

/**
 * To validate is the entered date future.
 * **/
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


/**
 *To find which number is large.
 **/
function isLarge(number1, number2) {
	if (number1 < number2) {
		return true;
	} else {
		return false;
	}
}
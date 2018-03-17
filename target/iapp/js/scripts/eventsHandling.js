$(function() {
	$("#datepicker").datepicker({
		showOtherMonths : true,
		selectOtherMonths : true,
		"dateFormat" : "dd-mm-yy",
		"minDate" : -59,
		"maxDate" : new Date()
	});
});

/*
 * $(function() { $("#datepicker").datepicker(); });
 */
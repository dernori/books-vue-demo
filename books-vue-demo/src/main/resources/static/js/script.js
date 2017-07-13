
/*----------- HELPER FUNCTIONS ---------*/


/**
 * Sets the display attribute of the selected object
 * @param selector 
 * @param display - change the value to
*/
function setDisplay(selector, display) {
	$(selector)[0].style.display = display;
}

/**
 * Redirects
 * @param path - to redirect to 
*/
function redirect(path) {
	// TODO (maybe) with vue-router
	window.location.href = path;
}

/**
 * Makes the selected table a DataTable
 * @param selector
 * @param length - preferred length of a page 
*/
function makeTableFancy(selector, length) {
	var dT = $(selector).DataTable();
	dT.destroy();
	console.log(dT);
	$(selector).DataTable( {
		"searching": false,
		"lengthChange": false,
		"pageLength": length
	} );
}


/*-------- END OF HELPER FUNCTIONS ------*/

/*---------------- EVENTS ---------------*/

$(document).on('change', ':file', function() {
    var input = $(this),
        numFiles = input.get(0).files ? input.get(0).files.length : 1,
        label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
    input.trigger('fileselect', [numFiles, label]);
});


$(document).ready(function() {			
	
	$('.datepicker').datepicker({
		format: 'yyyy mm dd',
		startDate: '-3d'				
	});
	
	 $('.timepicker').datetimepicker({
		format: 'HH:mm'
	});
	
	$(".custom-checkbox").click(function(){
		if ($('#box').hasClass('fa-square')) {
			$('#box').removeClass('fa-square').addClass('fa-check-square');
		} else {
			$('#box').removeClass('fa-check-square').addClass('fa-square');
		}
	});
	
	$(':file').on('fileselect', function(event, numFiles, label) {
        var input = $(this).parents('.input-group').find(':text'),
            log = numFiles > 1 ? numFiles + ' fájl kiválasztva' : label;

		if( input.length ) {
            input.val(log);
        } else {
            if( log ) alert(log);
        }
    });
} );

/*------------END OF EVENTS ---------------*/
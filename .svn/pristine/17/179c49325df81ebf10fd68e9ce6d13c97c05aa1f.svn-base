
$(document).ready(function() {
	var idno = document.getElementById("idno").value;
	
	//var idno = $("#idno").val();
	//alert(idno);
	$.ajax({
		
	    type: "GET",
	    contentType : "application/json",
	    url: "/HRMS/getleavebalance?idno=" +idno, //this is my servlet
	    success: function(data){ 
	    
	    	var clval = parseFloat(data[0]).toFixed(1);
	    	document.getElementById("cl").value=clval;
	    	var slval = parseFloat(data[1]).toFixed(1);
	    	document.getElementById("sl").value=slval;
	    	var elval = parseFloat(data[2]).toFixed(1);
	    	document.getElementById("el").value=elval;
	    	var coval = parseFloat(data[3]).toFixed(1);
	    	document.getElementById("co").value=coval;
	    }
	});
});


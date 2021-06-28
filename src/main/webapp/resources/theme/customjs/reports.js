//For reports dropdown

$(document).ready(function() {
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "getAllMenumaster", // this is my servlet

				success : function(data) {
					var abc = data;
					var ele = document.getElementById('itemname');
					for (var i = 0; i < abc.length; i++) {
						// POPULATE SELECT ELEMENT WITH JSON.
						ele.innerHTML = ele.innerHTML + '<option value="'+ abc[i]["itemid"] + '">' + abc[i]["itemname"]+ '</option>';
						}

				}
			});
		});


//cadre*********************************************************

$(document).ready(
		function() {
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "getallCadre", // this is my servlet

				success : function(data) {
					var abc = data;
					var ele = document.getElementById('cadreid');
					for (var i = 0; i < abc.length; i++) {
						// POPULATE SELECT ELEMENT WITH JSON.
						ele.innerHTML = ele.innerHTML + '<option value="'
								+ abc[i]["tranid"] + '">'
								+ abc[i]["cadredescription"] + '</option>';
					}

				}
			});
		});

//*******************PROJECTS DROPDOWN****************************************************

$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallDivision", // this is my servlet

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('division');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
			ele.innerHTML = ele.innerHTML + '<option value="'+ abc[i]["divisionid"] + '">' + abc[i]["name"]+ '</option>';								
			
			}

		}
	});
});


//projects

$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallproject", // this is my servlet
		success : function(data) {
			var abc = data;
			var ele = document.getElementById('project');
			for (var i = 0; i < abc.length; i++) {
				ele.innerHTML = ele.innerHTML + '<option value="'
						+ abc[i]["tranid"] + '">'
						+ abc[i]["projectname"] + '</option>';
			}

		}
	});
});



//grade

$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallempgrade", // this is my servlet
		success : function(data) {
			var abc = data;
			var ele = document.getElementById('gradeId');
			for (var i = 0; i < abc.length; i++) {
				ele.innerHTML = ele.innerHTML + '<option value="'
						+ abc[i]["gradeno"] + '">'
						+ abc[i]["description"] + '</option>';
			}

		}
	});
});


//*******************DEPARTMENT DROPDOWN**********************************8

$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallDepartment", // this is my servlet

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('workdeptid');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML + '<option value="'
						+ abc[i]["deptid"] + '">' + abc[i]["name"]
						+ '</option>';
			}

		}
	});
});


//*************************getallsection***********************************

$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallsection", // this is my servlet

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('sectionid');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML + '<option value="'
						+ abc[i]["sectionid"] + '">' + abc[i]["name"]
						+ '</option>';
			}

		}
	});
});


$(document).ready(function() {
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "getalljobstatus", // this is my servlet

				success : function(data) {
					var abc = data;
					var ele = document.getElementById('jobstatus');
					for (var i = 0; i < abc.length; i++) {
						ele.innerHTML = ele.innerHTML + '<option value="'
								+ abc[i]["jobstatusid"] + '">'
								+ abc[i]["description"] + '</option>';
					}

				}
			});
		});


$(document).ready(function() {
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "getallempstatus", // this is my servlet

				success : function(data) {
					var abc = data;
					var ele = document.getElementById('empstatus');
					for (var i = 0; i < abc.length; i++) {
						// POPULATE SELECT ELEMENT WITH JSON.
						ele.innerHTML = ele.innerHTML + '<option value="'
								+ abc[i]["empstatusid"] + '">'
								+ abc[i]["description"] + '</option>';
					}

				}
			});
		});


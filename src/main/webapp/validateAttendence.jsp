<%@include file="header.jsp" %>
 
 
 
<style>
.mycustom{


}
</style>
<style>
.search-table-outter {
	overflow-x: scroll;
}
</style>

<script>

/*Section dropdown*/

$(document).ready(function() {
	
	$.ajax({
       type: "GET",
       contentType : "application/json",
       url: "getallsection", //this is my servlet
     
       success: function(data){ 
       	var abc=data;
       	var ele = document.getElementById('sectionid');
           for (var i = 0; i < abc.length; i++) {
               // POPULATE SELECT ELEMENT WITH JSON.
               ele.innerHTML = ele.innerHTML +
                   '<option value="' + abc[i]["sectionid"] + '">' + abc[i]["name"] + '</option>';
           }
       	
       }
});
});


$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallproject", 

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('project1');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML + '<option value="'
						+ abc[i]["tranid"] + '">'
						+ abc[i]["projectname"] + '</option>';
			}

		}
	});
});

$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallDivision", // this is my servlet
                        success : function(data) {
			var abc = data;
			var ele = document.getElementById('division1');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
			ele.innerHTML = ele.innerHTML + '<option value="'+ abc[i]["divisionid"] + '">' + abc[i]["name"]+ '</option>';								
                    }
			}
                     });
 });
                     
$(document).ready(function() {

  	$.ajax({
         type: "GET",
         contentType : "application/json",
         url: "getAllHrShifts", 
       
         success: function(data){ 
         	var abc=data;
         	var ele = document.getElementById('shiftId');
             for (var i = 0; i < abc.length; i++) {
                 // POPULATE SELECT ELEMENT WITH JSON.
                 ele.innerHTML = ele.innerHTML +
                     '<option value="' + abc[i]["shiftid"] + '">' + abc[i]["name"] + '</option>';
             }
         	
         }
  });
  });

          	 $("#AttendenceData").on('click', '#reCalc', function() {
		    var currentRow = $(this).closest("tr");
		    ssIdno = currentRow.find("td:eq(0)").html(); 
                   $("#sssIdno").val(ssIdno);
                   dayCalc(ssIdno)
                });                
              
function dayCalc(sIdno){
	  var date=document.getElementById("date1").value;
	  var project=document.getElementById("project1").value;
          var division=document.getElementById("division1").value;
                   
        $("#AttendenceData").hide();
	    $("#image").show();
		 $.ajax({
				//url: '/DASHBOARD/getDropdowns',
				url : "/HRMS/validateAttendence?sType="+sIdno+"&&date="+date+"&&project="+project+"&&division="+division,

				success : function(data, textStatus, jqXHR) {
					 $("#msg").html("Attendece List on "+date );
					var table_data = data.dataBean;
					// //alert(table_data[punchcod]);
					var table = $('#AttendenceData').DataTable({
										"destroy" : true,										
										data : table_data,										
							                    columns : [
													{data : "employee.idNumber"},
													{data : "employee.employeeName"},
													{data : "attendid"},
													{data : "employee.design"},
													{data : "departments.name"},
													{data : "employeeDisplaystatus"},
													{data : "shifts.name"},
													{data : "inpunchcount"}, 
													{data : "outpunchcount"}, 
													{data : "durationInHours"},
													{data : "otinHours"},
													{
										                data: null,
										                className: "center",
										                defaultContent: '<input type="image" src="resources/assets/images/edit-icon.png" height="20" width="20"  id="attid" > '
										                + '<button type="button"  id="reCalc">Calc</button> '                                                                                                
										                + '<button type="button"  id="shiftid">Assign-Shift</button>'										            
												
										            }
													
													],
							                
										
													
									//  searching : false
									});
					table.destroy();
					var oTable = $('#AttendenceData').DataTable({
						"pageLength": 50,
						rowCallback: function(row, data, index){
						if(data[7]== data[8]){
						    	$(row).find('td:eq(7)').css('background-color', '#73f777');
						    	$(row).find('td:eq(8)').css('background-color', '#73f777');
						}
					  	if(data[7]!= data[8]){
					    	$(row).find('td:eq(7)').css('background-color', 'red');
					    	$(row).find('td:eq(8)').css('background-color', 'red');
					    }
					    
					  }
					});
					 $("#image").hide();
					 $("#AttendenceData").show();
				}
			});
 
  }
  
  $(document).ready(function() {
	  var date=document.getElementById("date").value;
	  var project=document.getElementById("project").value; 
            var division=document.getElementById("division").value; 
	  $("#AttendenceData").hide();
	  $("#image").show();
	  
	  
		 $.ajax({
				//url: '/DASHBOARD/getDropdowns',
				url : "/HRMS/validateAttendence?sType=0&&date="+date+"&&project="+project+"&&division="+division,
				success : function(data, textStatus, jqXHR) {
					 $("#msg").html("Attendece List on "+date );
					var table_data = data.dataBean;
					// //alert(table_data[punchcod]);
	
					var table = $('#AttendenceData').DataTable({
										"destroy" : true,
										
										data : table_data,										 							               
							                    columns : [
							                    	{data :"tranid"},
													{data : "employee.idNumber"},
													{data : "employee.employeeName"},
													{data : "attendid"},
													{data : "employee.design"},
													{data : "departments.name"},
													{data : "sectionDTO.name"},
													{data : "employeeDisplaystatus"},
													{data : "shifts.name"},
													{data : "inpunchcount"}, 
													{data : "outpunchcount"}, 
													{data : "durationInHours"},
													{data : "otinHours"},
													
													{
										                data: null,
										                className: "center",
										                defaultContent: '<input type="image" src="resources/assets/images/edit-icon.png" height="20" width="20"  id="attid" > '
										                	+ '<input type="image" src="resources/assets/images/update.jpg" height="20" width="20"  id="section">'
										                + '<button type="button"  id="reCalc">Calc</button> '                                                                                                
										                + '<button type="button"  id="shiftid">Assign-Shift</button> '
										                
												
										            }
													
													],
							                
										
													
									//  searching : false
									});
					table.destroy();
					var oTable = $('#AttendenceData').DataTable({
						"pageLength": 50,
						rowCallback: function(row, data, index){
						if(data[7]== data[8]){
						    	$(row).find('td:eq(7)').css('background-color', '#73f777');
						    	$(row).find('td:eq(8)').css('background-color', '#73f777');
						}
					  	if(data[7]!= data[8]){
					    	$(row).find('td:eq(7)').css('background-color', 'red');
					    	$(row).find('td:eq(8)').css('background-color', 'red');
					    }
					    
					  }
					});
					 $("#image").hide();
					 $("#AttendenceData").show();
				}
			});
	} );

  $(document).ready(function(){
  	 $("#AttendenceData").on('click', '#attid', function() {
  	var currentRow = $(this).closest("tr");
     var idno = currentRow.find("td:eq(1)").html(); 
     var shiftname = currentRow.find("td:eq(6)").html(); 
     if(shiftname==""){
    	 var shiftname = "null"; 
     }
     var empname = currentRow.find("td:eq(2)").html(); 
     var attendid = currentRow.find("td:eq(3)").html(); 
     var designation = currentRow.find("td:eq(4)").html(); 
     var depname = currentRow.find("td:eq(5)").html(); 
     var date=document.getElementById("date1").value;    
     var division = document.getElementById("division").value;
     var project = document.getElementById("project").value;
     
   window.location.href='#/displayhrpunches/'+date+'/'+idno+'/'+shiftname+'/'+empname+'/'+designation+'/'+depname+'/'+attendid+'/'+division+'/'+project;
    
  	 });
  });

/****************************************************** Assign Shifts ****************************************************/

  $(document).ready(function(){
  	 $("#AttendenceData").on('click', '#shiftid', function() {
  	var currentRow = $(this).closest("tr");
  //	var date=document.getElementById("date").value
    	var idno = currentRow.find("td:eq(0)").html(); 
    	document.getElementById("modalboxidno").value=idno;
  //displayHrpunches(date,idno,shiftname,empname,designation,depname,attendid)
    	$('#myModal').modal('show');
   
  	 });
  });

 /*****************************************************  section update ***************************************************/
  
	  	 $("#AttendenceData").on('click', '#section', function() {
	  	    var currentRow = $(this).closest("tr");
	    	var tranid = currentRow.find("td:eq(0)").html(); 
	    	//alert(">>>>>>>>>>>Tranid>>  "+tranid);
	    	document.getElementById("tranid").value=tranid;
	    	retrieve:true,
			$.ajax({
					contentType : "application/json",
					"url" : "sectionByTranidInPuncheslist?tranid="+ tranid,
						"dataSrc" : "dataBean",
						"type" : "GET",
						success : function(data) {
							document.getElementById("sectionid").value = data[0]["sectionid"];
						},
					});
	    	$('#sectionModal').modal('show');
	  	 });
	 
  
 /*********************************************************** Section Add **************************************************/
 
  $("#addsection").on('click', function() {
	 // alert(">>>>>>>click>>>>>>");
	  var tranid = document.getElementById("tranid").value;
	 // alert("tranid >>>>>>>>>>>>>>  "+tranid);
	  var sectionid = document.getElementById("sectionid").value;
	  //alert("sectionid  "+sectionid);
	  var sectionadd = {};
	  sectionadd["tranid"] = $("#tranid").val();
	  sectionadd["sectionid"] = $("#sectionid").val();
	   
	  $.ajax({
			type : "post",
			contentType : "application/json",
			url : "sectionadd", //this is my servlet
			data : JSON.stringify(sectionadd),
			success : function(data) {
				alert("SUCCESSFULLY");
				window.location.reload(); 
			}
		});
	    	
	      });
 
 
 
 
  $(document).ready(function() {
      $("#addManualPunch").on('click', function() {
  	var date=document.getElementById("date1").value;
    var idno = document.getElementById("modalboxidno").value;
  	var punchcode=document.getElementById("punchcode").value;
    var shiftId =  document.getElementById("shiftId").value;
    alert("shiftId  "+shiftId);
    var remarks= document.getElementById("remarks").value;
 
    	 $.ajax({
  	        type: "post",
  	       // url: "AddHrPunchCodesForI.jsp?idno="+idno+"&punchtypes="+punchtypes+"&date="+date,
  	        url: "AddHrPunchCodesForI?idno="+idno+"&punchtypes="+punchcode+"&date="+date+"&shiftcode="+shiftId+"&remarks="+remarks,

  	        		success: function(data){ 
  	    		window.location.reload();
  	        }
  	 });
      });
  });
  </script>
  <script>
 function getAttendenceData(){
	 var date=document.getElementById("date").value;
	 var project=document.getElementById("project").value;
	 var division=document.getElementById("division").value;
	 //window.location.href='#/attendance/'+date+'/'+project;
	 window.location.href='#/attendance/'+date+'/'+project+'/'+division;
 }
 </script>
</head>
<body>
<%
String date=request.getParameter("date");
String project=request.getParameter("project");
String division=request.getParameter("division");

%>
 <input type="hidden" value="<%=date %>" id="date">
 <input type="hidden" value="<%=project %>" id="project">
 <input type="hidden" value="<%=division %>" id="division">
 
 <input type="hidden" value="0" id="sssIdno">
          <div class="row">
	   <div class="box col-md-12">
		<div class="box-inner">
      		<div class="row">
      		<div class="form-group has-warning    col-md-3">
			<label class="control-label"  style="color: Blue" for="inputWarning1">Division</label><br>                    
			<select class="form-control" id="division1" name="division1" style="border:1px solid #696969">
			</select>                       
		</div>
    		<div class="form-group has-warning    col-md-3">
			<label class="control-label"  style="color: Blue" for="inputWarning1">Project</label><br>                    
			<select class="form-control" id="project1" name="project1" style="border:1px solid #696969">
			</select>                       
		</div>
    		<div class="form-group has-warning    col-md-3">
                    <label class="control-label" style="color: Blue"  for="inputWarning1">Attendence For </label> <br><input type="text" id="date1" value="<%=date %>" placeholder="YYYY-MM-DD" class="form-control" style="border:1px solid #696969">
		</div>
		 
                </div>
               
         <div align ="center">
		      <button  type="submit"  onclick="dayCalc(0)" style="background-color: blue;color:white" class="btn btn-primary"  > Show</button> &nbsp&nbsp&nbsp&nbsp
		      <button  type="button"  onclick="dayCalc(1)" style="background-color: blue;color:white" class="btn btn-primary"  >   DayCal</button>                     
		</div>
				
</div>
</div>
</div>
<!--<br><h3 id="msg" align="center" style="color:red"></h3>-->
<div class="search-table-outter wrapper">
<table id="AttendenceData" class="display compact nowrap" style="width:100%; padding:5px;" border="1">
			<thead>
			<tr>
			     <th>TRANID</th>
           		 <th>ID<br>NUMBER</th>
           		 <th>EMPNAME</th>
                 <th><b>ATTENDID</b></th>
                 <th><b>DESGN</b></th>
                 <th><b>DEP.NAME</b></th>
                 <th><b>SECTION</b></th>
                 <th><b>STATUS</b></th>
                 <th><b>SHIFT<br>NAME</b></th>
                 <th><b>IN<br>PUNCH</b></th>
                 <th><b>OUT<br>PUNCH</b></th>
                 <th><b>DURATION</b></th>
                 <th><b>O.T</b></th>
                 <th><b>Action</b></th> 
           </tr>
           </thead>
</table>
</div>

<!--*************************************************** AssignShifts Modal *****************************************************-->

 <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
         
        </div>
        <div class="modal-body">
        <input type="text" id="modalboxidno" hidden="hidden">
        <input type="text" id="punchcode" value="3" readonly="readonly"  hidden="hidden">
        Shifts: <select id="shiftId">
        
          </select>
        Reason: <input type="text" id="remarks" >
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal"   id="addManualPunch" >Submit</button>
        </div>
      </div>
      
    </div>
  </div>
  
  
<!--*************************************************** Section Modal *****************************************************-->

 
  <div class="modal fade" id="sectionModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      
      <div class="modal-content">
        <div class="modal-header">
           <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <form id="sectionValidation">
        <div class="modal-body" align="center">
         <input type="text" id="tranid" hidden="hidden">
         Section: <select id="sectionid"></select>
        </div>
         </form>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal"   id="addsection" >Submit</button>
        </div>
      </div>
    
    </div>
  </div>
  
  
  
<div align="center"><img src="resources/img/reload.gif" id="image"></div>
      	    <script src="resources/dist/js/sidebarmenu.js"></script>
<%@include file="footer.jsp" %>
<script>
function submit(){
	var date=document.getElementById("date1").value;
	var project=document.getElementById("project1").value;
	
	var division=document.getElementById("division1").value;
	window.location.href='#/attendance/'+date+'/'+project+'/'+division;
}
</script>
<script>
jQuery('#date1').datepicker({
    autoclose: true,
    todayHighlight: true
});
</script>
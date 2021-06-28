<%@include file="header.jsp" %>
<script>
$(document).ready(function() {
	
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "/DASHBOARD/getloginuser", //this is my servlet
      
        success: function(data){ 
        	
        	var abc=data;
        	var ele = document.getElementById('sel');
            for (var i = 0; i < abc.length; i++) {
                // POPULATE SELECT ELEMENT WITH JSON.
                ele.innerHTML = ele.innerHTML +
                    '<option value="' + abc[i]["uid"] + '">' + abc[i]["username"] + '</option>';
            }
        	
        }
 });
});

function show(ele) {
    // GET THE SELECTED VALUE FROM <select> ELEMENT AND SHOW IT.
    var msg = document.getElementById('msg');
    msg.innerHTML = 'Selected LeaveType: <b>' + ele.options[ele.selectedIndex].text + '</b> </br>';
}

function populateSelect(){
	var a=document.getElementById("sel").value;
}
</script>
<script>

$(document).ready(function() {
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "/DASHBOARD/getloginactivity", //this is my servlet
      
        success: function(data){ 
        	
        	var abc=data;
        	var act = document.getElementById('activity');
            for (var i = 0; i < abc.length; i++) {
                // POPULATE SELECT ELEMENT WITH JSON.
                act.innerHTML = act.innerHTML +
                    '<option value="' + abc[i]["itemid"] + '">' + abc[i]["itemname"] + '</option>';
            }
        	
        }
 });
});


function show(act) {
    // GET THE SELECTED VALUE FROM <select> ELEMENT AND SHOW IT.
    var msg = document.getElementById('msg');
    msg.innerHTML = 'Selected LeaveType: <b>' + act.options[ele.selectedIndex].text + '</b> </br>';
}

function populateSelect(){
	var a=document.getElementById("activity").value;
	
}
</script>
<script>
function alllist(){
	var idno = document.getElementById("sel").value;
	
	
	$('#useraccesslist').dataTable( {
		destroy: true,
		 "ajax" : {

		"url" : "/DASHBOARD/getuseraccesslist?idno="+idno,
		"dataSrc" : "dataBean",
		"type" : "GET",
	
	       },
		"columns": [
						{ data: "itemname"},
						{ data: "iscreate"},
						{ data: "isupdate"},
		 				{ data: "isview"},
				 		{ data: "isdelete"},
				 		{ data: "level1"},
				 		{ data: "level2"},
				 		{ data: "level3"},
				 		{ data: "level4"},
						
						{
			                data: null,
			                className: "center",
			                defaultContent: '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25"  id = "reportaccess" onclick="activityEdit()"  >   '
			            }
				],
	
	} );
}

function saveUserAccessList(){ 
	
	
	
	var saveUserAccessList = {};
	saveUserAccessList["idno"] = $("#sel").val();
	saveUserAccessList["menuitemid"] = $("#activity").val();
	
	saveUserAccessList["iscreate"] = $("#iscreate").val();
	saveUserAccessList["isupdate"] = $("#isupdate").val();
	saveUserAccessList["isview"] = $("#isview").val();
	saveUserAccessList["isdelete"] = $("#isdelete").val();
	saveUserAccessList["level1"] = $("#level1").val();
	saveUserAccessList["level2"] = $("#level2").val();
	saveUserAccessList["level3"] = $("#level3").val();
	saveUserAccessList["level4"] = $("#level4").val();
	
	 $.ajax({
		 
	        type: "POST",
	        contentType : "application/json",
	        url: "savenewactivity", //this is my servlet
	        data : JSON.stringify(saveUserAccessList),
	        
//	        
	        success: function(data){ 
	        	
	        	
	        	$('#processedData').html(data.successMessage);
				$('#displayDiv').show();
	        	
				usercompmapping();
	        }
	 });
}
function activityEdit(){
	
	$("#useraccesslist").on('click', '#reportaccess', function() {
		
		var currentRow = $(this).closest("tr");
		
		var rowData = $("#useraccesslist").DataTable().row(currentRow).data();

	   var tranid = rowData.tranid;
	  
		 });

}
//editactivity
</script>
<br>
<h4 style = "color:blue;text-align:center">USER ACTIVITY MAPPING</h4>
<hr>
<div class="box-content row">
<div class="form-group has-warning col-md-3">
			<label class="control-label">User</label> 
            <select id="sel" onchange ="alllist()" class="form-control">
                  <option value="">select</option>
             </select>
		</div>
<div class="form-group has-warning col-md-3">
			<label class="control-label">Activity</label> 
            <select id="activity" class="form-control">
                  <option value="">select</option>
             </select>
		</div>
</div>
<hr>
<div><h5>To Add New Activity ... Select Activity  <input type="submit" class="save"  onclick="saveUserAccessList()"  value="Click Here"></h5></div>
<table id="useraccesslist" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		 <th>Activity</th>
                <th>Create</th>
                <th>Update</th>
                <th>View</th>
                <th>Delete</th>
                <th>Level1</th>
                 <th>Level2</th>
                 <th>Level3</th>
                 <th>Level4</th>
                 
                
              	<th>Action</th>
                
            </tr>
        </thead>
       
    </table>
    
    
     <!-- Modal -->
          <div id="a">
     
  
  </div>



      	    <script src="resources/dist/js/sidebarmenu.js"></script>

<%@include file="footer.jsp"%>
<%@include file="header.jsp" %>
 <style>
caption { 
  display: table-caption;
  text-align: center;
}

table, th, td {
  border: 1px solid black;
}
</style>
     
<script>
$(document).ready(function(){
	   // $("#warnings").hide();
	    $("#success").hide();
	    $("#successinedit").hide();
	   
	});
</script>

<script>
$(document).ready(function() {
	
	$('#imagesList').dataTable( {
			 "ajax" : {
			"url" : "/HRMS/getAllImages",
			"dataSrc" : "dataBean",
			"type" : "GET",
		
		       },
		       
		     
			"columns": [
							{ data: "tranid"},
							{data: "base64Image",
							    render: function (data, type,row) {
							        var imgsrc = 'data:image/png;base64,' + data; // here data should be in base64 string
							        return '<img  src="' + imgsrc +'" style="height:25px;width:18px;" >';
							    }
							},
							/* { data: "image"}, */
 							
							{
				                data: null,
				                className: "center",
				                defaultContent: ' <input type="image" src="resources/assets/images/delete.png" id="deleteImage" height="15" width="15"  onclick="forImageDeletion()">'
				            }
					],
		
		} );
	
} );
</script>
<script>
$(document).ready(function() {
	$('#participantsList').dataTable( {
			 "ajax" : {
			"url" : "/HRMS/getAllParticipants",
			"dataSrc" : "dataBean",
			"type" : "GET",
		
		       },
			"columns": [
							{ data: "tranid"},
							{ data: "eventid"},
							{ data: "participantname"},
 							
							{
				                data: null,
				                className: "center",
				                defaultContent: ' <input type="image" src="resources/assets/images/delete.png" id="deleteId" height="15" width="15"  onclick="forDeletion()">'
				            }
					],
		
		} );
	
} );
</script>
<script>
$(document).ready(function() {
	$('#expensesDetailsList').dataTable( {
			 "ajax" : {
			"url" : "/HRMS/getAllExpenses",
			"dataSrc" : "dataBean",
			"type" : "GET",
		
		       },
			"columns": [
							{ data: "tranid"},
							{ data: "amount"},
							{ data: "accounthead"},
 							
							{
				                data: null,
				                className: "center",
				                defaultContent: '<input type="image" src="resources/assets/images/delete.png" id="deleteExpense" height="15" width="15"  onclick="forExpensesDeletion()">'
				            }
					],
		
		} );
	
} );
</script>
<script>
$(document).ready(function() {
	$('#eventsList').dataTable( {
			 "ajax" : {
			"url" : "/HRMS/getAllEvents",
			"dataSrc" : "dataBean",
			"type" : "GET",
		
		       },
			"columns": [
							{ data: "tranid"},
							{ data: "infodate"},
							{ data: "conductedby"},
							{ data: "totalexpense"},
							
							{
				                data: null,
				                className: "center",
				                defaultContent: '<input type="image" src="resources/assets/images/delete.png" id="deleteEvent" height="25" width="25"  onclick="forEventDeletion()"> / <input type="image" src="resources/assets/images/edit-icon.png" id="editEvent" height="25" width="25"  > '
				            }
					],
		
		} );
	
} );
</script>
<script>
function saveParticipants(){
var saveParticipants = {};
        saveParticipants["eventid"] = $("#tranid").val();
        saveParticipants["participantname"] = $("#participantname").val();
		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "saveParticipants", //this is my servlet
			data : JSON.stringify(saveParticipants),
			success : function(data) {
				
				$("#successmsg").html(data["successMessage"]);
				$("#success").show();	
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);

			}
		});
}
</script>
<script>
function saveExpenses(){
var saveExpenses = {};
        saveExpenses["eventid"] =$("#tranid").val();
        saveExpenses["amount"] = $("#amount").val();
        saveExpenses["accounthead"] = $("#item").val();
		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "saveExpenses", //this is my servlet
			data : JSON.stringify(saveExpenses),
			success : function(data) {
				
				$("#successmsg").html(data["successMessage"]);
				$("#success").show();	
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);

			}
		});
}
</script>
<script>
function saveImages() {
	
	var filecover = document.getElementById("fileUpload").files[0];
	var formdata = new FormData();
	formdata.append("filecover", filecover);
	$.ajax({
		type : "post",
		// contentType: false,
		url : "storeImagedetails" , // this controller url
		data : formdata,
		processData : false,
		contentType : false,
		success : function(data) {
			window.location.reload();
		}

	}); 

}
</script>
<script>
function saveEvents() {
	var saveEvents = {};
	saveEvents["infodate"] =$("#eventdate").val();
	saveEvents["conductedby"] = $("#organizedby").val();
	saveEvents["description"] = $("#programdetails").val();
	saveEvents["title"] =$("#title").val();
	saveEvents["totalexpense"] = $("#totalexpenses").val();
	
	$.ajax({
		type : "post",
		contentType : "application/json",
		url : "saveEvents", //this is my servlet
		data : JSON.stringify(saveEvents),
		success : function(data) {
			
			$("#successmsg").html(data["successMessage"]);
			$("#success").show();	
	        setInterval(function(){
	        	window.location.reload(); // this will run after every 5 seconds
	        }, 2000);

		}
	});

}
</script>
<script>
function forDeletion(){
	 $("#participantsList").on('click', '#deleteId', function() {
			var currentRow = $(this).closest("tr");
		    var tranid = currentRow.find("td:eq(0)").html(); 
		    var name = currentRow.find("td:eq(2)").html(); 
		    var retVal = confirm("would you like to delete this userId "+tranid+" and username is :"+name+"?");
            if( retVal == true ) {
            
               deletedSuccessfully(tranid);
            } else {
            
            }
	 });
}

function deletedSuccessfully(tranid){
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "deleteParticipant?tranid="+tranid, //this is my servlet
	        success: function(data){  
	        	$("#deletemessage").html("DeletedSucessFully");
	        	 setInterval(function(){
	 	        	window.location.reload(); // this will run after every 5 seconds
	 	        }, 2000);
	        }
	  });
}
</script>

<script>
function forExpensesDeletion(){
	 $("#expensesDetailsList").on('click', '#deleteExpense', function() {
			var currentRow = $(this).closest("tr");
		    var expensetranid = currentRow.find("td:eq(0)").html(); 
		    var description = currentRow.find("td:eq(2)").html(); 
		    var retVal = confirm("would you like to delete this userId "+expensetranid+" and description is :"+description+"?");
            if( retVal == true ) {
            
               deletedSuccessfully(expensetranid);
            } else {
            
            }
	 });
}

function deletedSuccessfully(expensetranid){
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "deleteExpense?expensetranid="+expensetranid, //this is my servlet
	        success: function(data){  
	        	$("#deletemessage1").html("DeletedSucessFully");
	        	 setInterval(function(){
	 	        	window.location.reload(); // this will run after every 5 seconds
	 	        }, 2000);
	        }
	  });
}
</script>
<script>
function forEventDeletion(){
	 $("#eventsList").on('click', '#deleteEvent', function() {
			var currentRow = $(this).closest("tr");
		    var eventtranid = currentRow.find("td:eq(0)").html(); 
		    var name = currentRow.find("td:eq(2)").html(); 
		    var retVal = confirm("would you like to delete this userId "+eventtranid+" and username is :"+name+"?");
            if( retVal == true ) {
            
               deletedSuccessfully(eventtranid);
            } else {
            
            }
	 });
}

function deletedSuccessfully(eventtranid){
	alert();
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "deleteEvent?eventtranid="+eventtranid, //this is my servlet
	        success: function(data){  
	        	$("#deletemessage2").html("DeletedSucessFully");
	        	 setInterval(function(){
	 	        	window.location.reload(); // this will run after every 5 seconds
	 	        }, 2000);
	        }
	  });
}
</script>
<script>
function forImageDeletion(){
	 $("#imagesList").on('click', '#deleteImage', function() {
			var currentRow = $(this).closest("tr");
		    var imagetranid = currentRow.find("td:eq(0)").html(); 
		    var retVal = confirm("would you like to delete this userId " + imagetranid );
            if( retVal == true ) {
            
               deletedSuccessfully(imagetranid);
            } else {
            
            }
	 });
}

function deletedSuccessfully(imagetranid){
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "deleteImage?imagetranid="+imagetranid, //this is my servlet
	        success: function(data){  
	        	$("#deletemessage2").html("DeletedSucessFully");
	        	 setInterval(function(){
	 	        	window.location.reload(); // this will run after every 5 seconds
	 	        }, 2000);
	        }
	  });
}
</script>
<script>
$("#eventsList").on('click','#editEvent',function() {
	var currentRow = $(this).closest("tr");
	var rowData = $("#eventsList").DataTable().row(currentRow).data();
	var tranid = rowData.tranid;
	retrieve:true,
	$.ajax({
		
	    type: "GET",
	    contentType : "application/json",
	    url: "/HRMS/getevents?tranid=" + tranid, //this is my servlet
	    success: function(data){ 
	    	for (var i = 0; i < data.length; i++) {
			$("#editeventid").val(data[i].tranid);
		    $("#editeventdate").val(data[i].infodate);
			$("#edittotalexpenses ").val(data[i].totalexpense);
			$("#editorganisedby").val(data[i].conductedby);
	    	
	    	}
			selectedRecord = data;
	    },
	});
	$('#eventmodal').modal('show');
});

</script>
<script>
function eventEdit(){
	alert();
	var eventEdit = {};
	eventEdit["tranid"] = $("#editeventid").val();
	eventEdit["infodate"] = $("#editeventdate").val();
	eventEdit["totalexpense"]=$("#edittotalexpenses").val();
	eventEdit["conductedby"] = $("#editorganisedby").val(); 

     $.ajax({
        type: "post",
        contentType : "application/json",
        url: "eventEdit", 
        data : JSON.stringify(eventEdit),
        success: function(data){  
    	 $("#DivisionStrong").html(data["successMessage"]);
       	 $("#DivisionEdit").show();
    	setInterval(function(){
        	window.location.reload(); // this will run after every 5 seconds
        }, 2000);
        }
   
    });
	
   
}

</script>

           <div>
             <h3 align="center" style="color: #fb8c00">Events Page</h3>
             </div>
             <hr color="00FFFF">
             <div>
             <h5 align="center"   style="color: #fb8c00"> New Events<a data-toggle="modal"
			         data-target="#newEvent" href="#"> Add Here</a></h5>
			         <h5 align="center" id="deletemessage2" style="color:red"></h5>
            </div>        
            
 <table id="eventsList" class="display" style="width:100%">
         <thead align="center">
            <tr>
           		  <th>EventId</th>
                  <th>EventDate</th>
                  <th>OrganisedBy</th>
                  <th>TotalExpense</th>
                  <th>Delete/Edit</th>
            </tr>
        </thead>
    </table>
     
	  	<br>
	  	<br>
	  	<hr color="00FFFF">
	  	<div>
           <h3 align="center" style="color: #fb8c00">Events Listing</h3>
       </div>
       <br>
       
       <div style="display: table">
       		<div style="display: table-cell;">
              <table id="participantsList" class="display" style="width:5%">
              <tbody>
                  <thead align="center">
                   <tr>
           		    <th colspan="4">
           		    <h5  style="color: #fb8c00"> Participants<a data-toggle="modal"
			         data-target="#newParticipant" href="#"> Add Here</a></h5>
			         <h5 align="center" id="deletemessage" style="color:red"></h5>
			         </th>
                    </tr>
                 <tr>
           		  <th>TranId</th>
           		  <th>EventId</th>
                  <th>Name</th>
                  <th>Action</th>
                </tr>
        </thead>
        </tbody>
    </table>
             </div>
           <div style="display: table-cell;">
           <table id="expensesDetailsList" class="display" style="width:5%">
          <thead align="center">
          <tr>
           <th colspan="5">
           <h5  style="color: #fb8c00"> Expenses Details<a data-toggle="modal"
			data-target="#newExpenses" href="#"> Add Here</a></h5>
			 <h5 align="center" id="deletemessage1" style="color:red"></h5>
			 </th>
   
            </tr>
              <tr>
           		  <th>TranId</th>
              	  <th>Amount</th>
              	  <th>Description</th>
              	  <th>Action</th>
                
            </tr>
        </thead>
    </table>

       </div>
        <div style="display: table-cell;">
              <table id="imagesList" class="display" style="width:5%">
          <thead align="center">
          <tr>
            <th colspan="3"><h5  style="color: #fb8c00"> Images <a data-toggle="modal"
			data-target="#newImages" href="#"> Upload Here</a></h5></th>
                
            </tr>
              <tr>
           		  <th>TranId</th>
                  <th>Image</th>
              	  <th>Action</th>
                
            </tr>
        </thead>
    </table>
       </div>    
       </div>
   
   
  <div class="modal fade" id="newParticipant" role="dialog">
       <div class="modal-dialog modal-sm">
		    <div class="modal-content">
			     <div class="modal-header">
			        <div class="container">
		            <h4 align="center" style="color: #0B1907" class="modal-title" > Adding Participants</h4>
		            </div>
				    <button type="button" class="close" data-dismiss="modal">&times;</button>
			     </div>
			    <div class="alert alert-success " id="success" style="text-align:center">
  	                <strong id="successmsg" ></strong> 
	            </div>
              <form id="grade_form">
			      <div class="modal-body">
				      <div class="box-content row">
				             <div class="form-group has-warning col-md-6">
					            <label class="control-label" for="inputWarning1">Name</label> <input
						            type="text" id="participantname" name="participantname" class="form-control">
				             </div>
				      </div>
			      </div>
			      <div class="modal-footer" >
			           <div class="container" align="center">
				          <button type="button" class="btn btn-primary"  id="participant_btn"  onclick="saveParticipants()">Submit</button>
			           </div>
			      </div>
			 </form>
		</div>	
	  </div>
  </div>
	
  <div class="modal fade" id="newExpenses" role="dialog">
	  <div class="modal-dialog modal-sm">
		  <div class="modal-content">
			    <div class="modal-header">
			       <div class="container">
		           <h4 align="center" style="color: #0B1907" class="modal-title" > Adding Expenses</h4>
		           </div>
				   <button type="button" class="close" data-dismiss="modal">&times;</button>
			    </div>
			    <div class="alert alert-success " id="success" style="text-align:center">
  	               <strong id="successmsg" ></strong> 
	            </div>
                <form id="grade_form">
			      <div class="modal-body">
				     <div class="box-content row">
				        <div class="form-group has-warning col-md-6">
					      <label class="control-label" for="inputWarning1">Amount</label> <input
						     type="text" id="amount" name="amount" class="form-control">
				        </div>
				        <div class="form-group has-warning col-md-6">
					      <label class="control-label" for="inputWarning1">Item</label> <input
						     type="text" id="item" name="item" class="form-control">
				       </div>						
                       <div class="form-group has-warning col-md-6">
					      <label class="control-label" for="inputWarning1" hidden="hidden">EventId</label>
					         <input type="text" id="eventid" name="eventid"
						         class="form-control" hidden="hidden">
				       </div>
			       </div>
			    </div>
		        <div class="modal-footer" >
			         <div class="container" align="center">
				         <button type="button" class="btn btn-primary"  id="grade_btn"  onclick="saveExpenses()">Submit</button>
			         </div>
			    </div>
			 </form>
		  </div>
		</div>
	</div>
	
 <div class="modal fade" id="newImages" role="dialog">
	  <div class="modal-dialog modal-sm">
		  <div class="modal-content">
			   <div class="modal-header">
			       <div class="container">
		               <h4 align="center" style="color: #0B1907" class="modal-title" > Uploading Images</h4>
		           </div>
				   <button type="button" class="close" data-dismiss="modal">&times;</button>
			   </div>
			  <div class="alert alert-success " id="success" style="text-align:center">
  	              <strong id="successmsg" ></strong> 
	          </div>
             <form id="photo_form">
			    <div class="modal-body">
	               <h3 align="left" style="color: #fb8c00">Photo</h3>
	               <div id="wrapper" style="margin-top: 20px;">
		           <input id="fileUpload" multiple="multiple" type="file"  />
		           <div id="image-holder"></div>
	               </div>
	            </div>
	        </form>
	        <div   class="modal-footer" >
	           <div class="container" align="center">
			   <input type="submit" id="photo_submit" onclick ="saveImages()" class="btn btn-primay" >
			   </div>
	        </div>	 
         </div>
       </div>
    </div>
    
    <div class="modal fade" id="newEvent" role="dialog">
	  <div class="modal-dialog modal-lg">
		  <div class="modal-content">
			   <div class="modal-header">
			       <div class="container">
		               <h4 align="center" style="color: #0B1907" class="modal-title" >Adding events</h4>
		           </div>
				   <button type="button" class="close" data-dismiss="modal">&times;</button>
			   </div>
			  <div class="alert alert-success " id="success" style="text-align:center">
  	              <strong id="successmsg" ></strong> 
	          </div>
             <form id="photo_form">
			    <div class="modal-body">
	               <div align="left" class="box-content row"  >
		<div  class="form-group has-warning col-md-3">
		    <label data-error="wrong" data-success="right"  style="color: Blue">EventId</label>
			<input type="text" id="eventid" name="eventid" class="form-control" style="border:1px solid #696969" readonly="readonly" >
		</div>	
		
		<div  class="form-group has-warning col-md-3">
						<label data-error="wrong" data-success="right" style="color: Blue">Date</label>
						<input type="text" id="eventdate" class="form-control" style="border:1px solid #696969"  >
		</div>
		<div  class="form-group has-warning col-md-3">
						<label data-error="wrong" data-success="right" style="color: Blue">Title</label>
						<input type="text" id="title" class="form-control" style="border:1px solid #696969" >
		</div>
		<div  class="form-group has-warning col-md-3">
						<label data-error="wrong" data-success="right" style="color: Blue">OrganizedBy</label>
						<input type="text" id="organizedby" class="form-control" style="border:1px solid #696969"  >
		</div>
		</div>
		<hr color="00FFFF">
	   <div align="left" class="box-content row"  >
		  <div  class="form-group has-warning col-md-9">
		    <label data-error="wrong" data-success="right"  style="color: Blue">ProgramDetails</label>
			 <textarea rows="4" cols="10" id="programdetails"
				name="" style="border:1px solid #696969" class="form-control" style="border:1px solid #696969" >
			</textarea>
		  </div>	
		
		  <div  class="form-group has-warning col-md-3">
			<label data-error="wrong" data-success="right" style="color: Blue">TotalExpenses</label>
			<input type="text" id="totalexpenses" class="form-control"   style="border:1px solid #696969" >
		  </div>
	  </div>
	            </div>
	        </form>
	        <div   class="modal-footer" >
	           <div class="container" align="center">
			   <input type="submit" id="photo_submit" onclick ="saveEvents()" class="btn btn-primay" >
			   </div>
	        </div>	 
         </div>
       </div>
    </div>	
    
     <div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="eventmodal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div align="center">
			<div class="alert alert-success " id="DivisionEdit" style="text-align:center">
  		<strong id="DivisionStrong" ></strong> 
		</div>
			</div>
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5" > Event Edit
						form</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "divisioneditvalidation">
				<div class="modal-body mx-12">
				<div class="box-content row">
					<div  class="form-group has-warning col-md-12">
		    <label data-error="wrong" data-success="right"  style="color: Blue">EventId</label>
			<input type="text" id="editeventid" name="editeventid" class="form-control"  readonly="readonly" >
		</div>	
		
		<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" style="color: Blue">Date</label>
						<input type="text" id="editeventdate" class="form-control"   >
		</div>
		<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" style="color: Blue">TotalExpenses</label>
						<input type="text" id="edittotalexpenses" class="form-control"  >
		</div>
		<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" style="color: Blue">OrganizedBy</label>
						<input type="text" id="editorganisedby" class="form-control"   >
		</div>
					
					<div align="center">
					<button type="button"id="submitgrade" class="btn btn-primary" onclick="eventEdit()">
						Submit
					</button> 
					</div>
				</div>				
				</div>
				</form>
			</div>
		</div>
	</div>
</div>
  		<script>
    var totalFileLength, totalUploaded, fileCount, filesUploaded;
 
    //To log everything on console
    function debug(s) {
        var debug = document.getElementById('debug');
        if (debug) {
            debug.innerHTML = debug.innerHTML + '<br/>' + s;
        }
    }
 
    //Will be called when upload is completed
    function onUploadComplete(e) {
        totalUploaded += document.getElementById('files').files[filesUploaded].size;
        filesUploaded++;
        debug('complete ' + filesUploaded + " of " + fileCount);
        debug('totalUploaded: ' + totalUploaded);
        if (filesUploaded < fileCount) {
            uploadNext();
        } else {
            var bar = document.getElementById('bar');
            bar.style.width = '100%';
            bar.innerHTML = '100% complete';
            alert('Finished uploading file(s)');
        }
    }
 
    //Will be called when user select the files in file control
    function onFileSelect(e) {
        var files = e.target.files; // FileList object
        var output = [];
        fileCount = files.length;
        totalFileLength = 0;
        for (var i = 0; i < fileCount; i++) {
            var file = files[i];
            output.push(file.name, ' (', file.size, ' bytes, ', file.lastModifiedDate.toLocaleDateString(), ')');
            output.push('<br/>');
            debug('add ' + file.size);
            totalFileLength += file.size;
        }
        document.getElementById('selectedFiles').innerHTML = output.join('');
        debug('totalFileLength:' + totalFileLength);
    }
 
    //This will continueously update the progress bar
    function onUploadProgress(e) {
        if (e.lengthComputable) {
            var percentComplete = parseInt((e.loaded + totalUploaded) * 100 / totalFileLength);
            var bar = document.getElementById('bar');
            bar.style.width = percentComplete + '%';
            bar.innerHTML = percentComplete + ' % complete';
        } else {
            debug('unable to compute');
        }
    }
 
    //the Ouchhh !! moments will be captured here
    function onUploadFailed(e) {
        alert("Error uploading file");
    }
 
    //Pick the next file in queue and upload it to remote server
    function uploadNext() {
        var xhr = new XMLHttpRequest();
        var fd = new FormData();
        var file = document.getElementById('files').files[filesUploaded];
        fd.append("multipartFile", file);
        xhr.upload.addEventListener("progress", onUploadProgress, false);
        xhr.addEventListener("load", onUploadComplete, false);
        xhr.addEventListener("error", onUploadFailed, false);
        xhr.open("POST", "save-product");
        debug('uploading ' + file.name);
        xhr.send(fd);
    }
 
    //Let's begin the upload process
    function startUpload() {
        totalUploaded = filesUploaded = 0;
        uploadNext();
    }
 
    //Event listeners for button clicks
    window.onload = function() {
        document.getElementById('files').addEventListener('change', onFileSelect, false);
        document.getElementById('uploadButton').addEventListener('click', startUpload, false);
    }
</script>
 <div style="width:55%"> 
        <h1>HTML5 Ajax Multi-file Upload With Progress Bar</h1>
        <div id='progressBar' style='height: 20px; border: 2px solid green; margin-bottom: 20px'>
            <div id='bar' style='height: 100%; background: #33dd33; width: 0%'>
            </div>
        </div>
        <form style="margin-bottom: 20px">
            <input type="file" id="files" multiple style="margin-bottom: 20px"/><br/>
            <output id="selectedFiles"></output>
            <input id="uploadButton" type="button" value="Upload" style="margin-top: 20px"/>
        </form>
        <div id='debug' style='height: 100px; border: 2px solid #ccc; overflow: auto'></div>
    </div>									
 <script src="resources/validation/bootstrapValidator.min.js"></script>
 <script src="resources/dist/js/sidebarmenu.js"></script> 
 <%@include file="footer.jsp"%>
<script>
	jQuery('#eventdate').datepicker({
	    autoclose: true,
	    todayHighlight: true
	});
	
	</script>

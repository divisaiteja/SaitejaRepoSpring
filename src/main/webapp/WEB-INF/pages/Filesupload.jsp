

 <%@ include file="header.jsp" %>
<link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >
	 <script src="resources/validation/bootstrapValidator.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
function goback() {
	window.location.href ="#/transaction/" ;
}
function reseteducationform() {
	//document.getElementById("document").value="";
	$("#uploadform").trigger("reset");
	$("#uploadform").data('bootstrapValidator').resetForm();
}
function TransactiondeleteDocument() {
	$("#transactiondoc").on('click', '#deleteDocument', function() {
		var currentRow = $(this).closest("tr");
	    var tranid = currentRow.find("td:eq(0)").html(); 
	//    alert("tranid "+tranid)
	    var retVal = confirm("would you like to delete this tranid "+tranid);
	   if( retVal == true ) {
	      deletedSuccessfully(tranid);
	   } else {
	      //document.write ("User does not want to continue!");
	   }
	  
	});
	
}
function deletedSuccessfully(tranid){
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "TransactionDeleteDocuments?tranid="+tranid, //this is my servlet
	        success: function(data){  
	        	$("#deletemessage").html("Deleted SucessFully");
	        	 setInterval(function(){
	 	        	window.location.reload(); // this will run after every 5 seconds
	 	        }, 2000);
	        }
	  });
}

$("#transactiondoc").on('click','#downloadFile',function(){
	var currentRow = $(this).closest("tr");
	var tranid = currentRow.find("td:eq(0)").html();
	 window.location='TransactionDownloadDocuments?tranid='+tranid;
});
$(document).ready(function() {
	var tranid = document.getElementById("tranid").value;
	$('#transactiondoc').dataTable({
				"ajax" : {
					"url" : "AllComplianceTransactionUploadsBasedOnTranid?tranid="+ tranid,
					"dataSrc" : "",
					"type" : "GET",
				},
				"columns" : [
				        {data : "tranid"},
						{data : "idno"},
						{data : "filename"},
						{data : "flag"},
                        {
							data : null,
							className : "center",
							defaultContent : ' <input type="image" src="resources/assets/images/delete.png" id="deleteDocument" height="15" width="18"  onclick="TransactiondeleteDocument()" > <input type="image" src="resources/assets/images/download1.jpg" id="downloadFile"  height="30" width="30"  "  >'
						} 
						],
			});
});
</script>
<body>
<input type="text" value="${tranid}" id="tranid" hidden="hidden">

<h3 align="center"></h3>
<div>
<h3 align="center">
	 <a data-toggle="modal"
			data-target="#upload" data-backdrop="static" data-keyboard="false" href="#"><input type="image" src="resources/assets/images/uploadAll.png" height="100" width="100"></a>
	</h3>
	<h5 align="center" id="deletemessage" style="color:red"></h5>
</div>


<table id="transactiondoc" class="display" style="width: 100%" border="1">
		<thead>
			<tr>
				<th>TranId</th>
				<th>TransactionTranid</th>
				<th>File Name</th>
				<th>Flag</th>
				<th>Action</th>
			</tr>
		</thead>

	</table>
<!--****************************Save Upload file model box ***********************************-->
	
	<div class="modal fade" id="upload" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
			   <div class="container">
		         <h4 align="center" style="color: #0B1907" class="modal-title" > </h4>
		       </div>
				<button type="button" class="close" data-dismiss="modal" onclick="reseteducationform()">&times;</button>
			</div>
	
	        <h5 align="center" id="successmessage" style="color:blue"></h5>
       <form id="uploadform" >
      
			<div class="modal-body">
				<div class="box-content row"  >
				 <div class="container" align="center">
				<div class="form-group has-warning col-sm-5">
				<label class="control-label" for="inputWarning1">Choose
					File:</label> <input type="file" id="document" name="document"  multiple="multiple" class="form-control">
			</div>
			</div>
			</div>
			</div>
			
			<div class="modal-footer" >
			 <div class="container" align="center">
				  <button type="button"  class="btn btn-primary"  id="uploadbtn" >Submit</button> 
			</div> 
			</div>
			</form>
		</div>
		</div>
	</div>
	<div align="center"> 
		<input type="submit" value ="GoBack" class="btn btn-success"  onclick="goback()"  >
		</div>
</body>
<!-- <script>
function saveUpload() {
	//alert("saveUpload")
	var tranid = document.getElementById("tranid").value;
//	alert("tranid   "+tranid);
	var file = document.getElementById("document").files[0];
	//alert("file "+file );
	var formdata = new FormData();
	formdata.append("file", file);
	$.ajax({
		type : "post",
		url : "TransactionstoreDocuments?tranid=" + tranid, // this controller url
		data : formdata,
		processData : false,
		contentType : false,
		success : function(data) {
			$("#successmessage").html(" Sucessfully Stored Files");
       	      setInterval(function(){
	        	window.location.reload(); // this will run after every 5 seconds
	        }, 2000);
			
		}

	});

}
</script> -->
<script>
function saveUpload() {
	alert("saveUpload")
	var tranid = document.getElementById("tranid").value;
	alert("tranid   "+tranid);
	var formdata = new FormData();
	 var totalFiles = document.getElementById("document").files.length;
	for (var i = 0; i < totalFiles; i++)
    {
     var  multiplefilesupload = document.getElementById("document").files[i];
     formdata.append("multiplefilesupload", multiplefilesupload);
    }  
	
	$.ajax({
		type : "post",
		url : "TransactionstoreDocuments?tranid=" + tranid, // this controller url
		data : formdata,
		processData : false,
		contentType : false,
		success : function(data) {
			$("#successmessage").html(" Sucessfully Stored Files");
       	      setInterval(function(){
	        	window.location.reload(); // this will run after every 5 seconds
	        }, 2000);
			
		}

	});

}
</script>
	<script>
 $('#uploadform').bootstrapValidator({
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields : {
 				document : {
 					validators : {
 						notEmpty : {
 							message : 'Select a valid file to upload'
 						},
 						file : {
 							extension : 'pdf,jpeg,png,jpg',
 							type : 'application/pdf,image/jpeg,image/png,image/jpg',
 							maxSize : 2048 * 1024,
 							message : 'The selected files only jpeg or png or jpg or pdf is valid'
 						}
 					}
 				},

 			}
         });
        $("#uploadbtn").click(function(){
$('#uploadform').data('bootstrapValidator').validate();
if($('#uploadform').data('bootstrapValidator').isValid()){
	saveUpload();
}
});
</script>
	<script src="resources/validation/bootstrapValidator.min.js"></script>
<script src="resources/dist/js/sidebarmenu.js"></script>
</html>
 <!-- <script >
var message = "right click disabled";

function rtclickcheck(keyp){ if (navigator.appName == "Netscape" && keyp.which == 3){ alert(message); return false; }

if (navigator.appVersion.indexOf("MSIE") != -1 && event.button == 2) { alert(message); return false; } }

document.onmousedown = rtclickcheck;
</script>  -->
<%@ include file="footer.jsp" %> 
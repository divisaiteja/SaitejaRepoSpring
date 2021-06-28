<%@include file="header.jsp" %>
 <link rel="stylesheet" href="resources/bootstrapCSS/datepicker.css" />
      <script src="resources/customjs/bootstrap-datepicker.js"></script> 
<style>
.mycustom{


}




</style>

  <script>
function getAttendence(){
	 var str =document.getElementById("date1").value;
	  var month = str.substring(0, 2);
	   var subdate = str.substring(3, 5);
	   var year = str.substring(6, 10);
	   var date=year+"-"+month+"-"+subdate;
	 //  alert(date);
  $(document).ready(function() {
  //var date=document.getElementById("date1").value;
  	$.ajax({
         type: "GET",
         contentType : "application/json",
         url: "/DASHBOARD/validateAttendence?date="+date, //this is my servlet
           success: function(data){ 
 	     	var json=data;
         	 var tr;
         	 var ele='<option value="">select</option>';
         		 for (var i = 0; i < json.length; i++) {
         			 if(json[i].inpunchcount!=json[i].outpunchcount){
         				tr = $('<tr style="background-color: #f38b8b"/>');
         			 }
         			 else{
         				tr = $('<tr/>');
         			 }
              //    alert(json[i].employee.employeeName)
                   tr.append("<td>" + json[i].employee.idNumber + "</td>");
                   tr.append("<td>" + json[i].shifts.name + "</td>");
                   tr.append("<td>" + json[i].employee.employeeName + "</td>");
                   tr.append("<td>" + json[i].attendid + "</td>");
                   tr.append("<td>" + json[i].employee.design + "</td>");
                   tr.append("<td>" + json[i].departments.name + "</td>");
                   tr.append("<td>" + json[i].inpunchcount + "</td>");
                   tr.append("<td>" + json[i].outpunchcount + "</td>");
                   tr.append("<td>" + json[i].duration + "</td>");
                   tr.append("<td>" + json[i].overtime + "</td>");
                   tr.append("<td><input type='image' src='resources/assets/images/edit-icon.png' height='20' width='20'  id='attid' ></td>");
//                  
//                   tr.append("<td>" + json[i].attdate + "</td>");
//                   tr.append("<td>" + json[i].punchstatus + "</td>");
//                   if(json[i].punchstatus=="DL"){
//              	   tr.append("<td>" + "----------" + "</td>");
//                 }
//                 else{
//                   tr.append("<td>" + "<select name='sweets' id='sravan'>"+ele+"</select>" + "</td>");
//                 }                
                  $('table').append(tr);
              }
         	
         }
  });			
  } );
  
}
  $( function() {
    $( "#date1" ).datepicker({
    	 dateFormat:"dd-mm-yy", 
    	      
    });
   
  } );
  
  function govalidateAtt(){
	  var str =document.getElementById("date1").value;
	  var month = str.substring(0, 2);
	   var subdate = str.substring(3, 5);
	   var year = str.substring(6, 10);
	   var date=year+"-"+month+"-"+subdate;
	  validateAtt(date)
  }
  
  
  </script>
  <script>
  
 
  
//   function showmenudata1()
//   {
//       if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete")
//       {
//           $("#showattendenceData").html(xmlHttp.responseText);

//          // var val=xmlHttp.responseText;  
//          // document.getElementById('showattendenceData').innerHTML=val; 
//       }
//   }
  </script>
</head>
<body>
 
Attendence For:<input type="text" id="date1"> 
<input type="submit" value="Check" onclick="submit()" style="background-color: blue;color:white	">
 <script src="resources/dist/js/sidebarmenu.js"></script>
 
<%@include file="footer.jsp" %>
<script>
function submit(){
var date=document.getElementById("date1").value;
// date=date.split('/').join('-');
// var str=date.split('/').join('-');
// var month = str.substring(0, 2);
// var subdate = str.substring(3, 5);
// var year = str.substring(6, 10);
// var date=year+"-"+month+"-"+subdate;
//alert(date);
//alert(date+">>>>>");
window.location.href='#/attendance/'+date;
}
</script>
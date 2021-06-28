<%@include file="header.jsp" %>
<script type="text/javascript" src="resources/customjs/leave.js"></script> 
<!-- <script>
function loads(){
	 alert("hi");
	 var addpermission=1;
	 if (addpermission==0){
		 document.getElementById('addLeave').style.dispaly = 'block';
		 }else{
			 document.getElementById('addLeave').style.display = 'none';
			 }
	 alert(addpermission+" - "+ document.getElementById('addLeave').style.dispaly);
	
	  
var y = document.getElementById("editLeave");
if (y.style.display === "none") {
  y.style.display = "block";
} else {
  y.style.display = "none";
}
var z = document.getElementById("deleteleave");
if (z.style.display === "none") {
  z.style.display = "block";
} else {
  z.style.display = "none";
}
}
</script> -->
 
<style>
th
{
	background-color:green;
	color:white;
	}
	</style>



<table id="leaveposting" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		 <th>SNo</th>
                <th>IdNO</th>
                <th>Code</th>
                <th>Name</th>
                <th>Desg</th>
                <th>Dept</th>
              	<th>Action</th>
                
            </tr>
        </thead>
       
    </table>
    
    
     <!-- Modal -->
          <div id="a">
     
  
  </div>
        	    <script src="resources/dist/js/sidebarmenu.js"></script>
  
  <%@include file="footer.jsp"%>
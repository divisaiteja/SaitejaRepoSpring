<%@include file="header.jsp" %>

<script>
$(document).ready(function() {
	var divisionid;
	var currendData;
	$.ajax({
		
	    type: "GET",
	    contentType : "application/json",
	    url: "/DASHBOARD/getdivisions?divisionid=" + $('#divisionid').val(), //this is my servlet
	    success: function(data){ 
	    	console.log(data);
	    	currendData = data;
	    	$("#divisionid").val(data.divisionid);
	    	$("#address").val(data.address);
	    	$("#name").val(data.name);
	    	$("#city").val(data.city);
	    	$("#statecode").val(data.statecode);
	    	$("#pannumber").val(data.pannumber);
	    	$("#gstn").val(data.gstn);
	    	$("#emailid").val(data.emailid);
	    	$("#contactno").val(data.contactno);
	    	$("#estddate").val(data.estddate);
	    	$("#regionid").val(data.regionid);
	    	$("#zoneid").val(data.zoneid);
	    	$("#areaid").val(data.areaid);
	    	$("#serialno").val(data.serialno);
	    	$("#parentid").val(data.parentid);
	    	$("#statusCodeForActive").val(data.isactive);
	    }
	});
});

</script>

<script>
function divisionEdit(){
	alert(" divisionEdit")
	var divisionEdit = {};
	divisionEdit["divisionid"] = $("#divisionid").val();
	 divisionEdit["name"] = $("#name").val();
     divisionEdit["address"]=$("#address")
	/*divisionEdit["city"] = $("#city").val();
	divisionEdit["statecode"]=$("#statecode")
	divisionEdit["pannumber"] = $("#pannumber").val();
	divisionEdit["gstn"] = $("#gstn").val();
	divisionEdit["emailid"] = $("#emailid").val();
	divisionEdit["contactno"] = $("#contactno").val();
	divisionEdit["estddate"] = $("#estddate").val();
	divisionEdit["regionid"] = $("#regionid").val();
	divisionEdit["zoneid"] = $("#zoneid").val();
	divisionEdit["areaid"] = $("#arreaid").val();
	divisionEdit["serialno"] = $("#serialno").val();
	divisionEdit["parentid"] = $("#parentid").val();
	divisionEdit["isactive"] = $("#statusCodeForActive").val(); */
   var name=document.getElementById("name").value;
	alert(name)
	 var address=document.getElementById("address").value;
	alert(address)
	
     $.ajax({
        type: "post",
        contentType : "application/json",
        url: "editDivision", 
        data : JSON.stringify(divisionEdit),
        success: function(data){  
        	alert("updated suessfull")
        	
        	division(); 
        }
   
    });
	
   
}

</script>

<%
int divisionid=Integer.parseInt(request.getParameter("divisionid"));

%><div>
<br>
<h3 align="center" style="color:#fb8c00">Edit Division</h3>
<br>
				<div class="box-content row">
						<div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">DivisionId</label> 
							<input type="text"  name="gradeno" id="divisionid"  value="<%out.println(divisionid); %>" class="form-control"
							readonly="readonly"	>

						</div>
						 <div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">Name
								</label> <input type="text"  id="name"
								class="form-control" >

						</div>
						 <div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">Address
								</label> <input type="text"  id="address"
								class="form-control" >

						</div>
						<!--  <div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">City
								</label> <input type="text"  id="city"  
								class="form-control" >

						</div>
						 <div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">State Code
								</label> <input type="text"  id="statecode"  
								class="form-control" >

						</div>

						 <div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">PAN Number
								</label> <input type="text"  id="pannumber"
								class="form-control" >

						</div>
						<div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">GST NO
								</label> <input type="text"  id="gstn" 
								class="form-control" >

						</div>
						
						<div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">EmailiID
								</label> <input type="text"  id="emailid" 
								class="form-control" >

						</div>
						
						<div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">ContactNumber
								</label> <input type="text"  id="contactno" 
								class="form-control" >

						</div>
						 <div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">EstablishDate
								</label> <input type="date"  id="estddate"  
								class="form-control" >

						</div>
						 <div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">RegionId
								</label> <input type="text"  id="regionid"  
								class="form-control" >

						</div>
						 <div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">AreaId
								</label> <input type="text"  id="areaid"  
								class="form-control" >

						</div>
						 <div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">ZoneId
								</label> <input type="text"  id="zoneid"  
								class="form-control" >

						</div>
						 <div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">SerialNo
								</label> <input type="text"  id="serialno"  
								class="form-control" >

						</div>
						 <div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">ParentId
								</label> <input type="text"  id="parentid"  
								class="form-control" >

						</div>
						

						<div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">Status
								</label> <input type="text"  id="statusCodeForActive" class="form-control"
								>

						</div>

 -->

					
						</div>
						
		
		<div align="center">
		<input type="submit" class="btn btn-success" onclick="divisionEdit()"  >
		<input type="submit" class="btn btn-success" onclick="division()" value="back" >
		</div>
		</div>
		<%@include file="footer.jsp" %>
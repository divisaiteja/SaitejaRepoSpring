<%@include file="header.jsp"%>
<link rel="stylesheet"
	href="resources/dist/css/icons/font-awesome/css/fontawesome.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/validation/validation.css">
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="com.hrms.utitlities.DBUtil"%>
<style>
.search-table-outter {
	overflow-x: scroll;
}
</style>
<script>

function saveIncrements() {	
	var saveIncrementsDetails = {};
	saveIncrementsDetails["wef"] = $("#wef").val();
	saveIncrementsDetails["divisionid"] = $("#divisionid").val();
	saveIncrementsDetails["cadreid"] = $("#cadreid").val();
	saveIncrementsDetails["jobstatusid"] = $("#jobstatusid").val();
	saveIncrementsDetails["gradeno"] = $("#gradeId").val();
	saveIncrementsDetails["designation"] = $("#designation").val();
	saveIncrementsDetails["basic"] = $("#basic").val();
	saveIncrementsDetails["da"] = $("#da").val();
	saveIncrementsDetails["hra"] = $("#hra").val();
	saveIncrementsDetails["conveyance"] = $("#conveyance").val();
	saveIncrementsDetails["others1"] = $("#others1").val();
	//saveIncrementsDetails["others2"] = $("#others2").val();   
	saveIncrementsDetails["lta"] = $("#lta").val();
	saveIncrementsDetails["medical"] = $("#medical").val();
	saveIncrementsDetails["bonus"] = $("#bonus").val();
	saveIncrementsDetails["grosssalary"] = $("#grosssalary").val();
	saveIncrementsDetails["ctc"] = $("#ctc").val();
	saveIncrementsDetails["pfpercentage"] = $("#pfpercent").val();
	saveIncrementsDetails["pfamount"] = $("#pfamount").val();
	saveIncrementsDetails["remarks"] = $("#remarks").val();
	saveIncrementsDetails["idno"] = $("#idnumber").val();
    saveIncrementsDetails["tranid"] = $("#incrtranid").val();
	var checkBox = document.getElementById("ispromoted1").checked;
	if (checkBox){
		   saveIncrementsDetails["ispromoted"] = "1";  
	   } else {
		   saveIncrementsDetails["ispromoted"] = "0";  
	   }
	var checkBox1 = document.getElementById("isannualincrement1").checked;
	if (checkBox1){
		   saveIncrementsDetails["isannualincrement"] = "1";  
	   } else {
		   saveIncrementsDetails["isannualincrement"] = "0";  
	   }
	var checkBox2 = document.getElementById("ishold1").checked;
	if (checkBox2){
		   saveIncrementsDetails["ishold"] = "1";  
	   } else {
		   saveIncrementsDetails["ishold"] = "0";  
	   }
	var checkBox3 = document.getElementById("isedited1").checked;
	if (checkBox3){
		   saveIncrementsDetails["isedited"] = "1";  
	   } else {
		   saveIncrementsDetails["isedited"] = "0";  
	   }
	
		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "saveIncrementsDetails", // this is my servlet
			data : JSON.stringify(saveIncrementsDetails),
			success : function(data) {
		        	window.location.reload(); // this will run after every 5 seconds
			}
		});
	}

function diffCalc(){

	document.getElementById("dbasic").value=parseInt($("#basic").val())-parseInt($("#pbasic").val());
	document.getElementById("dda").value=parseInt($("#da").val())-parseInt($("#pda").val());
	document.getElementById("dhra").value=parseInt($("#hra").val())-parseInt($("#phra").val());
	document.getElementById("dconveyance").value=parseInt($("#conveyance").val())-parseInt($("#pconveyance").val());
	document.getElementById("dothers1").value=parseInt($("#others1").val())-parseInt($("#pothers1").val());
	document.getElementById("dothers2").value=parseInt($("#others2").val())-parseInt($("#pothers2").val());
	document.getElementById("dgrosssalary").value=parseInt($("#grosssalary").val())-parseInt($("#pgrosssalary").val());
	document.getElementById("dlta").value=parseInt($("#lta").val())-parseInt($("#plta").val());
	document.getElementById("dmedical").value=parseInt($("#medical").val())-parseInt($("#pmedical").val());
	document.getElementById("dbonus").value=parseInt($("#bonus").val())-parseInt($("#pbonus").val());
	document.getElementById("dpfamount").value=parseInt($("#pfamount").val())-parseInt($("#ppfamount").val());
	document.getElementById("dctc").value=parseInt($("#ctc").val())-parseInt($("#pctc").val());
	

}

function salaryCalcBasedonGrossSalary(){
	var idnumber = document.getElementById("idnumber").value;
	var grosssalary = document.getElementById("grosssalary").value;
	$.ajax({
		type : "post",
		url : "salaryCalculationBasedonGrossSalaryInAppraisals?idnumber=" + idnumber+"&&grosssalary="+grosssalary, // this controller url
		processData : false,
		contentType : false,
		success : function(data) {
			document.getElementById("basic").value=data.dataBean["basic"];
			document.getElementById("da").value=data.dataBean["da"];
			document.getElementById("hra").value=data.dataBean["hra"];
			document.getElementById("conveyance").value=data.dataBean["conveyance"];
			document.getElementById("lta").value=data.dataBean["lta"];
			document.getElementById("medical").value=data.dataBean["medical"];
			document.getElementById("bonus").value=data.dataBean["bonus"];
			document.getElementById("others1").value=data.dataBean["otherallowance"];
			document.getElementById("pfamount").value=data.dataBean["pf"];                                        
			document.getElementById("ctc").value=data.dataBean["ctc"];		
			document.getElementById("pfpercent").value= data.dataBean["pfpercent"];
		}
	});
}



</script>

<script>
$(document).ready(function() {
    document.getElementById("basic").disabled = true;
	document.getElementById("hra").disabled = true;
	document.getElementById("da").disabled = true;
	document.getElementById("lta").disabled = true;
	document.getElementById("medical").disabled = true;
	document.getElementById("others1").disabled = true;
	document.getElementById("others2").disabled = true;
	document.getElementById("pfamount").disabled = true;
	document.getElementById("ctc").disabled = true;
	document.getElementById("bonus").disabled = true;
	document.getElementById("conveyance").disabled = true;
});
</script>
<script>
$(document).ready(function() {
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

$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallDivision", // this is my servlet

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('divisionid');
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
        url: "getalljobstatus", //this is my servlet
      
        success: function(data){ 
        	var abc=data;
        	var ele = document.getElementById('jobstatusid');
            for (var i = 0; i < abc.length; i++) {
                // POPULATE SELECT ELEMENT WITH JSON.
                ele.innerHTML = ele.innerHTML +
                    '<option value="' + abc[i]["jobstatusid"] + '">' + abc[i]["description"] + '</option>';
            }
        	
        }
 });
});

	</script>
	<script>
	$(document).ready(function() {				
		  var tranid = document.getElementById("tranid").value;
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "/HRMS/getEmpInfoByTranid?tranid="+ tranid,										
				success : function(data) {
				document.getElementById("empname").value = data[0]["employeeName"];
				document.getElementById("design").value = data[0]["design"];
				$("#workdeptname").val(data[0].hrDepartmentMaster.name); 
				document.getElementById("idnumber").value = data[0]["idNumber"]; 
				document.getElementById("divisionid").value = data[0]["workingDivisionId"];
				document.getElementById("gradeId").value = data[0]["gradeId"];
				document.getElementById("cadreid").value = data[0]["cadreId"];
				document.getElementById("jobstatusid").value = data[0]["jobStatus"];
			}
		});
		});
	
</script>
<input type="text" value="${tranid}" id="tranid" hidden="hidden">	
<input type="text" value="${idNumber}" id="idNumber" hidden="hidden">
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3" align="right"></div>
		<div class="col-md-6">
			<h3 align="center" style="color: #fb8c00">Employee Increments/Promotions </h3>
		</div>
		
	</div>
	
</div>	
<hr color="00FFFF">
<div class="box-content row">

			<div class="form-group has-warning col-md-3">
				<label style="color: Blue" class="control-label" for="inputWarning1">IdNo</label> <input
					type="text" name="" id="idnumber"
					 class="form-control"
					readonly="readonly">
                                    
			</div>


			<div class="form-group has-warning col-md-3">
				<label  style="color: Blue" class="control-label" for="inputWarning1">Name</label> <input
					type="text" name="" id="empname" class="form-control"
					readonly="readonly">

			</div>



			<div class="form-group has-warning col-md-3">
				<label style="color: Blue" class="control-label" for="inputWarning1">
					Designation</label> <input type="text" name="design" id="design"
					class="form-control" readonly="readonly">

			</div>

			<div class="form-group has-warning col-md-3">
				<label style="color: Blue"  class="control-label" for="inputWarning1">Department</label>
				<input type="text" id="workdeptname"  name="workdeptname" class="form-control"
					readonly="readonly">

			</div>
			
			
		</div>
<br>
<br>
<div>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3">
			<h3 align="left" style="color: #fb8c00">Promotion Details</h3>
		</div>
		</div>
	</div>
	<div class="row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-content row">
			<div class="form-group has-warning col-md-3">
					<label  style="color: Blue"  class="control-label" for="inputWarning1">WithEffectFrom</label><br>
					<input type="text" name="wef" id="wef" class="form-control">
			</div>
			<div class="form-group has-warning col-md-3">
				 <label style="color: Blue"  class="control-label" for="inputWarning1">Division</label> 
				<select  id="divisionid" class="form-control">
		
                 </select>
			</div>
				<div class="form-group has-warning col-md-3">
					<label style="color: Blue" class="control-label" for="inputWarning1">Grade
						</label> <select class="form-control" id="gradeId" name="gradeId " >
						
					</select>
			</div>
			<div class="form-group has-warning col-md-3">
					<label  style="color: Blue"  class="control-label" for="inputWarning1">Cadre</label><br>
					<select class="form-control" id="cadreid" name="cadreid">
					
					</select>
			</div>
			<div class="form-group has-warning col-md-3">
					<label style="color: Blue" class="control-label" for="inputWarning1">JobStatus
						</label> <select class="form-control" id="jobstatusid" name="jobstatusid " >
				
					</select>
			</div>
			<div class="form-group has-warning col-md-3">
					<label  style="color: Blue"  class="control-label" for="inputWarning1">Designation</label><br>
					<input type="text" name="designation" id="designation" class="form-control">
			</div>
			<div class="form-group has-warning col-md-3">
					<label  style="color: Blue"  class="control-label" for="inputWarning1">Remarks</label><br>
					<input type="text" name="remarks" id="remarks" class="form-control">
			</div>
			</div>
			<div class="box-content row">
			<div class="form-group has-warning    col-md-3">
					<label class="control-label" for="inputWarning1">IsPromoted</label> 
					<label> <input type="checkbox" id="ispromoted1" name="ispromoted1"></label><br>
			</div>
			<div class="form-group has-warning    col-md-3">
					<label class="control-label" for="inputWarning1">IsAnnualIncrement</label> 
					<label> <input type="checkbox" id="isannualincrement1" name="isannualincrement1"></label><br>
			</div>
			<div class="form-group has-warning    col-md-3">
					<label class="control-label" for="inputWarning1">IsHold</label> 
					<label> <input type="checkbox" id="ishold1" name="ishold1"></label><br>
			</div>
			<div class="form-group has-warning    col-md-3">
					<label class="control-label" for="inputWarning1">IsEdited</label> 
					<label> <input type="checkbox" id="isedited1" name="isedited1"></label><br>
			</div>				
		</div>
		</div>
	</div>
</div>
<br>
<br>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3">
			<h3 align="left" style="color: #fb8c00">Increment Details</h3>
		</div>
		</div>
	</div>
	<br>
	<%
	
Connection con = DBUtil.getConnection();
Statement stm = null;
ResultSet rs = null;
String sql = null;
stm=con.createStatement();
sql="INSERT INTO hr_increments (idno,p_divisionid,p_cadreid,p_jobstatusid,p_gradeno,p_desgn,tmon,tyear,p_wef,p_basic,p_da,p_hra,p_conveyance,p_others1,p_others2,p_lta,p_medical,p_pfpercentage,p_pfamount,p_bonus,p_grosssalary,p_ctc,docstatus,enteredon,wef)" +  
 "SELECT e.idno ,e.workingdivisionid,e.cadreid,e.jobstatus,e.gradeid,e.desgn,month(sysdate()),year(sysdate()),r.wef,r.basic,r.da,r.hra,r.conveyance,r.others1,r.others2,r.lta,r.medical,r.pfpercentage,r.pfamount,r.bonus,r.grosssalary,r.ctc,'FR', sysdate(),date_add(r.wef,interval 1 year) " +
"FROM hr_empmaster e,hr_rateofpay r where e.idno=r.idno and e.idno="+request.getParameter("idNumber") + " and (e.idno not in (select idno from hr_increments inc where docstatus<>'AU' and  docstatus<>'RJ'))";

stm.executeUpdate(sql);

sql="select  * from hr_increments where idno= " + request.getParameter("idNumber") ;
rs=stm.executeQuery(sql);

	%>
<div class="search-table-outter wrapper">
<table id="incrementsandpromotions" class="display" style="width:100%" border="1">

        <thead>
            <tr style="background-color: lightblue;color:black" align="center">
                <th></th>
           		<th>Basic</th>
                <th>Da</th>
                <th>Hra</th>
                <th>Conveyance</th>
                <th>Others-1</th>
                <th>Others-2</th>
                <th>Gross</th>
              	<th>Lta</th>
              	<th>Medical</th>
              	<th>Bonus</th>
                <th>PfAmount</th>
              	<th>Ctc</th>
                
            </tr>
            
            <%if(rs.next()){ %>
               <%if(rs.getInt("ispromoted")==1){ %>
                    <script>
                    $("#ispromoted1").attr("checked","checked");   
                    </script>
               <%}%>
               <%if(rs.getInt("isedited")==1){ %>
                    <script>               
                    $("#isedited1").attr("checked","checked");   
                    </script>                    
               <%}%>
               <%if(rs.getInt("ishold")==1){ %>
                    <script>               
                    $("#ishold1").attr("checked","checked");   
                    </script>                    
               <%}%>
               <%if(rs.getInt("isannualincrement")==1){ %>
                    <script>               
                    $("#isannualincrement1").attr("checked","checked");   
                    </script>                    
               <%}%>
               
             <tr align="center">
                <td>Existing</td>
           		<td><input type="text" name="pbasic" id="pbasic" readonly="readonly" style="text-align:center" value="<%=rs.getString("p_basic") %>">
                        <input type="text" id="incrtranid" value="<%=rs.getInt("tranid")  %>" hidden="hidden"></td>
                <td><input type="text" name="pda" id="pda"  readonly="readonly" style="text-align:center" value="<%=rs.getString("p_da") %>"></td>
                <td><input type="text" name="phra" id="phra"  readonly="readonly" style="text-align:center" value="<%=rs.getString("p_hra") %>"></td>
                <td><input type="text" name="pconveyance" id="pconveyance"  readonly="readonly" style="text-align:center" value="<%=rs.getString("p_conveyance") %>"></td>
                <td><input type="text" name="pothers1" id="pothers1"  readonly="readonly" style="text-align:center" value="<%=rs.getString("p_others1") %>"></td>
                <td><input type="text" name="pothers2" id="pothers2"  readonly="readonly" style="text-align:center" value="<%=rs.getString("p_others2") %>"></td>
                <td><input type="text" name="pgrosssalary" id="pgrosssalary"  readonly="readonly" style="text-align:center" value="<%=rs.getString("p_grosssalary") %>"></td>
                <td><input type="text" name="plta" id="plta"  readonly="readonly" style="text-align:center" value="<%=rs.getString("p_lta") %>"></td>
                <td><input type="text" name="pmedical" id="pmedical"  readonly="readonly" style="text-align:center" value="<%=rs.getString("p_medical") %>"></td>
                <td><input type="text" name="pbonus" id="pbonus"  readonly="readonly" style="text-align:center" value="<%=rs.getString("p_bonus") %>"></td>
                <td><input type="text" name="ppfamount" id="ppfamount"  readonly="readonly" style="text-align:center" value="<%=rs.getString("p_pfamount") %>"></td>
                <td><input type="text" name="pctc" id="pctc"  readonly="readonly" style="text-align:center" value="<%=rs.getString("p_ctc") %>"></td>
            </tr>
            
          
            
            <tr align="center">
                <td>Revised</td>
           		<td><input type="text" name="basic" id="basic" readonly="readonly" style="text-align:center" value="<%=rs.getString("basic") %>"></td>
                <td><input type="text" name="da" id="da"  readonly="readonly" style="text-align:center" value="<%=rs.getString("da") %>"></td>
                <td><input type="text" name="hra" id="hra"  readonly="readonly" style="text-align:center" value="<%=rs.getString("hra") %>"></td>
                <td><input type="text" name="conveyance" id="conveyance"  readonly="readonly" style="text-align:center" value="<%=rs.getString("conveyance") %>"></td>
                <td><input type="text" name="others1" id="others1" readonly="readonly" style="text-align:center" value="<%=rs.getString("others1") %>"></td>
                <td><input type="text" name="others2" id="others2"  readonly="readonly" style="text-align:center" value="<%=rs.getString("others2") %>"></td>
                <td><input type="text" name="grosssalary" id="grosssalary"  style="text-align:center" onchange="salaryCalcBasedonGrossSalary()" value="<%=rs.getString("grosssalary") %>"></td>
                <td><input type="text" name="lta" id="lta"  readonly="readonly" style="text-align:center" value="<%=rs.getString("lta") %>"></td>
                <td><input type="text" name="medical" id="medical"  readonly="readonly" style="text-align:center" value="<%=rs.getString("medical") %>"></td>
                <td><input type="text" name="bonus" id="bonus"  readonly="readonly" style="text-align:center" value="<%=rs.getString("bonus") %>"></td>
                <td><input type="text" name="pfamount" id="pfamount" readonly="readonly" style="text-align:center" value="<%=rs.getString("pfamount") %>"></td>
                <td><input type="text" name="ctc" id="ctc" readonly="readonly" style="text-align:center" value="<%=rs.getString("ctc") %>"></td>
                <td><input type="hidden" name="pfpercent" id="pfpercent" readonly="readonly" style="text-align:center" value="<%=rs.getString("pfpercentage") %>"></td>
                
            </tr>
            <%} %>
             <tr>
                <td>Increment</td>
           		<td><input type="text" name="dbasic" id="dbasic" readonly="readonly" style="text-align:center"></td>
                <td><input type="text" name="dda" id="dda"  readonly="readonly" style="text-align:center"></td>
                <td><input type="text" name="dhra" id="dhra"  readonly="readonly" style="text-align:center"></td>
                <td><input type="text" name="dconveyance" id="dconveyance"  readonly="readonly" style="text-align:center"></td>
                <td><input type="text" name="dothers1" id="dothers1" readonly="readonly" style="text-align:center" ></td>
                <td><input type="text" name="dothers2" id="dothers2"  readonly="readonly" style="text-align:center"></td>
                <td><input type="text" name="dgrosssalary" id="dgrosssalary"  style="text-align:center"></td>
                <td><input type="text" name="dlta" id="dlta"  readonly="readonly" style="text-align:center"></td>
                <td><input type="text" name="dmedical" id="dmedical"  readonly="readonly" style="text-align:center"></td>
                <td><input type="text" name="dbonus" id="dbonus"  readonly="readonly" style="text-align:center"></td>
                <td><input type="text" name="dpfamount" id="dpfamount" readonly="readonly" style="text-align:center"></td>
                <td><input type="text" name="dctc" id="dctc" readonly="readonly" style="text-align:center"></td>
            </tr>
        </thead>
</table>
</div>
<br>
<br>
  <div align="center">
      <input type="submit"  value="Submit" onclick="saveIncrements()" style="background-color: blue;color:white"	class="btn btn-primary"   > &nbsp&nbsp<input type="submit"  value="CalcIncDiff" onclick=" diffCalc()" style="background-color: blue;color:white"	class="btn btn-primary"   >
 </div>
</div>	
<script src="resources/dist/js/sidebarmenu.js"></script> 
<%@include file="footer.jsp"%>
<script>
	jQuery('#wef').datepicker({
	    autoclose: true,
	    todayHighlight: true
	});
	
	</script>
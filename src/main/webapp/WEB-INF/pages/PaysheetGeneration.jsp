<%@include file="header.jsp"%>
<script src="https://cdn.datatables.net/fixedcolumns/3.2.6/js/dataTables.fixedColumns.min.js"></script>
<style>

</style>
<script>
$(document).ready(function() {
	var tmonth=$("#tmonth").val();
	var tyear=$("#tyear").val();
	var division=$("#division").val();
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "paysheetcaluculation?tmonth="+tmonth+"&&tyear="+tyear+"&&division="+division, //this is my servlet
		success : function(data, textStatus, jqXHR) {
			var table_data = data.dataBean;
			// //alert(table_data[punchcod]);
			var table = $('#EmployeeMonthpayDetails').DataTable(
							{
								"destroy" : true,
								data : table_data,
								
								//dataSrc:data,
								//"dataSrc" : "data",
								columns : [
										{data :"idno"},
										{data :"empname"},
										{data :"mondays"},
										{data : "lopdays"},
										{data :"paiddays"},
										{data :"wef"},                                                                                
										{data :"basic"},
										{data :"da"},
										{data :"hra"},
										{data :"conveyance"},
										{data :"otherearnings1"},
										{data :"otherearnings2"},
										{data :"lta"},
										{data :"medical"},
										{data :"bonus"},
										{data :"grossearnings"},
										{data :"pfamount"},
										{data :"esiamount"},
										{data :"salaryadvance"},
										{data :"otherdeduction1"},
										{data :"otherdeduction2"},
										{data :"mobilededuction"},
										{data :"mediclaim"},
										{data :"vpfamount"},
										{data :"lic"},
										{data :"loanamount"},
										{data :"ptax"},
										{data :"canteencharges"},
										{data :"touradvance"},
										{data :"powercharges"},
										{data :"clubfund"},
										{data :"unionfund"},
										{data :"personaltripcharges"},
										{data :"itax"},
										{data :"welfareallowance"},
										{data :"grossdeductions"},
									        {data :"netamount"},
										{data :"rbasic"},
										{data :"rda"},
										{data :"rconveyance"},
										{data :"rlta"},
										{data :"rmedical"},
										{data :"rotherallowance1"},
										{data :"rotherallowance2"},
										{data :"isarrearsrecord"},
										{data :"remarks"}
										
										 ],
							//  searching : false
							scrollY:        "300px",
        					scrollX:        true,
        					scrollCollapse: true,
							fixedColumns:   {
            					leftColumns: 1,
            					leftColumns: 2
            					
        							}
							});
		}
	});

});	

</script>

<input type="text" value="${tyear}" id="tyear" hidden="hidden">
<input type="text" value="${tmonth}" id="tmonth" hidden="hidden">
<input type="text" value="${division}" id="division" hidden="hidden">
<h3 align="center">SALARIES FOR THE MONTH OF ${tmonth}-${tyear}</h3>
		<table id="EmployeeMonthpayDetails" class="display" style="width: 100%"
			border="1">
			<thead>
				<tr>
					
					<th>IdNo</th>
					<th>Name</th>
					<th>Mondays</th>
					<th>LopDays</th>
					<th>PaidDays</th>
					<th>Wef</th>                                        
					<th>Basic</th>
					<th>Da</th>
					<th>Hra</th>
					<th>Conveyance</th>
					<th>Otherearnings1</th>
					<th>Otherearnings2</th>
					<th>Lta</th>
					<th>Medical</th>
					<th>Bonus</th>
					<th>GrossEarnings</th>
					<th>PfAmount</th>
					<th>EsiAmount</th>
					<th>SalaryAdvance</th>
					<th>Otherdeduction1</th>
					<th>Otherdeduction2</th>
					<th>MobileDeduction</th>
					<th>Mediclaim</th>
					<th>VpfAmount</th>
					<th>Lic</th>
					<th>LoanAmount</th>
					<th>Ptax</th>
					<th>CanteenCharges</th>
					<th>Touradvance</th>
					<th>PowerCharges</th>
					<th>ClubFund</th>
					<th>UnionFund</th>
					<th>PersonalTripCharges</th>
					<th>Itax</th>
					<th>WelfareAllowance</th>
					<th>GrossDeductions</th>
					<th>NetAmount</th>
					<th>Rbasic</th>
					<th>Rda</th>
					<th>Rconveyance</th>
					<th>Rlta</th>
					<th>Rmedical</th>
					<th>Rotherallowance1</th>
					<th>Rotherallowance2</th>
					<th>Isarrearsrecord</th>
					<th>Remarks</th>
					
				
				</tr>
			</thead>

		</table>

      	    <script src="resources/dist/js/sidebarmenu.js"></script>

<%@include file="footer.jsp"%>
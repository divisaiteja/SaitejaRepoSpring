function salaryCalc() {
			var division = document.getElementById("division").value;
			var basic = document.getElementById("basic").value;
			var others2=document.getElementById("others2").value;
			$.ajax({
				type : "post",
				url : "salaryCalculation?division=" + division+"&&basic="+basic, // this controller url
				processData : false,
				contentType : false,
				success : function(data) {					
					document.getElementById("da").value=data.dataBean["da"];
					document.getElementById("hra").value=data.dataBean["hra"];
					document.getElementById("conveyance").value=data.dataBean["conveyance"];
					document.getElementById("lta").value=data.dataBean["lta"];
					document.getElementById("medical").value=data.dataBean["medical"];
					document.getElementById("bonus").value=data.dataBean["bonus"];
					document.getElementById("others1").value=data.dataBean["otherallowance"];
					document.getElementById("esipercentage").value=data.dataBean["esi"];
					document.getElementById("pfpercentage").value=data.dataBean["pf"];
					document.getElementById("grosssalary").value=parseInt(data.dataBean["grosssalary"])+parseInt(others2);
					document.getElementById("ctc").value=data.dataBean["ctc"];
				    document.getElementById("employercontribution").value=data.dataBean["pf"];
				}
			})
		}
 
 
// function GrossCalcBasedonOthers2(){
//			var division = document.getElementById("division").value;
//			var others2=0;
//			var gross=0;
//			var ctc=0;
//			if(!isNaN(others2)){
//			 others2 = document.getElementById("others2").value;
//			}
//			if(!isNaN(gross)){
//			 gross = document.getElementById("grosssalary").value;
//			}
//			if(!isNaN(ctc)){
//			 ctc = document.getElementById("ctc").value;
//			}
//					document.getElementById("grosssalary").value=parseInt(gross)+parseInt(others2);
//					document.getElementById("ctc").value=parseInt(ctc)+parseInt(others2);
//
//		}

 function salaryCalc(){
     if(!document.getElementById("autocalc").checked){         
         salaryCalcOnPFChange();
         salaryCalcOnESIChange();
        $("#grosssalary").val(parseInt($("#basic").val())+parseInt($("#da").val())+parseInt($("#hra").val())+parseInt($("#conveyance").val())+parseInt($("#others1").val())+parseInt($("#others2").val()));          
        $("#ctc").val(parseInt($("#grosssalary").val())+parseInt($("#bonus").val())+parseInt($("#pfamount").val())+parseInt($("#lta").val())+parseInt($("#medical").val()));
 }
 }

 function salaryCalcOnPFChange(){     
     var pfamount=$("#pfamount").val();
     var pfper=$("#pfpercentage").val();
     var basic=$("#basic").val();
     var pflimit = $("#pflimit").val();
     var ctc = parseInt($("#ctc").val())-parseInt(pfamount);
     
     pfamount=Math.round((pfper*basic)/100,0)
     if (basic>pflimit){
         pfamount=Math.round((pfper*pflimit)/100,0)
     }
     $("#pfamount").val(pfamount);          
     $("#employercontribution").val(pfamount);
     var ctc = ctc+pfamount;
     $("#ctc").val(ctc); 
     
     //salaryCalcBasedonGrossSalary();
 }

 function salaryCalcOnESIChange(){
     var esiamount=0;
     var esiper=$("#esipercentage").val();
     var gross=$("#grosssalary").val();
     var esilimit = $("#esilimit").val();

     esiamount=Math.round((esiper*gross)/100,0)
     if (gross>esilimit){
         esiamount=Math.round((esiper*esilimit)/100,0)
     }
     $("#esiamount").val(esiamount);          

 }

function salaryCalcBasedonGrossSalary(){
			var division = document.getElementById("division").value;
            var tranid = document.getElementById("salarytranid").value;
			var grosssalary = document.getElementById("grosssalary").value;
			$.ajax({
				type : "post",
				url : "salaryCalculationBasedonGrossSalary?tranid="+tranid+"&&division=" + division+"&&grosssalary="+grosssalary, // this controller url
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
					document.getElementById("esiamount").value=data.dataBean["esi"];
					document.getElementById("pfamount").value=data.dataBean["pf"];
//					document.getElementById("esipercentage").value=data.dataBean["esipercent"];
//					document.getElementById("pfpercentage").value=data.dataBean["pfpercent"];                                        
					document.getElementById("ctc").value=data.dataBean["ctc"];
				    document.getElementById("employercontribution").value=data.dataBean["pf"];					
				}
			})			
		}

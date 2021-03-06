<%@include file="header.jsp" %>
<style>
.ui-datepicker-calendar {

    display: none;

}​

</style>
<script>

$(document).ready( function() {
	getAbsentsBasedOnDivisionAndDate()
}); 

</script>
<script>
$(document).ready( function() {
	 var user_data = [];
     var drill_down_data = [];
     var processedjson = [];
     var departmentnames =[];
     var divisionnames = [];
     var uniqueNames = [];
     var result =[];
        $.ajax({
            type: "GET",
            url: 'getBarGraphs',
            dataType: "json",
            contentType: "application/json",
            crossDomain: true,
            success: function (data) {
            	result =data;
                // Populate series
               for (i = 0; i < result.length; i++) {
                	departmentnames.push(result[i].departmentName);
                	divisionnames.push(result[i].divisionName);
               }
                 $.each(divisionnames, function(i, el){
                    if($.inArray(el, uniqueNames) === -1) uniqueNames.push(el);
                });
                $.each(JSON.parse(JSON.stringify(result)), function(i, obj) {
                    var user = {};
                    durationSum = 0;
                    durationSum += obj.count;
                   user.name = obj.divisionName;
                   user.y = obj.count;
                    user.drilldown = obj.divisionName;
                    user_data.push(user);
                    var drilldown_user = {};
                    drilldown_user.id = obj.divisionName;
                    drilldown_user.data = [];
                    drilldown_user.data.push(obj.count);
                    drilldown_user.data.push(obj.departmentName);
                    drill_down_data.push(drilldown_user);
                }); 
                console.log(user_data,drill_down_data);
                // draw chart
                Highcharts.chart('chart1',{
                    chart: {
                        type: 'column'
                      },
                      title: {
                        text: 'DEPARTMENT WISE GRAPH'
                      },
                      xAxis: {
                    	  //type: 'category'
                    	   categories : uniqueNames 
                      },
                      yAxis: {
                    	  min: 0,
                        title: {
                          text: 'count'
                        }
                      },
                      legend: {
                        enabled: false
                      },
                      plotOptions: {
                          series: {
                              borderWidth: 0,
                              dataLabels: {
                                  enabled: true,
                                  format: '{point.y:.1f}%'
                              }
                          }
                      },
                      series: [{
                          name: 'Things',
                          colorByPoint: true,
                          data: user_data
                      }],
                      drilldown: {
                          series: drill_down_data
                      }
 });
        }  
            });
        $.ajax({
     	type: "GET",
     	url: "getDivisionBarGraphs",
        success : function(data) {            
        	// Populate series
            var processed_json = new Array();
            var projectnames = [];
            var divisionnames = [];
            var uniqueNames = [];
            var uniqueProjects = [];
            var rsultdata = [];
            for (i = 0; i < data.length; i++) {
                   divisionnames.push(data[i].divisionName);
                   projectnames.push(data[i].projectName);
                   processed_json.push(parseInt(data[i].count));
            }  
            $.each(divisionnames, function(i, el){
                if($.inArray(el, uniqueNames) === -1) uniqueNames.push(el);
            });
            $.each(projectnames, function(i, el1){
                if($.inArray(el1, uniqueProjects) === -1) uniqueProjects.push(el1);
            });       
            console.log(rsultdata);
                 var series = [];
                 for(i = 0;i<uniqueNames.length;i++){
                    series.push({
                        name: uniqueNames[i],
                       data: processed_json,
                    });
                } 
            Highcharts.chart('chart2',{
                chart: {
                    type: "column"
                },
                title: {
                    text: "DIVISION AND PROJECT WISE GRAPH"
                },
                xAxis:{
                	categories:uniqueProjects
                },
                  yAxis: {
                    min: 0,
                    title: {
                      text: 'Count'
                    }
                  },
                tooltip: {
                	 headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                	    pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                	      '<td style="padding:0"><b>{point.y:.1f}%</b></td></tr>',
                	    footerFormat: '</table>',
                	    shared: true,
                	    useHTML: true
                },
                plotOptions: {
                    column: {
                      pointPadding: 0.2,
                      borderWidth: 0
                    }
                  }, 
                  series:series
            });              
         }
            
        });
});
        function getAbsentsBasedOnDivisionAndDate(){
        	var date=document.getElementById("image").value;
        	//alert(">>>>>"+date);
        $.ajax({
         	type: "GET",
         	url: "getAbsentsBasedOnDivision?date="+date,
            success : function(data) { 
            	// Populate series
            //	alert("success");
                var processed_json = new Array();
                var projectnames = [];
                var divisionnames = [];
                var uniqueNames = [];
                var uniqueProjects = [];
                var rsultdata = [];
                for (i = 0; i < data.length; i++) {
                       divisionnames.push(data[i].divisionName);
                       projectnames.push(data[i].projectName);
                       processed_json.push(parseInt(data[i].count));
                }  
                $.each(divisionnames, function(i, el){
                    if($.inArray(el, uniqueNames) === -1) uniqueNames.push(el);
                });
                $.each(projectnames, function(i, el1){
                    if($.inArray(el1, uniqueProjects) === -1) uniqueProjects.push(el1);
                });       
                console.log(rsultdata);
                     var series = [];
                     for(i = 0;i<uniqueNames.length;i++){
                        series.push({
                            name: uniqueNames[i],
                           data: processed_json,
                        });
                    } 
                Highcharts.chart('chart3',{
                    chart: {
                        type: "column"
                    },
                    title: {
                        text: "ABSENT PROJECT WISE GRAPH"
                    },
                    xAxis:{
                    	categories:uniqueProjects
                    },
                      yAxis: {
                        min: 0,
                        title: {
                          text: 'Count'
                        }
                      },
                    tooltip: {
                    	 headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                    	    pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    	      '<td style="padding:0"><b>{point.y:.1f}%</b></td></tr>',
                    	    footerFormat: '</table>',
                    	    shared: true,
                    	    useHTML: true
                    },
                    plotOptions: {
                        column: {
                          pointPadding: 0.2,
                          borderWidth: 0
                        }
                      }, 
                      series:series
                });              
             }
                
            });

        }
 
</script>
<input type="hidden" id="graph1">
<input type="hidden" id="graph2">
<input type="hidden" id="graph3">
<input type="hidden" id="graph4">
<input type="hidden" id="graph5">
<input type="hidden" id="graph6">



<div class="row" style="border-bottom:2px solid">
    <div class="col-md-6" id="chart1" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto">
   </div>
   <div class="col-md-6" id="chart2" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto">
   </div>
   </div>
   <input type="image" id="image" alt="Login" onchange="getAbsentsBasedOnDivisionAndDate()" align="left" src="resources/assets/images/cal.png" height="50" width="50">
  
  Select Date : <input type='text' id='image1' />
  
   <div class="row" style="border-bottom:2px solid">
    <div class="col-md-6" id="chart3" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto">
   </div>
   <div class="col-md-6" id="chart4" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto">
   </div> 
   
   </div>
                  <div class="row" style="border-bottom:2px solid">
                    <div class="col-md-6">
                        <div id="chart1" ></div>
                    </div>
                    <div class="col-md-6">  
                        <div id="chart2"></div>
                    </div>
                  </div>
                  <div class="row" style="border-bottom:2px solid">
                    <div class="col-md-6">
                        <div id="chart3" ></div>
                    </div>
                    <div class="col-md-6">  
                        <div id="chart4"></div>
                    </div>
                  </div>
                  <div class="row" style="border-bottom:2px solid">
                    <div class="col-md-6">
                        <div id="chart5" ></div>
                    </div>
                    <div class="col-md-6">  
                        <div id="chart6"></div>
                    </div>
                  </div>

<div class="row" style="border-bottom:2px solid">
    <div class="col-md-6" id="chart1" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto">
   </div>
   <div class="col-md-6" id="chart2" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto">
   </div>
   </div>
   
   <div class="row" style="border-bottom:2px solid">
    <div class="col-md-6" id="chart3" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto">
   </div>
   <div class="col-md-6" id="chart4" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto">
   </div> 
   
   </div>

   <div class="row" style="border-bottom:2px solid">
    <div class="col-md-6" id="chart5" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto">
   </div>
   <div class="col-md-6" id="chart6" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto">
   </div> 
   </div>



<script src="resources/dist/js/sidebarmenu.js"></script>

  <%@include file="footer.jsp"%>
  
  <script>
  jQuery('#image').datepicker({
		autoclose : true,
		todayHighlight : true
	});
  </script>
  <script>
  jQuery('#image1').datepicker({
		autoclose : true,
		 changeMonth: true,
	     changeYear: true,
	     dateFormat: 'MM yy',
	});
 
 </script>
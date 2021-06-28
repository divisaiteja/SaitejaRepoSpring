<%@include file="header.jsp" %>

<script src="resources/highcharts/highcharts.js"></script>
<script src="resources/highcharts/exporting.js"></script>
<script src="resources/highcharts/export-data.js"></script>
<script>
var chart;
$(document).ready( function() {
            chart = new Highcharts.Chart({
                chart : {
                    renderTo : 'container',

                },
                title : {
                	text: 'Employees Strength Division-wise'
                },
                xAxis: {
    		        categories: ['Company-A', 'Company-B']
    		    },
    		    yAxis: {
    		        allowDecimals: false,
    		        min: 0,
    		        title: {
    		            text: 'Number Of employees'
    		        }
    		    },

                tooltip: {
    		        formatter: function () {
    		            return '<b>' + this.x + '</b><br/>' +
    		                this.series.name + ': ' + this.y + '<br/>' +
    		                'Total: ' + this.point.stackTotal;
    		        }
    		    },
    		    plotOptions: {
    		        column: {
    		            stacking: 'normal'
    		        }
    		    },
                labels : {
                    items : [ {
                        //html : 'Total Bugs',
                        style : {
                            left : '40px',
                            top : '8px',
                            color : 'black'
                        }
                    } ]
                },
                series : [{

                	 type: 'column',
                    //name : 'Total Bugs',
                    data : [],
                    center : [ 100, 80 ],
                    size : 100,
                    showInLegend : false,
                    dataLabels : {
                        enabled : false
                    },
                }]

            }, function getdata(chart) {
                var tmp="";
                var receivedData="";

                $.ajax({
                	type: "GET",
                	contentType : "application/json",
                	url: "getBarGraphs",
                	
                    error : function() {
                      alert("error occured!!!");
                    },
                    success : function(data) {
                    	   var chartData=[];
                    	   $.each(data.json, function(index)
                    	    {
                    	     $.each(data.json[index], 
                    	      function(key,value) {
                    	       var point = [];
                    	       point.push(key);
                    	       point.push(value);
                    	       chartData.push(point);                          
                    	      });
                    	   });
                    	   chart.series[0].setData(chartData);
                    	   var tCount=0;
           	        	var a=[];
           	        	
           	        	for(var i = 0; i < 2; i++){
           	        		
           	        		var a=data[i].departmentName;
           	        		alert(a);
           	        		var appendCount=""+data[i].count;
           	        		//alert(appendCount);
           	        		for(var j = 1; j < 2; j++){
           	        			tCount=0;
           	        			if (a=data[j].departmentName){
           	        				//alert("matched "+a+""+data[j].departmentName);
           	        				tCount = data[j].count;
           	        			}
                				appendCount = appendCount + ","+tCount;

                    	 }

                }
                );
            });

        });
</script>
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

  <%@include file="footer.jsp"%>
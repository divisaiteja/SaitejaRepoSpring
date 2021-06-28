<%@include file="header.jsp" %>


<script>
/*
var chart;
$(document).ready( function() {
            chart = new Highcharts.Chart('container',{
                chart : {
                   // renderTo : 'container',
                    type: 'column'

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

                	
                    //name : 'Total Bugs',
                    data : [],
                    center : [ 100, 80 ],
                    size : 100,
                    /* showInLegend : false,
                    dataLabels : {
                        enabled : false
                    }, */
                    
               // }]

          //  }, 
         /*
            function getdata(chart) {
              
               

                $.ajax({
                	type: "GET",
                	contentType : "application/json",
                	url: "getBarGraphs",
                    error : function() {
                      alert("error occured!!!");
                    },
                    success : function(data) {
                 	   console.log(data);

                    	   var chartData=[];
                    	   $.each(data.json, function(divCount)
                    	    {
                    	     $.each(data.json[divCount], function(key,value) {
                    	       var div = [];
                    	       div.push(key);
                    	       div.push(value);
                    	       chartData.push(div); 

                    	      });
                    	     
                    	   });
                    	   console.log(chart.series[0].setData(chartData));

                    	   chart.series[0].setData(chartData);
                    	   var tCount=0;
           	        	var a=[];
           	        	
           	        	for(var i = 0; i < 2; i++){
           	        		
           	        		var a=data[i].departmentName;
           	        		//alert(a);
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
                    }
                    	 }

                
                );
            });

        });
        */
        
        
</script>
<script>
Highcharts.chart('container', {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    },
    title: {
        text: 'Employee Info May 2019'
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                }
            }
        }
    },
    series: [{
        name: 'Brands',
        colorByPoint: true,
        data: [{
            name: 'PresentPercent',
            y: 61.41,
            sliced: true,
            selected: true
        }, {
            name: 'AbsentPercent',
            y: 11.84
        }, {
            name: 'LeavePercent',
            y: 10.85
        }]
    }]
});
</script>
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
      	    <script src="resources/dist/js/sidebarmenu.js"></script>

  <%@include file="footer.jsp"%>
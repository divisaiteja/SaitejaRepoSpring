<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
     <style>
.nth-table {
    border-collapse: collapse;
    border: 1px solid #400040;
  }
 .nth-table tr:nth-child(){
        background: #ebf7d4;
        
    }
.nth-table th{
    border: 1px dotted #460046;
    color: #000;
    padding:5px;
    background-color:#AFD8D8;
  }
.nth-table td{
    border: 1px dashed #000;
    color: #002F5E;
    padding:5px;
    width:100px;
  }
</style>
</head>
<body> 
<% 
int division=Integer.parseInt(request.getParameter("division"));
int month=Integer.parseInt(request.getParameter("month"));
int year=Integer.parseInt(request.getParameter("year"));


%>

<input type="hidden" id="division" value="<%=division%>">
<input type="hidden" id="month" value="<%=month%>">
<input type="hidden" id="year" value="<%=year%>">

<div id="tblCustomers">
 <h3 align="center">ATTENDANCE FOR THE <%=month%></h3>

<table class="nth-table" >

  <tr>
        <th width="100">SNO</th>
        <th width="100">IDNO</th>
        <th width="100">NAME</th>	
	    <th width="100">1</th>
	    <th width="100">2</th> 
	    <th width="100">3</th>
	    <th width="100">4</th>
		<th width="100">5</th>
		<th width="100">6</th>
		<th width="100">7</th>
		<th width="100">8</th>
		<th width="100">9</th>
		<th width="100">10</th>
		<th width="100">11</th>
		<th width="100">12</th>
		<th width="100">13</th> 
		<th width="100">14</th>
		<th width="100">15</th> 
		<th width="100">16</th> 
		<th width="100">17</th> 
		<th width="100">18</th> 
		<th width="100">19</th> 
		<th width="100">20</th> 
		<th width="100">21</th> 
		<th width="100">22</th> 
		<th width="100">23</th> 
		<th width="100">24</th> 
		<th width="100">25</th>
		<th width="100">26</th>
		<th width="100">27</th> 
		<th width="100">28</th>
		<th width="100">29</th>
		<th width="100">30</th>
		<th width="100">31</th>
	    <th width="100">REMARKS</th>
	  
	</tr>  
  
  <tr>
	  <td>1</td>
	  <td>1001</td>
	  <td>Ramdas</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
	  <td>A</td>
  </tr>
</table>
</div>
    <br/>
    <input type="button" id="btnExport" value="Export" />
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
    <script type="text/javascript">
        $("body").on("click", "#btnExport", function () {
            html2canvas($('#tblCustomers')[0], {
                onrendered: function (canvas) {
                    var data = canvas.toDataURL();
                    var docDefinition = {
                        content: [{
                            image: data,
                            width: 500
                        }]
                    };
                    pdfMake.createPdf(docDefinition).download("DailyAttendenceReport");
                }
            });
        });
    </script>
</body>
</html>
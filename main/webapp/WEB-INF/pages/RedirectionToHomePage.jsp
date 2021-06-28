<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="com.hrms.utitlities.DBUtil" %>
<%
	HttpSession sess = request.getSession();
	String username = (String) sess.getAttribute("username");
%>
<%
	if (username != null) {
		response.sendRedirect("home.jsp");
%>
<%@include file="header.jsp" %>
 

<script src="resources/highcharts/highcharts.js"></script>
<script src="resources/highcharts/exporting.js"></script>
<script src="resources/highcharts/export-data.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script type="text/javascript" src="resources/assets/libs/jquery/dist/jquery.min.js"></script>
<script src="resources/summy/sammy.js"></script>
<script src="resources/summy/sammy.template.js"></script>
<script src="resources/summy/app.js"></script>
<script>

function GetXmlHttpObject()
{
    var xmlHttp = null;
    if (window.XMLHttpRequest) {
        xmlHttp = new window.XMLHttpRequest;
    } else {
        try {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (ex) {
            return null;
        }
    }
    return xmlHttp;
}//GetXmlHttpObject
function fun(){
	alert();
	 xmlHttp = GetXmlHttpObject();
	    var url = "employeeInformation";
	    xmlHttp.onreadystatechange = showmenudata1;
	    xmlHttp.open("GET", url, true);
	    xmlHttp.send(null);
}
function fun1(){
	alert();
	 xmlHttp = GetXmlHttpObject();
	    var url = "example3.jsp";
	    xmlHttp.onreadystatechange = showmenudata1;
	    xmlHttp.open("GET", url, true);
	    xmlHttp.send(null);
}
function showmenudata1()
{
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete")
    {
        $("#data").html(xmlHttp.responseText);
    }
}

$(document).ready(function() {
	xmlHttp = GetXmlHttpObject();
    var url = "openDashBoard";
    xmlHttp.onreadystatechange = showmenudata1;
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);
	//alert("dsd");

});

</script>
<div id="main-wrapper">
         <header class="topbar" data-navbarbg="skin5">
            <nav class="navbar top-navbar navbar-expand-md navbar-dark">
                <div class="navbar-header" data-logobg="skin5" style="background-color:#043f61!importan">
                    <!-- This is for the sidebar toggle which is visible on mobile only -->
                    <a class="nav-toggler waves-effect waves-light d-block d-md-none" href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
                    <!-- ============================================================== -->
                    <!-- Logo -->
                    <!-- ============================================================== -->
                    <a class="navbar-brand" >
                          <span class="logo-text">
                             <!-- dark Logo text -->
                             <img src="resources/assets/images/booklogo.png" alt="homepage" height="50" width="160"/>
                        </span>
                       
                    </a>
                         <a class="topbartoggler d-block d-md-none waves-effect waves-light" href="javascript:void(0)" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><i class="ti-more"></i></a>
                </div>
                <!-- ============================================================== -->
                <!-- End Logo -->
                <!-- ============================================================== -->
                <div class="navbar-collapse collapse" id="navbarSupportedContent"  style="background-color:#043f61!importan">
                    <!-- ============================================================== -->
                    <!-- toggle and nav items -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav float-left mr-auto">
                        <li class="nav-item d-none d-md-block"><a class="nav-link sidebartoggler waves-effect waves-light" href="javascript:void(0)" data-sidebartype="mini-sidebar"><i class="mdi mdi-menu font-24"></i></a></li>
                            <!-- ============================================================== -->
                        <!-- Search -->
                        <!-- ============================================================== -->
                        <li class="nav-item search-box"> <a class="nav-link waves-effect waves-dark" href="javascript:void(0)"><i class="ti-search"></i></a>
                            <form class="app-search position-absolute">
                                <input type="text" class="form-control" placeholder="Search &amp; enter"> <a class="srh-btn"><i class="ti-close"></i></a>
                            </form>
                        </li>
                    </ul>
                    <!-- ============================================================== -->
                    <!-- Right side toggle and nav items -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav float-right">
                             <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark pro-pic" href="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <input type="submit" value="logout" class="btn btn-danger"></a>
                            <div class="dropdown-menu dropdown-menu-right user-dd animated">
                                 <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="javascript:void(0)"><i class="fa fa-power-off m-r-5 m-l-5"></i> Logout</a>
                            </div>
                        </li>
                        <!-- ============================================================== -->
                        <!-- User profile and search -->
                        <!-- ============================================================== -->
                    </ul>
                </div>
            </nav>
        </header>

        <aside class="left-sidebar" data-sidebarbg="skin5">
        <%
        Connection con=DBUtil.getConnection();
        Statement stm=con.createStatement();
/*         String sql="select * from menu_master mm where itemid in (select menuitemid from user_menuaccessrights ma where ma.idno=1001)";
 */    
 String sql="select * from menu_master";
ResultSet rs=stm.executeQuery(sql);
			%>
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav" style="background-color: #043f61">
                    <ul id="sidebarnav" class="p-t-30" style="background-color: #043f61">
                       <%while(rs.next()){ %>
					    <li class="sidebar-item">
                         <a class="sidebar-link waves-effect waves-dark sidebar-link" onclick="<%out.println(rs.getString("itemaction"));%>()" aria-expanded="false"><i class="mdi mdi-view-dashboard"></i>
                        <span class="hide-menu"><%out.println(rs.getString("itemname"));%></span></a>
                        </li>
                        <% } %>
                    </ul>
            </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </aside>
     	      <div class="page-wrapper" style="background-color: #ffffff">
           
            <div class="container-fluid">
                  <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                
                              <div id="data"></div>
                                          
                            </div>
                        </div>
                    </div>
                </div>
            </div>
           
        </div>
       
    </div>
    <%con.close(); %>
    <%@include file="footer.jsp" %>
<%
		} else {
	%>
	<%
		response.sendRedirect("login");
	%>
	<%
		}
	%>
</body>

</html>
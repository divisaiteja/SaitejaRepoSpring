<!DOCTYPE html>
<html>
<head>
<%
HttpSession sess=request.getSession();
String username=(String)sess.getAttribute("username");
%>
<%if(username!=null){%>
<%@include file="header.jsp"%>
<script>

</script>
<script type="text/javascript" src="resources/assets/libs/jquery/dist/jquery.min.js"></script>
	    <script src="resources/dist/js/sidebarmenu.js"></script>

<script src="resources/summy/sammy.js"></script>
<script src="resources/summy/sammy.template.js"></script>
<script src="resources/summy/app.js"></script>

  
</head>

<body>


	<div id="main-wrapper">
		<header class="topbar" data-navbarbg="skin5">
			<nav class="navbar top-navbar navbar-expand-md navbar-dark">
				<div class="navbar-header" data-logobg="skin5"
					>
					<!-- This is for the sidebar toggle which is visible on mobile only -->
					<a class="nav-toggler waves-effect waves-light d-block d-md-none"
						href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
					<!-- ============================================================== -->
					<!-- Logo -->
					<!-- ============================================================== -->
					<a class="navbar-brand"> <span class="logo-text"> <!-- dark Logo text -->
							<img src="resources/assets/images/booklogo.png" alt="homepage"
							height="50" width="160" />
					</span>

					</a> <a
						class="topbartoggler d-block d-md-none waves-effect waves-light"
						href="javascript:void(0)" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation"><i class="ti-more"></i></a>
				</div>
				<!-- ============================================================== -->
				<!-- End Logo -->
				<!-- ============================================================== -->
				<div class="navbar-collapse collapse" id="navbarSupportedContent"
					>
					<!-- ============================================================== -->
					<!-- toggle and nav items -->
					<!-- ============================================================== -->
					<ul class="navbar-nav float-left mr-auto">
						<li class="nav-item d-none d-md-block"><a
							class="nav-link sidebartoggler waves-effect waves-light"
							href="javascript:void(0)" data-sidebartype="mini-sidebar"><i
								class="mdi mdi-menu font-24"></i></a></li>
						<!-- ============================================================== -->
						<!-- Search -->
						<!-- ============================================================== -->
					
					</ul>
					<div align="center"><h3 style="color:white">WELCOME <%out.println(username); %></h3></div>
					<!-- ============================================================== -->
					<!-- Right side toggle and nav items -->
					<!-- ============================================================== -->
					<ul class="navbar-nav float-right">
						<li class="nav-item dropdown">
						<a
							class="nav-link dropdown-toggle text-muted waves-effect waves-dark pro-pic"
							href="javascript:void(0)" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
							
							<img src="resources/assets/images/LOGOUT.png" alt="user" width="41" onclick="logout()">
							
							</a>
								
								
							</li>
						<!-- ============================================================== -->
						<!-- User profile and search -->
						<!-- ============================================================== -->
					</ul>
				</div>
			</nav>
		</header>
		
		<aside class="left-sidebar" data-sidebarbg="skin5">

			<!-- Sidebar scroll-->
			<div class="scroll-sidebar">
				<!-- Sidebar navigation-->
				<nav class="sidebar-nav" >
					<ul id="sidebarnav" class="p-t-30"
						>
							
								 <li class="sidebar-item">
                                <a href="#/accordian/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> HomePage </span>
                                </a>
								
								</li>	
									
						<li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-face"></i><span class="hide-menu">HR Management</span></a>
                            <ul aria-expanded="false" class="collapse  first-level">
                                <li class="sidebar-item">
                                
                                <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-clipboard-account"></i><span class="hide-menu"> Employee Information </span>
                                </a>
								<ul aria-expanded="false" class="collapse  first-level">
                                <li class="sidebar-item"><a href="#/jobDetails" class="sidebar-link">
								<i class="mdi mdi-note-outline"></i><span class="hide-menu"> New Joining</span></a>
								</li>
                                <li class="sidebar-item"><a href="#/employeeInformation/"  class="sidebar-link">
                                <i class="mdi mdi-note-plus"></i><span class="hide-menu"> Personal Information </span></a>
                                </li>
								</ul>
								</li>
								
								
								<li class="sidebar-item">
                                <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-clock"></i><span class="hide-menu"> Attendence </span>
                                </a>
								<ul aria-expanded="false" class="collapse  first-level">
                                <li class="sidebar-item"><a href="#/attendance/" class="sidebar-link">
								<i class="mdi mdi-note-outline"></i><span class="hide-menu"> Punches Checklist </span></a>
								</li>
                                <li class="sidebar-item"><a href="#/leaveposting/" class="sidebar-link">
                                <i class="mdi mdi-note-plus"></i><span class="hide-menu"> Leave Posting </span></a>
                                </li>
                                <li class="sidebar-item"><a href="#/otentry/" class="sidebar-link">
                                <i class="mdi mdi-note-plus"></i><span class="hide-menu"> OT Entry </span></a>
                                </li>
								</ul>
								</li>
								
                                
                                
                                <li class="sidebar-item">
                                <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-cash"></i><span class="hide-menu"> PayRoll </span>
                                </a>
								<ul aria-expanded="false" class="collapse  first-level">
                                <li class="sidebar-item"><a onclick="monthdeductions()" class="sidebar-link">
								<i class="mdi mdi-note-outline"></i><span class="hide-menu"> Month Deductions </span></a>
								</li>
                                <li class="sidebar-item"><a href="#/salaryDeductions/" class="sidebar-link">
                                <i class="mdi mdi-note-plus"></i><span class="hide-menu"> Salary Deductions </span></a>
                                </li>
								</ul>
								</li>
                               
                                <li class="sidebar-item"><a href="icon-fontawesome.html" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Appraisals  </span></a></li>
                           
                            
                           </ul>
                        </li>
								
								<li class="sidebar-item"><a 
							class="sidebar-link waves-effect waves-dark sidebar-link"
							aria-expanded="false"><i class="mdi mdi-face"></i>
								<span class="hide-menu">CSR Activities</span></a></li>
								
									
								
								<li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-face"></i><span class="hide-menu">Masters</span></a>
                            <ul aria-expanded="false" class="collapse  first-level">
                                <li class="sidebar-item">
                                <a href="#/grade-list/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> Grades </span>
                                </a>
								
								</li>
								
						
                              <li class="sidebar-item"><a href="#/jobstatus/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Job Status  </span></a></li>
                             <li class="sidebar-item"><a href="#/view-emp-status/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Employee Status  </span></a></li>
                             <li class="sidebar-item"><a href="#/division/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Divisions  </span></a></li>                             
                             <li class="sidebar-item"><a  class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Shift Schedules  </span></a></li>
                             <li class="sidebar-item"><a href="#/view-blood-group/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> BloodGroup  </span></a></li>
                          
                         <li class="sidebar-item"><a href="#/shifts/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Shifts  </span></a></li>
                           
                          <li class="sidebar-item"><a href="#/jobtype/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> JobType  </span></a></li>
                          <li class="sidebar-item"><a href="#/cadre/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Cadre  </span></a></li>
                          <li class="sidebar-item"><a href="#/department/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Department  </span></a></li>
                          <li class="sidebar-item"><a href="#/sections/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu">  Sections </span></a></li>
                          <li class="sidebar-item"><a href="#/projects/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Projects  </span></a></li>
                          <li class="sidebar-item"><a href="#/holidays/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Holidays  </span></a></li>
                          
                           </ul>
                        </li>
								
								
								
								
								
								
								
								<li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-face"></i><span class="hide-menu">Utilities</span></a>
                            <ul aria-expanded="false" class="collapse  first-level">
                                <li class="sidebar-item">
                                <a href="icon-fontawesome.html" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> User-Components Mapping </span>
                                </a>
								
								</li>
								<li class="sidebar-item">
                                <a href="#/settings/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> Settings </span>
                                </a>
								
								</li>
								
								
                            
                           </ul>
                        </li>
                        
                        
                        
                        
                        
								 <li class="sidebar-item">
                                <a href="#/reports/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> ReportCenter </span>
                                </a>
								
								</li>
								
									
								
									
								
						
									
					</ul>
				</nav>
				<!-- End Sidebar navigation -->
			</div>
			<!-- End Sidebar scroll-->
		</aside>
		

		<div class="page-wrapper" style="background-color: #ffffff">

			<div class="container-fluid">
				<div class="main wrapper clearfix">
					<div id="app">
						<!--  template will be injected here -->
					</div>
				</div>
			</div>

		</div>

	</div>
	<%}else{
		
		response.sendRedirect("login");
	}
		%>
	}
</body>
</html>
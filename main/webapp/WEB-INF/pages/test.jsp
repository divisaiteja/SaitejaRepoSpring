<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="header.jsp"%>

<script type="text/javascript" src="resources/assets/libs/jquery/dist/jquery.min.js"></script>
<script src="resources/summy/sammy.js"></script>
<script src="resources/summy/sammy.template.js"></script>
<script src="resources/summy/app.js"></script>
</head>

<body>
<%response.sendRedirect("test.jsp"); %>


	<div id="main-wrapper">
		<header class="topbar" data-navbarbg="skin5">
			<nav class="navbar top-navbar navbar-expand-md navbar-dark">
				<div class="navbar-header" data-logobg="skin5"
					style="background-color: #043f61!importan">
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
					style="background-color: #043f61!importan">
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
						<li class="nav-item search-box"><a
							class="nav-link waves-effect waves-dark"
							href="javascript:void(0)"><i class="ti-search"></i></a>
							<form class="app-search position-absolute">
								<input type="text" class="form-control"
									placeholder="Search &amp; enter"> <a class="srh-btn"><i
									class="ti-close"></i></a>
							</form></li>
					</ul>
					<!-- ============================================================== -->
					<!-- Right side toggle and nav items -->
					<!-- ============================================================== -->
					<ul class="navbar-nav float-right">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle text-muted waves-effect waves-dark pro-pic"
							href="" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"><img
								src="resources/assets/images/users/1.jpg" alt="user"
								class="rounded-circle" width="31"></a>
							<div class="dropdown-menu dropdown-menu-right user-dd animated">
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="javascript:void(0)"><i
									class="fa fa-power-off m-r-5 m-l-5"></i> Logout</a>
							</div></li>
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
				<nav class="sidebar-nav" style="background-color: #043f61">
					<ul id="sidebarnav" class="p-t-30"
						style="background-color: #043f61">

						<li class="sidebar-item"><a href="#/jobDetails/"
							class="sidebar-link waves-effect waves-dark sidebar-link"
							aria-expanded="false"><i class="mdi mdi-view-dashboard"></i>
								<span class="hide-menu">jobDetails</span></a></li>
								
								<li class="sidebar-item"><a href="#/employeeInformation/"
							class="sidebar-link waves-effect waves-dark sidebar-link"
							aria-expanded="false"><i class="mdi mdi-view-dashboard"></i>
								<span class="hide-menu">Employees</span></a></li>
								
								<li class="sidebar-item"><a href="#/leaveposting/"
							class="sidebar-link waves-effect waves-dark sidebar-link"
							aria-expanded="false"><i class="mdi mdi-view-dashboard"></i>
								<span class="hide-menu">leaveposting</span></a></li>

                           <li class="sidebar-item"><a href="#/OTEntry/"
							class="sidebar-link waves-effect waves-dark sidebar-link"
							aria-expanded="false"><i class="mdi mdi-view-dashboard"></i>
								<span class="hide-menu">OTEntry</span></a></li>
								
								 <li class="sidebar-item"><a href="#/settings/"
							class="sidebar-link waves-effect waves-dark sidebar-link"
							aria-expanded="false"><i class="mdi mdi-view-dashboard"></i>
								<span class="hide-menu">setting</span></a></li>
								
								<li class="sidebar-item"><a href="#/salaryDeductions/"
							class="sidebar-link waves-effect waves-dark sidebar-link"
							aria-expanded="false"><i class="mdi mdi-view-dashboard"></i>
								<span class="hide-menu">salaryDeductions</span></a></li>
								
								<li class="sidebar-item"><a href="#/hrrepoter/"
							class="sidebar-link waves-effect waves-dark sidebar-link"
							aria-expanded="false"><i class="mdi mdi-view-dashboard"></i>
								<span class="hide-menu">hrrepoter</span></a></li>
								
								<li class="sidebar-item"><a href="#/listAttendence/"
							class="sidebar-link waves-effect waves-dark sidebar-link"
							aria-expanded="false"><i class="mdi mdi-view-dashboard"></i>
								<span class="hide-menu">listAttendence</span></a></li>
								
								<li class="sidebar-item"><a href="#/jobstatus/"
							class="sidebar-link waves-effect waves-dark sidebar-link"
							aria-expanded="false"><i class="mdi mdi-view-dashboard"></i>
								<span class="hide-menu">jobstatus</span></a></li>
								
								<li class="sidebar-item"><a href="#/division/"
							class="sidebar-link waves-effect waves-dark sidebar-link"
							aria-expanded="false"><i class="mdi mdi-view-dashboard"></i>
								<span class="hide-menu">division</span></a></li>
								
								<li class="sidebar-item"><a href="#/settings/"
							class="sidebar-link waves-effect waves-dark sidebar-link"
							aria-expanded="false"><i class="mdi mdi-view-dashboard"></i>
								<span class="hide-menu">setting</span></a></li>
								
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
</body>
</html>
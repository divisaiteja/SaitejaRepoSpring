<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 	            <!-- Sidebar scroll-->
 	            
             <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav" style="background-color: #043f61">
                    <ul id="sidebarnav" class="p-t-30" >
                    
                           <c:forEach var="map" items="${sidebarMenu}" >
		                  
					     <li class="sidebar-item">
                          <a class="sidebar-link waves-effect waves-dark sidebar-link" onclick=<c:out value="${map.itemaction}"></c:out> aria-expanded="false"><i class="mdi mdi-view-dashboard"></i>
                        <span class="hide-menu"><c:out value="${map.itemname}"></c:out></span></a>
                        </li>
                   
  	             </c:forEach>
                    </ul>
                    
                </nav>
              
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
</body>
</html>
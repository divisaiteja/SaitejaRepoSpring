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

		} else {
	response.sendRedirect("login");
	
		}
	%>
</body>

</html>
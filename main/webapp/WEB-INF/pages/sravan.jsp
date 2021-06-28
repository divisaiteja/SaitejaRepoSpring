
<%
	HttpSession sess = request.getSession();
	String username = (String) sess.getAttribute("username");
%>
<%
	if (username != null) {
		response.sendRedirect("home.jsp");
%>

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
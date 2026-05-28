<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
	// Startup JSP: redirect to dashboard if user session exists, otherwise to login page
	String currentUser = (String) session.getAttribute("currentUser");
	if (currentUser != null && !currentUser.isEmpty()) {
		response.sendRedirect(request.getContextPath() + "/jsp/dashboard.jsp");
	} else {
		response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
	}
%>

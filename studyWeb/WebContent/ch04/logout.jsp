<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name ="viewport" content="width=device-width,initial-scale=1.0"/>

<%
	session.invalidate();
	response.sendRedirect("sessionTestForm.jsp");
%>
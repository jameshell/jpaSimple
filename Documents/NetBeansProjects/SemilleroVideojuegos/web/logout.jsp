<%-- 
    Document   : logout
    Created on : Dec 2, 2016, 6:46:05 AM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
session.setAttribute("userid", null);
session.invalidate();
response.sendRedirect("Login.jsp");
%>
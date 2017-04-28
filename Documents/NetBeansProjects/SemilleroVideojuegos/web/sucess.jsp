<%-- 
    Document   : sucess.jsp
    Created on : Dec 2, 2016, 6:44:22 AM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
You are not logged in<br/>
<a href="login.jsp">Please Login</a>
<%} else {
%>
Welcome <%=session.getAttribute("userid")%>
<a href='home.jsp'>Continue to USA Semillero!</a>
<a href='logout.jsp'>Log out</a>
<%
    }
%>
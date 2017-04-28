<%-- 
    Document   : log
    Created on : Dec 2, 2016, 6:48:43 AM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%
    String userid = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/semillero",
            "root", "root");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from USUARIOS where usuario_correo='" + userid + "' and usuario_password='" + pwd + "'");
    if (rs.next()) {
        session.setAttribute("userid", userid);
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        response.sendRedirect("sucess.jsp");
    } else {
        out.println("Invalid password <a href='Login.jsp'>try again</a>");
    }
%>

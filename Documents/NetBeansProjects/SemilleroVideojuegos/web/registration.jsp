<%-- 
    Document   : registration
    Created on : Dec 2, 2016, 7:19:42 AM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%
    String user = request.getParameter("nombreUsuario");    
    String pwd = request.getParameter("passwordUsuario");
    String carrera = request.getParameter("carreraUsuario");
    String cedula = request.getParameter("cedulaUsuario");
    String email = request.getParameter("correoUsuario");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/semillero",
            "root", "root");
    Statement st = con.createStatement();
    //ResultSet rs;
    int i = st.executeUpdate("insert into USUARIOS(usuario_nombre, usuario_cedula, usuario_correo, usuario_carrera, usuario_password) values ('" + user + "','" + cedula + "','" + email + "','" + carrera + "','" + pwd + "', CURDATE())");
    if (i > 0) {
        //session.setAttribute("userid", user);
        response.sendRedirect("welcome.jsp");
       // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("login.jsp");
    }
%>
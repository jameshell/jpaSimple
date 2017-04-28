<%-- 
    Document   : regJuego
    Created on : Dec 2, 2016, 7:37:42 AM
    Author     : james
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%
    String nombreJuego = request.getParameter("nombreJuego");    
    String descripcion = request.getParameter("descripcionJuego");
    String autor = request.getParameter("autorJuego");
    String link = request.getParameter("linkJuego");
    String genero = request.getParameter("generoJuego");
    String lenguaje =request.getParameter("lenguajeJuego");
    

    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/semillero",
            "root", "root");
    Statement st = con.createStatement();
    //ResultSet rs;
    int i = st.executeUpdate("insert into JUEGOS(juego_nombre,juego_descripcion,juego_autor,juego_link,juego_genero,juego_lenguaje,usuario_id) values ('" + nombreJuego + "','" + descripcion + "','" + autor + "','" + link + "','" + genero + "', CURDATE())");
    if (i > 0) {
        //session.setAttribute("userid", user);
        response.sendRedirect("lista.jsp");
       //out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("home.jsp");
        out.print("No se pudo realizar la persistencia >.<'");
    }
%>
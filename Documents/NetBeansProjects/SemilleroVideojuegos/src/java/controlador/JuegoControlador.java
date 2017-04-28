/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.DaoJuego;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Juego;

/**
 *
 * @author james
 */
public class JuegoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
          System.out.println("xxx");
       ArrayList<Juego> lista  = null;
       //1. Crear instancia del DAO
       DaoJuego daoJuego = new DaoJuego();
       //Lista todos los elementos.
       lista = daoJuego.listarTodo();
       //2. Envio de los datos por el request.
       request.setAttribute("juegos",lista);
       
       //3. RequestDispacher
       RequestDispatcher rd = 
               request.getRequestDispatcher("lista.jsp");
       rd.forward(request, response);
   
        
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        //1.Captura de datos del formulario
       String nombre= request.getParameter("nombreJuego");
       String genero= request.getParameter("generoJuego");
       String lenguaje=request.getParameter("lenguajeJuego");
       String autor= request.getParameter("autorJuego");
       String descripcion= request.getParameter("descripcionJuego");
       String link= request.getParameter("linkJuego"); 
       
    
       //2. Validaciones de seguridad
       //3. Crear el DTO
       Juego juego = new Juego();
       juego.setNombreJuego(nombre);
       juego.setDescripcionJuego(descripcion);
       juego.setAutorJuego(autor);
       juego.setGeneroJuego(genero);
       juego.setLenguajeJuego(lenguaje);
       juego.setLinkJuego(link);
     
       
       //4. Enlazarme con el DAO.
       DaoJuego daoJuego = new DaoJuego();
       boolean resultado = daoJuego.insertar(juego);
       if(resultado == false){
         request.setAttribute("insersion", "OK");
       }
       else{
         request.setAttribute("insersion", "NOK");
       }
       //5. RequestDispacher
       RequestDispatcher rd = 
               request.getRequestDispatcher("registro.jsp");
       rd.forward(request, response);
       
        
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.DaoJuego;
import DAO.DaoSugerencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Juego;
import modelo.Sugerencia;

/**
 *
 * @author james
 */
public class sugerenciasControlador extends HttpServlet {

     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
          System.out.println("xxx");
       ArrayList<Sugerencia> lista  = null;
       //1. Crear instancia del DAO
       DaoSugerencia daoSugerencia = new DaoSugerencia();
       //Lista todos los elementos.
       lista = daoSugerencia.listarTodo();
       //2. Envio de los datos por el request.
       request.setAttribute("sugerencias",lista);
       
       //3. RequestDispacher
       RequestDispatcher rd = 
               request.getRequestDispatcher("sugerencias.jsp");
       rd.forward(request, response);
   
     
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //1.Captura de datos del formulario
       String titulo= request.getParameter("tituloSugerencia");
       String area= request.getParameter("areaSugerencia");
       String descripcion=request.getParameter("descripcionSugerencia");
     
       
    
       //2. Validaciones de seguridad
       //3. Crear el DTO
       Sugerencia sugerencia = new Sugerencia();
        sugerencia.setTituloSugerencia(titulo);
        sugerencia.setAreaSugerencia(area);
        sugerencia.setDescripcionsSugerencia(descripcion);
     
       
       //4. Enlazarme con el DAO.
       DaoSugerencia daoSugerencia = new DaoSugerencia();
       boolean resultado = daoSugerencia.insertar(sugerencia);
       if(resultado == false){
         request.setAttribute("insersion", "OK");
       }
       else{
         request.setAttribute("insersion", "NOK");
       }
       //5. RequestDispacher
       RequestDispatcher rd = 
               request.getRequestDispatcher("sugerencias.jsp");
       rd.forward(request, response);
       
  
    }


  

}

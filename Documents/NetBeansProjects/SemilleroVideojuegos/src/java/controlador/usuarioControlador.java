/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.DaoSugerencia;
import DAO.DaoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Sugerencia;
import modelo.Usuario;

/**
 *
 * @author james
 */
public class usuarioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        
          System.out.println("xxx");
       ArrayList<Usuario> lista  = null;
       //1. Crear instancia del DAO
       DaoUsuario daoUsuario = new DaoUsuario();
       //Lista todos los elementos.
       lista = daoUsuario.listarTodo();
       //2. Envio de los datos por el request.
       request.setAttribute("usuarios",lista);
       
       //3. RequestDispacher
       RequestDispatcher rd = 
               request.getRequestDispatcher("Login.jsp");
       rd.forward(request, response);
   
     
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //1.Captura de datos del formulario
       String nombre= request.getParameter("nombreUsuario");
       int cedula= Integer.parseInt(request.getParameter("cedulaUsuario"));
       String correo=request.getParameter("correoUsuario");
       String carrera=request.getParameter("carreraUsuario");
       String password= request.getParameter("passwordUsuario");
       
       
     
       
    
       //2. Validaciones de seguridad
       //3. Crear el DTO
        Usuario usuario= new Usuario();
        usuario.setNombreUsuario(nombre);
        usuario.setCedulaUsuario(cedula);
        usuario.setCorreoUsuario(correo);
        usuario.setCarreraUsuario(carrera);
        usuario.setPasswordUsuario(password);
        
       
       //4. Enlazarme con el DAO.
       DaoUsuario daoUsuario = new DaoUsuario();
       boolean resultado = daoUsuario.insertar(usuario);
       if(resultado == false){
         request.setAttribute("insersion", "OK");
       }
       else{
         request.setAttribute("insersion", "NOK");
       }
       //5. RequestDispacher
       RequestDispatcher rd = 
               request.getRequestDispatcher("Login.jsp");
       rd.forward(request, response);
       
   
    }

 

}

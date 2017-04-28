/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import util.Conexion;

/**
 *
 * @author james
 */
public class DaoUsuario { 
    
    private Connection conexion;
    public DaoUsuario(){
       Conexion db = Conexion.getConexion();
       this.conexion = db.getConnection();
    }
    
    public boolean insertar(Usuario usuario){
          boolean resultado = false;
      try {
      //1.Establecer la consulta
      String consulta= "INSERT INTO USUARIOS VALUES(?,?,?,?,?,?)";
      //2. Crear el PreparedStament
      PreparedStatement statement =
                  this.conexion.prepareStatement(consulta);
      //-----------------------------------
      statement.setInt(1, usuario.getIdUsuario());
      statement.setString(2, usuario.getNombreUsuario());
      statement.setInt(3, usuario.getCedulaUsuario());
      statement.setString(4, usuario.getCorreoUsuario());
      statement.setString(5, usuario.getCarreraUsuario());
      statement.setString(6,usuario.getPasswordUsuario());
      //--------------------------------------
      //3. Hacer la ejecucion
      resultado = statement.execute();
      
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
      
      return resultado;
    }
    
    public ArrayList<Usuario> listarTodo(){
       //1.Consulta
       ArrayList<Usuario> respuesta = new ArrayList();
       String consulta ="SELECT * FROM USUARIOS";
        try {
            //----------------------------
            //Statement
            Statement statement =
                    this.conexion.createStatement();
            //Ejecucion
            ResultSet resultado = 
                    statement.executeQuery(consulta);
            //----------------------------
            //Recorrido sobre el resultado
            while(resultado.next()){
               Usuario usuario = new Usuario();
               usuario.setIdUsuario(1);
               usuario.setNombreUsuario(resultado.getString("nombreUsuario"));
               usuario.setCedulaUsuario(resultado.getInt("cedulaUsuario"));
               usuario.setCorreoUsuario(resultado.getString("correoUsuario"));
               usuario.setCarreraUsuario(resultado.getString("carreraUsuario"));
               usuario.setPasswordUsuario(resultado.getString("passwordUsuario"));
               
               respuesta.add(usuario);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return respuesta;
    }
    
    public Usuario buscar(String nombre){
          Usuario usuario = null;
        try {
            String consulta ="SELECT * FROM USUARIOS WHERE usuario_nombre = ?";
            PreparedStatement statement =
                    this.conexion.prepareStatement(consulta);
            
            statement.setString(1, nombre);
            ResultSet resultado =statement.executeQuery();
            if(resultado.next()){
              usuario = new Usuario();  
                usuario.setNombreUsuario(resultado.getString("nombreUsuario"));
               usuario.setCedulaUsuario(resultado.getInt("cedulaUsuario"));
               usuario.setCorreoUsuario(resultado.getString("correoUsuario"));
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

   
    
    
}

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
import modelo.Juego;
import util.Conexion;

/**
 *
 * @author james
 */
public class DaoJuego {
    
     private Connection conexion;
    public DaoJuego(){
       Conexion db = Conexion.getConexion();
       this.conexion = db.getConnection();
    }
    
    public boolean insertar(Juego juego){
          boolean resultado = false;
      try {
      //1.Establecer la consulta
      String consulta=
      "INSERT INTO JUEGOS(juego_nombre,juego_descripcion,juego_autor,juego_link,juego_genero,juego_lenguaje,usuario_id) VALUES(?,?,?,?,?,?);";
      //2. Crear el PreparedStament
      PreparedStatement statement =
                  this.conexion.prepareStatement(consulta);
      //-----------------------------------
      statement.setString(1, juego.getNombreJuego());
      statement.setString(2, juego.getDescripcionJuego());
      statement.setString(3, juego.getAutorJuego());
      statement.setString(4,juego.getLinkJuego());
      statement.setString(5,juego.getGeneroJuego());
      statement.setString(6,juego.getLenguajeJuego());
      statement.setInt(7,1);
      
      //--------------------------------------
      //3. Hacer la ejecucion
      resultado = statement.execute();
      
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
      
      return resultado;
    }
    
    public ArrayList<Juego> listarTodo(){
       //1.Consulta
       ArrayList<Juego> respuesta = new ArrayList();
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
               Juego juego = new Juego();
               juego.setNombreJuego(resultado.getString("nombreJuego"));
               juego.setAutorJuego(resultado.getString("autorJuego"));
               juego.setDescripcionJuego(resultado.getString("descripcionJuego"));
               juego.setLinkJuego(resultado.getString("linkJuego")); 
               juego.setGeneroJuego(resultado.getString("generoJuego"));
                juego.setLenguajeJuego(resultado.getString("lenguajeJuego"));
                
               respuesta.add(juego);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return respuesta;
    }
    
    public Juego buscar(String nombre){
          Juego juego = null;
        try {
            String consulta ="SELECT * FROM JUEGOS WHERE juego_nombre = ?";
            PreparedStatement statement =
                    this.conexion.prepareStatement(consulta);
            
            statement.setString(1, nombre);
            ResultSet resultado =statement.executeQuery();
            if(resultado.next()){
              juego = new Juego();  
                juego.setNombreJuego(resultado.getString("nombreJuego"));
               juego.setAutorJuego(resultado.getString("autorJuego"));
               juego.setDescripcionJuego(resultado.getString("descripcionJuego"));
               juego.setLinkJuego(resultado.getString("linkJuego")); 
               juego.setGeneroJuego(resultado.getString("generoJuego"));
               juego.setLenguajeJuego(resultado.getString("lenguajeJuego"));
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return juego;
    }

   
    
}

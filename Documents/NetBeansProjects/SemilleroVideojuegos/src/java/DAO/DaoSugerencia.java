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
import modelo.Sugerencia;
import util.Conexion;

/**
 *
 * @author james
 */
public class DaoSugerencia {
    
      private Connection conexion;
    public DaoSugerencia(){
       Conexion db = Conexion.getConexion();
       this.conexion = db.getConnection();
    }
    
    public boolean insertar(Sugerencia sugerencia){
          boolean resultado = false;
      try {
      //1.Establecer la consulta
      String consulta= "INSERT INTO SUGERENCIAS VALUES(?,?,?)";
      //2. Crear el PreparedStament
      PreparedStatement statement =
                  this.conexion.prepareStatement(consulta);
      //-----------------------------------
      statement.setString(1,sugerencia.getTituloSugerencia() );
      statement.setString(2, sugerencia.getAreaSugerencia());
      statement.setString(3, sugerencia.getDescripcionsSugerencia());
      //--------------------------------------
      //3. Hacer la ejecucion
      resultado = statement.execute();
      
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
      
      return resultado;
    }
    
    public ArrayList<Sugerencia> listarTodo(){
       //1.Consulta
       ArrayList<Sugerencia> respuesta = new ArrayList();
       String consulta ="SELECT * FROM SUGERENCIAS";
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
               Sugerencia sugerencia = new Sugerencia();
               sugerencia.setTituloSugerencia(resultado.getString("tituloSugerencia"));
               sugerencia.setAreaSugerencia(resultado.getString("areaSugerencia"));
               sugerencia.setDescripcionsSugerencia(resultado.getString("descripcioSugerencia"));
               respuesta.add(sugerencia);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return respuesta;
    }
    
    public Sugerencia buscar(int codigo){
          Sugerencia sugerencia = null;
        try {
            String consulta ="SELECT * FROM SUGERENCIAS WHERE id = ?";
            PreparedStatement statement =
                    this.conexion.prepareStatement(consulta);
            
            statement.setInt(1, codigo);
            ResultSet resultado =statement.executeQuery();
            if(resultado.next()){
              sugerencia = new Sugerencia();  
               sugerencia.setTituloSugerencia(resultado.getString("tituloSugerencia"));
               sugerencia.setAreaSugerencia(resultado.getString("areaSugerencia"));
               sugerencia.setDescripcionsSugerencia(resultado.getString("descripcioSugerencia"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sugerencia;
    }

   
    
    
}

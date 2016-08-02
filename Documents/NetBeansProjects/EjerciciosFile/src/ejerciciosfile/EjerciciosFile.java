/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosfile;

import com.sun.istack.internal.logging.Logger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author james
 */
public class EjerciciosFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        FileWriter escritura=null;
        try{
            File archivo = new File("hola.txt");
        if(archivo.exists()==true){
            System.out.println("Existe");
        }else{
            
                archivo.createNewFile();
                escritura= new FileWriter(archivo);
                escritura.write("Hola Mundo \n");
                escritura.flush();
                escritura.close();
            }}catch(IOException ex){
               ex.printStackTrace();
            }
        }
        
          
            
        
    }
    


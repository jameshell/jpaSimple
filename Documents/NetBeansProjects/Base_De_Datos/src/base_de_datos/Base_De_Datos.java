/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base_de_datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Jaime Alonso
 */
public class Base_De_Datos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        agregarEstudianteEnArchvivo("tipo2", "tipo2","tipo2","tipo2","tipo2","tipo2","test.csv");
        
        
        
    }
    
    public static void agregarEstudianteEnArchvivo(String tipo, String cedula,String nombre,String fecha, String departamento, String cursosHoras,String nombreArchivo) throws IOException{
     String csvFile = nombreArchivo;
        FileWriter writer = new FileWriter(csvFile,true);

        CSVUtils.writeLine(writer, Arrays.asList(tipo, cedula, nombre, fecha, departamento, cursosHoras));

        writer.flush();
        writer.close();
    }
    public static void agregarPartialEnArchvivo(String tipo, String cedula,String nombre,String fecha, String departamento, String categoria, String horas, String nombreArchivo) throws IOException{
     String csvFile = nombreArchivo;
        FileWriter writer = new FileWriter(csvFile,true);

        CSVUtils.writeLine(writer, Arrays.asList(tipo, cedula, nombre, fecha, departamento, categoria, horas));

        writer.flush();
        writer.close();
    }
    public static void agregarFullEnArchvivo(String tipo, String cedula,String nombre,String fecha, String departamento,String nombreArchivo) throws IOException{
     String csvFile = nombreArchivo;
        FileWriter writer = new FileWriter(csvFile,true);

        CSVUtils.writeLine(writer, Arrays.asList(tipo, cedula, nombre, fecha, departamento));

        writer.flush();
        writer.close();
    }
    public static void agregarAdminEnArchvivo(String tipo, String cedula,String nombre,String fecha, String departamento, String categoria,String nombreArchivo) throws IOException{
     String csvFile = nombreArchivo;
        FileWriter writer = new FileWriter(csvFile,true);

        CSVUtils.writeLine(writer, Arrays.asList(tipo, cedula, nombre, fecha, departamento, categoria));

        writer.flush();
        writer.close();
    }
    public static void agregarByContractEnArchvivo(String tipo, String cedula,String nombre,String fecha, String departamento, String meses, String valor, String nombreArchivo) throws IOException{
     String csvFile = nombreArchivo;
        FileWriter writer = new FileWriter(csvFile,true);

        CSVUtils.writeLine(writer, Arrays.asList(tipo, cedula, nombre, fecha, departamento, meses, valor));

        writer.flush();
        writer.close();
    }
    
    
    public void crearArchivo(String nombreArchivo){
        String csvFile = nombreArchivo;
    }
    
    public void solicitarSalario(String var){
       
    }
    
    
    public void leerArchivoeImprimir(){
                 String csvFile = "baseDeDatos.csv";                                 //Nombre del archivo a que se va a accerder
                    String line = "";                                               // Se ignoraran espacios
                    String cvsSplitBy = ",";                                       // Se crea el sepaarador con el que se va a identificar en el texto
                    UniversityStaff staff= new UniversityStaff();                 //Se crea la lista donde se agrega lo leido

                    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

                    while ((line = br.readLine()) != null) {

                                // Se utiliza la coma como separador
                            String[] dato = line.split(cvsSplitBy);   // Se divide el archivo por las comas
                
                            Person per= new Person(dato[1],dato[2]);  //Se crean objetos del tipo "Person" para agregar al ArrayList
                staff.addPerson(per); //Se agrega
            }
            
            staff.printStaff();  //Se imprime la lista
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

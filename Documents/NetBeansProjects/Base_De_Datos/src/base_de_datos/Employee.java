/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base_de_datos;

import java.util.Date;

/**
 *
 * @author Jaime Alonso
 */
public abstract class Employee extends Person{
    
    protected Date hiringDate;
    
    public Employee(String id, String name){
        super(id,name);
    }    
    
    public float paySalary(){
        throw new UnsupportedOperationException("Not Supported");
    }
}

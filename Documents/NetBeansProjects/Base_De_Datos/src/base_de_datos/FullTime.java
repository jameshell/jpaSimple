/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base_de_datos;

/**
 *
 * @author Jaime Alonso
 */
public class FullTime extends Professor{
    
    protected float salary;

    public FullTime(String id, String name) {
        super(id, name);
    }
    
    
    @Override
     public float paySalary(){
         return 1250000;
    }
}

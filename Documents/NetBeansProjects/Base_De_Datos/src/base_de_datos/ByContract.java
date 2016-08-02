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
public class ByContract extends Employee{
    
    private int months;
    private float value;

    public ByContract(String id, String name) {
        super(id, name);
    }
    
    public void setByContractMonths(int months){
        this.months=months;
    }
    
    public int getByContractMonths(){
        return months;
    }
    
    public void setByContractValue(float value){
        this.value=value;
    }
    
    public float getByContractValue(){
        return value;
    }
    
    
    @Override
     public float paySalary(){
         float salary;
         salary= value/months;
         return salary;
    }
    
}

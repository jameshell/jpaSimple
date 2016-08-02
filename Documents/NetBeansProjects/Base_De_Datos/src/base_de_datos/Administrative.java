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
public class Administrative extends Employee {
    
    
    private String category;
    private float salary;

    public Administrative(String id, String name) {
        super(id, name);
    }
    
    public void setCategory(String category){
        this.category=category;
    }
    
    public String getCategory(){
        return category;
    }
    
    public float getSalary(){
        return paySalary();
    }
    
    @Override
     public float paySalary(){
     return 800000;
    }
}

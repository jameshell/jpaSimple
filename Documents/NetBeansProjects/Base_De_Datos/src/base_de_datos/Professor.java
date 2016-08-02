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
public class Professor extends Employee{
    
    protected String school;
    protected String department;

    public Professor(String id, String name) {
        super(id, name);
    }
    
    public void setSchool(String school){
        this.school=school;
    }
    public String getSchool(){
        return school;
    }
    
}

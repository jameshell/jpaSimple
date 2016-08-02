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
public class Grad extends Student{
    
    protected int courses;

    public Grad(String id, String name) {
        super(id, name);
    }
    public void setCourses(int courses){
        this.courses=courses;
    }
    public int getCourses(){
        return courses;
    }
    @Override
     public float paySalary(){
         if(courses==1){
             return 2000000;
         } else if(courses==2){
             return 3500000;
         } else{
             return 0;
         }
    }
    
    
}

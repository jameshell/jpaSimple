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
public class PartialTime extends Professor {
    
    protected String category;
    protected int classHours;

    public PartialTime(String id, String name) {
        super(id, name);
    }
    
    public void setCategory(String category){
        this.category=category;
    }
    
    public String getCategory(){
        return category;
    }
    
    public void setClassHours(int classHours){
        this.classHours=classHours;
    }
    
    public int getClassHours(){
        return classHours;
    }
    
    
    @Override
     public float paySalary(){
         if(category=="a" || category=="A"){
         return 60000*classHours;
     } else if(category=="b" || category=="B"){
         return 80000*classHours;
     }else if(category=="c" || category=="C"){
         return 100000*classHours;
     }
     else{
         return 0;
     } 
    }
}

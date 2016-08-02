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
public class Undergrad extends Student {
    
    private int weekHours;

    public Undergrad(String id, String name) {
        super(id, name);
    }
    
    public void setWeekHours(int weekHours){
        this.weekHours=weekHours;
    }
    
    public int getWeekHours(){
        return weekHours;
    }
    
    @Override
     public float paySalary(){
         if(weekHours==6){
             return 689000/3;
         }
         else if(weekHours==12){
             return (689000*2)/3;
         } else{
             return 0;
         }
         
        
    }
    
    
    
}

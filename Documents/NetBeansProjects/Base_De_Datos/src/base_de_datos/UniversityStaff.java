/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base_de_datos;

import java.util.ArrayList;

/**
 *
 * @author Jaime Alonso
 */
public class UniversityStaff {
    
    private ArrayList<Person> payroll;
    
    public UniversityStaff(){
        this.payroll=new ArrayList();
    }
    
    public void addPerson(Person person){
        
        this.payroll.add(person);
    }
    
    public void printStaff(){
        int cont=0;
        while(cont!=this.payroll.size()){
            System.out.println("Nombre="+this.payroll.get(cont).name+"  ID="+this.payroll.get(cont).id);
            cont++;
        }
    }
    
    public void deletePerson(Person person){
        this.payroll.remove(this.payroll.indexOf(person));
    }
    
    public void clearMemory(){
        this.payroll.clear();
    }
    
    
    
}

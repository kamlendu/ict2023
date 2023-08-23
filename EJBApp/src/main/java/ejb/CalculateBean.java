/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless(mappedName = "ejb/ops")
public class CalculateBean implements Calculate {

//    int x;
//    int y;
//    @PostConstruct
//    public void initialize()
//    {
//    
//        
//    }
    
    @Override
    public int multiply(int x, int y) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
    return x*y;
    }
   
    
    
}

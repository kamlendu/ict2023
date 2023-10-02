/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.ws.rs.PathParam;

/**
 *
 * @author root
 */
@Stateless
public class LogicBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
public String sayHello(){
        return "<h3> Hello World of Rest</h3>";
    }

public String sayPersonalHello( String person){
        return "<h3> Hello World to "+ person + "</h3>";
    }

public Collection<String> unames(Collection<String> pnames){
       ArrayList names = new ArrayList<>();
        
       for(String p : pnames)
       {
           names.add(p.toUpperCase());
       }
       
        
        return names;
    }


}

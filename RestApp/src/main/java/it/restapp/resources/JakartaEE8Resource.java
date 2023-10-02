package it.restapp.resources;

import ejb.LogicBean;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author 
 */
@Path("rest")
public class JakartaEE8Resource {
    
    @EJB LogicBean lb;
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHello(){
     
        return lb.sayHello();
        
//  return "<h3> Hello World of Rest</h3>";
    }
    
    @GET
    @Path("hello/{p}")
    @Produces(MediaType.TEXT_HTML)
    public String sayPersonalHello(@PathParam("p") String person){
        //return "<h3> Hello World to "+ person + "</h3>";
        return lb.sayPersonalHello(person);
    }
    
    @POST
    @Path("uppers")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Collection<String> unames(Collection<String> pnames){
//       ArrayList names = new ArrayList<>();
//        
//       for(String p : pnames)
//       {
//           names.add(p.toUpperCase());
//       }
//       
//        
        return lb.unames(pnames);
    }
    
}

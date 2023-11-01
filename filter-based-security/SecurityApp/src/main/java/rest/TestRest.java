/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.TestEJB;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Context;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("rest")
@RequestScoped
@DeclareRoles({"Admin","Supervisor"})
public class TestRest {
    @EJB TestEJB test;
    
    
    @Context
    private UriInfo context;
    

    

    /**
     * Creates a new instance of TestRest
     */
    public TestRest() {
    }

    /**
     * Retrieves representation of an instance of rest.TestRest
     * @return an instance of java.lang.String
     */
    @GET
    @RolesAllowed("Admin")
    @Produces("text/html")
    public String greet() {
        //TODO return proper representation object
      
        return test.sayHello()+" Response fron Secure REST";
    }

   
}

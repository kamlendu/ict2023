/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.BookBean;
import entity.BookMaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("book")
@RequestScoped
public class BookResource {
    
    @EJB BookBean bb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BookResource
     */
    public BookResource() {
    }

    /**
     * Retrieves representation of an instance of rest.BookResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public Collection<BookMaster> getBooks()
    {
        return bb.getAllBooks();
    }
    
    
}

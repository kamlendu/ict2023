/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.PublishingBeanLocal;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("publish")
@RequestScoped
public class PublishingResource {
    
    @EJB PublishingBeanLocal pbl;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PublishingResource
     */
    public PublishingResource() {
    }

   
   @POST 
   @Path("addcust/{fname}/{lname}")
    public void addCustomer(@PathParam("fname") String firstName, @PathParam("lname") String lastName) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
      pbl.addCustomer(firstName, lastName);
    }

    @PUT 
   @Path("updatecust/{cid}/{fname}/{lname}")
    public void updateCustomer(@PathParam("cid") Integer cid, @PathParam("fname") String firstName,@PathParam("lname") String lastName) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    pbl.updateCustomer(cid, firstName, lastName);
    
    }

    @DELETE
    @Path("remcust/{cid}")
    public void removeCustomer(@PathParam("cid") Integer cid) {
    
        pbl.removeCustomer(cid);
    }

    @GET
    @Path("getcustbyid/{cid}")
    @Produces("application/json")
    public Customer findCustomerById(@PathParam("cid") Integer cid) {
   
        return pbl.findCustomerById(cid);
    }

    @GET
    @Produces("application/json")
    public Collection<Customer> getAllCustomers() {
     
        return pbl.getAllCustomers();
    }

    @GET
    @Path("getallcustbyfname/{fname}")
    @Produces("application/json")
    public Collection<Customer> getCustomersByfirstName( @PathParam("fname") String firstName) {
     
        return pbl.getCustomersByfirstName(firstName);
    }

     @GET
    @Path("getallcustbylname/{lname}")
    @Produces("application/json")
    public Collection<Customer> getCustomersBylastName(@PathParam("lname")String lastName) {
     
        return pbl.getCustomersBylastName(lastName);
    }

    @POST
    @Path("addaddress/{street}/{city}/{state}/{zip}/{cid}")
    public void addAddressToCustomer(@PathParam("street") String street, @PathParam("city") String city, @PathParam("state") String state,@PathParam("zip") String zip, @PathParam("cid") Integer cid) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
     pbl.addAddressToCustomer(street, city, state, zip, cid);
    
    }

    
//    public void updateAddressToCustomer(Integer aid, String street, String city, String state, String zip, Integer cid) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @DELETE
    @Path("remaddress/{aid}/{cid}")
    public void removeAddressToCustomer(@PathParam("aid") Integer aid, @PathParam("cid") Integer cid) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
    pbl.removeAddressToCustomer(aid, cid);
    
    }

    @GET
    @Path("getaddressofcust/{cid}")
    @Produces("application/json")
    public Collection<Address> getAddressesofCustomer(@PathParam("cid") Integer cid) {
     return  pbl.getAddressesofCustomer(cid);
    }

    
//    public Collection<Address> getAddressesByCity(String city) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    
//    public Collection<Address> getAddressesByState(String state) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    
//    public Collection<Address> getAddressesByZip(String zip) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @POST
    @Path("createsub/{title}/{type}")
    public void createSubscription(@PathParam("title") String title, @PathParam("type") String type) {
       
        pbl.createSubscription(title, type);
    
    }

    
//    public void updateSubscription(Integer id, String title, String type) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @DELETE
    @Path("remsub/{sid}")
    public void removeSubscription(@PathParam("sid") int sid) {
     pbl.removeSubscription(sid);
    }

    @GET
    @Path("getallsubs")
    @Produces("application/json")
    public Collection<Subscription> getAllSubscriptions() {
     
        return pbl.getAllSubscriptions();
    }

    @GET
    @Path("getallsubsofcust/{cid}")
    @Produces("application/json")
    public Collection<Subscription> getAllSubscriptionsOfCustomer( @PathParam("cid") Integer cid) {
   
        return pbl.getAllSubscriptionsOfCustomer(cid);
    }

    
//    public Collection<Subscription> getSubscriptionsByType(String type) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @POST
    @Path("addsubstocust/{cid}")
    @Consumes("application/json")
    public void addSubscriptionsToCustomer(@PathParam("cid") int cid, Collection<Integer> sids) {
      
    pbl.addSubscriptionsToCustomer(cid, sids);
    }

    @POST
    @Path("removesubstocust/{cid}")
    @Consumes("application/json")
    public void removeSubscriptionsToCustomer(@PathParam("cid") int cid, Collection<Integer> sids) {
      
    pbl.removeSubscriptionsToCustomer(cid, sids);
    }
    
    
}

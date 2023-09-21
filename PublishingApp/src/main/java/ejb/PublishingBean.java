/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PublishingBean implements PublishingBeanLocal {
    
    @PersistenceContext(unitName = "pubpu")
    EntityManager em;

    @Override
    public void addCustomer(String firstName, String lastName) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
      Customer c = new Customer();
      c.setFirstName(firstName);
      c.setLastName(lastName);
      em.persist(c);
    
    }

    @Override
    public void updateCustomer(Integer cid, String firstName, String lastName) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Customer c = (Customer) em.find(Customer.class, cid);
     c.setFirstName(firstName);
      c.setLastName(lastName);
      
      em.merge(c);
    
    
    }

    @Override
    public void removeCustomer(Integer cid) {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      Customer c = (Customer) em.find(Customer.class, cid);
  
       em.remove(c);
    
    }

    @Override
    public Customer findCustomerById(Integer cid) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Customer c = (Customer) em.find(Customer.class, cid);
    return c;
    }

    @Override
    public Collection<Customer> getAllCustomers() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
       Collection<Customer> customers = em.createNamedQuery("Customer.findAll").getResultList();
    return customers;
    }

    @Override
    public Collection<Customer> getCustomersByfirstName(String firstName) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   Collection<Customer> customers = em.createNamedQuery("Customer.findByFirstName")
           .setParameter("firstName", firstName)
           .getResultList();
    return customers;
    }

    @Override
    public Collection<Customer> getCustomersBylastName(String lastName) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Collection<Customer> customers = em.createNamedQuery("Customer.findByLastName")
           .setParameter("lastName", lastName)
           .getResultList();
    
    return customers;
    }

    @Override
    public void addAddressToCustomer(String street, String city, String state, String zip, Integer cid) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Customer c = (Customer) em.find(Customer.class, cid);
    Collection<Address> addresses = c.getAddressCollection();
    
   Address a = new Address();
   a.setStreet(street);
   a.setCity(city);
   a.setState(state);
   a.setZip(zip);
   a.setCustomer(c);
   
   addresses.add(a);
   c.setAddressCollection(addresses);
   
   em.persist(a);
   em.merge(c);
    
    }

    @Override
    public void updateAddressToCustomer(Integer aid, String street, String city, String state, String zip, Integer cid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeAddressToCustomer(Integer aid, Integer cid) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
    Customer c = (Customer) em.find(Customer.class, cid);
    Address a = (Address) em.find(Address.class, aid);
   
    Collection<Address> addresses = c.getAddressCollection();
    
    if(addresses.contains(a))
    {
        addresses.remove(a);
        c.setAddressCollection(addresses);
        em.remove(a);
    }
    
    
    }

    @Override
    public Collection<Address> getAddressesofCustomer(Integer cid) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Customer c = (Customer) em.find(Customer.class, cid);
    
     return c.getAddressCollection();
    }

    @Override
    public Collection<Address> getAddressesByCity(String city) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Address> getAddressesByState(String state) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Address> getAddressesByZip(String zip) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void createSubscription(String title, String type) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        Subscription sub = new Subscription();
        sub.setTitle(title);
        sub.setType(type);
        em.persist(sub);
    
    }

    @Override
    public void updateSubscription(Integer id, String title, String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeSubscription(int sid) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Subscription sub = (Subscription) em.find(Subscription.class, sid);
    em.remove(sub);
    }

    @Override
    public Collection<Subscription> getAllSubscriptions() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    return em.createNamedQuery("Subscription.findAll").getResultList();
    }

    @Override
    public Collection<Subscription> getAllSubscriptionsOfCustomer(Integer cid) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Customer c = (Customer) em.find(Customer.class, cid);
    return c.getSubscriptionCollection();
    }

    @Override
    public Collection<Subscription> getSubscriptionsByType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addSubscriptionsToCustomer(int cid, Collection<Integer> sids) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Customer c = (Customer) em.find(Customer.class, cid);
     Collection<Subscription> subs = c.getSubscriptionCollection();
     
    for(Integer sid: sids)
    {
    
        Subscription s = (Subscription) em.find(Subscription.class, sid);
        
        if(!subs.contains(s))
        {
            Collection<Customer> customers = s.getCustomerCollection();
            customers.add(c);
            subs.add(s);
            
            c.setSubscriptionCollection(subs);
            s.setCustomerCollection(customers);
            
            em.merge(s);
          
        }
    }
    
    }

    @Override
    public void removeSubscriptionsToCustomer(int cid, Collection<Integer> sids) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Customer c = (Customer) em.find(Customer.class, cid);
     Collection<Subscription> subs = c.getSubscriptionCollection();
     
    for(Integer sid: sids)
    {
    
        Subscription s = (Subscription) em.find(Subscription.class, sid);
        
        if(subs.contains(s))
        {
            Collection<Customer> customers = s.getCustomerCollection();
            customers.remove(c);
            subs.remove(s);
            
            c.setSubscriptionCollection(subs);
            s.setCustomerCollection(customers);
            
            em.merge(s);
          
        }
    }
    
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")




}

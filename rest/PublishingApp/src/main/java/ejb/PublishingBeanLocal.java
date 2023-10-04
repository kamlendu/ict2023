/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PublishingBeanLocal {
    
   // === Customer =====
    void addCustomer(String firstName, String lastName);
    void updateCustomer(Integer cid, String firstName, String lastName);
    void removeCustomer(Integer cid);
    Customer findCustomerById(Integer cid);
    Collection<Customer> getAllCustomers();
    Collection<Customer> getCustomersByfirstName(String firstName);
    Collection<Customer> getCustomersBylastName(String lastName);
    
    //========  Address
    
    void addAddressToCustomer(String street, String city, String state, String zip, Integer cid);
    void updateAddressToCustomer(Integer aid, String street, String city, String state, String zip, Integer cid);  
    void removeAddressToCustomer(Integer aid, Integer cid);
    Collection<Address> getAddressesofCustomer(Integer cid);
    Collection<Address> getAddressesByCity(String city);
    Collection<Address> getAddressesByState(String state);
    Collection<Address> getAddressesByZip(String zip);
    
    //====  Subscription
    
    void createSubscription(String title, String type);
    void updateSubscription(Integer id, String title, String type);
    void removeSubscription(int sid);
    Collection<Subscription> getAllSubscriptions();
     Collection<Subscription> getAllSubscriptionsOfCustomer(Integer cid);
   
    Collection<Subscription> getSubscriptionsByType(String type);
    
    
    void addSubscriptionsToCustomer(int cid, Collection<Integer> sids);
    void removeSubscriptionsToCustomer(int cid, Collection<Integer> sids);
    
    
    
    
    
    
    
    
    
    
}

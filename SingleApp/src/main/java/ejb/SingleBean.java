/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package ejb;

import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.UserTransaction;

/**
 *
 * @author root
 */
@TransactionManagement(TransactionManagementType.BEAN)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@AccessTimeout(unit = TimeUnit.SECONDS, value = 30)
@Startup
@Singleton
@DependsOn({"FirstBean", "SecondBean"})
public class SingleBean {
    
    @Resource UserTransaction utx;
    
    String firstName;
    String lastName;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

@PostConstruct    
public void initialize()
{
    firstName="Rajesh";
    lastName ="Patel";
    System.out.println(" I am a Singleton Bean");
}
    @Lock(LockType.READ)
    public String getFirstName() {
        return firstName;
    }
    @Lock(LockType.WRITE)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Lock(LockType.READ)
    public String getLastName() {
        return lastName;
    }

    @Lock(LockType.WRITE)
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getFullName( String fname, String lname)
    {
        String fullname="";
        this.firstName=fname;
        this.lastName=lname;
       try{
        fullname = firstName + " "+ lastName;
        utx.commit();
       }
       catch(Exception e)
       {
           try{
           utx.setRollbackOnly();
           }
           catch(Exception tr)
           {
               tr.printStackTrace();
           }
           e.printStackTrace();
       }
        return fullname;
    }





}

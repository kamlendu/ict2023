/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author root
 */
@Named(value = "person")
@RequestScoped
public class Person {
    
    String pname;
    String email;
    double salary;
    String gender;
    Collection<String> hobbies;

    /**
     * Creates a new instance of Person
     */
    public Person() {
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
    
    
    
//    public String showMe()
//    {
//        return "Show";
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

   
public void validateSalary(FacesContext ctx, UIComponent ui, Object obj)
{

Double sal = (Double)obj;

if(sal <3000)
{
    FacesMessage msg = new FacesMessage("Salary cannot be less than 3000");
    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
    throw new ValidatorException(msg);
    
}





    
}
   

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Collection<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Collection<String> hobbies) {
        this.hobbies = hobbies;
    }

    
    public String showMe()
    {
        
        this.pname=this.pname.toUpperCase();
        return "Show";
    }
   
}

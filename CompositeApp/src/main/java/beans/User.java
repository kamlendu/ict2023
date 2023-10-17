/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author root
 */
@Named(value = "user")
@SessionScoped
public class User implements Serializable {

    String person;
    String username;
    String password;
    Collection<String> names;
    String message1;
    String message2;
    
    /**
     * Creates a new instance of User
     */
    public String action()
    {
        return "Show.jsf";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public User() {
        
        names = new ArrayList<>();
        names.add("Ritesh");
        names.add("Sapna");
        names.add("Arvind");
        
    }
    
    
    public void valueEvent(ValueChangeEvent evt)
    {
       this.message1 = "Old Val : "+ evt.getOldValue() + " New Val : "+ evt.getNewValue();
    }
    
    
    public void handle(ActionEvent ae)
    {
        this.message2 = "You have Clicked a button";
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public Collection<String> getNames() {
        return names;
    }

    public void setNames(Collection<String> names) {
        this.names = names;
    }

    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }
    
    
    
}

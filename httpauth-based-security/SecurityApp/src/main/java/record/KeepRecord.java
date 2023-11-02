/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package record;

import java.io.Serializable;
import java.util.Set;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.security.enterprise.CallerPrincipal;

/**
 *
 * @author root
 */
@Named
@SessionScoped
public class KeepRecord implements Serializable {
    
   static CallerPrincipal principal;
   static Set<String> roles;

    public static CallerPrincipal getPrincipal() {
        return principal;
    }

    public static void setPrincipal(CallerPrincipal principal) {
        KeepRecord.principal = principal;
    }

    public static Set<String> getRoles() {
        return roles;
    }

    public static void setRoles(Set<String> roles) {
        KeepRecord.roles = roles;
    }

    
    public static void reset()
    {
        principal=null;
        roles=null;
    }
    
    
}

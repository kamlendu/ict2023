/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author root
 */
public class MyListeners implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application Deployed ....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
         System.out.println("Application UnDeployed ....");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        
         System.out.println("Application Attribute added  .... name =" + event.getName() + " value = " + event.getValue().toString());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
               System.out.println("Application Attribute removed  .... name =" + event.getName() + " value = " + event.getValue().toString());
  
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        
               System.out.println("Session created ... ");
  
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
          System.out.println("Session destroyed ... ");
  
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        
               System.out.println("Session Attribute added  .... name =" + event.getName() + " value = " + event.getValue().toString());
 
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
               System.out.println("Session Attribute removed  .... name =" + event.getName() + " value = " + event.getValue().toString());
 
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
    }
}

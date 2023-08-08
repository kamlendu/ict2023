
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */

/**
 * Web application lifecycle listener.
 *
 * @author root
 */
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
         String[] stringArray = new String[] {
	    "A first string",
	    "Second String",
	    "Third String",
	};
         sce.getServletContext().setAttribute("strArray", stringArray);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}


import java.util.Hashtable;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Web application lifecycle listener.
 * @author root
 */
public class MyListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {

        int[] intArray = new int[] {10, 20, 30, 40, 50};
        sce.getServletContext().setAttribute("intArray", intArray);

	/**
	 * Array of Objects (String)
	 */
	String[] stringArray = new String[] {
	    "A first string",
	    "Second String",
	    "Third String",
	};
        sce.getServletContext().setAttribute("stringArray", stringArray);

	/**
        * String-keyed Map
        */
        Hashtable stringMap = new Hashtable();
        sce.getServletContext().setAttribute("stringMap", stringMap);
        stringMap.put("one", "uno");
        stringMap.put("two", "dos");
        stringMap.put("three", "tres");
        stringMap.put("four", "cuatro");
        stringMap.put("five", "cinco");
        stringMap.put("six", "seis");
        stringMap.put("seven", "siete");
        stringMap.put("eight", "ocho");
        stringMap.put("nine", "nueve");
        stringMap.put("ten", "diez");

    }

    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

public MyListener()
    {

}


}

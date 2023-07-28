
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CalculateVisit extends HttpServlet {

    private int Counter;

    /*Processing an HTTP GET request */
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws
            ServletException, IOException {
        /* Obtaining an output stream */
        PrintWriter out = response.getWriter();

        /* Setting content type and other response header fields */
        response.setContentType("text/html");

        boolean newVisitor = true;

        /* Retrieving all cookies into an array of type cookie */
        Cookie[] visitCookie = request.getCookies();
        

        /* Verifying if cookies were retrieved or not */
        if (visitCookie != null) {
            /* Traversing across the values held in the cookies array */
//for(Cookie c : visitCookie)
    
            for (int i = 0; i < visitCookie.length; i++) {
                /* Verifying whether the cookie name is oldVisitor and value is 1 */
                if ((visitCookie[i].getName().equals("oldVisitor")) && (visitCookie[i].getValue().equals("1"))) {
                    /* Setting the value of Boolean newVisitor to false */
                    newVisitor = false;
                    break;
                }
            }
        }

        /* Verifying if the Boolean value is true */
        if (newVisitor) {
            /* Creating two cookies */
            Cookie returnVisitorCookie = new Cookie("oldVisitor", "1");
            Cookie visitorCounter = new Cookie("cnt", "1");

            /* Setting how much time in seconds should elapse before the cookie expires */
            returnVisitorCookie.setMaxAge(3600);
            /* Adding cookie to the Set-Cookie response header by means of the addCookie method of HttpServletResponse */
            response.addCookie(returnVisitorCookie);

            /* Setting how much time in seconds should elapse before the cookie expires */
            visitorCounter.setMaxAge(3600);
            /* Adding cookie to the Set-Cookie response header by means of the addCookie method of HttpServletResponse */
            response.addCookie(visitorCounter);

            /* Message displayed when visited for the first time */
            out.println("This is the first time you have visited this page.");
        } else {
            /* Message displayed when visited more than once */
            out.println("Welcome Back To This Page");
            /* Retrieving all cookies into an array of type cookie */
            Cookie[] c = request.getCookies();

            /* Verifying if cookies were retrieved or not */
            if (c != null) {
                /* Creating an empty cookie */
                Cookie tc = null;

                /* Traversing across the values held in the cookies array */
                for (int i = 0; i < c.length; i++) {
                    /* Verifying whether the cookie name is cnt */
                    if (c[i].getName().equals("cnt")) {
                        /* Setting the value of the number of cookies retrieved to the cookie named tc */
                        tc = c[i];
                        /* Setting the value of the number of cookies retrieved to the variable named Counter */
                        Counter = Integer.parseInt(c[i].getValue());
                        break;
                    }
                }
                /* Incrementing the counter for displaying the number of visits made */
                Counter++;

    /* Setting the value of the variable named Counter to cookie named tc */
                tc.setValue(Integer.toString(Counter));
                /* Setting how much time in seconds should elapse before the cookie expires */
                tc.setMaxAge(3600);
                /* Adding cookie to the Set-Cookie response header by means of the addCookie method of HttpServletResponse */
                response.addCookie(tc);

                /* Displaying total number of visits made to this page */
                out.println("<BR><B>You have visited this page " + Counter + " time(s)</B>");
            }
        }
    }
}

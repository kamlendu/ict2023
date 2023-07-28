
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class DisplaySession extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession mySession = request.getSession(true);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //
        String heading;
        Integer counter = new Integer(0);

        if (mySession.isNew()) {
            heading = "This is the first time you are visiting this page.";
        } else {
            heading = "Welcome back to this page";
            Integer oldCounter = (Integer) mySession.getAttribute("counter");

            if (oldCounter != null) {
                counter = new Integer(oldCounter.intValue() + 1);
            }
        }

        mySession.setAttribute("counter", counter);

        out.println("<HTML><HEAD><TITLE>Welcome To The World Of Sessions</TITLE></HEAD><BODY>");
        out.println("<H3>" + heading + "</H3><BR>");
        out.println("<B>Session ID: </B>" + mySession.getId() + "<BR>");
        out.println("<B>Creation Time of the Session: </B>" + new Date(mySession.getCreationTime()) + "<BR>");
        out.println("<B>Time of Last Access: </B>" + new Date(mySession.getLastAccessedTime()) + "<BR><BR>");
        out.println("You have visited this page " + (++counter));
        out.println((counter == 1) ? " time " : " times ");
        out.println("</BODY></HTML>");

    mySession.setMaxInactiveInterval(2);
    }
}
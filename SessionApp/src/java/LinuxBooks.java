
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class LinuxBooks extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession sessionCart = request.getSession(true);

        /* Setting MIME type for HTTP header */
        response.setContentType("text/html");
        /* Obtaining the output stream */
        PrintWriter out = response.getWriter();

        if (request.getParameter("btnBill") != null) {
            Enumeration productNames = sessionCart.getAttributeNames();

            if (productNames.hasMoreElements()) {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/GenerateBill");
                rd.include(request, response);
            } else {
                out.println("<FONT COLOR='blue'><B>Basket seems to be empty. </B>Please select some item(s) and add them to the basket before generating the bill</FONT>");
            }
        }

        if (request.getParameter("btnRmvLinux") != null) {
            String books[] = request.getParameterValues("chkLinux");

            if (books != null) {
                for (int i = 0; i < books.length; i++) {
                    sessionCart.removeAttribute(books[i]);
                }
            }
        }

        if (request.getParameter("btnAddLinux") != null) {
            String books[] = request.getParameterValues("chkLinux");
            String costs[] = request.getParameterValues("txtLinux");
            String qty[] = request.getParameterValues("txtQty");

            String total;
            if (books != null) {
                for (int i = 0; i < books.length; i++) {
                    total = Float.toString(Float.valueOf(costs[i]) * Float.valueOf(qty[i]));
                    sessionCart.setAttribute(books[i], total);
                }
            }
        }

        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<SCRIPT LANGUAGE='JavaScript'>");
        out.println("function swap() {");
        out.println("for (var i=0,n=document.frmLinuxBooks.chkLinux.length;i<n;i++)  {");
        out.println("checked = document.frmLinuxBooks.chkLinux[i].checked;");
        out.println("if (checked==false) {");
        out.println("document.frmLinuxBooks.txtLinux[i].disabled = true;");
        out.println("document.frmLinuxBooks.txtQty[i].disabled = true;");
        out.println("} else {");
        out.println("document.frmLinuxBooks.txtLinux[i].disabled = false;");
        out.println("document.frmLinuxBooks.txtQty[i].disabled = false;");
        out.println("}");
        out.println("}");
        out.println("}");
        out.println("</SCRIPT>");
        out.println("<TITLE>Linux Books</TITLE></HEAD>");

        out.println("<BODY BGCOLOR='pink'>");
        out.println("<H1 ALIGN='center'>Linux Books For Sale</H1><BR>");
        out.println("<FORM NAME='frmLinuxBooks' METHOD='post' ACTION='/SessionApp/LinuxBooks'>");
        out.println("<TABLE BGCOLOR='pink' WIDTH='100%' ALIGN='center' CELLPADDING='1' CELLSPACING='1'>");
        out.println("<TR BGCOLOR='pink'><TD WIDTH='70%'>");
        out.println("<TABLE BGCOLOR='pink' WIDTH='400' ALIGN='center' CELLPADDING='1' CELLSPACING='1' BORDERCOLOR='maroon' BORDER='1'>");
        out.println("<TR BGCOLOR='maroon'>");
        out.println("<TH ALIGN='left' COLSPAN='2' WIDTH='340'><B>");
        out.println("<FONT COLOR='WHITE'>Book Titles</FONT></B></TH>");
        out.println("<TH WIDTH='60'><B>");
        out.println("<FONT COLOR='WHITE'>Price</FONT></B></TH>");
        out.println("<TH WIDTH='60'><B>");
        out.println("<FONT COLOR='WHITE'>Qty</FONT></B></TH>");
        out.println("</TR>");

        out.println("<TR>");
        out.println("<TD>");
        out.println("<INPUT TYPE='checkbox' NAME='chkLinux' onClick='swap();' VALUE='Using MySQL on Linux'></TD>");
        out.println("<TD WIDTH='340'>Using MySQL on Linux </TD>");
        out.println("<TD WIDTH='60'><INPUT TYPE='text' NAME='txtLinux' VALUE='150' DISABLED></TD></TD>");
        out.println("<TD WIDTH='60'><INPUT TYPE='text' NAME='txtQty' VALUE='1' DISABLED></TD></TD>");
        out.println("</TR>");

        out.println("<TR>");
        out.println("<TD>");
        out.println("<INPUT TYPE='checkbox' NAME='chkLinux' onClick='swap();' VALUE='Using OpenOffice on Linux'></TD>");
        out.println("<TD WIDTH='340'>Using OpenOffice on Linux </TD>");
        out.println("<TD WIDTH='60'><INPUT TYPE='text' NAME='txtLinux' VALUE='200' DISABLED></TD></TD>");
        out.println("<TD WIDTH='60'><INPUT TYPE='text' NAME='txtQty' VALUE='1' DISABLED></TD></TD>");
        out.println("</TR>");

        out.println("<TR>");
        out.println("<TD>");
        out.println("<INPUT TYPE='checkbox' NAME='chkLinux' onClick='swap();' VALUE='Using Staroffice 7.0 on Linux'></TD>");
        out.println("<TD WIDTH='340'>Using Staroffice 7.0 on Linux </TD>");
        out.println("<TD WIDTH='60'><INPUT TYPE='text' NAME='txtLinux' VALUE='250' DISABLED></TD></TD>");
        out.println("<TD WIDTH='60'><INPUT TYPE='text' NAME='txtQty' VALUE='1' DISABLED></TD></TD>");
        out.println("</TR>");

        out.println("<TR>");
        out.println("<TD>");
        out.println("<INPUT TYPE='checkbox' NAME='chkLinux' onClick='swap();' VALUE='Application Development With Oracle & PHP on Linux'></TD>");
        out.println("<TD WIDTH='340' HEIGHT='24'>App. Development With Oracle & PHP On Linux </TD>");
        out.println("<TD WIDTH='60'><INPUT TYPE='text' NAME='txtLinux' VALUE='400' DISABLED></TD></TD>");
        out.println("<TD WIDTH='60'><INPUT TYPE='text' NAME='txtQty' VALUE='1' DISABLED></TD></TD>");
        out.println("</TR>");

        out.println("<TR><TD COLSPAN='4'>");
        out.println("<TABLE BGCOLOR='pink' ALIGN='center'>");
        out.println("</TR>");
        out.println("<TD COLSPAN='2' ALIGN='right'>");
        out.println("<INPUT TYPE='submit' VALUE='Add To My Basket' NAME='btnAddLinux'>");
        out.println("</TD>");
        out.println("<TD COLSPAN='2' ALIGN='right'>");
        out.println("<INPUT TYPE='submit' VALUE='Remove From My Basket' NAME='btnRmvLinux'></TD>");
        out.println("</TD>");
        out.println("<TD COLSPAN='2' ALIGN='right'>");
        out.println("<INPUT NAME='btnBill' TYPE='submit' ID='btnBill' VALUE='Generate Bill'>");
        out.println("</TD>");
        out.println("</TR></TABLE>");
        out.println("</TD></TR>");
        out.println("</TABLE>");
        out.println("</TD>");

        out.println("<TD>");
        out.println("<TABLE BORDER='1' ALIGN='right' BORDERCOLOR='blue' WIDTH='350' HEIGHT='250'>");
        out.println("<TR>");
        out.println("<TD ALIGN='center' BGCOLOR='lightblue' COLSPAN='2' HEIGHT='20'>Basket</TD>");
        out.println("</TR>");

        out.println("<TR>");
        out.println("<TD ALIGN='center' BGCOLOR='lightblue' HEIGHT='20'>Book</TD>");
        out.println("<TD ALIGN='center' BGCOLOR='lightblue' HEIGHT='20'>Price</TD>");
        out.println("</TR>");

        String productName = null;
        float totalCost = 0;
        float price = 0;

        Enumeration productNames = sessionCart.getAttributeNames();

        for (int i = 0; productNames.hasMoreElements(); i++) {
            productName = (String) productNames.nextElement();
            price = Float.valueOf(sessionCart.getAttribute(productName).toString());

            out.println("<TR>");
            out.println("<TD ALIGN='left' BGCOLOR='lightblue'>");
            out.println(productName);
            out.println("</TD>");

            out.println("<TD ALIGN='left' BGCOLOR='lightblue'>");
            out.println(price);
            out.println("</TD>");
            out.println("</TR>");

            totalCost += price;
        }
        out.println("<TR>");
        out.println("<TD ALIGN='center' BGCOLOR='lightblue' HEIGHT='20'>Total: </TD>");
        out.println("<TD ALIGN='center' BGCOLOR='lightblue' HEIGHT='20'>" + totalCost + "</TD>");
        out.println("</TR>");

        out.println("</TABLE>");
        out.println("</TD></TR>");
        out.println("</TABLE>");
        out.println("</FORM>");
        out.println("</BODY>");
        out.println("</HTML>");

        out.close();
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import client.PublishClient;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@WebServlet(name = "RestPublishServlet", urlPatterns = {"/RestPublishServlet"})
public class RestPublishServlet extends HttpServlet {
    //@EJB PublishingBeanLocal pbl;
    
    PublishClient pbl;
    Response res;
    Collection<Customer> customers;
    GenericType<Collection<Customer>> gcustomers;
    Collection<Address> addresses;
     GenericType<Collection<Address>> gaddresses;
    Collection<Subscription> subs;
     GenericType<Collection<Subscription>> gsubs;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PublishingServlet</title>");            
            out.println("</head>");
            out.println("<body><h3>");
            
            pbl = new PublishClient();
            customers = new ArrayList<>();
            gcustomers = new GenericType<Collection<Customer>>(){};
            addresses = new ArrayList<>();
            gaddresses = new GenericType<Collection<Address>>(){};
            subs = new ArrayList<>();
            gsubs =  new GenericType<Collection<Subscription>>(){};
            
          //  pbl.addCustomer("Subhash", "Patel");
          //pbl.addAddressToCustomer("C-101", "Indore", "MP","543210", "13");
         // pbl.addAddressToCustomer("Downing Street", "Old Delhi", "Delhi","1110110", "13");
        
            Collection<Integer> ids = new ArrayList<>();
            ids.add(1);ids.add(2);ids.add(3);
            
           // pbl.addSubscriptionsToCustomer(ids, "13");
           // pbl.removeSubscriptionsToCustomer(ids, "13");
            
            //pbl.removeAddressToCustomer("8","13");
            // pbl.removeAddressToCustomer("9","13");


                pbl.removeCustomer("13");
               
            
            res = pbl.getAllCustomers(Response.class);
            customers = res.readEntity(gcustomers);
            out.println("<h3>");
            for(Customer c : customers)
            {
                out.println("id = "+ c.getCustomerID()+ " "+ c.getFirstName()+ " "+ c.getLastName());
                
                res = pbl.getAddressesofCustomer(Response.class, c.getCustomerID().toString());
                addresses  = res.readEntity(gaddresses);
               // rs.readEntity(gaddresses);
                for(Address a : addresses)
                {
                out.println("<br/>id = "+ a.getAddressId()+ " street: "+ a.getStreet()+ " city : "+ a.getCity()+ " state : "+ a.getState());
                }
                res = pbl.getAllSubscriptionsOfCustomer(Response.class, c.getCustomerID().toString());
                subs = res.readEntity(gsubs);
                for(Subscription s : subs)
                {
                    out.println("<br/>id = "+ s.getSubscriptionId()+" title : "+ s.getTitle()+ " type :"+ s.getType());
                }
                
               out.println("<hr/>");
            }
            
             out.println("</h3>");
            
            
            
            out.println("<h1>Servlet RestPublishServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

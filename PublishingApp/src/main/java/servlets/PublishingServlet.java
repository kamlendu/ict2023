/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import ejb.PublishingBeanLocal;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "PublishingServlet", urlPatterns = {"/PublishingServlet"})
public class PublishingServlet extends HttpServlet {
    
    @EJB PublishingBeanLocal pbl;

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
            
           // pbl.addCustomer("Riken", "Parmar");
         //  pbl.addAddressToCustomer("Udhna Street", "Surat", "Gujarat", "362312", 10);
          //pbl.addAddressToCustomer("Vadodara Street", "Vadodara", "Gujarat", "380001", 10);
          
         // pbl.removeAddressToCustomer(6, 10);
         //  pbl.removeAddressToCustomer(7, 10);
          
         pbl.removeCustomer(10);
        
          
          ArrayList<Integer> sids = new ArrayList<Integer>();
          sids.add(1);
          sids.add(4);
          
         // pbl.addSubscriptionsToCustomer(10, sids);
          
         //  pbl.removeSubscriptionsToCustomer(10, sids);
            
            Collection<Customer> customers = pbl.getAllCustomers();
            
            for(Customer c : customers)
            {
                out.println("id: "+ c.getCustomerID()+" Customer Name : "+ c.getFirstName() + " "+ c.getLastName());
                
                Collection<Address> addresses = pbl.getAddressesofCustomer(c.getCustomerID());
             
                for(Address a : addresses)
               {
                  out.println("<br/> Aid : "+ a.getAddressId()+" Street :"+ a.getStreet()+ " city: "+ a.getCity()+" State: "+ a.getState());
               }
               Collection<Subscription> subs = pbl.getAllSubscriptionsOfCustomer(c.getCustomerID());
                
               for(Subscription s : subs){
                out.println("<br/> sid : "+ s.getSubscriptionId()+" Title: "+ s.getTitle() + " Type : "+ s.getType());
               }
               
              out.println("<hr/>");
            }
            
            
            
            
            out.println("<h1>Servlet PublishingServlet at " + request.getContextPath() + "</h1>");
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

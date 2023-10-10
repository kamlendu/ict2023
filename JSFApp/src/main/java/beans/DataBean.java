/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.BookClient;
import ejb.BookBean;
import entity.BookMaster;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@Named(value = "dataBean")
@RequestScoped
public class DataBean {
    
    //@EJB BookBean bb;
    BookClient cl;
    Response rs;
    
    String bookname;
    
    Collection<BookMaster> books;
    
    GenericType<Collection<BookMaster>> gbooks;

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    /**
     * Creates a new instance of DataBean
     */
    public DataBean() {
        
        cl = new BookClient();
        books = new ArrayList<>();
        gbooks = new GenericType<Collection<BookMaster>>(){};
        
    }

    public Collection<BookMaster> getBooks() {
        
        rs = cl.getBooks(Response.class);
        books = rs.readEntity(gbooks);
        //books = bb.getAllBooks();
        return books;
    }

    public void setBooks(Collection<BookMaster> books) {
        this.books = books;
    }
    
    
    
}

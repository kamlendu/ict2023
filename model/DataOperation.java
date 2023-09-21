/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.BookMaster;
import java.util.Collection;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author root
 */
@Named
public class DataOperation {
    EntityManager em;

    public DataOperation() {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpapu");
        em = emf.createEntityManager();
        
    }
  
    
    public Collection<BookMaster> getAllBooks() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
       Collection<BookMaster> books = em.createNamedQuery("BookMaster.findAll").getResultList();
       // Collection<BookMaster> books = em.createQuery("select b from BookMaster b").getResultList();
    
    return books;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    
    public void addBook(String bookName, String author, String publisher, String synopsis) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        BookMaster bm = new BookMaster();
        bm.setBookName(bookName);
        bm.setAuthorName(author);
        bm.setPublisherName(publisher);
        bm.setSynopsis(synopsis);
        
        try{
        em.getTransaction().begin();
        
        em.persist(bm);
        
        em.getTransaction().commit();
        }
        catch(Exception e)
        {
            em.getTransaction().rollback();
        }
    
    }

    
    public void updateBook(int bookid, String bookName, String author, String publisher, String synopsis) {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    BookMaster bm = em.find(BookMaster.class, bookid);
    bm.setBookName(bookName);
        bm.setAuthorName(author);
        bm.setPublisherName(publisher);
        bm.setSynopsis(synopsis);
        
        em.getTransaction().begin();
        em.merge(bm);
        em.getTransaction().commit();
    
    }

    
    public void removeBook(int bookid) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    BookMaster bm = em.find(BookMaster.class, bookid);
    
    em.getTransaction().begin();
     em.remove(bm);
     em.getTransaction().commit();
    }

    
    public Collection<BookMaster> findBookByAuthor(String authorName) {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
    Collection<BookMaster> books = em.createNamedQuery("BookMaster.findByAuthorName")
                                    .setParameter("authorName", authorName)
                                       .getResultList();
    
    return books;
    }

    
    public BookMaster findBookbyID(int bookid) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    BookMaster bm = em.find(BookMaster.class, bookid);
    
    return bm;
    }

    
    public BookMaster findBookByName(String bookName) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    BookMaster bm = (BookMaster) em.createNamedQuery("BookMaster.findByBookName")
                                    .setParameter("bookName", bookName)
                                       .getSingleResult();
     return bm;
    }

    
    
}

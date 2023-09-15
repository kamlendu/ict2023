/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.BookMaster;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class JPABean implements JPABeanLocal {
    
    @PersistenceContext(unitName = "jpapu")
    EntityManager em;
    
    
    
    

    @Override
    public Collection<BookMaster> getAllBooks() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
       Collection<BookMaster> books = em.createNamedQuery("BookMaster.findAll").getResultList();
       // Collection<BookMaster> books = em.createQuery("select b from BookMaster b").getResultList();
    
    return books;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addBook(String bookName, String author, String publisher, String synopsis) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        BookMaster bm = new BookMaster();
        bm.setBookName(bookName);
        bm.setAuthorName(author);
        bm.setPublisherName(publisher);
        bm.setSynopsis(synopsis);
        
        em.persist(bm);
    
    }

    @Override
    public void updateBook(int bookid, String bookName, String author, String publisher, String synopsis) {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    BookMaster bm = em.find(BookMaster.class, bookid);
    bm.setBookName(bookName);
        bm.setAuthorName(author);
        bm.setPublisherName(publisher);
        bm.setSynopsis(synopsis);
        
        em.merge(bm);
    
    }

    @Override
    public void removeBook(int bookid) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    BookMaster bm = em.find(BookMaster.class, bookid);
    
     em.remove(bm);
    }

    @Override
    public Collection<BookMaster> findBookByAuthor(String authorName) {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
    Collection<BookMaster> books = em.createNamedQuery("BookMaster.findByAuthorName")
                                    .setParameter("authorName", authorName)
                                       .getResultList();
    
    return books;
    }

    @Override
    public BookMaster findBookbyID(int bookid) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    BookMaster bm = em.find(BookMaster.class, bookid);
    
    return bm;
    }

    @Override
    public BookMaster findBookByName(String bookName) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    BookMaster bm = (BookMaster) em.createNamedQuery("BookMaster.findByBookName")
                                    .setParameter("bookName", bookName)
                                       .getSingleResult();
     return bm;
    }



}

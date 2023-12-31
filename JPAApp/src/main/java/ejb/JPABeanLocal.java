/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.BookMaster;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface JPABeanLocal {
    
    Collection<BookMaster> getAllBooks();
    void addBook(String bookName, String author, String publisher, String synopsis);
    void updateBook(int bookid, String bookName, String author, String publisher, String synopsis);
    void removeBook(int bookid);
    Collection<BookMaster> findBookByAuthor(String authorName );
    BookMaster findBookbyID(int bookid);
    BookMaster findBookByName(String bookName);
    
}

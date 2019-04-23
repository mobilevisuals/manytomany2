/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manytomanytester;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import packag.Author;
import packag.Book;

/**
 *
 * @author eyvind
 */
public class ManyToManyTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("ManyToManyTesterPU");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        Book book1=new Book();
        book1.setTitle("Tapeter och solsken");
        book1.setPages(678);
        Book book2=new Book();
        book2.setTitle("Java och annat");
        book2.setPages(478);
        
        Author author=new Author();
        author.setCountry("Sverige");
        author.setName("Janne Andersson");
        Author author2=new Author();
        author2.setCountry("Sverige");
        author2.setName("Jan Nilsson");
        Set<Book> books=new HashSet();
        books.add(book1);
         books.add(book2);
        author.setBooks(books);
          Set<Author> authors=new HashSet();
          authors.add(author);
            authors.add(author2);
          book1.setAuthors(authors);
          em.persist(author);
          em.persist(book1);
          em.persist(author2);
          em.persist(book2);
          em.getTransaction().commit();
        
    }
    
}

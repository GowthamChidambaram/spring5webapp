package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Gowtham C on 17/04/21.
 */

@Component
public class BootStrapData implements CommandLineRunner {

  @Autowired
  private AuthorRepository authorRepository;
  @Autowired
  private BookRepository bookRepository;

  public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "123123");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(ddd);

    Author rod = new Author("Rod", "Jhonson");
    Book noEJB = new Book("J2EE development without EJB", "3939459459");
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);

    authorRepository.save(rod);
    bookRepository.save(noEJB);

    System.out.println("Started in bootstrap");
    System.out.println("Number of Books" + bookRepository.count());

  }
}
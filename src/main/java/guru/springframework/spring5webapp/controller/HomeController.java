package guru.springframework.spring5webapp.controller;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Gowtham C on 19/04/21.
 */
@Controller
public class HomeController {

  @Autowired
  private final AuthorRepository authorRepository;
  @Autowired
  private final BookRepository bookRepository;

  public HomeController(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @RequestMapping("/home")
  @ResponseBody
  public String countHome() {
    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "123123");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(ddd);

    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "3939459459");
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);

    authorRepository.save(rod);
    bookRepository.save(noEJB);

    System.out.println("Started in Bootstrap");
    String c= "Number of Books: " + bookRepository.count();

    return c;
  }
}

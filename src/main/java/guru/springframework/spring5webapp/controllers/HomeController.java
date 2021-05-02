package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
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
  @Autowired
  private final PublisherRepository publisherRepository;

  public HomeController(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @RequestMapping("/home")
  @ResponseBody
  public String countHome() {

    Publisher publisher = new Publisher();
    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "123123");

    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);
    publisher.setName("dubuku");

//    publisher.setName("SFG publishing");
//    publisher.setCity("california");
//    publisher.setState("NY");

    ddd.setPublisher(publisher);
    publisher.getBooks().add(ddd);



    authorRepository.save(eric);
    publisherRepository.save(publisher);
    bookRepository.save(ddd);

    Publisher publisher1 = new Publisher();
    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "3939459459");
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);

    noEJB.setPublisher(publisher1);
    publisher1.getBooks().add(noEJB);

    authorRepository.save(rod);
    publisherRepository.save(publisher1);
    bookRepository.save(noEJB);


    System.out.println("Started in Bootstrap");
    System.out.println("publisher count"+ publisher.getBooks().size());
    String c= "Number of Books: " + bookRepository.count();





    return c;
  }
}

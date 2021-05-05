package com.kimz.storewebapp.bootstrap;

import com.kimz.storewebapp.domain.Author;
import com.kimz.storewebapp.domain.Book;
import com.kimz.storewebapp.domain.Publisher;
import com.kimz.storewebapp.repositories.AuthorRepository;
import com.kimz.storewebapp.repositories.BookRepository;
import com.kimz.storewebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component  //tells the spring framework to go ahead and detect this as spring managed component
public class BootStrapData implements CommandLineRunner {

    //using dependency injection
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    //when spring implements this component it would do dependency injection into the
    //constructor for an instance of author repository and book repository
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository =publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Oreilly Media");
        publisher.setAddressLine1("CA, 947582");
        publisher.setState("New York");
        publisher.setZip("474747SD");

        publisherRepository.save(publisher);
        System.out.println("Publisher count: " + publisherRepository.count());

        Author eric = new Author("Jane", "Brady");
        Book ddd = new Book("Domain driven design", "6563251013");


        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "56312272232");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


        System.out.println("Number of books: "+ bookRepository.count());


    }
}

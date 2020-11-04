package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author Reza = new Author("reza" , "rezaaaaa");
        Book ddd = new Book("Domain Driven Design" , "123456");
        Reza.getBooks().add(ddd);
        ddd.getAuthors().add(Reza);

        authorRepository.save(Reza);
        bookRepository.save(ddd);

        Author Radin = new Author("Rod" , "Iconic");
        Book noEJB = new Book("J2EE DEV W EJB" , "321968510");
        Radin.getBooks().add(noEJB);
        noEJB.getAuthors().add(Radin);

        authorRepository.save(Radin);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstratp");
        System.out.println("Number of Books:" + bookRepository.count());

    }
}

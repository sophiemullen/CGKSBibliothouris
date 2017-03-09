package be.cegeka.bibliothouris.domain.book;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class BookService {

    @Inject
    private BookRepository bookRepository;


    public void addBook(String isbn, String title, String authorFirstName, String authorLastName){
        Book book = new Book(isbn, title, authorFirstName, authorLastName);
        bookRepository.addBook(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.getBooks();
    }
}

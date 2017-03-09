package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.book.Book;
import be.cegeka.bibliothouris.domain.book.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController {

    @Inject
    private BookService bookService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void addBook(@RequestParam(value = "isbn") String isbn,
                        @RequestParam(value = "title") String title,
                        @RequestParam(value = "AuthorFirstName") String authorFirstName,
                        @RequestParam(value = "AuthorLastName") String authorLastName){
        bookService.addBook(isbn, title, authorFirstName, authorLastName);
    }

}

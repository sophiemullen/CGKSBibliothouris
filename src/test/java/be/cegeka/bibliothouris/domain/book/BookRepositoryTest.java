package be.cegeka.bibliothouris.domain.book;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BookRepositoryTest {

    private BookRepository bookRepository;
    private List<Book> books;
    private Book book;
    private Book book1;

    @Before
    public void setUp() throws Exception {
        bookRepository = new BookRepository();
        books = new ArrayList<>();
        book = new Book("1234", "The Da Vinci Code", "Dan", "Brown");
        book1 = new Book("5678", "Harry Potter", "JK", "Rowling");
    }

    @Test
    public void addBook_AddsBookToList() throws Exception{
        books.add(book);
        Assertions.assertThat(books).contains(book);
    }

    @Test
    public void getBooks_ReturnsAllBooks(){
        books.add(book);
        books.add(book1);
        bookRepository.getBooks();
        Assertions.assertThat(books).contains(book, book1);
    }

    @Test
    public void searchByPartialISBN_ReturnsAllMatchingBooks(){
        bookRepository.addBook(book);
        bookRepository.addBook(book1);
        Assertions.assertThat(bookRepository.searchByPartialISBN("123")).containsOnly(book);
    }

    @Test
    public void searchByPartialTitle_ReturnsAllMatchingBooks(){
        bookRepository.addBook(book);
        bookRepository.addBook(book1);
        Assertions.assertThat(bookRepository.searchByPartialTitle("Da Vinci")).containsOnly(book);
    }

    @Test
    public void searchByPartialAuthorName_ReturnsAllMatchingBooks(){
        bookRepository.addBook(book);
        bookRepository.addBook(book1);
        Assertions.assertThat(bookRepository.searchByPartialAuthorName("Brown")).containsOnly(book);
    }
}
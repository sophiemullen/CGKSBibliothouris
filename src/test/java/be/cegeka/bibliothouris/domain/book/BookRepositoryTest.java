package be.cegeka.bibliothouris.domain.book;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookRepositoryTest {

    private Book book;
    private List<Book> books;

    @Before
    public void setUp() throws Exception {
        book = new Book("1234", "The Da Vinci Code", "Dan", "Brown");
    }

    @Test
    public void addBook_AddsBookToList(){
        books.add(book);
        Assertions.assertThat(books).contains(book);
    }

    @Test
    public void getBooks_ReturnsAllBooks(){

    }
}
package be.cegeka.bibliothouris.domain.book;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.inject.Inject;

import java.util.Arrays;
import java.util.List;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book, book1, book2, book3;

    @Before
    public void setup(){
        book = new Book("1234","The Da Vinci Code", "Dan", "Brown");
        book1 = new Book("1234", "The Da Vinci Code", "Dan", "Brown");
        book2 = new Book("1256", "LittleBilly", "Kevin", "Billen");
        book3 = new Book("4567", "Harry Potter", "JK", "Rowling");
    }

    @Test
    public void addBook_AddsTheSameBookAsTheRepoDoes() throws Exception{
        bookService.addBook("1234", "The Da Vinci Code", "Dan", "Brown");
        verify(bookRepository).addBook(book);
    }

    @Test
    public void getBooks_ReturnsSameBooksAsInRepo(){
        when(bookRepository.getBooks()).thenReturn(Arrays.asList(book, book2, book3));
        Assertions.assertThat(bookService.getAllBooks()).containsOnly(book, book2, book3);

    }

}
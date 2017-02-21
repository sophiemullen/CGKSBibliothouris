package be.cegeka.bibliothouris.domain.book;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private Book book;

    @Before
    public void setUp(){
        book = new Book("1234", "The Da Vinci Code", "Dan", "Brown");
    }

    @Test
    public void toString_Called_ReturnsAString() throws Exception{
        String expected = " 1234 The Da Vinci Code Dan Brown";
        Assertions.assertThat(book.toString().equals(expected));
    }

}
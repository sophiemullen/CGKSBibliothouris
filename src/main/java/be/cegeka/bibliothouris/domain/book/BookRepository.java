package be.cegeka.bibliothouris.domain.book;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Named
public class BookRepository {

    private List<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }


    public List<Book> searchByPartialISBN(String partialISBN) {
        List<Book> booksWithPartialISBN = new ArrayList<>();
        partialISBN = partialISBN.replace("\\*", ".*");
        Stream<Book> stream = books.stream();
        Pattern partial = Pattern.compile(".*" + partialISBN + ".*");
        booksWithPartialISBN = stream.filter(book -> partial.matcher(book.getIsbn()).matches()).collect(Collectors.toList());
        return booksWithPartialISBN;
    }


    public List<Book> searchByPartialTitle(String partialTitle) {
        List<Book> booksWithPartialTitle = new ArrayList<>();
        Regex regx = new Regex(partialTitle);
        for(Book book : books) {
            if (regx.(book.getTitle())) {
                booksWithPartialTitle.add(book);
            }
        }
        Pattern partial = Pattern.compile(".*" + partialTitle + ".*");
        Matcher matcher = partial.matcher(partialTitle);
        if(matcher.find()) {
            booksWithPartialTitle.add(matcher);
        }
        return booksWithPartialTitle;
    }

    public List<Book> searchByPartialAuthorName(String partialAuthorName) {
    }
}






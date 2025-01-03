package starter.librarysystem.apiactions.preactions;

import io.cucumber.java.BeforeAll;

import starter.librarysystem.api.ApiUtil;
import starter.librarysystem.dto.Book;

import java.util.ArrayList;
import java.util.List;


public class PreAction {
    public static Book globalBookToTest;
    public static List<Book> globalBookToDelete = new ArrayList<>();

    @BeforeAll
    public static void givenThatBookIsAvailableInLibraryWithTitleAndAuthor() {

        Book book = new Book("Jenkins Tutorial", "Reyon");
        ApiUtil util = new ApiUtil();
        globalBookToTest = util.asUser().addBook(book);

        Book book2 = new Book("Delete book 1", "Shakila");
        Book book3 = new Book("Delete book 2", "Akila");
        Book book4 = new Book("Delete book 3", "Hasitha");
        globalBookToDelete.add(util.asUser().addBook(book2));
        globalBookToDelete.add(util.asUser().addBook(book3));
        globalBookToDelete.add(util.asUser().addBook(book4));
    }
}

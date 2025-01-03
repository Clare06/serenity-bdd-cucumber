package starter.librarysystem.apiactions.preactions;

import io.cucumber.java.BeforeAll;

import org.junit.jupiter.api.Tag;
import starter.librarysystem.api.ApiUtil;
import starter.librarysystem.dto.Book;


public class GetBookWithIdPreAction {
    public static Book globalBookToTest;

    @BeforeAll
    public static void givenThatBookIsAvailableInLibraryWithTitleAndAuthor() {

        Book book = new Book("Jenkins Tutorial", "Reyon");
        ApiUtil util = new ApiUtil();
        globalBookToTest = util.asUser().addBook(book);
    }
}

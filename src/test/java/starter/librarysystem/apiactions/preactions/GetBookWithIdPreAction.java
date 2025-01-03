package starter.librarysystem.apiactions.preactions;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import net.serenitybdd.core.steps.UIInteractions;
import starter.librarysystem.api.ApiUtil;
import starter.librarysystem.dto.Book;

public class GetBookWithIdPreAction {
    public static Book globalBookToTest;

//    @Given("Given that book is available in library with title {string} and author {string}")
    @Before("@searchByIdAsUser")
    public static void givenThatBookIsAvailableInLibraryWithTitleAndAuthor() {
        Book book = new Book("Jenkins Tutorial", "Reyon");
        ApiUtil util = new ApiUtil();
        globalBookToTest= util.asUser().addBook(book);
    }

}

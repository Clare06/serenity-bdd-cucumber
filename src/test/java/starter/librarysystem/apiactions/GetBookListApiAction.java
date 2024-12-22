package starter.librarysystem.apiactions;

import com.google.gson.reflect.TypeToken;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.librarysystem.apiacitonsabstract.GetBookListApiAbstract;
import starter.librarysystem.dto.Book;
import starter.librarysystem.rest.RestRequestHelper;

import java.lang.reflect.Type;
import java.util.List;

public class GetBookListApiAction extends GetBookListApiAbstract {
    private static List<Book> bookList;

    @Given("The library get book list API is available")
    public void theLibraryApiIsAvailable() {
        verifyApiIsAvailable();
    }

    @When("I fetch the book list")
    public void fetchBookList() {

        Type bookListType = new TypeToken<List<Book>>() {}.getType();
        RestRequestHelper restHelper = new RestRequestHelper("/api/books/");

        bookList = restHelper.sendRequest("GET", null, "admin","password").body().as(bookListType);

    }

    @Then("I should receive a list of books")
    public void verifyBookList() {
        if ( bookList == null ) {
            throw new AssertionError("Book list not fetched successfully");
        }
        System.out.println("Books fetched successfully: " + bookList.size() + " books found.");
    }
}

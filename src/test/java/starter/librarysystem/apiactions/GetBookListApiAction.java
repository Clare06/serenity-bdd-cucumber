package starter.librarysystem.apiactions;

import com.google.gson.reflect.TypeToken;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.librarysystem.api.ApiUtil;
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

        ApiUtil util = new ApiUtil();
        bookList = util.asAdmin().fetchBookList();

    }

    @Then("I should receive a list of books")
    public void verifyBookList() {
        if ( bookList == null ) {
            throw new AssertionError("Book list not fetched successfully");
        }
        System.out.println("Books fetched successfully: " + bookList.size() + " books found.");
    }
}

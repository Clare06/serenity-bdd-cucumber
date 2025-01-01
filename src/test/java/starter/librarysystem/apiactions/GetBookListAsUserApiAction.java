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

public class GetBookListAsUserApiAction extends GetBookListApiAbstract {
    private static List<Book> bookList;

    @Given("The get book list API is available and running")
    public void theLibraryApiIsAvailable() {
        verifyApiIsAvailable();
    }
    @When("As an user fetch the book list")
    public void fetchBookList() {
        
        ApiUtil util = new ApiUtil();
        bookList = util.asUser().fetchBookList();

    }

    @Then("He should receive a list of books")
    public void verifyBookList() {
        if ( bookList == null ) {
            throw new AssertionError("Book list is not fetched successfully");
        }
        System.out.println("Books fetched successfully: " + bookList.size() + " books found.");
    }
}

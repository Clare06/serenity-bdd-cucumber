package starter.librarysystem.apiactions;

import com.google.gson.reflect.TypeToken;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import starter.librarysystem.availableapiacitons.GetBookListApiAbstract;
import starter.librarysystem.dto.Book;
import starter.librarysystem.rest.RestRequestHelper;

import java.lang.reflect.Type;
import java.util.List;

public class GetBookListApiAsRandomUserApiAction extends GetBookListApiAbstract {
    private static Response response;

    @Given("The library get book list API is available and running for authorized user")
    public void theLibraryApiIsAvailable() {
        verifyApiIsAvailable();
    }

    @When("As a random user fetch the book list")
    public void fetchBookList() {

//        Type bookListType = new TypeToken<List<Book>>() {}.getType();
        RestRequestHelper restHelper = new RestRequestHelper("/api/books/");

        response = restHelper.sendRequest("GET", null, "reyon","password");

    }

    @Then("He should receive unauthorized code {int}")
    public void verifyAuthorizationCode401(Integer statusCode) {
        if ( response.getStatusCode() != statusCode ) {
            throw new AssertionError("Api allowed random user to fetch or error code isn't handled, returned code:" + response.getStatusCode() );
        }
        System.out.println("Api is working successfully and giving: " + response.getStatusCode());
    }
}

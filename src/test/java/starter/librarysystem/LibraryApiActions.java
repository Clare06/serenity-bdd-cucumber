package starter.librarysystem;

import com.google.gson.reflect.TypeToken;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.core.steps.UIInteractions;

import java.lang.reflect.Type;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.*;

public class LibraryApiActions extends UIInteractions {
    private static List<Book> bookList;

    @Given("The library API is available")
    public void theLibraryApiIsAvailable() {
        RestAssured.given()
                .baseUri("http://localhost:7081")
                .basePath("/api/books/")
                .auth()
                .basic("admin", "password") // Ensure the correct authentication credentials
                .get()
                .then()
                .statusCode(200);
    }

    @When("I fetch the book list")
    public void fetchBookList() {
        // Define the correct type for the deserialization of a list of Book objects
        Type bookListType = new TypeToken<List<Book>>() {}.getType();

       bookList = RestAssured.given()
                .baseUri("http://localhost:7081")
                .basePath("/api/books/")
                .auth()
                .basic("admin", "password")
                .accept(ContentType.JSON)
                .get()
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(bookListType, ObjectMapperType.GSON);
    }

    @Then("I should receive a list of books")
    public void verifyBookList() {
        if ( bookList == null ) {
            throw new AssertionError("Book list is empty or not fetched successfully");
        }
        System.out.println("Books fetched successfully: " + bookList.size() + " books found.");
    }
}

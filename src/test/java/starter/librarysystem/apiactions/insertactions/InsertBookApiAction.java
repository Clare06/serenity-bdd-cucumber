package starter.librarysystem.apiactions.insertactions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.librarysystem.apiacitonsabstract.InsertBookApiAbstract;
import starter.librarysystem.apiresult.InsertBookApiResult;
import starter.librarysystem.dto.Book;


public class InsertBookApiAction extends InsertBookApiAbstract {
    private Book bookTest ;
    private static InsertBookApiResult insertBookApiResult;

    @Given("The library add book API is available")
    public void theLibraryApiIsAvailable() {
        verifyApiIsAvailable();
    }

    @When("I add a book with {string}, author {string}, and role {string}")
    public void iAddABookWithTheTitleAndAuthorAsA(String title, String author, String role) {
        bookTest = new Book(title, author);
        insertBookApiResult = apiCall(title, author, role);
    }

    @Then("I should receive this {string}")
    public void verifyOutcome(String outcome) {
        verifyInsertBookApi(outcome, insertBookApiResult, bookTest);
    }

}

package starter.librarysystem.apiactions.deleteactions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.librarysystem.apiacitonsabstract.DeleteBookApiAbstract;
import starter.librarysystem.apiresult.DeleteBookApiResult;

public class DeleteBookApiAction extends DeleteBookApiAbstract {
    private static DeleteBookApiResult deleteBookApiResult;

    @Given("The library delete book API is available")
    public void theLibraryDeleteApiIsAvailable() {
        verifyApiIsAvailable();
    }

    @When("I try to delete a book as a {string}")
    public void tryToDeleteBookAsRole(String role) {
        deleteBookApiResult = apiCall(role);
    }

    @Then("I should receive {string} for delete attempt")
    public void verifyOutcome(String outcome) {
        verifyDeleteBookApi(outcome, deleteBookApiResult);
    }
}

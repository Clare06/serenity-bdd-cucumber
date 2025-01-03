package starter.librarysystem.apiactions.updateactions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.librarysystem.apiacitonsabstract.UpdateBookNameApiAbstract;
import starter.librarysystem.apiresult.UpdateBookNameApiResult;

public class UpdateBookNameApiAction extends UpdateBookNameApiAbstract {
    private static UpdateBookNameApiResult updateBookNameApiResult;

    @Given("The library update book name API is available")
    public void theLibraryApiIsAvailable() {
        verifyApiIsAvailable();
    }

    @When("I update the book name to {string} as an {string}")
    public void updateBookName(String newBookName, String role) {
        updateBookNameApiResult = apiCall(newBookName, role);
    }

    @Then("I should receive a success message confirming the book name is updated")
    public void verifyOutcome() {
        verifyUpdateBookNameApi(updateBookNameApiResult);
    }
}
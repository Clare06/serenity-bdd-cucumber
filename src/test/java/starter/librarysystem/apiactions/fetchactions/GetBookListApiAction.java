package starter.librarysystem.apiactions.fetchactions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.librarysystem.apiacitonsabstract.GetBookListApiAbstract;
import starter.librarysystem.apiresult.GetbookListApiResult;


public class GetBookListApiAction extends GetBookListApiAbstract {
    private static GetbookListApiResult getBookListApiResult;

    @Given("The library get book list API is available")
    public void theLibraryApiIsAvailable() {
        verifyApiIsAvailable();
    }

    @When("I fetch the book list as a {string}")
    public void fetchBookListAsRole(String role) {
        getBookListApiResult= apiCall(role);
    }

    @Then("I should receive {string}")
    public void verifyOutcome(String outcome) {
        verifyGetBookListApi(outcome, getBookListApiResult);
    }
}


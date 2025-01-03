package starter.librarysystem.apiactions.deleteactions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import starter.librarysystem.apiacitonsabstract.DeleteBookAbstract;
import starter.librarysystem.apiresult.DeleteBookApiResult;
import starter.librarysystem.apiresult.ResponseResultUnauthorizedBookFetchWithID;
import starter.librarysystem.dto.Book;

import static starter.librarysystem.apiactions.preactions.PreAction.globalBookToTest;

public class DeleteBookApiAction extends DeleteBookAbstract {

    public static DeleteBookApiResult deleteBookApiResult  = new DeleteBookApiResult();

    @When("I delete the book as a {string}")
    public void deleteBookWithRole(String role){
        deleteBook(role);
    }

    @Then("I should receive delete {string}")
    public void heShouldReceiveTheBookWithTitle(String outcome){
        verifyDeleteBook(outcome);
    }

}

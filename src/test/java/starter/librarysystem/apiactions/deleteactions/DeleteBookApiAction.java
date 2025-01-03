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
        deleteBookByRole(role);
    }

    @Then("I should receive {string} for {string}")
    public void heShouldReceiveTheBookWithTitle(String outcome, String role){
        verifyDeleteBook(role,outcome);
    }

    @When("I delete a nonexistent book as a {string}")
    public void deleteNonExistentBook(String role){
        deleteBook(role, 99999999);
    }

    @When("I delete a book without a providing a book id as a {string}")
    public void deleteBookWithoutId(String role){
        deleteBookWithNoId(role);
    }

}

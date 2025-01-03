package starter.librarysystem.apiactions.fetchactions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.librarysystem.apiacitonsabstract.GetBookWithIdAbstract;
import starter.librarysystem.apiresult.ResponseResultUnauthorizedBookFetchWithID;
import starter.librarysystem.dto.Book;

import static starter.librarysystem.apiactions.preactions.PreAction.globalBookToTest;

public class GetBookWithIdApiAction extends GetBookWithIdAbstract {
    private static Book book;
    public static ResponseResultUnauthorizedBookFetchWithID responseResultUnauthorizedBookFetchWithID = new ResponseResultUnauthorizedBookFetchWithID();

    @When("As a {string}, fetch the book with its id")
    public void fetchBookWithId(String role){
        Book jenkinBook = fetchBook(globalBookToTest.getId(), role);

        if (jenkinBook == null) {
            throw new AssertionError("Error: Book is not being added!. For" + role);
        }

        book = jenkinBook;
    }
    @Then("He should receive {string}")
    public void heShouldReceiveTheBookWithTitle(String outcome){
        verifyBook(outcome, book);
    }
}

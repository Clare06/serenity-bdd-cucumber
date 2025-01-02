package starter.librarysystem.apiactions.insertactions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.librarysystem.apiacitonsabstract.InsertBookApiAbstract;
import starter.librarysystem.apiresult.InsertBookApiResult;
import starter.librarysystem.dto.Book;
import starter.librarysystem.dto.BookEntry;

import java.util.Map;


public class InsertBookApiAction extends InsertBookApiAbstract {
    private Book bookTest ;
    public static InsertBookApiResult insertBookApiResult =new InsertBookApiResult();

    @DataTableType
    public BookEntry bookEntryTransformer(Map<String, String> entry) {
        return new BookEntry(
                entry.get("title"),
                entry.get("author"),
                entry.get("role")
        );
    }

    @When("I add a book with the following details:")
    public void iAddABookWithTheFollowingDetails(BookEntry bookEntry) {
        bookTest = new Book(bookEntry.getTitle(), bookEntry.getAuthor());
        apiCall(bookEntry.getTitle(), bookEntry.getAuthor(), bookEntry.getRole());
    }

    @Then("I should receive a response indicating {string}")
    public void verifyOutcome(String outcome) {
        verifyInsertBookApi(outcome, insertBookApiResult, bookTest);
    }

}

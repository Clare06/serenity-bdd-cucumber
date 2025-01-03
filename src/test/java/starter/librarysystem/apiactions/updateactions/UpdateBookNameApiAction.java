package starter.librarysystem.apiactions.updateactions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.librarysystem.apiacitonsabstract.UpdateBookNameApiAbstract;
import starter.librarysystem.apiresult.UpdateBookNameApiResult;
import starter.librarysystem.dto.Book;
import starter.librarysystem.dto.BookEntry;

import static starter.librarysystem.apiactions.preactions.PreAction.globalBookToUpdate;

public class UpdateBookNameApiAction extends UpdateBookNameApiAbstract {
    private static UpdateBookNameApiResult updateBookNameApiResult;
    private Book bookTest ;


    @When("I update a book with the following details:")
    public void updateBookName(BookEntry bookEntry) {
        int temp;
        if (bookEntry.getRole().equals("unauthorized")) {
            temp=0;
        } else if (bookEntry.getRole().equals("user")) {
            temp=1;
        }else {
            temp=2;
        }

        bookTest = new Book(globalBookToUpdate.get(temp).getId(),bookEntry.getTitle(), bookEntry.getAuthor());
        updateBookNameApiResult = apiCall(bookTest, bookEntry.getRole(), globalBookToUpdate.get(temp).getId());
    }

//    @When("I update a book with the following details:")
//    public void iUpdateABookWithTheFollowingDetails(BookEntry bookEntry) {
//
//        apiCall(bookEntry.getTitle(), bookEntry.getAuthor(), bookEntry.getRole());
//    }

    @Then("I should receive a response for update indicating {string}")
    public void verifyOutcome(String outcome) {
        verifyUpdateBookNameApi(outcome, updateBookNameApiResult, bookTest);
    }
}
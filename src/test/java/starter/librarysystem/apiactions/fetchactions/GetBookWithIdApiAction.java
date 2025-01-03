package starter.librarysystem.apiactions.fetchactions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.librarysystem.apiacitonsabstract.GetBookWithIdAbstract;
import starter.librarysystem.dto.Book;

import static starter.librarysystem.apiactions.preactions.GetBookWithIdPreAction.globalBookToTest;

public class GetBookWithIdApiAction extends GetBookWithIdAbstract {
    private static Book book;

    @When("As an user fetch the book with its id.")
    public void fetchBookWithId(){
        Book jenkinBook = fetchBook(globalBookToTest.getId());

        // Validate the fetched book
        if (jenkinBook == null) {
            throw new AssertionError("Error: Book is not being added! Fetched object is null or not of type Book.");
        }

        // Assign the fetched book if validation passes
        book = jenkinBook;
        System.out.println("***********" + jenkinBook.getAuthor());
    }
    @Then("He should receive the book with title {string}")
    public void heShouldReceiveTheBookWithTitle(String title){
        verifyBook(title, book);
    }
}

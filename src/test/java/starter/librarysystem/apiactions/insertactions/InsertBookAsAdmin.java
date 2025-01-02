//package starter.librarysystem.apiactions.insertactions;
//
//import com.google.gson.reflect.TypeToken;
//import io.cucumber.java.After;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import starter.librarysystem.apiacitonsabstract.InsertBookApiAbstract;
//import starter.librarysystem.dto.Book;
//import starter.librarysystem.rest.RestRequestHelper;
//
//import java.lang.reflect.Type;
//
//public class InsertBookAsAdmin extends InsertBookApiAbstract {
//    private Integer id;
//    private Book book;
//
//    @Given("Add book API is available and running")
//    public void theLibraryAddApiIsAvailable() {
//        this.id = verifyApiIsAvailable();
//    }
//
//    @When("a book with the title {string} and author {string} added to system")
//    public void addBookToSystem(String title, String author) {
//        Book bookTest = new Book(title, author);
//        Type bookType = new TypeToken<Book>() {}.getType();
//        RestRequestHelper restHelper = new RestRequestHelper();
//
//        book= restHelper.sendAsAdmin("POST", bookTest).body().as(bookType);
//
//    }
//
//    @Then("the book with title {string} should exist in the system")
//    public void verifyBookList(String title) {
//        if ( book == null || book.getTitle() != null && !book.getTitle().equals(title) ) {
//            throw new AssertionError("Book is not available! :Request has defect");
//        }
//        System.out.println("Books added successfully: " + book.getTitle() + "found.");
//    }
//
////    @After
////    public void cleanUpData() {
////        cleanUp(this.id);
////        cleanUp(this.book.getId());
////    }
//
//}

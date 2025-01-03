package starter.librarysystem.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import starter.librarysystem.api.ApiUtil;
import static starter.librarysystem.apiactions.insertactions.InsertBookApiAction.insertBookApiResult;

public class AddBookAfterHook {

//    @After("@addBook")
//    public void cleanUpAddedData(Scenario scenario) {
//        // Only run for API tests (not UI tests)
//        if (scenario.isFailed()) {
//            System.out.println("Scenario failed, skipping cleanup.");
//        } else {
//            // Perform cleanup (deleting books)
//            deleteBookById(insertBookApiResult.getBook().getId());
//            deleteBookById(insertBookApiResult.getBook2().getId());
//        }
//    }
    @AfterAll
    public static void cleanUpAddedData() {
        deleteBookById(insertBookApiResult.getBook().getId());
        deleteBookById(insertBookApiResult.getBook2().getId());
    }

    private static void deleteBookById(Integer bookId) {
        ApiUtil apiUtil = new ApiUtil(bookId);
        apiUtil.asUser().getResponseOfDeleteBook();
        System.out.println("Cleaning up: Deleting book with ID: " + bookId);
    }
}

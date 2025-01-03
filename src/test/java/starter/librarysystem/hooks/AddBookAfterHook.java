package starter.librarysystem.hooks;

import io.cucumber.java.AfterAll;
import starter.librarysystem.api.ApiUtil;
import static starter.librarysystem.apiactions.insertactions.InsertBookApiAction.insertBookApiResult;
import static starter.librarysystem.apiactions.preactions.GetBookWithIdPreAction.globalBookToTest;

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
        deleteBookById(globalBookToTest.getId());
    }

    private static void deleteBookById(Integer bookId) {
        ApiUtil apiUtil = new ApiUtil(bookId);
        apiUtil.asUser().getResponseOfDeleteBook();
        System.out.println("Cleaning up: Deleting book with ID: " + bookId);
    }
}

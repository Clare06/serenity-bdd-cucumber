package starter.librarysystem.hooks;

import io.cucumber.java.AfterAll;
import starter.librarysystem.api.ApiUtil;
import starter.librarysystem.dto.Book;

import static starter.librarysystem.apiactions.insertactions.InsertBookApiAction.insertBookApiResult;
import static starter.librarysystem.apiactions.preactions.PreAction.*;

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

        //for book with id
        deleteBookById(insertBookApiResult.getBook().getId());
        deleteBookById(insertBookApiResult.getBook2().getId());
        deleteBookById(globalBookToTest.getId());

        // for  delete
        for (Book book : globalBookToDelete){
            deleteBookById(book.getId());
        }

        //for update
        for (Book book1 : globalBookToUpdate){
            deleteBookById(book1.getId());
        }

    }

    private static void deleteBookById(Integer bookId) {
        ApiUtil apiUtil = new ApiUtil(bookId);
        apiUtil.asUser().getResponseOfDeleteBook();
        System.out.println("Cleaning up: Deleting book with ID: " + bookId);
    }
}

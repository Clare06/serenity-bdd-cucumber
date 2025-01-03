package starter.librarysystem.apiacitonsabstract;

import com.fasterxml.jackson.core.JsonParseException;
import io.restassured.response.Response;
import net.serenitybdd.core.steps.UIInteractions;
import starter.librarysystem.api.ApiUtil;
import starter.librarysystem.dto.Book;

import static starter.librarysystem.apiactions.preactions.GetBookWithIdPreAction.globalBookToTest;

public class GetBookWithIdAbstract extends UIInteractions {
    protected Book fetchBook(Integer id) {
        ApiUtil apiUtil = new ApiUtil(id);
        Response res = apiUtil.asUser().getResponseOfBookById();
        String responseBody = res.getBody().asString();

        if (!responseBody.trim().startsWith("{")) {
            throw new AssertionError("Unexpected response format: " + responseBody);
        }

        try {
            return apiUtil.asUser().getBookById();
        } catch (Exception e) {
            throw new AssertionError("Error parsing JSON response: " + responseBody, e);
        }
    }


    protected void verifyBook(String book, Book bookToVerify) {
        if(book == null || !bookToVerify.getTitle().equals(globalBookToTest.getTitle())) {
            throw new AssertionError("Book :" + book + " is not found");
        }
        System.out.println("Book fetched successfully: " + globalBookToTest.getTitle() + " book found.");
    }

}

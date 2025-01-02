package starter.librarysystem.apiacitonsabstract;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.core.steps.UIInteractions;
import starter.librarysystem.api.ApiUtil;
import starter.librarysystem.apiresult.InsertBookApiResult;
import starter.librarysystem.dto.Book;
import starter.librarysystem.rest.RestRequestHelper;

import static starter.librarysystem.apiactions.insertactions.InsertBookApiAction.insertBookApiResult;

public abstract class InsertBookApiAbstract extends UIInteractions {
//    protected Integer verifyApiIsAvailable() {
//        ApiUtil apiUtil = new ApiUtil();
//        Book book = new Book("Cucumber for beginners", "Harini");
//        Response res = apiUtil.asAdmin().getResponseOfAddBook(book);
//        res.then().statusCode(201);
//        return res.getBody().as(Book.class).getId();
//    }
//
//    protected void cleanUp(Integer id) {
//        RestRequestHelper restHelper = new RestRequestHelper(id);
//        restHelper.sendAsUser("DELETE",null).then().statusCode(200);
//    }
    protected void apiCall(String title, String author, String role) {
        ApiUtil util = new ApiUtil();

        Book book = new Book(title, author);

        switch (role.toLowerCase()) {
            case "admin":
                insertBookApiResult.setBook(util.asAdmin().addBook(book));
                break;
            case "user":
                insertBookApiResult.setBook2(util.asUser().addBook(book));
                break;
            case "unauthorized user":
                Response response = util.asNonAuthorized().getResponseOfAddBook(book);
                    insertBookApiResult.setResponse(response);
                break;
            default:
                throw new IllegalArgumentException("Unsupported role: " + role);
        }

    }

    protected void verifyInsertBookApi(String outcome, InsertBookApiResult result, Book bookTest) {
        if (outcome.equalsIgnoreCase("book added successfully for admin")) {
            validateBookAddition(result.getBook(), bookTest);
        } else if (outcome.equalsIgnoreCase("book added successfully for user")) {
            validateBookAddition(result.getBook2(), bookTest);
        } else if (outcome.startsWith("unauthorized code")) {
            validateUnauthorizedCode(outcome, result);
        } else {
            throw new IllegalArgumentException("Unsupported outcome: " + outcome);
        }
    }

    private void validateBookAddition(Book book, Book bookTest) {

        if (book == null || !book.getTitle().equals(bookTest.getTitle())) {
            throw new AssertionError("Book was not added successfully or titles do not match");
        }
        System.out.println("Book added successfully: " + book.getTitle());
    }

    private void validateUnauthorizedCode(String outcome, InsertBookApiResult result) {

        int expectedCode = Integer.parseInt(outcome.split(" ")[2]);
        if (result.getResponse() == null || result.getResponse().getStatusCode() != expectedCode) {
            throw new AssertionError("Expected " + expectedCode + ", but got: " +
                    (result.getResponse() != null ? result.getResponse().getStatusCode() : "null response"));
        }
        System.out.println("API returned correct unauthorized code: " + result.getResponse().getStatusCode());
    }

}

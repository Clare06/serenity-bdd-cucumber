package starter.librarysystem.apiacitonsabstract;

import io.restassured.response.Response;
import net.serenitybdd.core.steps.UIInteractions;
import starter.librarysystem.api.ApiUtil;
import starter.librarysystem.apiresult.InsertBookApiResult;
import starter.librarysystem.dto.Book;
import starter.librarysystem.rest.RestRequestHelper;

public abstract class InsertBookApiAbstract extends UIInteractions {
    protected Integer verifyApiIsAvailable() {
        ApiUtil apiUtil = new ApiUtil();
        Book book = new Book("Cucumber for beginners", "Harini");
        Response res = apiUtil.asAdmin().getResponseOfAddBook(book);
        res.then().statusCode(201);
        return res.getBody().as(Book.class).getId();
    }

    protected void cleanUp(Integer id) {
        RestRequestHelper restHelper = new RestRequestHelper(id);
        restHelper.sendAsUser("DELETE",null).then().statusCode(200);
    }
    protected InsertBookApiResult apiCall(String title, String author, String role) {
        ApiUtil util = new ApiUtil();
        InsertBookApiResult result = new InsertBookApiResult();
        Book book = new Book(title, author);

        switch (role.toLowerCase()) {
            case "admin":
                result.setBook(util.asAdmin().addBook(book));
                break;
            case "user":
                result.setBook(util.asUser().addBook(book));
                break;
            case "unauthorized user":
                result.setResponse(util.asNonAuthorized().getResponseOfAddBook(book));
                break;
            default:
                throw new IllegalArgumentException("Unsupported role: " + role);
        }

        return result;
    }

    protected void verifyInsertBookApi(String outcome, InsertBookApiResult result,  Book bookTest) {
        if (outcome.equalsIgnoreCase("book added successfully")) {
            if (result.getBook() == null || result.getBook().getTitle().equals(bookTest.getTitle())) {
                throw new AssertionError("Book not added successfully");
            }
            System.out.println("Book added successfully: " + result.getBook().getTitle());
        } else if (outcome.startsWith("unauthorized code")) {
            int expectedCode = Integer.parseInt(outcome.split(" ")[2]);
            if (result.getResponse() == null || result.getResponse().getStatusCode() != expectedCode) {
                throw new AssertionError("Expected " + expectedCode + ", but got: " +
                        (result.getResponse() != null ? result.getResponse().getStatusCode() : "null response"));
            }
            System.out.println("API returned correct unauthorized code: " + result.getResponse().getStatusCode());
        } else {
            throw new IllegalArgumentException("Unsupported outcome: " + outcome);
        }
    }
}

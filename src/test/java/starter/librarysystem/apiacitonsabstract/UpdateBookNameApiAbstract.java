package starter.librarysystem.apiacitonsabstract;

import net.serenitybdd.core.steps.UIInteractions;
import starter.librarysystem.api.ApiUtil;
import starter.librarysystem.apiresult.UpdateBookNameApiResult;
import starter.librarysystem.dto.Book;

public abstract class UpdateBookNameApiAbstract extends UIInteractions {

    protected UpdateBookNameApiResult apiCall(Book bookTest, String role, int id) {
        ApiUtil util = new ApiUtil(id);
        UpdateBookNameApiResult result = new UpdateBookNameApiResult();

        switch (role.toLowerCase()) {
            case "admin":
                result.setResponseAsAdmin(util.asAdmin().getResponseOfUpdateBook(bookTest));
                break;
            case "user":
                result.setResponseAsUser(util.asUser().getResponseOfUpdateBook(bookTest));
                break;
            case "unauthorized":
                result.setResponseAsNotAuthorized(util.asNonAuthorized().getResponseOfUpdateBook(bookTest));
                break;
            default:
                throw new IllegalArgumentException("Unsupported role: " + role);
        }

        return result;
    }

    protected void verifyUpdateBookNameApi(String outcome, UpdateBookNameApiResult result, Book bookTest) {
        if (outcome.equalsIgnoreCase("forbidden 403")) {
            if(result.getResponseAsUser().statusCode() != 403){
                throw new AssertionError("He didn't receive: " + outcome);
            }
            System.out.println("He did receive" + outcome);
//            validateBookUpdate(result.getBook(), bookTest);
        } else if (outcome.equalsIgnoreCase("book updated successfully for admin")) {

            if(result.getResponseAsAdmin().statusCode() != 200){
                throw new AssertionError("He didn't receive: " + outcome + "or not updated succefully");
            }
            System.out.println("He did receive" + outcome + "book title is :"+ result.getResponseAsAdmin().getBody().as(Book.class).getTitle());
        } else if (outcome.startsWith("unauthorized code 401")) {
            if(result.getResponseAsNotAuthorized().statusCode() != 401){
                throw new AssertionError("He didn't receive: " + outcome);
            }
            System.out.println("He did receive" + outcome);
        } else {
            throw new IllegalArgumentException("Unsupported outcome: " + outcome);
        }
    }
    //user 403
    //admin 200
    //notauthorized 401

//    private void validateBookUpdate(Book book, Book bookTest) {
//
//        if (book.getTitle().equals(bookTest.getTitle())) {
//            throw new AssertionError("Book was not updated successfully because titles do match or no return");
//        }
//        System.out.println("Book updated successfully: " + book.getTitle());
//    }
//
//    private void validateUnauthorizedCode(String outcome, InsertBookApiResult result) {
//
//        int expectedCode = Integer.parseInt(outcome.split(" ")[2]);
//        if (result.getResponse() == null || result.getResponse().getStatusCode() != expectedCode) {
//            throw new AssertionError("Expected " + expectedCode + ", but got: " +
//                    (result.getResponse() != null ? result.getResponse().getStatusCode() : "null response"));
//        }
//        System.out.println("API returned correct unauthorized code: " + result.getResponse().getStatusCode());
//    }
}
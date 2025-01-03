package starter.librarysystem.apiacitonsabstract;

import io.restassured.response.Response;
import net.serenitybdd.core.steps.UIInteractions;
import starter.librarysystem.api.ApiUtil;
import starter.librarysystem.dto.Book;

import static starter.librarysystem.apiactions.fetchactions.GetBookWithIdApiAction.responseResultUnauthorizedBookFetchWithID;
import static starter.librarysystem.apiactions.preactions.PreAction.globalBookToTest;

public class GetBookWithIdAbstract extends UIInteractions {
    protected Book fetchBook(Integer id, String role) {

        Response res = getResponseByRole(role, id);

        String responseBody = res.getBody().asString();

        if (!responseBody.trim().startsWith("{") && !role.equalsIgnoreCase("unauthorized")) {
            throw new AssertionError("Unexpected response format: " + responseBody + "For:" + role);
        }

        try {
            if (role.equalsIgnoreCase("unauthorized")){
                return new Book("unauthorized", "unauthororized");
            }
            return res.getBody().as(Book.class);
        } catch (Exception e) {
            throw new AssertionError("Error parsing JSON response: " + responseBody + "for:" + role, e);
        }
    }


    protected void verifyBook(String outcome, Book bookToVerify) {
        if(outcome.equalsIgnoreCase("unauthorized code 401")){
            if (responseResultUnauthorizedBookFetchWithID.getResponse().statusCode() != 401){
                throw new AssertionError("Unexpected response code: " + responseResultUnauthorizedBookFetchWithID);
            }
            System.out.println("He received " + outcome);
        }else {
            if(bookToVerify == null || !bookToVerify.getTitle().equals(globalBookToTest.getTitle())) {
                throw new AssertionError("He didn't receive :" + outcome);
            }
            System.out.println("Book fetched successfully: " + globalBookToTest.getTitle() + " book found.");
        }
    }
    private Response getResponseByRole(String role, Integer id) {
        ApiUtil apiUtil = new ApiUtil(id);
            switch (role.toLowerCase()) {
                case "user":
                    return apiUtil.asUser().getResponseOfBookById();
                case "admin":
                    return apiUtil.asAdmin().getResponseOfBookById();
                case "unauthorized":
                    Response res = apiUtil.asNonAuthorized().getResponseOfBookById();
                    responseResultUnauthorizedBookFetchWithID.setResponse(res);
                    return res;
                default:
                    throw new IllegalArgumentException("Invalid role: " + role);
            }

    }

}

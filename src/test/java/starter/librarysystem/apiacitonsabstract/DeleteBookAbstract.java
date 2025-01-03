package starter.librarysystem.apiacitonsabstract;

import net.serenitybdd.core.steps.UIInteractions;
import starter.librarysystem.api.ApiUtil;
import static starter.librarysystem.apiactions.deleteactions.DeleteBookApiAction.deleteBookApiResult;
import static starter.librarysystem.apiactions.preactions.PreAction.globalBookToDelete;

public abstract class DeleteBookAbstract extends UIInteractions {

    protected void deleteBookByRole(String role){
        switch (role.toLowerCase()){
            case "admin":
                deleteBook("admin", globalBookToDelete.get(0).getId());
                break;
            case "user":
                deleteBook("user", globalBookToDelete.get(1).getId());
                break;
            case "unauthorized":
                deleteBook("unauthorized", globalBookToDelete.get(2).getId());
                break;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
    }

    protected void deleteBook(String role, int id) {
        getResponseByRole(role, id);
    }

    protected void deleteBookWithNoId(String role){
        ApiUtil apiUtil = new ApiUtil();
        switch (role.toLowerCase()) {
            case "user":
                deleteBookApiResult.setResponseUser(apiUtil.asUser().getResponseOfDeleteBook());
                break;
            case "admin":
                deleteBookApiResult.setResponseAdmin(apiUtil.asAdmin().getResponseOfDeleteBook());
                break;
            case "unauthorized":
                deleteBookApiResult.setResponseUnauthorized(apiUtil.asNonAuthorized().getResponseOfDeleteBook());
                break;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
    }

    protected void verifyDeleteBook(String role, String outcome) {
        int expectedStatusCode;

        switch (outcome.toLowerCase()) {
            case "unauthorized 401":
                expectedStatusCode = 401;
                break;
            case "forbidden 403":
                expectedStatusCode = 403;
                break;
            case "not found 404":
                expectedStatusCode = 404;
                break;
            case "bad request 400":
                expectedStatusCode = 400;
                break;
            case "not allowed 405":
                expectedStatusCode = 405;
                break;
            case "status 200":
                expectedStatusCode = 200;
                break;
            default:
                expectedStatusCode = 0;
                break;
        }

        int actualStatusCode;
        switch (role.toLowerCase()) {
            case "admin":
                actualStatusCode = deleteBookApiResult.getResponseAdmin().statusCode();
                break;
            case "unauthorized":
                actualStatusCode = deleteBookApiResult.getResponseUnauthorized().statusCode();
                break;
            case "user":
                actualStatusCode = deleteBookApiResult.getResponseUser().statusCode();
                break;
            default:
                throw new IllegalArgumentException("Unknown role: " + role);
        }

        // Assert the status code
        if (actualStatusCode != expectedStatusCode) {
            throw new AssertionError("Unexpected response code: " + actualStatusCode);
        }

        // Print success message
        if (expectedStatusCode == 200) {
            System.out.println("Book deleted successfully");
        } else {
            System.out.println("He received " + actualStatusCode);
        }
    }

    private void getResponseByRole(String role, int id) {
        ApiUtil apiUtil = new ApiUtil(id);
        switch (role.toLowerCase()) {
            case "user":
                deleteBookApiResult.setResponseUser(apiUtil.asUser().getResponseOfDeleteBook());
                break;
            case "admin":
                deleteBookApiResult.setResponseAdmin(apiUtil.asAdmin().getResponseOfDeleteBook());
                break;
            case "unauthorized":
                deleteBookApiResult.setResponseUnauthorized(apiUtil.asNonAuthorized().getResponseOfDeleteBook());
                break;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }

    }
}

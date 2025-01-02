package starter.librarysystem.apiacitonsabstract;

import net.serenitybdd.core.steps.UIInteractions;
import starter.librarysystem.api.ApiUtil;
import starter.librarysystem.apiresult.DeleteBookApiResult;

public abstract class DeleteBookApiAbstract extends UIInteractions {
    protected void verifyApiIsAvailable() {
        ApiUtil apiUtil = new ApiUtil(1); // Assuming ID 1 exists for testing purposes.
        apiUtil.asAdmin().getResponseOfDeleteBook().then().statusCode(200);
    }

    protected DeleteBookApiResult apiCall(String role) {
        ApiUtil util = new ApiUtil(1); // Assuming ID 1 exists for testing purposes.
        DeleteBookApiResult result = new DeleteBookApiResult();

        switch (role.toLowerCase()) {
            case "admin":
                result.setResponse(util.asAdmin().getResponseOfDeleteBook());
                break;
            case "user":
                result.setResponse(util.asUser().getResponseOfDeleteBook());
                break;
            case "unauthorized user":
                result.setResponse(util.asNonAuthorized().getResponseOfDeleteBook());
                break;
            default:
                throw new IllegalArgumentException("Unsupported role: " + role);
        }

        return result;
    }

    protected void verifyDeleteBookApi(String outcome, DeleteBookApiResult result) {
        if (outcome.equalsIgnoreCase("success")) {
            if (result.getResponse() == null || result.getResponse().getStatusCode() != 200) {
                throw new AssertionError("Expected 200 success, but got: " +
                        (result.getResponse() != null ? result.getResponse().getStatusCode() : "null response"));
            }
            System.out.println("Book deleted successfully.");
        } else if (outcome.equalsIgnoreCase("401")) {
            if (result.getResponse() == null || result.getResponse().getStatusCode() != 401) {
                throw new AssertionError("Expected 401 unauthorized, but got: " +
                        (result.getResponse() != null ? result.getResponse().getStatusCode() : "null response"));
            }
            System.out.println("Unauthorized attempt to delete book returned 401 as expected.");
        } else {
            throw new IllegalArgumentException("Unsupported outcome: " + outcome);
        }
    }
}

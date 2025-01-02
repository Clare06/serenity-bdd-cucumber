package starter.librarysystem.apiacitonsabstract;

import net.serenitybdd.core.steps.UIInteractions;
import starter.librarysystem.api.ApiUtil;
import starter.librarysystem.apiresult.GetbookListApiResult;

public abstract class GetBookListApiAbstract extends UIInteractions {
    protected void verifyApiIsAvailable() {
        ApiUtil apiUtil = new ApiUtil();
        apiUtil.asAdmin().getResponseOfFetchBookList().then().statusCode(200);

    }

    protected GetbookListApiResult apiCall(String role) {
        ApiUtil util = new ApiUtil();
        GetbookListApiResult result = new GetbookListApiResult();

        switch (role.toLowerCase()) {
            case "admin":
                result.setBookList(util.asAdmin().fetchBookList());
                break;
            case "user":
                result.setBookList(util.asUser().fetchBookList());
                break;
            case "unauthorized user":
                result.setResponse(util.asNonAuthorized().getResponseOfFetchBookList());
                break;
            default:
                throw new IllegalArgumentException("Unsupported role: " + role);
        }

        return result;
    }

    protected void verifyGetBookListApi (String outcome, GetbookListApiResult result) {
        if (outcome.equalsIgnoreCase("a list of books")) {
            if (result.getBookList() == null ) {
                throw new AssertionError("Book list not fetched successfully");
            }
            System.out.println("Books fetched successfully: " + result.getBookList().size() + " books found.");
        } else if (outcome.equalsIgnoreCase("unauthorized code 401")) {
            if (result.getResponse() == null || result.getResponse().getStatusCode() != 401) {
                throw new AssertionError("Expected 401 unauthorized, but got: " +
                        (result.getResponse() != null ? result.getResponse().getStatusCode() : "null response"));
            }
            System.out.println("API is working successfully and returning unauthorized code: " + result.getResponse().getStatusCode());
        } else {
            throw new IllegalArgumentException("Unsupported outcome: " + outcome);
        }
    }
}

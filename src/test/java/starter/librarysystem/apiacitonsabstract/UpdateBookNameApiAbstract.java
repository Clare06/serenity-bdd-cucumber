package starter.librarysystem.apiacitonsabstract;

import net.serenitybdd.core.steps.UIInteractions;
import starter.librarysystem.api.ApiUtil;
import starter.librarysystem.apiresult.UpdateBookNameApiResult;

public abstract class UpdateBookNameApiAbstract extends UIInteractions {

    protected void verifyApiIsAvailable() {
        ApiUtil apiUtil = new ApiUtil();
        apiUtil.asAdmin().getResponseOfFetchBookList().then().statusCode(200);
    }

    protected UpdateBookNameApiResult apiCall(String newBookName, String role) {
        ApiUtil util = new ApiUtil();
        UpdateBookNameApiResult result = new UpdateBookNameApiResult();

        switch (role.toLowerCase()) {
            case "admin":
                result.setBook(util.asAdmin().updateBookName(newBookName));
                break;
            case "user":
                result.setResponse(util.asUser().getResponseOfFetchBookList());
                break;
            case "unauthorized user":
                result.setResponse(util.asNonAuthorized().getResponseOfFetchBookList());
                break;
            default:
                throw new IllegalArgumentException("Unsupported role: " + role);
        }

        return result;
    }

    protected void verifyUpdateBookNameApi(UpdateBookNameApiResult result) {
        if (result.getBook() == null) {
            throw new AssertionError("Book name not updated successfully");
        }
        System.out.println("Book name updated successfully: " + result.getBook().getTitle());
    }
}
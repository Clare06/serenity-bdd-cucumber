package starter.librarysystem.apiresult;

import starter.librarysystem.dto.Book;
import io.restassured.response.Response;

public class UpdateBookNameApiResult {
    private Response responseAsNotAuthorized;
    private Response responseAsUser;
    private Response responseAsAdmin;

    public Response getResponseAsNotAuthorized() {
        return responseAsNotAuthorized;
    }

    public void setResponseAsNotAuthorized(Response responseAsNotAuthorized) {
        this.responseAsNotAuthorized = responseAsNotAuthorized;
    }

    public Response getResponseAsUser() {
        return responseAsUser;
    }

    public void setResponseAsUser(Response responseAsUser) {
        this.responseAsUser = responseAsUser;
    }

    public Response getResponseAsAdmin() {
        return responseAsAdmin;
    }

    public void setResponseAsAdmin(Response responseAsAdmin) {
        this.responseAsAdmin = responseAsAdmin;
    }
}
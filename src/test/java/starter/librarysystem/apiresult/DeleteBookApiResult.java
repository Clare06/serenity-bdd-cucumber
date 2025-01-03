package starter.librarysystem.apiresult;

import io.restassured.response.Response;

public class DeleteBookApiResult {

    private Response responseAdmin;
    private Response responseUser;
    private Response responseUnauthorized;

    public Response getResponseAdmin() {
        return responseAdmin;
    }

    public void setResponseAdmin(Response responseAdmin) {
        this.responseAdmin = responseAdmin;
    }

    public Response getResponseUser() {
        return responseUser;
    }

    public void setResponseUser(Response responseUser) {
        this.responseUser = responseUser;
    }

    public Response getResponseUnauthorized() {
        return responseUnauthorized;
    }

    public void setResponseUnauthorized(Response responseUnauthorized) {
        this.responseUnauthorized = responseUnauthorized;
    }
}

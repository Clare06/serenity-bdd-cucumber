package starter.librarysystem.apiresult;

import io.restassured.response.Response;

public class ResponseResultUnauthorizedBookFetchWithID {
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}

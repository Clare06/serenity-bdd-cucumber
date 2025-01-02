package starter.librarysystem.rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class RestRequestHelper {

    private final String baseUri = "http://nishovmlinux.centralindia.cloudapp.azure.com:7081";
    private final String endpoint;

    public RestRequestHelper() {
        this.endpoint = "/api/books/";
    }

    public RestRequestHelper(Integer id) {
        this.endpoint = enpointConstructor(id);
    }

    public Response sendAsAdmin (String method, Object body) {
        return this.sendRequest(method, body, "admin", "password");
    }

    public Response sendAsUser (String method, Object body) {
        return this.sendRequest(method, body, "user", "password");
    }

    public Response sendAsNotAuthorizedUser (String method, Object body) {
        return this.sendRequest(method, body, "hacker", "password");
    }

    private String enpointConstructor (Integer id) {
        return "/api/books/" + id;
    };

    private Response sendRequest(String method, Object body, String username, String password) {

        switch (method.toUpperCase()) {
            case "GET":
                return RestAssured.given()
                        .baseUri(this.baseUri)
                        .basePath(this.endpoint)
                        .auth()
                        .basic(username, password)
                        .accept(ContentType.JSON)
                        .get();
            case "POST":
                return RestAssured.given()
                        .baseUri(this.baseUri)
                        .basePath(this.endpoint)
                        .auth()
                        .basic(username, password)
                        .contentType(ContentType.JSON)
                        .body(body)
                        .post();
            case "PUT":
                return RestAssured.given()
                        .baseUri(this.baseUri)
                        .basePath(this.endpoint)
                        .auth()
                        .basic(username, password)
                        .contentType(ContentType.JSON)
                        .body(body)
                        .put();
            case "DELETE":
                return RestAssured.given()
                        .baseUri(this.baseUri)
                        .basePath(this.endpoint)
                        .auth()
                        .basic(username, password)
                        .delete();
            default:
                throw new IllegalArgumentException("Invalid HTTP Method: " + method);
        }
    }
}

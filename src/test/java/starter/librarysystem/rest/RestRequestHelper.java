package starter.librarysystem.rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class RestRequestHelper {

    private final String baseUri = "http://localhost:7081";
    private final String endpoint;

    public RestRequestHelper(String endpoint) {
        this.endpoint = endpoint;
    }

    public Response sendRequest(String method, Object body, String username, String password) {

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

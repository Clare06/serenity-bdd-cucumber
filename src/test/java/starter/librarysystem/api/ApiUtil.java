package starter.librarysystem.api;

import com.google.gson.reflect.TypeToken;
import io.restassured.response.Response;
import starter.librarysystem.dto.Book;
import starter.librarysystem.rest.RestRequestHelper;

import java.lang.reflect.Type;
import java.util.List;

public class ApiUtil {
    private final RestRequestHelper restRequestHelper;
    private final boolean isIdProvided;
    private String accessType = "asNonAuthorized";

    public ApiUtil() {
        restRequestHelper = new RestRequestHelper();
        this.isIdProvided = false;
    }

    public ApiUtil(Integer id) {
        restRequestHelper = new RestRequestHelper(id);
        this.isIdProvided = true;
    }

    public ApiUtil asAdmin() {
        this.accessType = "asAdmin";
        return this;
    }

    public ApiUtil asUser() {
        this.accessType = "asUser";
        return this;
    }

    public ApiUtil asNonAuthorized() {
        this.accessType = "asNonAuthorized";
        return this;
    }

    public List<Book> fetchBookList() {
        Type bookListType = new TypeToken<List<Book>>() {}.getType();
        return getResponseOfFetchBookList().as(bookListType);
    }

    public Response getResponseOfFetchBookList() {

        return executeRequest("GET", null);
    }

    public Book getBookById() {

        return getResponseOfBookById().as(Book.class);
    }

    public Response getResponseOfBookById() {
        if (!isIdProvided) {
            throw new UnsupportedOperationException("getBookById can only be accessed when constructed with an ID.");
        }

        return executeRequest("GET", null);
    }

    public Book addBook(Book bookTest) {
        Type bookType = new TypeToken<Book>() {}.getType();
        return getResponseOfAddBook(bookTest).body().as(bookType);
    }

    public Response getResponseOfAddBook(Book bookTest) {
        return executeRequest("POST", bookTest);
    }

    public Book updateBook(Book bookTest) {

        return getResponseOfUpdateBook(bookTest).body().as(Book.class);
    }

    public Response getResponseOfUpdateBook(Book bookTest) {
        if (bookTest.getId() == null) {
            throw new IllegalArgumentException("Book ID cannot be null.");
        }
        return executeRequest("PUT", bookTest);
    }

    private Response executeRequest(String method, Object body) {
        switch (accessType) {
            case "asAdmin":
                return restRequestHelper.sendAsAdmin(method, body);
            case "asUser":
                return restRequestHelper.sendAsUser(method, body);
            case "asNonAuthorized":
            default:
                return restRequestHelper.sendAsNotAuthorizedUser(method, body);
        }
    }
}

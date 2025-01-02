package starter.librarysystem.apiresult;

import io.restassured.response.Response;
import starter.librarysystem.dto.Book;

public class InsertBookApiResult {
    private Book book;
    private Response response;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}

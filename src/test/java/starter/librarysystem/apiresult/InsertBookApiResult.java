package starter.librarysystem.apiresult;

import io.restassured.response.Response;
import starter.librarysystem.dto.Book;

public class InsertBookApiResult {
    private Book book;
    private Book book2;

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

    public Book getBook2() {
        return book2;
    }

    public void setBook2(Book book2) {
        this.book2 = book2;
    }
}

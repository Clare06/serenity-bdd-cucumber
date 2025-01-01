package starter.librarysystem.apiresult;

import io.restassured.response.Response;
import starter.librarysystem.dto.Book;

import java.util.List;

public class GetbookListApiResult {
    private List<Book> bookList;
    private Response response;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}

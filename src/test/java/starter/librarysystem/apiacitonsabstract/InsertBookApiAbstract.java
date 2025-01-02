package starter.librarysystem.apiacitonsabstract;

import io.restassured.response.Response;
import net.serenitybdd.core.steps.UIInteractions;
import starter.librarysystem.dto.Book;
import starter.librarysystem.rest.RestRequestHelper;

public abstract class InsertBookApiAbstract extends UIInteractions {
    protected Integer verifyApiIsAvailable() {
        RestRequestHelper restHelper = new RestRequestHelper();
        Book book = new Book( "Harini", "Cucumber for Beginners");
        Response res = restHelper.sendAsAdmin("POST",book);
        res.then().statusCode(201);

        return res.getBody().as(Book.class).getId();
    }

    protected void cleanUp(Integer id) {
        RestRequestHelper restHelper = new RestRequestHelper(id);
        restHelper.sendAsUser("DELETE",null).then().statusCode(200);
    }
}

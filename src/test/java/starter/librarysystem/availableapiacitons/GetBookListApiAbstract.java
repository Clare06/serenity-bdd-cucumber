package starter.librarysystem.availableapiacitons;

import net.serenitybdd.core.steps.UIInteractions;
import starter.librarysystem.rest.RestRequestHelper;

public abstract class GetBookListApiAbstract extends UIInteractions {
    protected void verifyApiIsAvailable() {
        RestRequestHelper restHelper = new RestRequestHelper("/api/books/");
        restHelper.sendRequest("GET",null,"admin", "password").then().statusCode(200);
    }
}

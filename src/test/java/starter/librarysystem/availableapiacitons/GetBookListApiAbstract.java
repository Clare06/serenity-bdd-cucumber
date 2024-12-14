package starter.librarysystem.availableapiacitons;

import io.restassured.RestAssured;
import net.serenitybdd.core.steps.UIInteractions;

public abstract class GetBookListApiAbstract extends UIInteractions {
    protected void verifyApiIsAvailable() {
        RestAssured.given()
                .baseUri("http://localhost:7081")
                .basePath("/api/books/")
                .auth()
                .basic("admin", "password")
                .get()
                .then()
                .statusCode(200);
    }
}

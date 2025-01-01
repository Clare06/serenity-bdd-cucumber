package starter.librarysystem.apiacitonsabstract;

import net.serenitybdd.core.steps.UIInteractions;
import starter.librarysystem.api.ApiUtil;
import starter.librarysystem.rest.RestRequestHelper;

public abstract class GetBookListApiAbstract extends UIInteractions {
    protected void verifyApiIsAvailable() {
        ApiUtil apiUtil = new ApiUtil();
        apiUtil.asAdmin().getResponseOfFetchBookList().then().statusCode(200);

    }
}

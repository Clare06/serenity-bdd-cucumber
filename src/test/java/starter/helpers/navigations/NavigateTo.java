package starter.helpers.navigations;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import starter.helpers.pages.UOMPage;

public class NavigateTo {
    public static Performable theSearchHomePage() {
        return Task.where("{0} opens the UOM page",
                Open.browserOn().the(UOMPage.class));
    }
}

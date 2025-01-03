package starter.uitesting.helpers.navigations;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import starter.uitesting.helpers.pages.AccountRequestPage;
import starter.uitesting.helpers.pages.UOMITfacPage;
import starter.uitesting.helpers.pages.UOMPage;
import starter.uitesting.helpers.pages.UOMResearchPage;

public class NavigateTo {
    public static Performable theSearchHomePage() {
        return Task.where("{0} opens the UOM page",
                Open.browserOn().the(UOMITfacPage.class));
    }

    public static Performable theUOMHomePage() {
        return Task.where("{0} opens the UOM home page",
                Open.browserOn().the(UOMPage.class));
    }

    public static Performable theUOMReserachPage() {
        return Task.where("{0} opens the UOM home page",
                Open.browserOn().the(UOMResearchPage.class));
    }

    public static Performable theUOMCitesPage() {
        return Task.where("{0} opens the UOM home page",
                Open.browserOn().the(AccountRequestPage.class));
    }
}

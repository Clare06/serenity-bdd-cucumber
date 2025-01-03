package starter.uitesting.helpers.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://uom.lk/cites/downloads/uom-account-request")
public class AccountRequestPage extends PageObject {
    public static final Target CHECKBOX = Target.the("Checkbox to show download button")
            .locatedBy("//input[@id='myCheck']");

    public static final Target DOWNLOAD_BUTTON = Target.the("Download UOM Account Request Form button")
            .locatedBy("//input[@id='text' and @value='Download UOM Account Request Form']");
}
package starter.uitesting.helpers.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;

@DefaultUrl("https://uom.lk/")
public class UOMPage extends PageObject  {
    public static final Target COURSES_BUTTON = Target.the("Courses button")
            .locatedBy("//a[contains(@href, '/courses')]"); // Adjust XPath/CSS if needed
}

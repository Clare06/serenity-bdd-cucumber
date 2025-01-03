package starter.uitesting.helpers.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;

@DefaultUrl("https://uom.lk/cites/policy/password-policy")
public class PasswordPolicyPage extends PageObject {

    // Locator for the incorrect <a> tag inside <p> above the table, without href attribute
    public static final Target INCORRECT_TABLE_HEADING = Target.the("Incorrect table heading with anchor tag without href")
            .located(By.xpath("//p//a[not(@href)]"));
}

package starter.uitesting.helpers.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;


@DefaultUrl("https://uom.lk/itfac")
public class UOMITfacPage extends PageObject {
    public static Target ITEM_NAME_FIELD = Target.the("item name field").locatedBy(".is-active sf-depth-1");
    public static final Target TELEPHONE_DIRECTORY_LINK = Target.the("telephone directory link")
            .locatedBy("//a[contains(@href, 'telephone-directory')]");

    public static final Target INTERNAL_TELEPHONE_DIRECTORY_LINK = Target.the("internal telephone directory link")
            .locatedBy("//a[contains(@href, '/internal-telephone-directory')]");

    public static final Target DIVISIONS_MENU = Target.the("Divisions menu")
            .located(By.id("main-menu-faculty-it-menu-link-content814134c6-2aa4-491b-be77-a312ee9018bd"));

    public static Target dropdownOption(String optionText) {
        return Target.the(optionText + " dropdown option")
                .located(By.xpath("//a[text()='" + optionText + "']"));
    }

    public static final Target ACADEMIC_CALENDAR_LINK = Target.the("Academic calendar link")
            .locatedBy("//a[contains(@href, 'https://dms.uom.lk/s/JY5tcRR2g89ncGe?dir=undefined&openfile=40460036')]");

}
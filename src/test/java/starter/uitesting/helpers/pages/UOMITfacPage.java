package starter.uitesting.helpers.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;


@DefaultUrl("https://uom.lk/itfac")
public class UOMITfacPage extends PageObject {

    public static Target menu(String menuName) {
        switch (menuName.toLowerCase()) {
            case "divisions":
                return DIVISIONS_MENU;
            case "about us":
                return ABOUT_US_MENU;
            case "schedules":
                return SCHEDULES_MENU;
            case "curriculum":
                return CURRICULUM_MENU;
            default:
                throw new IllegalArgumentException("Unknown menu: " + menuName);
        }
    }

    public static Target ITEM_NAME_FIELD = Target.the("item name field").locatedBy(".is-active sf-depth-1");

    public static final Target TELEPHONE_DIRECTORY_LINK = Target.the("telephone directory link")
            .locatedBy("//a[contains(@href, 'telephone-directory')]");

    public static final Target INTERNAL_TELEPHONE_DIRECTORY_LINK = Target.the("internal telephone directory link")
            .locatedBy("//a[contains(@href, '/internal-telephone-directory')]");

    public static final Target DIVISIONS_MENU = Target.the("Divisions menu")
            .located(By.id("main-menu-faculty-it-menu-link-content814134c6-2aa4-491b-be77-a312ee9018bd"));

    public static final Target ABOUT_US_MENU = Target.the("About us menu")
            .located(By.id("main-menu-faculty-it-menu-link-contentef79f04f-f927-47f1-9222-3115ada94692"));

    public static Target dropdownOption(String optionText) {
        return Target.the(optionText + " dropdown option")
                .located(By.xpath("//a[text()='" + optionText + "']"));
    }

    public static final Target ACADEMIC_CALENDAR_LINK = Target.the("Academic calendar link")
            .locatedBy("//a[contains(@href, 'https://dms.uom.lk/s/JY5tcRR2g89ncGe?dir=undefined&openfile=40460036')]");


    // Komuthu
    // VerifyHomePage test
    public String getPageTitle() {
        return getDriver().getTitle(); // Retrieves the title from the current WebDriver instance
    }

    public static final Target MAIN_BANNER = Target.the("main banner").locatedBy(".tp-bgimg");
    public static final Target NAVIGATION_MENU_ITEM = Target.the("{0} navigation menu item")
        .locatedBy(".sf-main-menu-faculty-it li a");


    // Verify newsletter
    public static final Target SUBSCRIPTION_FIELD = Target.the("email subscription field")
            .locatedBy(".form-text");

    public static final Target SUBSCRIBE_BUTTON = Target.the("Subscribe button")
            .locatedBy(".col-lg-7 .form-actions .form-submit");

    public static final Target PAGE_TITLE = Target.the("page title")
            .locatedBy("title");

    public static final Target CURRENT_URL = Target.the("current page URL")
            .locatedBy("");





    public static final Target CURRICULUM_MENU = Target.the("Curriculum menu")
            .located(By.id("main-menu-menu-link-content20aa3286-c546-4bcb-9007-f851c7826c82"));

    public static final Target SCHEDULES_MENU = Target.the("Schedules menu")
            .located(By.id("main-menu-menu-link-content542a697c-c45d-47c3-a120-2640fc947ba7"));
    public static final Target EMAIL_LINK = Target.the("info-fit@uom.lk email link")
            .locatedBy("//div[contains(@class,'text-formatted field field--name-body field--type-text-with-summary field--label-hidden field__item')]//*[text()='info-fit@uom.lk']");


}
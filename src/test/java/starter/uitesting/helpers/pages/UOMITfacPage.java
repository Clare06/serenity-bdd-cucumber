package starter.uitesting.helpers.pages;

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


    // Komuthu
    // VerifyHomePage test
    public String getPageTitle() {
        return getDriver().getTitle(); // Retrieves the title from the current WebDriver instance
    }

    public static final Target MAIN_BANNER = Target.the("main banner").locatedBy(".tp-bgimg");
    public static final Target NAVIGATION_MENU_ITEM = Target.the("{0} navigation menu item")
        .locatedBy(".sf-main-menu-faculty-it li a");


    // Verify HomePage Responsiveness
    // Locators for elements
//    public static final Target MAIN_BANNER = Target.the("main banner")
//            .locatedBy(".tp-bgimg");
//    public static final Target HAMBURGER_MENU = Target.the("hamburger menu")
//            .locatedBy(".sf-accordion-toggle");
//    public static final Target NAVIGATION_BAR = Target.the("navigation bar")
//            .locatedBy(".sf-main-menu-faculty-it");
//    public static final Target NAVIGATION_MENU_ITEMS = Target.the("navigation menu items")
//            .locatedBy(".sf-main-menu-faculty-it li a");
//    public static final Target FOOTER = Target.the("footer")
//            .locatedBy("footer");

    // Utility method to check if the footer is stacked
//    public boolean footerIsStacked() {
//        return FOOTER.resolveFor(getDriver()).getCssValue("flex-direction").equals("column");
//    }



}
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
    // Added for VerifyHomePage test
    public String getPageTitle() {
        return getDriver().getTitle(); // Retrieves the title from the current WebDriver instance
    }

    public static final Target MAIN_BANNER = Target.the("main banner").locatedBy(".tp-bgimg");
    public static final Target NAVIGATION_MENU_ITEM = Target.the("{0} navigation menu item")
        .locatedBy(".sf-main-menu-faculty-it li a");




}
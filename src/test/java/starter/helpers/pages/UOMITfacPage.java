package starter.helpers.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;


@DefaultUrl("https://uom.lk/itfac")
public class UOMITfacPage extends PageObject {
    public static Target ITEM_NAME_FIELD = Target.the("item name field").locatedBy(".is-active sf-depth-1");
    public static final Target TELEPHONE_DIRECTORY_LINK = Target.the("telephone directory link")
            .locatedBy("a[href='https://uom.lk/telephone-directory']");
//    public static Target ITEMS_LIST = Target.the(" item list").locatedBy(".todo-list li");
}
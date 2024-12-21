package starter.helpers.actions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import starter.helpers.pages.UOMPage;

public class AddAnItem {

    public static Performable withName(String itemName){
        return Task.where("{0} adds an item with name "+itemName,
                Enter.theValue(itemName)
                        .into(UOMPage.ITEM_NAME_FIELD)
                        .thenHit(Keys.ENTER)
        );
    }
}
package starter.uitesting.stepdefinitions.commonsteps;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import starter.uitesting.helpers.navigations.NavigateTo;

public class UserInITFacultyPageStep {
    @Given("{actor} is in UOM IT Faculty page")
    public void openITFacultyPage(Actor actor) {
        actor.wasAbleTo(NavigateTo.theSearchHomePage());
    }
}

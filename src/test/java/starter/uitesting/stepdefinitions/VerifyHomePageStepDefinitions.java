package starter.uitesting.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.uitesting.helpers.navigations.NavigateTo;
import starter.uitesting.helpers.pages.UOMITfacPage;

public class VerifyHomePageStepDefinitions {

//    @Given("{actor} wants to view the IT Faculty homepage")
//    public void openITFacultyHomepage(Actor actor) {
//        actor.wasAbleTo(NavigateTo.theSearchHomePage());
//    }

    @When("{actor} opens the IT Faculty homepage")
    public void navigateToITFacultyHomepage(Actor actor) {
        actor.wasAbleTo(NavigateTo.theSearchHomePage());
    }

    @Steps
    UOMITfacPage uomITfacPage; // Automatically injected by Serenity

    @Then("{actor} should see the title {string}")
    public void verifyPageTitle(Actor actor, String expectedTitle) {
        actor.attemptsTo(
                Ensure.that(uomITfacPage.getPageTitle()).isEqualTo(expectedTitle)
        );
    }

    @Then("{actor} the main banner should be displayed")
    public void verifyMainBanner(Actor actor) {
        actor.attemptsTo(
                Ensure.that(UOMITfacPage.MAIN_BANNER).isDisplayed()
        );
    }

    @Then("{actor} the navigation menu should contain {string}")
    public void verifyNavigationMenu(Actor actor, String menuItems) {
        String[] items = menuItems.split(", ");
        for (String item : items) {
            actor.attemptsTo(
                    Ensure.that(UOMITfacPage.NAVIGATION_MENU_ITEM.of(item)).isDisplayed()
            );
        }
    }
}

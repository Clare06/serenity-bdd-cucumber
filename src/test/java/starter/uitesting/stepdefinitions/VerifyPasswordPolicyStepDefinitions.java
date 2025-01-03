package starter.uitesting.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.uitesting.helpers.navigations.NavigateTo;
import starter.uitesting.helpers.pages.PasswordPolicyPage;

public class VerifyPasswordPolicyStepDefinitions {

    @Given("{actor} is in the UOM Password Policy page")
    public void navigateToPasswordPolicyPage(Actor actor) {
        actor.wasAbleTo(NavigateTo.thePasswordPolicyPage());
    }

    @Then("{actor} should verify that all table headings are correctly formatted")
    public void verifyTableHeadingFormat(Actor actor) {
        actor.attemptsTo(
                Ensure.that(PasswordPolicyPage.INCORRECT_TABLE_HEADING).isNotDisplayed()
        );
    }
}

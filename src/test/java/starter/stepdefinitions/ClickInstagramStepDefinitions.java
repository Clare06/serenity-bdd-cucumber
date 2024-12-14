package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import starter.helpers.NavigateTo;
import starter.helpers.instagram.TargetButton;

public class ClickInstagramStepDefinitions {
    @Given("{actor} wants to go to UOM instagram page")
    public void lookingForInstagaram(Actor actor) {
        actor.wasAbleTo(NavigateTo.theSearchHomePage());
    }

    @When("{actor} clicks Instagram icon")
    public void clickingInstagram(Actor actor) {
        actor.attemptsTo(
                Click.on(TargetButton.BODY)
        );
    }

    @Then("{actor} should see instagram url {string}")
    public void should_see_information_about(Actor actor, String term) {

        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).containsIgnoringCase(term)
        );
    }
}

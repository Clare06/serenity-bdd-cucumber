package starter.uitesting.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.TextContent;
import starter.uitesting.helpers.navigations.NavigateTo;
import starter.uitesting.helpers.research.TargetButton;
import starter.uitesting.helpers.research.TargetHeading;

public class ClickMoreReserach {
    @Given("{actor} is on the Research page of the UOM website")
    public void IsOnTheResearchPage(Actor actor) {
        actor.attemptsTo(NavigateTo.theUOMReserachPage());
    }

    @When("{actor} clicks the More button")
    public void heClicksTheMoreButton(Actor actor) {
        actor.attemptsTo(
                Click.on(TargetButton.MORE_BUTTON)
        );
    }

    @Then("{actor} should be redirected to the URL {string}")
    public void heShouldBeRedirectedToTheURL(Actor actor,String expectedUrl) {
        actor.attemptsTo(
                Ensure.thatTheCurrentPage().currentUrl().isEqualTo(expectedUrl)
        );
    }

    @Then("the page should contain the heading {string}")
    public void thePageShouldContainTheHeading(Actor actor, String expectedHeading) {
        String actualHeading = actor.asksFor(TextContent.of(TargetHeading.RESEARCH_HEADING));

        actor.attemptsTo(
                Ensure.that(actualHeading).isEqualTo(expectedHeading)
        );
    }

}

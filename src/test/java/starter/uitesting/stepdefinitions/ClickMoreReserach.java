package starter.uitesting.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.uitesting.helpers.navigations.NavigateTo;
import starter.uitesting.helpers.courses.TargetButton;

public class ClickMoreReserach {
    @Given("{actor} is on the Research page of the UOM website")
    public void shakilaIsOnTheResearchPage(Actor actor) {
        actor.attemptsTo(NavigateTo.theResearchPage());
    }

    @When("{actor} clicks the More button")
    public void heClicksTheMoreButton(Actor actor {
        actor.attemptsTo(
                Click.on(ResearchPage.MORE_BUTTON)
        );
    }

    @Then("{actor} should be redirected to the URL {string}")
    public void heShouldBeRedirectedToTheURL(Actor actor,String expectedUrl) {
        actor.attemptsTo(
                Ensure.thatTheCurrentPage().currentUrl().isEqualTo(expectedUrl)
        );
    }

    @Then("the page should contain the heading {string}")
    public void thePageShouldContainTheHeading(String expectedHeading) {
        shakila.attemptsTo(
                Ensure.that(Text.of(ResearchPage.RESEARCH_HEADING)).isEqualTo(expectedHeading)
        );
    }

}

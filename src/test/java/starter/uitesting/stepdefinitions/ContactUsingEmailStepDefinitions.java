package starter.uitesting.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.uitesting.helpers.pages.UOMITfacPage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ContactUsingEmailStepDefinitions {

    @When("{actor} clicks on the email link")
    public void clickOnEmailLink(Actor actor){
        actor.attemptsTo(
                WaitUntil.the(UOMITfacPage.EMAIL_LINK, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(UOMITfacPage.EMAIL_LINK)
        );
    }

    @Then("the email app should open")
    public void emailAppShouldOpen() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(UOMITfacPage.EMAIL_LINK.resolveFor(theActorInTheSpotlight()).getAttribute("href"))
                        .containsIgnoringCase("mailto:info-fit@uom.lk")
        );
    }

}

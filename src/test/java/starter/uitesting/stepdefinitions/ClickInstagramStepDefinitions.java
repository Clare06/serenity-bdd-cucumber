package starter.uitesting.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.WebDriver;
import starter.uitesting.helpers.instagram.TargetButton;

public class ClickInstagramStepDefinitions {

    @When("{actor} clicks Instagram icon")
    public void clickingInstagram(Actor actor) {
        actor.attemptsTo(
                Click.on(TargetButton.BODY)
        );
    }

    @Then("{actor} should see instagram url {string}")
    public void should_see_information_about(Actor actor, String term) {
        WebDriver driver = Serenity.getDriver();
        String currentUrl = driver.getCurrentUrl();

        if (!currentUrl.toLowerCase().contains(term.toLowerCase())) {
            throw new AssertionError(
                    "Expected URL to contain: '" + term + "', but the current URL is: '" + currentUrl + "'"
            );
        }

        actor.attemptsTo(
                Ensure.that(currentUrl).containsIgnoringCase(term)
        );
    }

}

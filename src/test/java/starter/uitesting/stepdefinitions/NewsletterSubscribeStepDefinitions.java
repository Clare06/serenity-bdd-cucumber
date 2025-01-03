package starter.uitesting.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.WebDriver;
import starter.uitesting.helpers.pages.UOMITfacPage;
import starter.uitesting.helpers.navigations.NavigateTo;

public class NewsletterSubscribeStepDefinitions {
//    @Given("{actor} wants to subscribe to the IT Faculty newsletter")
//    public void openSubscriptionPage(Actor actor) {
//        actor.wasAbleTo(NavigateTo.theSearchHomePage());
//    }

    @When("{actor} enters {string} in the subscription field")
    public void enterEmailInSubscriptionField(Actor actor, String email) {
        actor.attemptsTo(
                Ensure.that(UOMITfacPage.SUBSCRIPTION_FIELD).isDisplayed(),
                Ensure.that(UOMITfacPage.SUBSCRIPTION_FIELD).isEnabled(),
                Enter.theValue(email).into(UOMITfacPage.SUBSCRIPTION_FIELD)
        );
    }

    @When("{actor} clicks the Subscribe button")
    public void clickSubscribeButton(Actor actor) {
        actor.attemptsTo(
                Ensure.that(UOMITfacPage.SUBSCRIBE_BUTTON).isDisplayed(),
                Ensure.that(UOMITfacPage.SUBSCRIBE_BUTTON).isEnabled(),
                Click.on(UOMITfacPage.SUBSCRIBE_BUTTON)
        );
    }

    @Then("{actor} should be redirected to the 404 error page")
    public void verifyRedirectedTo404(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        String originalWindow = driver.getWindowHandle();

        // Switch to the newly opened tab
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        String currentUrl = driver.getCurrentUrl();
        actor.attemptsTo(
                Ensure.that(currentUrl).contains("https://uom.us15.list-manage.com/subscribe/post?u=e1954f05a5caa63b03ce7c1b8&id=319e36416d")
        );

        // Close the new tab and switch back to the original tab
        driver.close();
        driver.switchTo().window(originalWindow);
    }

}

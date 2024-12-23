package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.helpers.actions.LogIn;
import starter.helpers.navigations.NavigateTo;
import starter.helpers.pages.UOMITfacPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GetTelephoneDirectoryDefinitions {
    @Given("{actor} is looking for telephone directory of academic staffs")
    public void lookingTelephoneDirectory(Actor actor) {
        actor.wasAbleTo(NavigateTo.theSearchHomePage());
    }

    @When("{actor} scrolls down and click telephone directory link")
    public void scrollDownAndClickTelephoneDirectoryLink(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(UOMITfacPage.TELEPHONE_DIRECTORY_LINK, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(UOMITfacPage.TELEPHONE_DIRECTORY_LINK)
        );

    }
    @Then("{actor} should see {string} and current URL should be {string}")
    public void shouldSeeClickHere(Actor actor, String term, String url) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).containsIgnoringCase(url)
        );
        actor.attemptsTo(
                Ensure.that(TheWebPage.source()).containsIgnoringCase(term)
        );
    }
    @When("{actor} clicks here link")
    public void clickHere(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(UOMITfacPage.INTERNAL_TELEPHONE_DIRECTORY_LINK, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(UOMITfacPage.INTERNAL_TELEPHONE_DIRECTORY_LINK)
        );
    }
    @Then("{actor} should see login page and warning message {string}")
    public void shouldSeeLoginPageAndWarningMessage(Actor actor, String message) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.source()).containsIgnoringCase(message)
        );
    }
    @When("{actor} gives her credentials username {string} password {string} and clicks LOG IN button")
    public void giveHerCredentials(Actor actor, String username, String password) {
        actor.attemptsTo(
                LogIn.withCredentials(username, password)
        );
    }
    @Then("{actor} should see the telephone directories pdf and header {string}")
    public void shouldSeeTelephoneDirectoriesPdfAndHeader(Actor actor, String header) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.source()).containsIgnoringCase(header)
        );
    }
}

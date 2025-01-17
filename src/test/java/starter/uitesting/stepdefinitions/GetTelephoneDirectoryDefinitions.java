package starter.uitesting.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.uitesting.helpers.actions.LogIn;
import starter.uitesting.helpers.pages.UOMITfacPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static starter.testsetup.GlobalTestSetUp.getEnvData;

public class GetTelephoneDirectoryDefinitions {

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
    @When("{actor} gives her credentials clicks LOG IN button")
    public void giveHerCredentials(Actor actor) {
        actor.attemptsTo(
                LogIn.withCredentials(getEnvData("UOMUSER"), getEnvData("PASSWORD"))
        );
    }
    @Then("{actor} should see the telephone directories pdf and header {string}")
    public void shouldSeeTelephoneDirectoriesPdfAndHeader(Actor actor, String header) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.source()).containsIgnoringCase(header)
        );
    }
}

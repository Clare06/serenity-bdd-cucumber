package starter.uitesting.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hover;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.uitesting.helpers.pages.UOMITfacPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.containsString;

public class FindCalenderStepDefinitions {

    @When("the user hovers over the {string} menu")
    public void userHoversOverMenu(String menu) {
        theActorInTheSpotlight().attemptsTo(Hover.over(UOMITfacPage.DIVISIONS_MENU));
    }

    @And("selects {string} from the dropdown")
    public void selectsOptionFromDropdown(String option) {
        theActorInTheSpotlight().attemptsTo(Click.on(UOMITfacPage.dropdownOption(option)));
    }

    @Then("the user should be navigated to the {string} page")
    public void userShouldBeNavigatedToPage(String pageTitle) {
        theActorInTheSpotlight().should(seeThat(TheWebPage.title(), containsString(pageTitle)));
    }

    @When("{actor} clicks on academic calendar")
    public void userClicksOnAcademicCalendar(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(UOMITfacPage.ACADEMIC_CALENDAR_LINK, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(UOMITfacPage.ACADEMIC_CALENDAR_LINK)
        );
    }
    @Then("{actor} should see the url contains {string}")
    public void userShouldSeeCalendar(Actor actor, String url) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).containsIgnoringCase(url)
        );
    }
}

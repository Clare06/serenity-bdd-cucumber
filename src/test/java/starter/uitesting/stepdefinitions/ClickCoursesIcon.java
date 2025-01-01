package starter.uitesting.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.uitesting.helpers.navigations.NavigateTo;
import starter.uitesting.helpers.courses.TargetButton;
public class ClickCoursesIcon {

    @Given("{actor} opens the home page")
    public void lookingForCourses(Actor actor) {
        actor.wasAbleTo(NavigateTo.theUOMHomePage());
    }

    @When("{actor} clicks the Courses icon")
    public void heClicksTheCoursesButton(Actor actor) {
        actor.attemptsTo(
                Click.on(TargetButton.COURSES_BUTTON)
        );
    }

    @Then("{actor} should see the courses page URL {string}")
    public void heShouldSeeTheCoursesPageURL(Actor actor, String expectedUrl) {
        actor.attemptsTo(
                Ensure.thatTheCurrentPage().currentUrl().isEqualTo(expectedUrl)
        );
    }
}

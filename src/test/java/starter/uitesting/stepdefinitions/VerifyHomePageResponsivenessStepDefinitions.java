package starter.uitesting.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.JavascriptExecutor;
import starter.uitesting.helpers.navigations.NavigateTo;
import starter.uitesting.helpers.pages.UOMITfacPage;

public class VerifyHomePageResponsivenessStepDefinitions {

//    @Steps
//    UOMITfacPage uomITfacPage;
//
//    @Given("{actor} wants to view the IT Faculty homepage")
//    public void openITFacultyHomepage(Actor actor) {
//        actor.wasAbleTo(NavigateTo.theSearchHomePage());
//    }

//    @When("{actor} views the homepage on screen sizes {string}")
//    public void actorViewsHomepageOnScreenSizes(Actor actor, String screenSizes) {
//        String[] sizes = screenSizes.split(", ");
//        for (String size : sizes) {
//            String[] dimensions = size.split("x");
//            int width = Integer.parseInt(dimensions[0]);
//            int height = Integer.parseInt(dimensions[1]);
//            uomITfacPage.getDriver().manage().window().setSize(new org.openqa.selenium.Dimension(width, height));
//        }
//    }

//    @Then("{actor} can see the main banner should adjust correctly without overflow")
//    public void mainBannerShouldAdjustCorrectly(Actor actor) {
//        // Cast WebDriver to JavascriptExecutor
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) uomITfacPage.getDriver();
//
//        // Get page width using JavaScript
//        long pageWidth = (long) jsExecutor.executeScript("return document.body.scrollWidth;");
//        int viewportWidth = uomITfacPage.getDriver().manage().window().getSize().getWidth();
//
//        actor.attemptsTo(
//                Ensure.that(UOMITfacPage.MAIN_BANNER).isDisplayed(),
//                Ensure.that(pageWidth).isLessThanOrEqualTo((long) viewportWidth)
//        );
//    }


//    @Then("{actor} should see the navigation menu should behave responsively")
//    public void navigationMenuShouldBehaveResponsively(Actor actor) {
//        int screenWidth = uomITfacPage.getDriver().manage().window().getSize().getWidth();
//        if (screenWidth < 760) {
//            actor.attemptsTo(
//                    Ensure.that(UOMITfacPage.HAMBURGER_MENU).isDisplayed()
//            );
//            UOMITfacPage.HAMBURGER_MENU.resolveFor(actor).click();
//            actor.attemptsTo(
//                    Ensure.that(UOMITfacPage.NAVIGATION_MENU_ITEMS).isDisplayed()
//            );
//        } else {
//            actor.attemptsTo(
//                    Ensure.that(UOMITfacPage.NAVIGATION_BAR).isDisplayed()
//            );
//        }
//    }

//    @Then("{actor} the footer should stack correctly on small screens")
//    public void footerShouldStackCorrectlyOnSmallScreens(Actor actor) {
//        int screenWidth = uomPage.getDriver().manage().window().getSize().getWidth();
//        if (screenWidth < 760) {
//            actor.attemptsTo(
//                    Ensure.that(uomPage.footerIsStacked()).isTrue()
//            );
//        }
//    }

//    @Then("{actor} no horizontal scrollbars should appear")
//    public void noHorizontalScrollbarsShouldAppear(Actor actor) {
//        int pageWidth = Integer.parseInt((String) uomPage.getDriver()
//                .executeScript("return document.body.scrollWidth;"));
//        int viewportWidth = uomPage.getDriver().manage().window().getSize().getWidth();
//        actor.attemptsTo(
//                Ensure.that(pageWidth).isLessThanOrEqualTo(viewportWidth)
//        );
//    }
}

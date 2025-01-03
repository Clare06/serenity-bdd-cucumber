package starter.uitesting.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.WebDriver;
import starter.uitesting.helpers.navigations.NavigateTo;
import starter.uitesting.helpers.pages.AccountRequestPage;

import java.io.File;
public class DownloadRequestFormStepDefinitions {
    WebDriver driver;
    @Given("{actor} is on the UOM Cites page")
    public void theUserIsOnThePage(Actor actor) {
        actor.attemptsTo(NavigateTo.theUOMCitesPage());
    }

    @When("{actor} checks the checkbox")
    public void theUserChecksTheCheckbox(Actor actor) {
        actor.attemptsTo(
                Click.on(AccountRequestPage.CHECKBOX)
        );
    }

    @Then("{actor} can see the download button")
    public void theButtonBecomesVisible(Actor actor) {
        actor.attemptsTo(
                Ensure.that(AccountRequestPage.DOWNLOAD_BUTTON)
                        .attribute("style").isEqualTo("display: block;")
        );
    }

    @Then("{actor} clicks the {string} button")
    public void theUserClicksTheButton(Actor actor,String buttonText) {
        actor.attemptsTo(
                Click.on(AccountRequestPage.DOWNLOAD_BUTTON)
        );
    }

    @And("the {string} file should be downloaded to the computer")
    public void theFileShouldBeDownloadedToTheComputer(String fileName) {
        String downloadPath = System.getProperty("user.home") + "/Downloads";
        File downloadedFile = new File(downloadPath + "/" + fileName);

        // Ensure the file exists
        Ensure.that(downloadedFile.exists()).isTrue();

        // Clean up: Delete the file after checking
        if (downloadedFile.exists()) {
            downloadedFile.delete();
        }
    }


}

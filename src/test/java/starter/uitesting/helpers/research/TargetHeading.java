package starter.uitesting.helpers.research;
import net.serenitybdd.screenplay.targets.Target;

public class TargetHeading {

    public static final Target RESEARCH_HEADING = Target.the("Research Unit heading")
            .locatedBy("//h1[@class='title page-title']/span[@property='schema:name']");
}

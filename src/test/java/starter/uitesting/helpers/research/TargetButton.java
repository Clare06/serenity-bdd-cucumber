package starter.uitesting.helpers.research;

import net.serenitybdd.screenplay.targets.Target;

public class TargetButton {
    public static final Target MORE_BUTTON = Target.the("More button")
            .locatedBy("//img[@alt='readmore']/parent::a"); // Adjust XPath/CSS selector as needed
}
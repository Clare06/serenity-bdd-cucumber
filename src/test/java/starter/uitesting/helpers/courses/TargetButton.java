package starter.uitesting.helpers.courses;

import net.serenitybdd.screenplay.targets.Target;

public class TargetButton {
    public static final Target COURSES_BUTTON = Target.the("Courses button")
            .locatedBy("//a[contains(@href, '/courses')]");
}

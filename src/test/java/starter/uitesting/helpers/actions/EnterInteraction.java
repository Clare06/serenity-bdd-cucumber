package starter.uitesting.helpers.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class EnterInteraction implements Interaction {

    private final String value;
    private final Target target;

    public EnterInteraction(String value, Target target) {
        this.value = value;
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        target.resolveFor(actor).sendKeys(value);
    }

    public static EnterInteraction into(String value, Target target) {
        return Tasks.instrumented(EnterInteraction.class, value, target);
    }
}

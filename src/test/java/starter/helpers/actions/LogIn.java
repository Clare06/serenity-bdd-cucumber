package starter.helpers.actions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import starter.helpers.forms.LoginForm;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class LogIn {
    public static Performable withCredentials(String username, String password) {
        return Task.where("{0} logs in with username and password",
                Enter.theValue(username).into(LoginForm.USERNAME_FIELD),
                Enter.theValue(password).into(LoginForm.PASSWORD_FIELD).thenHit(Keys.TAB),
                Scroll.to(LoginForm.LOGIN_BUTTON),
                WaitUntil.the(LoginForm.LOGIN_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(LoginForm.LOGIN_BUTTON)
        );
    }
}

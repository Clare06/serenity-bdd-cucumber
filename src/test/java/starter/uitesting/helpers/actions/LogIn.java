package starter.uitesting.helpers.actions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.uitesting.helpers.forms.LoginForm;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class LogIn {
    public static Performable withCredentials(String username, String password) {
        return Task.where("{0} logs in with username and password",
                EnterInteraction.into(username, LoginForm.USERNAME_FIELD),
                EnterInteraction.into(password, LoginForm.PASSWORD_FIELD),
                Scroll.to(LoginForm.LOGIN_BUTTON),
                WaitUntil.the(LoginForm.LOGIN_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(LoginForm.LOGIN_BUTTON)
        );
    }
}

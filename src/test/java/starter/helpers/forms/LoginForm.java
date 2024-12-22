package starter.helpers.forms;

import net.serenitybdd.screenplay.targets.Target;

public class LoginForm {
    public static final Target USERNAME_FIELD = Target.the("username field").locatedBy("#edit-name");
    public static final Target PASSWORD_FIELD = Target.the("password field").locatedBy("#edit-pass");
    public static final Target LOGIN_BUTTON = Target.the("login button").locatedBy("//input[@id='edit-submit' and @value='Log in' and @name='op']");
}

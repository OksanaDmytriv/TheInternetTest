package pages;

import org.openqa.selenium.Keys;

import static core.ConciseAPI.*;
import static core.CustomConditions.exactMessageText;

public class TheInternet {

    public static void visit() {
        open("http://the-internet.herokuapp.com/login");
    }

    public static void login(String email, String password) {
        $("#username").sendKeys(email);
        $("#password").sendKeys(password + Keys.ENTER);
    }

    public static void assertMessage(String expectedError) {
        assertThat(exactMessageText(byCSS("#flash"), expectedError));
    }

    public static void logout() {
        $(".button").sendKeys(Keys.ENTER);
    }
}

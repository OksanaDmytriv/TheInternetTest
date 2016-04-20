package pages;

import org.openqa.selenium.Keys;

import static core.ConciseAPI.*;
import static core.CustomConditions.exactErrorText;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class TheInternet {

    public static void login(String email, String password) {
        $("#username").sendKeys(email);
        $("#password").sendKeys(password + Keys.ENTER);
    }

    public static void visit() {
        open("http://the-internet.herokuapp.com/login");
    }

    public static void assertOpenedURL(String title) {
        assertThat(titleContains(title));
    }

    public static void assertErrorShown(String expectedError) {
        assertThat(exactErrorText(byCSS("#flash"), expectedError));
    }

    public static void logout() {
        $(".button.secondary.radius").sendKeys(Keys.ENTER);
    }
}

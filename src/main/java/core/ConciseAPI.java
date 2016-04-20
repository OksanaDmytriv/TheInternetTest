package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class ConciseAPI {

    private static Map<Thread, WebDriver> drivers = new HashMap<Thread, WebDriver>();

    public static WebDriver getDriver() {
        return drivers.get(Thread.currentThread());
    }

    public static void setDriver(WebDriver driver) {
        drivers.put(Thread.currentThread(), driver);
    }

    public static <V> void assertThat(ExpectedCondition<V> condition) {
        assertThat(condition, Configuration.timeout);
    }

    public static <V> void assertThat(ExpectedCondition<V> condition, int timeout) {
        (new WebDriverWait(getDriver(), timeout)).until(condition);
    }

    public static WebElement $(By locator) {
        assertThat(visibilityOfElementLocated(locator));
        return getDriver().findElement(locator);
    }

    public static WebElement $(String cssSelector) {
        return $(byCSS(cssSelector));
    }

    public static By byCSS(String cssSelector) {
        return By.cssSelector(cssSelector);
    }

    public static void open(String URL) {
        getDriver().get(URL);
    }
}

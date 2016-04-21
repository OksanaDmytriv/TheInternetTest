package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {

    public static ExpectedCondition<Boolean> exactMessageText(final By locator,
                                                              final String expectedText) {
        return new ExpectedCondition<Boolean>() {
            private String currentText;

            public Boolean apply(WebDriver webDriver) {
                try {
                    WebElement element = webDriver.findElement(locator);
                    currentText = element.getText();
                    return currentText.contains(expectedText);
                } catch (IndexOutOfBoundsException ex) {
                    return null;
                }
            }

            public String toString() {
                return String.format("\nExpected text of element should be: %s\n while current text is: %s\n", expectedText, currentText);

            }
        };
    }
}

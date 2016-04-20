package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {

    public static ExpectedCondition<Boolean> exactErrorText(final By locator,
                                                            final String text) {
        return new ExpectedCondition<Boolean>() {
            private String currentText;
            private WebElement element;

            public Boolean apply(WebDriver webDriver) {
                try {
                    element=webDriver.findElement(locator);
                    currentText = element.getText();
                    return (currentText.contains(text)) ? true : false;
                } catch (IndexOutOfBoundsException ex) {
                    return null;
                }
            }

            public String toString() {
                return String.format("\ntext of element should be: %s\n while actual text is: %s\n", text, currentText);

            }
        };
    }
}

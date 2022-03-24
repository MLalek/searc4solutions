package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods {
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView({block: \"center\",inline: \"center\",behavior: \"smooth\"});", element);
    }

    public static void waitForStaleElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        boolean cevir = true;
        while (cevir) {
            try {
                ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
                wait.until(ExpectedConditions.visibilityOf(element));
                element.click();
                cevir = false;
            } catch (StaleElementReferenceException e) {
                cevir = true;
            }
        }
    }
}

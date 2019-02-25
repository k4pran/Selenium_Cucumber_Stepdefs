package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;

/**
 * Enumeration of explicit wait selector methods.
 * Apply wait will call the corresponding explicit wait.
 * Some methods are intended to return a single element, however for compatibility across waits an immutable list is
 * returned and it is the caller's responsibility to extract the single element.
 * Waits that are actually intended to return multiple elements are prefixed by 'ALL'
 */
public enum ExplicitWait {

    CLICKABLE {
        @Override
        public List<WebElement> applyWait(WebDriver driver, Selector selector, String locator, long timeout) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return Collections.singletonList(
                    wait.until(ExpectedConditions.elementToBeClickable(ExplicitWait.resolveSearchMethod(selector, locator))));
        }
    },

    PRESENT {
        @Override
        public List<WebElement> applyWait(WebDriver driver, Selector selector, String locator, long timeout) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return Collections.singletonList(wait.until(
                    ExpectedConditions.presenceOfElementLocated(ExplicitWait.resolveSearchMethod(selector, locator))));
        }
    },

    VISIBLE {
        @Override
        public List<WebElement> applyWait(WebDriver driver, Selector selector, String locator, long timeout) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return Collections.singletonList(wait.until(
                    ExpectedConditions.visibilityOfElementLocated(ExplicitWait.resolveSearchMethod(selector, locator))));
        }
    },

    ALL_PRESENT {
        @Override
        public List<WebElement> applyWait(WebDriver driver, Selector selector, String locator, long timeout) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(ExplicitWait.resolveSearchMethod(selector, locator)));
        }
    },

    ALL_VISIBLE {
        @Override
        public List<WebElement> applyWait(WebDriver driver, Selector selector, String locator, long timeout) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(ExplicitWait.resolveSearchMethod(selector, locator)));
        }
    };

    public abstract List<WebElement> applyWait(WebDriver driver, Selector searchMethod, String locator, long timeout);

    private static By resolveSearchMethod(Selector selector, String locator) {

        switch (selector) {
            case CSS:
                return By.cssSelector(locator);

            case XPATH:
                return By.xpath(locator);

            case ID:
                return By.id(locator);

            case CLASS:
                return By.tagName(locator);

            case TAG:
                return By.tagName(locator);

            case LINK:
                return By.linkText(locator);

            case PARTIAL_LINK:
                return By.partialLinkText(locator);

            default:
                throw new RuntimeException("Unknown selector");
        }
    }
}

package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Steps {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    private List<WebElement> selectedElements = new ArrayList<>();
    private WebElement selectedElement;

    @Given("^I select driver \"([^\"]*)\"")
    public void selectDriver(WebElement webElement) throws Throwable {
        // todo
    }

    @Given("^implicit wait is set to (\\d+) nanoseconds")
    public void setImplicitWaitNano(long nanos) throws Throwable {
        driver.manage().timeouts().implicitlyWait(nanos, TimeUnit.NANOSECONDS);
    }

    @Given("^implicit wait is set to (\\d+) milliseconds")
    public void setImplicitWaitMs(long ms) throws Throwable {
        driver.manage().timeouts().implicitlyWait(ms, TimeUnit.MILLISECONDS);
    }

    @Given("^implicit wait is set to (\\d+) seconds")
    public void setImplicitWaitSeconds(long seconds) throws Throwable {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    @Given("^I? ?open (?:the )? ?browser$")
    public void openBrowser() throws Throwable {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        webDriverWait = new WebDriverWait(driver, 0);
    }

    @Given("^I? ?go to url \"([^\"]*)\"$")
    public void goToUrl(String url) throws Throwable {
        driver.get(url);
    }

    @Given("^window is maximized$")
    public void maximizeWindow() throws Throwable {
        driver.manage().window().maximize();
    }

    @When("^I? ?select element by css selector using value \"([^\"]*)\"$")
    public void selectElementByCss(String selector) throws Throwable {
        selectedElement = selectedElement == null ? driver.findElement(By.cssSelector(selector)) :
                                                    selectedElement.findElement(By.cssSelector(selector));
    }

    @When("^I? ?select elements by css selector using value \"([^\"]*)\"$")
    public void selectElementsByCss(String selector) throws Throwable {
        selectedElements = selectedElement == null ? driver.findElements(By.cssSelector(selector)) :
                                                     selectedElement.findElements(By.cssSelector(selector));
    }

    @When("^I? ?select element by xpath using value \"([^\"]*)\"$")
    public void selectElementByXpath(String selector) throws Throwable {
        selectedElement = selectedElement == null ? driver.findElement(By.xpath(selector)) :
                                                    selectedElement.findElement(By.xpath(selector));
    }

    @When("^I? ?select elements by xpath using value \"([^\"]*)\"$")
    public void selectElementsByXpath(String selector) throws Throwable {
        selectedElements = selectedElement == null ? driver.findElements(By.xpath(selector)) :
                                                     selectedElement.findElements(By.xpath(selector));
    }

    @When("^I? ?select element by id using value \"([^\"]*)\"$")
    public void selectElementById(String selector) throws Throwable {
        selectedElement = selectedElement == null ? driver.findElement(By.id(selector)) :
                selectedElement.findElement(By.id(selector));
    }

    @When("^I? ?select element by tag using value \"([^\"]*)\"$")
    public void selectElementByTag(String selector) throws Throwable {
        selectedElement = selectedElement == null ? driver.findElement(By.tagName(selector)) :
                                                    selectedElement.findElement(By.tagName(selector));
    }

    @When("^I? ?select elements by tag using value \"([^\"]*)\"$")
    public void selectElementsByTag(String selector) throws Throwable {
        selectedElements = selectedElement == null ? driver.findElements(By.tagName(selector)) :
                                                     selectedElement.findElements(By.tagName(selector));
    }

    @When("^I? ?select element by class name using value \"([^\"]*)\"$")
    public void selectElementByClassName(String selector) throws Throwable {
        selectedElement = selectedElement == null ? driver.findElement(By.className(selector)) :
                                                    selectedElement.findElement(By.className(selector));
    }

    @When("^I? ?select elements by class name using value \"([^\"]*)\"$")
    public void selectElementsByClassName(String selector) throws Throwable {
        selectedElements = selectedElement == null ? driver.findElements(By.className(selector)) :
                                                     selectedElement.findElements(By.className(selector));
    }

    @When("^I? ?select element by link text using value \"([^\"]*)\"$")
    public void selectElementByLinkText(String selector) throws Throwable {
        selectedElement = selectedElement == null ? driver.findElement(By.linkText(selector)) :
                                                    selectedElement.findElement(By.linkText(selector));
    }

    @When("^I? ?select element by partial link text using value \"([^\"]*)\"$")
    public void selectElementByPartialLinkText(String selector) throws Throwable {
        selectedElement = selectedElement == null ? driver.findElement(By.partialLinkText(selector)) :
                                                    selectedElement.findElement(By.partialLinkText(selector));
    }

    /**
     * Selects WebElement from selectedElements and assigned to selectedElement
     * @param index to select from selectedElements
     * @throws Throwable
     */
    @When("^I? ?select index (\\d+) from selected elements$")
    public void selectFromElements(Integer index) throws Throwable {
        selectedElement = selectedElements.get(index);
    }

    @When("^I? ?click selected element$")
    public void clickElement() throws Throwable {
        selectedElement.click();
    }

    @When("^I? ?double click selected element$")
    public void doubleClickElement() throws Throwable {
        Actions actions = new Actions(driver);
        actions.doubleClick(selectedElement).perform();
    }

    @When("^I? ?click and hold element$")
    public void clickAndHold() throws Throwable {
        Actions actions = new Actions(driver);
        actions.clickAndHold(selectedElement).perform();
    }

    @When("^I? ?submit form$")
    public void submit() throws Throwable {
        selectedElement.submit();
    }

    @When("^I? ?hover over selected element$")
    public void hoverElement() throws Throwable {
        Actions actions = new Actions(driver);
        actions.moveToElement(selectedElement).perform();
    }

    @When("^I? ?enter the text \"([^\"]*)\"$")
    public void enterText(String text) throws Throwable {
        selectedElement.sendKeys(text);
    }

    @When("^I? ?refresh the page$")
    public void refresh() throws Throwable {
        driver.navigate().refresh();
    }

    @When("^I? ?go back a page$")
    public void back() throws Throwable {
        driver.navigate().back();
    }

    @When("^I? ?go forward a page$")
    public void forward() throws Throwable {
        driver.navigate().forward();
    }

    @When("^I? ?pause for (\\d+) milliseconds$")
    public void pauseMs(long milliseconds) throws Throwable {
        Actions actions = new Actions(driver);
        actions.pause(Duration.ofMillis(milliseconds));
    }

    @When("^I? ?pause for (\\d+) seconds$")
    public void pauseSecs(long seconds) throws Throwable {
        Actions actions = new Actions(driver);
        actions.pause(Duration.ofSeconds(seconds));
    }

    @Then("^I? ?check current url is \"([^\"]*)\"")
    public void checkCurrentUrl(String expectedUrl) throws Throwable {
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Then("^I? ?check current url contains \"([^\"]*)\"")
    public void checkCurrentUrlContains(String urlPart) throws Throwable {
        assertThat(driver.getCurrentUrl(), CoreMatchers.containsString(urlPart));
    }

    @Then("^I? ?check the page title is \"([^\"]*)\"")
    public void checkPageTitle(String pageTitle) throws Throwable {
        assertEquals(pageTitle, driver.getTitle());
    }

    @Then("^I? ?check the page title contains \"([^\"]*)\"")
    public void checkPageTitleContains(String expectedTitlePart) throws Throwable {
        assertThat(driver.getTitle(), CoreMatchers.containsString(expectedTitlePart));
    }

    @Then("^I? ?check the element's inner text is equal to \"([^\"]*)\"")
    public void checkInnerText(String expectedText) throws Throwable {
        assertEquals(expectedText, selectedElement.getText());
    }

    @Then("^I? ?check the element's inner text contains \"([^\"]*)\"")
    public void checkInnerTextContains(String expectedSubText) throws Throwable {
        assertThat(selectedElement.getText(), CoreMatchers.containsString(expectedSubText));
    }

    @Then("^I? ?check attribute \"([^\"]*)\" exists")
    public void checkAttributeExists(String attribute) throws Throwable {
        // todo
    }

    @Then("^I? ?check the element's attribute \"([^\"]*)\" is equal to \"([^\"]*)\"")
    public void checkAttributeValue(String attribute, String value) throws Throwable {
        assertEquals(value, selectedElement.getAttribute(attribute));
    }

    @Then("^I? ?check the number of elements found is (\\d+)")
    public void checkPageTitleContains(int expectedCount) throws Throwable {
        assertEquals(expectedCount, selectedElements.size());
    }

    @Then("^I? ?check the element is displayed")
    public void checkElementIsDisplayed() throws Throwable {
        assertTrue(selectedElement.isDisplayed());
    }

    @Then("^I? ?check the element is selected")
    public void checkElementIsSelected() throws Throwable {
        assertTrue(selectedElement.isSelected());
    }

    @Then("^I? ?check the element is enabled")
    public void checkElementIsEnabled() throws Throwable {
        assertTrue(selectedElement.isEnabled());
    }

    /**
     * Clears both selectedElements list and the single selectedElement
     * @throws Throwable
     */
    @Then("^I? ?clear selected elements$")
    public void clearSelectedElements() throws Throwable {
        selectedElement = null;
        selectedElements = new ArrayList<>();
    }

    @Then("^I? ?close the browser$")
    public void closeBrowser() throws Throwable {
        driver.close();
    }
}
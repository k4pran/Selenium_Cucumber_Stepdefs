package StepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Step definitions for performing basic selenium tasks
 * Most actions are performed on the <b>selectedElement</b> property.
 * Multiple WebElements can be found and stored in <b></b>selectedElements</b> and then moved into selectedElement
 * WebElements can also be named and referenced by storing them in <b>namedElements</b>
 *
 * When selecting elements, if <b>selectedElement</b> is null then the whole dom hierarchy will be searched. If
 * it is not null then the select methods will be actioned relative to the currently selected element. If you
 * have selected an element and then afterwards want to search the whole dom then make sure to clear the selected
 * element (and giving it an alias to add into namedElements if you want to use it later)
 */

public class Steps {

    private WebDriver driver;

    private HashMap<String, WebElement> namedElements;
    private List<WebElement> selectedElements;
    private WebElement selectedElement;
    private ExplicitWait explicitWait;
    private ExplicitWait explicitWaitAll;
    private int explicitWaitTimeout;

    public Steps() {
        this.namedElements = new HashMap<>();
        this.selectedElements = new ArrayList<>();
    }

    @Given("(?:the)? ?\"([^\"]*)\" browser is open")
    public void openGivenWebBrowser(String browserName) throws Throwable {
        launchBrowser(browserName);
    }

    @Given("^implicit wait is set to (\\d+) nanoseconds$")
    public void setImplicitWaitNano(long nanos) {
        driver.manage().timeouts().implicitlyWait(nanos, TimeUnit.NANOSECONDS);
    }

    @Given("^implicit wait is set to (\\d+) milliseconds$")
    public void setImplicitWaitMs(long ms) {
        driver.manage().timeouts().implicitlyWait(ms, TimeUnit.MILLISECONDS);
    }

    @Given("^implicit wait is set to (\\d+) seconds$")
    public void setImplicitWaitSeconds(long seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    @Given("^I? ?open (?:the)? ?browser$")
    public void openBrowser() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    /**
     * Opens a url
     * @param url should be a fully qualified url such as https://www.google.com rather than google.com
     */
    @Given("^I? ?(?:(?:go to)|(?:visit)) (?:the)? ?(?:website|url) \"([^\"]*)\"$")
    public void goToUrl(String url) {
        driver.get(url);
    }

    @Given("^(?:the)? ?window is maximized$")
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }


    @Given("^I? ?am waiting for elements to be clickable with a timeout of (\\d+) seconds(?: when selecting)?$")
    public void setExplicitWaitToClickable(int timout) {
        explicitWait = ExplicitWait.CLICKABLE;
        explicitWaitTimeout = timout;
    }

    @Given("^I? ?am waiting for elements to be present with a timeout of (\\d+) seconds(?: when selecting)?$")
    public void setExplicitWaitToPresent(int timout) {
        explicitWait = ExplicitWait.PRESENT;
        explicitWaitAll = ExplicitWait.ALL_PRESENT;
        explicitWaitTimeout = timout;
    }

    @Given("^I? ?am waiting for elements to be visible with a timeout of (\\d+) seconds(?: when selecting)?$")
    public void setExplicitWaitToVisibility(int timout) {
        explicitWait = ExplicitWait.VISIBLE;
        explicitWaitAll = ExplicitWait.ALL_VISIBLE;
        explicitWaitTimeout = timout;
    }

    @Given("^no explicit wait$")
    public void clearExplicitWait() {
        explicitWait = null;
        explicitWaitAll = null;
        explicitWaitTimeout = 0;
    }

    //-------------------------//
    //    Selector methods     //
    //-------------------------//

    /**
     * Selected element will be stored in selectedElement which is the webElement used by default for most step defs
     * An exception is thrown if no element is found and the value of selectedElement will remain unchanged
     * @param locator a string that targets an element in the dom.
     * @throws NoSuchElementException when no element is not found
     */
    @When("^I? ?select element by css locator using value \"([^\"]*)\"$")
    public void selectElementByCss(String locator) throws NoSuchElementException {
        if (explicitWait != null) {
            selectedElement = explicitWait.applyWait(driver, Selector.CSS, locator, explicitWaitTimeout).get(0);
            return;
        }
        selectedElement = selectedElement == null ? driver.findElement(By.cssSelector(locator)) :
                    selectedElement.findElement(By.cssSelector(locator));
    }

    /**
     * Selected elements will be stored in selectedElements and any of these can be assigned to selectedElement
     * by calling selectFromElements(int index) step definition.
     * Selenium returns an empty list if no elements found, however NoSuchElementException is thrown to
     * remain consistent with the selectElementBy... methods.
     * @param locator a string that targets an element in the dom.
     * @throws NoSuchElementException when no element is not found
     */
    @When("^I? ?select elements by css locator using value \"([^\"]*)\"$")
    public void selectElementsByCss(String locator) throws NoSuchElementException {
        if (explicitWaitAll != null) {
            selectedElements = explicitWaitAll.applyWait(driver, Selector.CSS, locator, explicitWaitTimeout);
            return;
        }
        selectedElements = selectedElement == null ? driver.findElements(By.cssSelector(locator)) :
                selectedElement.findElements(By.cssSelector(locator));
    }

    /**
     * Selected element will be stored in selectedElement which is the webElement used by default for most step defs
     * An exception is thrown if no element is found and the value of selectedElement will remain unchanged
     * @param locator a string that targets an element in the dom.
     * @throws NoSuchElementException when no element is not found
     */
    @When("^I? ?select element by xpath using value \"([^\"]*)\"$")
    public void selectElementByXpath(String locator) throws NoSuchElementException {
        if (explicitWait != null) {
            selectedElement = explicitWait.applyWait(driver, Selector.XPATH, locator, explicitWaitTimeout).get(0);
            return;
        }
        selectedElement = selectedElement == null ? driver.findElement(By.xpath(locator)) :
                selectedElement.findElement(By.xpath(locator));
    }

    /**
     * Selected elements will be stored in selectedElements and any of these can be assigned to selectedElement
     * by calling selectFromElements(int index) step definition.
     * Selenium returns an empty list if no elements found, however NoSuchElementException is thrown to
     * remain consistent with the selectElementBy... methods.
     * @param locator a string that targets an element in the dom.
     * @throws NoSuchElementException when no element is not found
     */
    @When("^I? ?select elements by xpath using value \"([^\"]*)\"$")
    public void selectElementsByXpath(String locator) throws NoSuchElementException {
        if (explicitWaitAll != null) {
            selectedElements = explicitWaitAll.applyWait(driver, Selector.XPATH, locator, explicitWaitTimeout);
            return;
        }
        selectedElements = selectedElement == null ? driver.findElements(By.xpath(locator)) :
                selectedElement.findElements(By.xpath(locator));
    }

    /**
     * Selected element will be stored in selectedElement which is the webElement used by default for most step defs
     * An exception is thrown if no element is found and the value of selectedElement will remain unchanged
     * @param locator a string that targets an element in the dom.
     * @throws NoSuchElementException when no element is not found
     */
    @When("^I? ?select element by id using value \"([^\"]*)\"$")
    public void selectElementById(String locator) throws NoSuchElementException {
        if (explicitWait != null) {
            selectedElement = explicitWait.applyWait(driver, Selector.ID, locator, explicitWaitTimeout).get(0);
            return;
        }
        selectedElement = selectedElement == null ? driver.findElement(By.id(locator)) :
                selectedElement.findElement(By.id(locator));
    }

    /**
     * Selected element will be stored in selectedElement which is the webElement used by default for most step defs
     * An exception is thrown if no element is found and the value of selectedElement will remain unchanged
     * @param locator a string that targets an element in the dom.
     * @throws NoSuchElementException when no element is not found
     */
    @When("^I? ?select element by tag using value \"([^\"]*)\"$")
    public void selectElementByTag(String locator) throws NoSuchElementException {
        if (explicitWait != null) {
            selectedElement = explicitWait.applyWait(driver, Selector.TAG, locator, explicitWaitTimeout).get(0);
            return;
        }
        selectedElement = selectedElement == null ? driver.findElement(By.tagName(locator)) :
                selectedElement.findElement(By.tagName(locator));
    }

    /**
     * Selected elements will be stored in selectedElements and any of these can be assigned to selectedElement
     * by calling selectFromElements(int index) step definition.
     * Selenium returns an empty list if no elements found, however NoSuchElementException is thrown to
     * remain consistent with the selectElementBy... methods.
     * @param locator a string that targets an element in the dom.
     * @throws NoSuchElementException when no element is not found
     */
    @When("^I? ?select elements by tag using value \"([^\"]*)\"$")
    public void selectElementsByTag(String locator) throws NoSuchElementException {
        if (explicitWaitAll != null) {
            selectedElements = explicitWaitAll.applyWait(driver, Selector.TAG, locator, explicitWaitTimeout);
            return;
        }
        selectedElements = selectedElement == null ? driver.findElements(By.tagName(locator)) :
                selectedElement.findElements(By.tagName(locator));
    }

    /**
     * Selected element will be stored in selectedElement which is the webElement used by default for most step defs
     * An exception is thrown if no element is found and the value of selectedElement will remain unchanged
     * If multiple elements are found the first element will be assigned to selectedElement
     * @param locator a string that targets an element in the dom.
     * @throws NoSuchElementException when no element is not found
     */
    @When("^I? ?select element by class name using value \"([^\"]*)\"$")
    public void selectElementByClassName(String locator) throws NoSuchElementException {
        if (explicitWait != null) {
            selectedElement = explicitWait.applyWait(driver, Selector.CLASS, locator, explicitWaitTimeout).get(0);
            return;
        }
        selectedElement = selectedElement == null ? driver.findElement(By.className(locator)) :
                selectedElement.findElement(By.className(locator));
    }

    /**
     * Selected elements will be stored in selectedElements and any of these can be assigned to selectedElement
     * by calling selectFromElements(int index) step definition.
     * Selenium returns an empty list if no elements found, however NoSuchElementException is thrown to
     * remain consistent with the selectElementBy... methods.
     * @param locator a string that targets an element in the dom.
     * @throws NoSuchElementException when no element is not found
     */
    @When("^I? ?select elements by class name using value \"([^\"]*)\"$")
    public void selectElementsByClassName(String locator) throws NoSuchElementException {
        if (explicitWaitAll != null) {
            selectedElements = explicitWaitAll.applyWait(driver, Selector.CLASS, locator, explicitWaitTimeout);
            return;
        }
        selectedElements = selectedElement == null ? driver.findElements(By.className(locator)) :
                selectedElement.findElements(By.className(locator));
    }

    /**
     * Selected element will be stored in selectedElement which is the webElement used by default for most step defs
     * An exception is thrown if no element is found and the value of selectedElement will remain unchanged
     * @param locator a string that targets an element in the dom.
     * @throws NoSuchElementException when no element is not found
     */
    @When("^I? ?select element by link text using value \"([^\"]*)\"$")
    public void selectElementByLinkText(String locator) throws NoSuchElementException {
        if (explicitWait != null) {
            selectedElement = explicitWait.applyWait(driver, Selector.LINK, locator, explicitWaitTimeout).get(0);
            return;
        }
        selectedElement = selectedElement == null ? driver.findElement(By.linkText(locator)) :
                selectedElement.findElement(By.linkText(locator));
    }

    /**
     * Selected element will be stored in selectedElement which is the webElement used by default for most step defs
     * An exception is thrown if no element is found and the value of selectedElement will remain unchanged
     * @param locator a string that targets an element in the dom.
     * @throws NoSuchElementException when no element is not found
     */
    @When("^I? ?select element by partial link text using value \"([^\"]*)\"$")
    public void selectElementByPartialLinkText(String locator) throws NoSuchElementException {
        if (explicitWait != null) {
            selectedElement = explicitWait.applyWait(driver, Selector.PARTIAL_LINK, locator, explicitWaitTimeout).get(0);
            return;
        }
        selectedElement = selectedElement == null ? driver.findElement(By.partialLinkText(locator)) :
                selectedElement.findElement(By.partialLinkText(locator));
    }

    /**
     * Selects WebElement from selectedElements and assigned to selectedElement
     * @param index to select from selectedElements
     */
    @When("^I? ?select index (\\d+) from selected elements$")
    public void selectFromElements(Integer index) {
        selectedElement = selectedElements.get(index);
    }

    @When("^I? ?filter selected elements by xpath using value \"([^\"]*)\"$")
    public void filterSelectedElementsByXPath(String filter) {
        selectedElements.removeIf(element -> element.findElements(By.xpath(filter)).size() == 0);
    }

    @When("^I? ?filter selected elements based on if their descendents contain the text \"([^\"]*)\"$")
    public void filterSelectedElementsByText(String filterText) {
        selectedElements.removeIf(element -> element.findElements(By.xpath(".//*[contains(text(),'" + filterText + "')]")).size() == 0);
    }

    /**
     * If the named element exists it will become the selectedElement so that actions can be performed on it
     * @param elementName alias to be selected
     */
    @When("^I? ?select (?:the)? ?named element \"([^\"]*)\"$")
    public void selectNamedElement(String elementName) {
        selectedElement = namedElements.get(elementName);
    }

    @When("^I? ?(?:left)? ?click (?:the)? ?selected element$")
    public void clickElement() {
        selectedElement.click();
    }

    @When("^I? ?double click selected element$")
    public void doubleClickElement() {
        Actions actions = new Actions(driver);
        actions.doubleClick(selectedElement).perform();
    }

    @When("^I? ?click and hold element$")
    public void clickAndHold() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(selectedElement).perform();
    }

    /**
     * Convenience method - Submit a form if element is contained within a form
     */
    @When("^I? ?submit(?: form)?$")
    public void submit() {
        selectedElement.submit();
    }

    @When("^I? ?(?:(?:hover over)|(?:move to)) (?:the)? ?selected element$")
    public void hoverElement() {
        Actions actions = new Actions(driver);
        actions.moveToElement(selectedElement).perform();
    }

    @When("^I? ?(?:type|enter|input) (?:the text|text)? ?\"([^\"]*)\"$")
    public void enterText(String text) {
        selectedElement.sendKeys(text);
    }

    @When("^I? ?(?:press|select|click|click on)? ?(?:refresh|reload) ?(?:the)? ?(?:page)?$")
    public void refresh() {
        driver.navigate().refresh();
    }

    @When("^I? ?go back a page$")
    public void back() {
        driver.navigate().back();
    }

    @When("^I? ?go forward a page$")
    public void forward() {
        driver.navigate().forward();
    }

    @When("^I? ?pause for (\\d+) milliseconds$")
    public void pauseMs(long milliseconds) {
        Actions actions = new Actions(driver);
        actions.pause(Duration.ofMillis(milliseconds));
    }

    @When("^I? ?pause for (\\d+) seconds$")
    public void pauseSecs(long seconds) {
        Actions actions = new Actions(driver);
        actions.pause(Duration.ofSeconds(seconds));
    }

    @When("^I? ?name (?:the)? ?selected element as \"([^\"]*)\"$")
    public void nameSelectedElement(String elementName) {
        namedElements.put(elementName, selectedElement);
    }

    // Temporary method until explicit waits are implemented
    @When("^a (\\d+) second pause$")
    public void pause(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @Then("^I? ?check (?:the)? ?current url is \"([^\"]*)\"$")
    public void checkCurrentUrl(String expectedUrl) {
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Then("^I? ?check (?:the)? ?current url contains \"([^\"]*)\"$")
    public void checkCurrentUrlContains(String urlPart) {
        assertThat(driver.getCurrentUrl(), CoreMatchers.containsString(urlPart));
    }

    @Then("^I? ?check (?:the)? ?page title is \"([^\"]*)\"$")
    public void checkPageTitle(String pageTitle) {
        assertEquals(pageTitle, driver.getTitle());
    }

    @Then("^I? ?check (?:the)? ?page title contains \"([^\"]*)\"$")
    public void checkPageTitleContains(String expectedTitlePart) {
        assertThat(driver.getTitle(), CoreMatchers.containsString(expectedTitlePart));
    }

    @Then("^I? ?check (?:the)? ?page contains the text \"([^\"]*)\"$")
    public void checkPageContainsText(String expectedText) {
        List<WebElement> elementsFound = driver.findElements(By.xpath("//*[contains(text(),'" + expectedText + "')]"));
        assertTrue("Text " + expectedText + " not found", elementsFound.size() > 0);
    }

    @Then("^I? ?check (?:the)? ?page does not contain the text \"([^\"]*)\"$")
    public void checkPageDoesNotContainsText(String unExpectedText) throws Exception {
        List<WebElement> elementsFound = driver.findElements(By.xpath("//*[contains(text(),'" + unExpectedText + "')]"));
        assertTrue("Text " + unExpectedText + " not found", elementsFound.size() == 0);
    }

    @Then("^I? ?check (?:the)? ?element's inner text is equal to \"([^\"]*)\"$")
    public void checkInnerText(String expectedText) {
        assertEquals(expectedText, selectedElement.getText());
    }

    @Then("^I? ?check (?:the)? ?element's inner text contains \"([^\"]*)\"$")
    public void checkInnerTextContains(String expectedSubText) {
        assertThat(selectedElement.getText(), CoreMatchers.containsString(expectedSubText));
    }

    @Then("^I? ?check if the element's descendents contain the text \"([^\"]*)\"$")
    public void checkDescendents(String expectedText) {
        assertTrue(selectedElement == null ?
                driver.findElements(By.xpath("//*[contains(text(),'" + expectedText + "')]")).size() > 0 :
                selectedElement.findElements(By.xpath(".//*[contains(text(),'" + expectedText + "')]")).size() > 0);
    }

    @Then("^I? ?check (?:the)? ?attribute \"([^\"]*)\" exists$")
    public void iCheckAttributeExists(String attribute) {
        String expectedAttribute = selectedElement.getAttribute(attribute);
        assertNotNull(expectedAttribute);
    }

    @Then("^I? ?check (?:the)? ?element's attribute \"([^\"]*)\" is equal to \"([^\"]*)\"$")
    public void checkAttributeValue(String attribute, String value) {
        assertEquals(value, selectedElement.getAttribute(attribute));
    }

    @Then("^I? ?check (?:the)? ?element's attribute \"([^\"]*)\" contains \"([^\"]*)\"$")
    public void checkAttributeValueContains(String attribute, String value) {
        assertThat(selectedElement.getAttribute(attribute), CoreMatchers.containsString(value));
    }

    /**
     * @param expectedCount expected number of elements in selectedElements
     */
    @Then("^I? ?check (?:the)? ?number of elements found is (\\d+)$")
    public void checkNumberOfElementsFound(int expectedCount) {
        assertEquals(expectedCount, selectedElements.size());
    }

    /**
     * @param expectedCount expected number of elements in selectedElements
     */
    @Then("^I? ?check (?:the)? ?number of elements found is at least (\\d+)$")
    public void checkNumberOfElementsFoundAtLeast(int expectedCount) {
        assertTrue(selectedElements.size() >= expectedCount);
    }

    @Then("^I? ?check (?:the)? ?element is displayed$")
    public void checkElementIsDisplayed() {
        assertTrue(selectedElement.isDisplayed());
    }

    @Then("^I? ?check (?:the)? ?element is selected$")
    public void checkElementIsSelected() {
        assertTrue(selectedElement.isSelected());
    }

    @Then("^I? ?check (?:the)? ?element is enabled$")
    public void checkElementIsEnabled() {
        assertTrue(selectedElement.isEnabled());
    }


    // EXPLICIT WAIT VALIDATIONS

    @Then("^I? ?check (?:the)? ?invisibility of (?:the)? ?selected element with a timeout of (\\d+) seconds$")
    public void invisibilityOfElement(long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        assertTrue(wait.until(ExpectedConditions.invisibilityOf(selectedElement)));
    }

    @Then("^I? ?check (?:the)? ?invisibility of (?:the)? ?selected elements with a timeout of (\\d+) seconds$")
    public void invisibilityOfAllElements(long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        assertTrue(wait.until(ExpectedConditions.invisibilityOfAllElements(selectedElements)));
    }

    @Then("^I? ?check (?:the)? ?selected element is in focus with a timeout of (\\d+) seconds$")
    public void elementIsSelected(long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        assertTrue(wait.until(ExpectedConditions.elementSelectionStateToBe(selectedElement, true)));
    }

    @Then("^I? ?check (?:the)? ?selected element is not in focus with a timeout of (\\d+) seconds$")
    public void elementIsNotSelected(long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        assertTrue(wait.until(ExpectedConditions.elementSelectionStateToBe(selectedElement, false)));
    }

    @Then("^I? ?check (?:the)? ?selected element is no longer attached to (?:the)? ?dom with a timeout of (\\d+) seconds$")
    public void elementIsStale(long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        assertTrue(wait.until(ExpectedConditions.stalenessOf(selectedElement)));
    }

    @Then("^I? ?check (?:the)? ?text \"([^\"]*)\" is present in the selected element with a timeout of (\\d+) seconds$")
    public void textIsPresent(String expectedText, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(selectedElement, expectedText)));
    }

    @Then("^I? ?check (?:the)? ?text \"([^\"]*)\" is present in the selected element's value with a timeout of (\\d+) seconds$")
    public void textIsPresentInValue(String expectedText, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        assertTrue(wait.until(ExpectedConditions.textToBePresentInElementValue(selectedElement, expectedText)));
    }

    @Then("^I? ?check (?:the)? ?page title is \"([^\"]*)\" with a timeout of (\\d+) seconds$")
    public void checkTitleWithWait(String expectedTitle, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(selectedElement, expectedTitle)));
    }

    @Then("^I? ?check (?:the)? ?page title contains \"([^\"]*)\" with a timeout of (\\d+) seconds$")
    public void checkTitleContainsWithWait(String expectedTitlePart, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(selectedElement, expectedTitlePart)));
    }

    /**
     * Clears both selectedElements list and the single selectedElement
     */
    @Then("^I? ?clear (?:the)? ?selected elements$")
    public void clearSelectedElements() {
        selectedElement = null;
        selectedElements = new ArrayList<>();
    }

    /**
     * Clears only named elements
     */
    @Then("^I? ?clear (?:the)? ?named elements$")
    public void clearNamedElements() {
        namedElements = new HashMap<>();
    }

    @Then("^I? ?(?:close|quit)(?:(?: the)? browser)?$")
    public void closeBrowser() {
        driver.close();
    }

    //-------------------------//
    //         ALIASES         //
    //-------------------------//

    @Given("^I (?:choose|select|am using) ?(?:the)? driver \"([^\"]*)\"$")
    public void selectDriver(String driver) throws Throwable {
        openGivenWebBrowser(driver);
    }

    @Given("^I? ?set implicit wait to (\\d+) nanoseconds$")
    public void setImplicitWaitNanoAlias(long nanos) {
        setImplicitWaitNano(nanos);
    }

    @Given("^I? ?set implicit wait to (\\d+) milliseconds$")
    public void setImplicitWaitMsAlias(long ms) {
        setImplicitWaitMs(ms);
    }

    @Given("^I? ?set implicit wait to (\\d+) seconds$")
    public void setImplicitWaitSecondsAlias(long seconds) {
        setImplicitWaitSeconds(seconds);
    }

    @Given("^I? ?maximize (?:the)? ?window$")
    public void maximizeWindowAlias() {
        maximizeWindow();
    }

    @Given("I? ?set explicit wait to 0")
    public void clearExplicitWaitAlias1() {
        clearExplicitWait();
    }

    @Given("I? ?disable explicit wait")
    public void clearExplicitWaitAlias2() {
        clearExplicitWait();
    }

    @Given("Explicit wait is disabled")
    public void clearExplicitWaitAlias3() {
        clearExplicitWait();
    }

    @Given("^I? ?launch (?:the )? ?browser$")
    public void openBrowserAlias() {
        openBrowser();
    }

    @Given("^(?:the)? ?browser (?:is|has been) (?:launched|(?:opened|open))$")
    public void openBrowserAlias2() {
        openBrowser();
    }

    @When("^element at index (\\d+) (?:is selected|from results is selected)$")
    public void selectFromElementsAlias(Integer index) {
        selectFromElements(index);
    }

    @When("^I (?:select|choose|get|grab|fetch|focus in on) element number (\\d+) from (?:results|selected elements|list|elements|group)$")
    public void selectFromElementsAlias2(Integer index) {
        selectFromElements(index);
    }

    @When("^I? ?(?:press|select|click|click on|go) back$")
    public void backAlias() {
        back();
    }

    @When("^I? ?(?:press|select|click|click on|go) forward$")
    public void forwardAlias() {
        forward();
    }

    // Utility methods

    /**
     * Initiates the specified browser driver
     * @param browserName name of the browser
     * @throws SeleniumStepException if browser is not supported
     */
    private void launchBrowser(String browserName) throws SeleniumStepException {
        if(browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver(options);
        }
        else {
            throw new SeleniumStepException("Browser " + browserName + " is not supported");
        }
    }

    @After
    public void forceCloseBrowser() {
        driver.close();
    }
}
package fixture.stepdefs;

import cucumber.api.java.en.Then;
import fixture.SeleniumHandlers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Validations {

    @Then("^I? ?check (?:the)? ?current url is \"([^\"]*)\"$")
    public void checkCurrentUrl(String expectedUrl) {
        SeleniumHandlers.checkCurrentUrl(expectedUrl);
    }

    @Then("^I? ?check (?:the)? ?current url contains \"([^\"]*)\"$")
    public void checkCurrentUrlContains(String urlPart) {
        SeleniumHandlers.checkCurrentUrlContains(urlPart);
    }

    @Then("^I? ?check (?:the)? ?page title is \"([^\"]*)\"$")
    public void checkPageTitle(String pageTitle) {
        SeleniumHandlers.checkPageTitle(pageTitle);
    }

    @Then("^I? ?check (?:the)? ?page title contains \"([^\"]*)\"$")
    public void checkPageTitleContains(String expectedTitlePart) {
        SeleniumHandlers.checkPageTitleContains(expectedTitlePart);
    }

    @Then("^I? ?check (?:the)? ?page contains the text \"([^\"]*)\"$")
    public void checkPageContainsText(String expectedText) {
        SeleniumHandlers.checkPageContainsText(expectedText);
    }

    @Then("^I? ?check (?:the)? ?page does not contain the text \"([^\"]*)\"$")
    public void checkPageDoesNotContainsText(String unexpectedText) {
        SeleniumHandlers.checkPageDoesNotContainsText(unexpectedText);
    }

    @Then("^I? ?check (?:that)? ?any element's inner text is equal to \"([^\"]*)\"$")
    public void checkPageElementHasInnerText(String expectedText) {
        SeleniumHandlers.checkPageElementHasInnerText(expectedText);
    }

    @Then("^I? ?check (?:that)? ?no element's inner text is equal to \"([^\"]*)\"$")
    public void checkNoPageElementHasInnerText(String unexpectedText) {
        SeleniumHandlers.checkNoPageElementHasInnerText(unexpectedText);
    }

    @Then("^I? ?check (?:the)? ?element's inner text is equal to \"([^\"]*)\"$")
    public void checkInnerText(String expectedText) {
        SeleniumHandlers.checkInnerText(expectedText);
    }

    @Then("^I? ?check (?:the)? ?element's inner text contains \"([^\"]*)\"$")
    public void checkInnerTextContains(String expectedSubText) {
        SeleniumHandlers.checkInnerTextContains(expectedSubText);
    }

    @Then("^I? ?check if the element's descendents contain the text \"([^\"]*)\"$")
    public void checkDescendents(String expectedText) {
        SeleniumHandlers.checkDescendents(expectedText);
    }

    @Then("^I? ?check (?:the)? ?attribute \"([^\"]*)\" exists$")
    public void iCheckAttributeExists(String attribute) {
        SeleniumHandlers.iCheckAttributeExists(attribute);
    }

    @Then("^I? ?check (?:the)? ?element's attribute \"([^\"]*)\" is equal to \"([^\"]*)\"$")
    public void checkAttributeValue(String attribute, String value) {
        SeleniumHandlers.checkAttributeValue(attribute, value);
    }

    @Then("^I? ?check (?:the)? ?element's attribute \"([^\"]*)\" contains \"([^\"]*)\"$")
    public void checkAttributeValueContains(String attribute, String value) {
        SeleniumHandlers.checkAttributeValueContains(attribute, value);
    }

    /**
     * @param expectedCount expected number of elements in selectedElements
     */
    @Then("^I? ?check (?:the)? ?number of elements found is (\\d+)$")
    public void checkNumberOfElementsFound(int expectedCount) {
        SeleniumHandlers.checkNumberOfElementsFound(expectedCount);
    }

    /**
     * @param expectedCount expected number of elements in selectedElements
     */
    @Then("^I? ?check (?:the)? ?number of elements found is at least (\\d+)$")
    public void checkNumberOfElementsFoundAtLeast(int expectedCount) {
        SeleniumHandlers.checkNumberOfElementsFoundAtLeast(expectedCount);
    }

    @Then("^I? ?check (?:the)? ?element is displayed$")
    public void checkElementIsDisplayed() {
        SeleniumHandlers.checkElementIsDisplayed();
    }

    @Then("^I? ?check (?:the)? ?element is selected$")
    public void checkElementIsSelected() {
        SeleniumHandlers.checkElementIsSelected();
    }

    @Then("^I? ?check (?:the)? ?element is enabled$")
    public void checkElementIsEnabled() {
        SeleniumHandlers.checkElementIsEnabled();
    }

    @Then("^I? ?check (?:the)? ?invisibility of (?:the)? ?selected element with a timeout of (\\d+) seconds$")
    public void invisibilityOfElement(long timeout) {
        SeleniumHandlers.invisibilityOfElement(timeout);
    }

    @Then("^I? ?check (?:the)? ?invisibility of (?:the)? ?selected elements with a timeout of (\\d+) seconds$")
    public void invisibilityOfAllElements(long timeout) {
        SeleniumHandlers.invisibilityOfAllElements(timeout);
    }

    @Then("^I? ?check (?:the)? ?selected element is in focus with a timeout of (\\d+) seconds$")
    public void elementIsSelected(long timeout) {
        SeleniumHandlers.elementIsSelected(timeout);
    }

    @Then("^I? ?check (?:the)? ?selected element is not in focus with a timeout of (\\d+) seconds$")
    public void elementIsNotSelected(long timeout) {
        SeleniumHandlers.elementIsNotSelected(timeout);
    }

    @Then("^I? ?check (?:the)? ?selected element is no longer attached to (?:the)? ?dom with a timeout of (\\d+) seconds$")
    public void elementIsStale(long timeout) {
        SeleniumHandlers.elementIsStale(timeout);
    }

    @Then("^I? ?check (?:the)? ?text \"([^\"]*)\" is present in the selected element with a timeout of (\\d+) seconds$")
    public void textIsPresent(String expectedText, long timeout) {
        SeleniumHandlers.textIsPresent(expectedText, timeout);
    }

    @Then("^I? ?check (?:the)? ?text \"([^\"]*)\" is present in the selected element's value with a timeout of (\\d+) seconds$")
    public void textIsPresentInValue(String expectedText, long timeout) {
        SeleniumHandlers.textIsPresentInValue(expectedText, timeout);
    }

    @Then("^I? ?check (?:the)? ?page title is \"([^\"]*)\" with a timeout of (\\d+) seconds$")
    public void checkTitleWithWait(String expectedTitle, long timeout) {
        SeleniumHandlers.checkTitleWithWait(expectedTitle, timeout);
    }

    @Then("^I? ?check (?:the)? ?page title contains \"([^\"]*)\" with a timeout of (\\d+) seconds$")
    public void checkTitleContainsWithWait(String expectedTitlePart, long timeout) {
        SeleniumHandlers.checkTitleContainsWithWait(expectedTitlePart, timeout);
    }
}

package fixture.stepdefs;

import cucumber.api.java.en.When;
import fixture.SeleniumHandlers;

public class Interaction {

    @When("^I? ?(?:left)? ?click (?:the)? ?selected element$")
    public void clickElement() {
        SeleniumHandlers.clickElement();
    }

    @When("^I? ?(?:left)? ?click and clear (?:the)? ?selected element$")
    public void clickElementAndClear() {
        SeleniumHandlers.clickElement();
        SeleniumHandlers.clearSelectedElements();
    }

    @When("^I? ?double click selected element$")
    public void doubleClickElement() {
        SeleniumHandlers.doubleClickElement();
    }

    @When("^I? ?click and hold element$")
    public void clickAndHold() {
        SeleniumHandlers.clickAndHold();
    }

    /**
     * Convenience method - Submit a form if element is contained within a form
     */
    @When("^I? ?submit(?: form)?$")
    public void submit() {
        SeleniumHandlers.submit();
    }

    @When("^I? ?(?:(?:hover over)|(?:move to)) (?:the)? ?selected element$")
    public void hoverElement() {
        SeleniumHandlers.hoverElement();
    }

    @When("^I? ?(?:press|select|click|click on)? ?(?:refresh|reload) ?(?:the)? ?(?:page)?$")
    public void refresh() {
        SeleniumHandlers.refresh();
    }
}

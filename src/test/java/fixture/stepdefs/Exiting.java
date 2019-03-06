package fixture.stepdefs;

import browser.BrowserBase;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import fixture.SeleniumHandlers;

public class Exiting {

    @Then("^I? ?take a? ?screenshot$")
    public void takeScreenshot() {
        BrowserBase.getCurrentBrowser().takeScreenshot();
    }

    @After
    @Then("^I? ?(?:close|quit)(?:(?: the)? browser)?$")
    public void closeBrowser() {
        SeleniumHandlers.closeBrowser();
    }
}

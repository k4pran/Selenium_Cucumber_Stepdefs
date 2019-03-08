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

    @Then("^I? ?(?:close|quit)(?:(?: the)? browser)?$")
    public void closeBrowser() {
        SeleniumHandlers.closeBrowser();
    }

    @After
    @Then("^--AUTO_CLOSE--DO NOT USE$")
    public void autocloseBrowser() {
        SeleniumHandlers.autoCloseBrowser();
    }
}

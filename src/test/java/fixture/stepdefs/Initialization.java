package fixture.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import fixture.SeleniumHandlers;

public class Initialization {

    @Given("^I? ?open (?:the)? ?browser$")
    public void openBrowser() {
        SeleniumHandlers.openBrowser();
    }

    @Given("(?:the)? ?\"([^\"]*)\" browser is open")
    public void openGivenWebBrowser(String browserName) throws Throwable {
        SeleniumHandlers.openGivenWebBrowser(browserName);
    }

    /**
     * Opens a url
     * @param url should be a fully qualified url such as https://www.google.com rather than google.com
     */
    @Given("^I? ?(?:(?:go to)|(?:visit)) (?:the)? ?(?:website|url) \"([^\"]*)\"$")
    public void goToUrl(String url) {
        SeleniumHandlers.goToUrl(url);
    }

    @Given("^(?:the)? ?window is maximized$")
    public void maximizeWindow() {
        SeleniumHandlers.maximizeWindow();
    }

    @Then("^I? ?(?:close|quit)(?:(?: the)? browser)?$")
    public void closeBrowser() {
        SeleniumHandlers.closeBrowser();
    }


    // ALIASES

    @Given("^I (?:choose|select|am using) ?(?:the)? driver \"([^\"]*)\"$")
    public void selectDriver(String driver) throws Throwable {
        openGivenWebBrowser(driver);
    }

    @Given("^I? ?maximize (?:the)? ?window$")
    public void maximizeWindowAlias() {
        maximizeWindow();
    }

    @Given("^I? ?launch (?:the )? ?browser$")
    public void openBrowserAlias() {
        openBrowser();
    }

    @Given("^(?:the)? ?browser (?:is|has been) (?:launched|(?:opened|open))$")
    public void openBrowserAlias2() {
        openBrowser();
    }
}

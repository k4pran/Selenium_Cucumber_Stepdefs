package fixture.stepdefs;

import cucumber.api.java.en.When;
import fixture.SeleniumHandlers;

public class Input {

    @When("^I? ?(?:type|enter|input) (?:the text|text)? ?\"([^\"]*)\"$")
    public void enterText(String text) {
        SeleniumHandlers.enterText(text);
    }

}

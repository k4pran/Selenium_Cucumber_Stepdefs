package fixture.stepdefs;

import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import fixture.SeleniumHandlers;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Input {

    @When("^I? ?(?:type|enter|input) (?:the text|text)? ?\"([^\"]*)\"$")
    public void enterText(String text) {
        SeleniumHandlers.enterText(text);
    }

    /**Keys*/

    @When("^I? ?press enter key$")
    public void iPressEnterKey(){ SeleniumHandlers.pressEnterKey(); }

    @When("^I? press enter$")
    public void iPressEnter() { SeleniumHandlers.pressEnter(); }

    @When("^I? press enter key on dropdown$")
    public void iPressEnterKeyOnDropdown(){ SeleniumHandlers.pressEnterKeyOnDropDown();}

    /**ArrowKeys*/

    @When("^I? press arrow downKey$")
    public void iPressArrowDownKey(){SeleniumHandlers.pressArrowDownKey();}

    @When("^I? press arrow downKey (\\d+) times$")
    public void iPressArrowDownKeyTimes(int times) { SeleniumHandlers.pressArrowDownKeyTimes(times);}

    @When("^I? press arrow upKey$")
    public void iPressArrowUpKey(){SeleniumHandlers.pressArrowUpKey();}

    @When("^I? press arrow upKey (\\d+) times$")
    public void iPressArrowUpKeyTimes(int times) { SeleniumHandlers.pressArrowKeyUpTimes(times);}

    @When("^I? press arrow leftKey$")
    public void iPressArrowLeftKey(){SeleniumHandlers.pressArrowLeftKey();}

    @When("^I? press arrow leftKey (\\d+) times$")
    public void iPressArrowLeftKeyTimes(int times) { SeleniumHandlers.pressArrowLeftKeyTimes(times);}

    @When("^I? press arrow rightKey$")
    public void iPressArrowRightKey(){SeleniumHandlers.pressArrowRightKey();}

    @When("^I? press arrow rightKey (\\d+) times$")
    public void iPressArrowRightKeyTimes(int times) {SeleniumHandlers.pressArrowRightKeyTimes(times);}

    /**ArrowKeys and Enter*/

    @When("^I? press arrow downKey and enter$")
    public void iPressArrowDownKeyAndEnter() { SeleniumHandlers.pressArrowDownKeyAndEnter();}

    @When("^I? press arrow upKey and enter$")
    public void iPressArrowUpKeyAndEnter() {SeleniumHandlers.pressArrowUpKeyAndEnter();}

    @When("^I? press arrow leftKey and enter$")
    public void iPressArrowLeftKeyAndEnter(){SeleniumHandlers.pressArrowLeftKeyAndEnter();}

    @When("^I? press arrow rightKey and enter$")
    public void iPressArrowRightKeyAndEnter(){ SeleniumHandlers.pressArrowRightKeyAndEnter();}

    /**OtherKeys*/

    @When("^I? press backspace$")
    public void iPressBackspace(){SeleniumHandlers.pressBackspace();}

    @When("^I? press backspace (\\d+) times$")
    public void iPressBackspaceTimes(int times) {SeleniumHandlers.pressBackspaceTimes(times);}

    @When("^I? press delete$")
    public void iPressDelete(){SeleniumHandlers.pressDelete();}

    @When("^I? press Ctrl Key$")
    public void iPressCtrlKey(){SeleniumHandlers.pressCtrlKey();}

    @When("^I? press AltKey$")
    public void iPressAltKey(){SeleniumHandlers.pressAltKey();}

    @When("^I? press Shift Key$")
    public void iPressShiftKey(){SeleniumHandlers.pressShiftKey();}

    @When("^I? press Spacebar Key$")
    public void iPressSpacebarKey(){SeleniumHandlers.pressSpacebarKey();}

    @When("^I? press spacebar (\\d+) times$")
    public void iPressSpacebarTimes(int times) {SeleniumHandlers.pressSpacebarTimes(times);}

    @When("^I? press Tab Key$")
    public void iPressTabKey(){SeleniumHandlers.pressTabKey();}

    @When("^I? press tab (\\d+) times$")
    public void iPressTabKeyTimes(int times) {SeleniumHandlers.pressTabKeyTimes(times);}

    @When("^I? press Equals Key$")
    public void iPressEqualsKey(){SeleniumHandlers.pressEqualsKey();}

    @When("^I? press Home Key$")
    public void iPressHomeKey(){SeleniumHandlers.pressHomeKey();}

    @When("^I? press Insert Key$")
    public void iPressInsertKey(){SeleniumHandlers.pressInsertKey();}

    @When("^I? press PageUp Key$")
    public void iPressPageUpKey(){SeleniumHandlers.pressPageUpKey();}

    @When("^I? press arrow PageUp (\\d+) times$")
    public void iPressPageUpTimes(int times) {SeleniumHandlers.pressPageUpTimes(times);}

    @When("^I? press PageDown Key$")
    public void iPressPageDownKey(){SeleniumHandlers.pressPageDownKey();}

    @When("^I? press arrow PageDown (\\d+) times$")
    public void iPressPageDownTimes(int times) {SeleniumHandlers.pressPageDownTimes(times);}

    /**FunctionKeys*/

    @When("^I? press F1 Key$")
    public void iPressF1Key(){SeleniumHandlers.pressF1Key();}

    @When("^I? press F2 Key$")
    public void iPressF2Key(){SeleniumHandlers.pressF2Key();}

    @When("^I? press F3 Key$")
    public void iPressF3Key(){SeleniumHandlers.pressF3Key();}

    @When("^I? press F4 Key$")
    public void iPressF4Key(){SeleniumHandlers.pressF4Key();}

    @When("^I? press F5 Key$")
    public void iPressF5Key(){SeleniumHandlers.pressF5Key();}

    @When("^I? press F6 Key$")
    public void iPressF6Key(){SeleniumHandlers.pressF6Key();}

    @When("^I? press F7 Key$")
    public void iPressF7Key(){SeleniumHandlers.pressF7Key();}

    @When("^I? press F8 Key$")
    public void iPressF8Key(){SeleniumHandlers.pressF8Key();}

    @When("^I? press F9 Key$")
    public void iPressF9Key(){SeleniumHandlers.pressF9Key();}

    @When("^I? press F10 Key$")
    public void iPressF10Key(){SeleniumHandlers.pressF10Key();}

    @When("^I? press F11 Key$")
    public void iPressF11Key(){SeleniumHandlers.pressF11Key();}

    @When("^I? press F12 Key$")
    public void iPressF12Key(){SeleniumHandlers.pressF12Key();}

    /**End of sendKeys*/
}

package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        strict = true,
        monochrome = true,
        features="features",
        glue={"fixture.stepdefs"})
public class Runner {
}

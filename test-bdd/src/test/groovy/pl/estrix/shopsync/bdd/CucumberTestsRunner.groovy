package pl.estrix.shopsync.bdd

import cucumber.api.CucumberOptions
import net.serenitybdd.cucumber.CucumberWithSerenity
import org.junit.runner.RunWith

@CucumberOptions(
        glue = ["src/test/groovy/pl/estrix/shopsync/bdd/steps"],
        features = ["src/test/resources/features"],
        plugin = ["pretty", "html:target/cucumber-reports"],
        monochrome = true,
        strict = true
)
@RunWith(CucumberWithSerenity.class)
class CucumberTestsRunner {
}
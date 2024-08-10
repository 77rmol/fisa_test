package co.com.test.certification.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "co.com.test.certification.stepdefinitions",
        tags = "@test",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class MainRunner {

}

package co.com.test.certification.stepdefinitions;

import co.com.test.certification.tasks.MelodieTask;
import co.com.test.certification.utils.MelodiesKeys;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.thucydides.core.annotations.Managed;

import net.thucydides.core.util.EnvironmentVariables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.openqa.selenium.WebDriver;


import java.util.List;

public class TestStepDefinitions {

    @CastMember(name = "Tester")
    Actor tester;

    @Managed
    private WebDriver hisBrowser;
    private static final Logger LOGGER = LogManager.getLogger(TestStepDefinitions.class);
    public static EnvironmentVariables environmentVariables;
    static String url;

    @Before()
    public void jamesCanBrowseTheWeb() {
        url = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("base.url");
        tester.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("i want to play a song")
    public void playSong(){
        tester.has(Open.url(url));
    }

    @When("i send the {string}")
    public void sendMelodie(String melodie){
        LOGGER.info("try to play a song in the piano");
        List<Character> melodieKeys = MelodiesKeys.convertNotesToKeys(melodie);
        tester.attemptsTo(MelodieTask.play(melodieKeys));

    }

    @Then("i can ear the melodie")
    public void earMelodie(){
        LOGGER.info("i ear a song played");
        System.out.println();
    }

    @After
    public void jamesCloseDriver(){
        hisBrowser.quit();
    }


}

package co.com.test.certification.stepdefinitions;

import co.com.test.certification.tasks.MelodieTask;
import co.com.test.certification.utils.MelodiesKeys;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class TestStepDefinitions {

    @CastMember(name = "Tester")
    Actor tester;

    @Managed
    private WebDriver hisBrowser;

    @BeforeEach
    public void jamesCanBrowseTheWeb() {
        tester.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("i want to play a song")
    public void playSong(){
        tester.has(Open.url("https://www.musicca.com/es/piano"));
    }

    @When("i send the {string}")
    public void sendMelodie(String melodie){
        List<Character> melodieKeys = MelodiesKeys.convertNotesToKeys(melodie);
        //tester.attemptsTo(MelodieTask2.play(List.of('q', 'w', 'e', 'r')));
        tester.attemptsTo(MelodieTask.play(melodieKeys));
//        tester.attemptsTo(MelodieTask.play(melodieKeys));
    }

    @Then("i can ear the melodie")
    public void earMelodie(){
        System.out.println();
    }



}

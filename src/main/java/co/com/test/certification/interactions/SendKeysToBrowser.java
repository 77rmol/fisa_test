package co.com.test.certification.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SendKeysToBrowser implements Performable {
    private final Character key;

    public SendKeysToBrowser(Character key) {
        this.key = key;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = Serenity.getDriver();
        new Actions(driver).sendKeys(Keys.chord(key.toString())).perform();
        manualWait(500);
    }

    public static SendKeysToBrowser using(Character key) {
        return new SendKeysToBrowser(key);
    }

    private void manualWait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

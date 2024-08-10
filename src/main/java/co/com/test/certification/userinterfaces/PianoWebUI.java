package co.com.test.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PianoWebUI {

    public static final By DO = By.cssSelector("#piano > div > ul > li:nth-child(8) > span");
    public static final By RE = By.cssSelector("#piano > div > ul > li:nth-child(9) > span");
    public static final By MI = By.cssSelector("#piano > div > ul > li:nth-child(10) > span");
    public static final By FA = By.cssSelector("#piano > div > ul > li:nth-child(11) > span");
    public static final By SOL = By.cssSelector("#piano > div > ul > li:nth-child(12) > span");
    public static final By LA = By.cssSelector("#piano > div > ul > li:nth-child(13) > span");
    public static final By SI = By.cssSelector("#piano > div > ul > li:nth-child(14) > span");
}

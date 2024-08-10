package co.com.test.certification.tasks;

import co.com.test.certification.interactions.SendKeysToBrowser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

import java.util.List;

public class MelodieTask implements Performable {

    private final List<Character> keys;

    @Override
    public <T extends Actor> void performAs(T actor) {

        manualWait(5000);
        keys.forEach(x -> {
           actor.attemptsTo(
                   SendKeysToBrowser.using(x)
           );
        });

    }

    private MelodieTask(List<Character> keys) {
        this.keys = keys;
    }

    public static MelodieTask play(List<Character> keys) {
        return new MelodieTask(keys);
    }

    private void manualWait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

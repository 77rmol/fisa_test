package co.com.test.certification.utils;

import co.com.test.certification.exceptions.InvalidNoteException;
import co.com.test.certification.userinterfaces.PianoWebUI;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MelodiesKeys {

    private static  Map<String, Character>  mapperKeys(){
        Map<String, Character> notes = new HashMap<>();
        notes.put("do", 't');
        notes.put("re", 'y');
        notes.put("mi", 'u');
        notes.put("fa", 'q');
        notes.put("sol",'w');
        notes.put("la", 'e');
        notes.put("si", 'r');
        return notes;
    }

    public static List<Character> convertNotesToKeys(String notes) {
        notes= notes.trim();
        String[] arrayNotes = notes.split(",");
        List <Character> finalMelodie = new ArrayList<>();

        Map<String, Character> equivalence = mapperKeys();
        for (String nota : arrayNotes) {
            String key = nota.trim().toLowerCase();
            if (!equivalence.containsKey(key))
                throw new InvalidNoteException(key);
            finalMelodie.add(equivalence.get(key));
        }
        return finalMelodie;
    }

}


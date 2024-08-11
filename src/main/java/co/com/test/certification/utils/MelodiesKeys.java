package co.com.test.certification.utils;

import co.com.test.certification.exceptions.InvalidNoteException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static co.com.test.certification.models.NotesMelodiesModel.mapperKeys;

public class MelodiesKeys {

    public static List<Character> convertNotesToKeys(String notes) {
        notes = notes.trim();
        String[] arrayNotes = notes.split(",");
        List<Character> finalMelodie = new ArrayList<>();

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


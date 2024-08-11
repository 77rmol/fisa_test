package co.com.test.certification.models;

import java.util.HashMap;
import java.util.Map;

public class NotesMelodiesModel {

    public static Map<String, Character> mapperKeys(){
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

}

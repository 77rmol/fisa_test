package co.com.test.certification.exceptions;

public class InvalidNoteException extends RuntimeException {
    public InvalidNoteException(String note) {
        super("La nota '" + note + "' no existe.");
    }

}

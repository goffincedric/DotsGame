package be.kdg.Dots.Model;

/**
 * Dit is een specifieke exception die momenteel gebruikt wordt in model om een fout weer te geven.
 *
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 5/02/2017 14:55
 */
public class DotsException extends Exception {
    public DotsException() {

    }

    public DotsException(String message) {
        super(message);
    }

    public DotsException(String message, Throwable cause) {
        super(message, cause);
    }
}

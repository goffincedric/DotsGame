package be.kdg.Dots.Model;

/**
 * @author Cédric Goffin
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

package be.kdg.DotsConsole;

/**
 * @author Cédric Goffin
 * @version 1.0 16/02/2017 10:25
 */
public class DotsConsoleException extends Exception {
    public DotsConsoleException() {

    }

    public DotsConsoleException(String message) {
        super(message);
    }

    public DotsConsoleException(String message, Throwable cause) {
        super(message, cause);
    }
}

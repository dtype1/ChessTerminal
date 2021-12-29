package exceptions;

/**
 * This class extends "RuntimeException" to be able to create custom error messages.
 */
public class GenericException extends RuntimeException {
    public GenericException(String msg) {
        super(msg);
    }
}

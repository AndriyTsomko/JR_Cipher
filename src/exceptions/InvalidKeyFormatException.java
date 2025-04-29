package exceptions;

public class InvalidKeyFormatException extends RuntimeException {
    public InvalidKeyFormatException(String message) {
        super(message);
    }
}

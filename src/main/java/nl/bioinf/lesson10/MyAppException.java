package nl.bioinf.lesson10;

public class MyAppException extends RuntimeException {
    public MyAppException(String message) {
        super(message);
    }

    public MyAppException(String message, Throwable cause) {
        super(message, cause);
    }
}

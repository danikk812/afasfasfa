package lab3.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Exception e) {
        super(e);
    }

    public UserNotFoundException(String message, Exception e) {
        super(message, e);
    }
}

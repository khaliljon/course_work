package kstu.fit.sib.kalandarov.autobase.entities.exceptions;

public class RemoveCarException extends Exception{
    public RemoveCarException() {
        super();
    }

    public RemoveCarException(String message) {
        super(message);
    }

    public RemoveCarException(String message, Throwable cause) {
        super(message, cause);
    }

    public RemoveCarException(Throwable cause) {
        super(cause);
    }
}

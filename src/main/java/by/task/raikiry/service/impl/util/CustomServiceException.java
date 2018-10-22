package by.task.raikiry.service.impl.util;

/**
 * Raikiry exception
 */
public class CustomServiceException extends Exception{
    private static final long serialVersionUID = -7909871550893750979L;

    public CustomServiceException() {
        super();
    }

    public CustomServiceException(String message) {
        super(message);
    }

    public CustomServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomServiceException(Throwable cause) {
        super(cause);
    }
}

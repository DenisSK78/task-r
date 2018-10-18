package by.task.raikiry.service.impl.util;

/**
 * Raikiry exception
 */
public class CastomException extends Exception{
    private static final long serialVersionUID = -7909871550893750979L;

    public CastomException() {
        super();
    }

    public CastomException(String message) {
        super(message);
    }

    public CastomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CastomException(Throwable cause) {
        super(cause);
    }
}

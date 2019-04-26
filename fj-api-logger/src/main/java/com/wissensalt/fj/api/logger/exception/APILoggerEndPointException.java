package com.wissensalt.fj.api.logger.exception;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class APILoggerEndPointException extends Exception {
    /**
     *
     *
     */
    private static final long serialVersionUID = 149835854690073083L;

    public APILoggerEndPointException(String message) {
        super(message);
    }

    public APILoggerEndPointException(String message, Throwable cause) {
        super(message, cause);
    }
}

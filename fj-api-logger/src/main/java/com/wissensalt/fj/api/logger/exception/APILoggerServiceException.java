package com.wissensalt.fj.api.logger.exception;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class APILoggerServiceException extends Exception {
    /**
     *
     *
     */
    private static final long serialVersionUID = 6010628684293271354L;

    public APILoggerServiceException(String message) {
        super(message);
    }

    public APILoggerServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

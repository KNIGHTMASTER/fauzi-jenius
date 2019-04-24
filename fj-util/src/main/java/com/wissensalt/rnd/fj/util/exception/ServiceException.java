package com.wissensalt.rnd.fj.util.exception;

/**
 * Created on 11/2/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ServiceException extends Exception {
    /**
     *
     *
     */
    private static final long serialVersionUID = 8024895122045859786L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

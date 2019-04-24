package com.wissensalt.rnd.fj.util.exception;

/**
 * Created on 11/2/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class EndPointException extends Exception {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7697643370872599673L;

    public EndPointException(String message) {
        super(message);
    }

    public EndPointException(String message, Throwable cause) {
        super(message, cause);
    }
}

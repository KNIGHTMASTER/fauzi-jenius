package com.wissensalt.rnd.fj.util.exception;

/**
 * Created on 11/2/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DAOException extends Exception {
    /**
     *
     *
     */
    private static final long serialVersionUID = -2031181605742564468L;

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}

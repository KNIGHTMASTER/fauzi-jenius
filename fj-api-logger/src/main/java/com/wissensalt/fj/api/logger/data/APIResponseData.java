package com.wissensalt.fj.api.logger.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Getter
@Setter
public class APIResponseData implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7992314610409878305L;
    private String host;
    private String body;
}

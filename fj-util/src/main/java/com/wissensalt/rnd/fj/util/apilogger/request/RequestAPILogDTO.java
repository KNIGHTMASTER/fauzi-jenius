package com.wissensalt.rnd.fj.util.apilogger.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Getter
@Setter
public class RequestAPILogDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -2029528692465582941L;

    private Date timeStamp;
    private String serviceName;
    private ContentAPIRequestData requestData;
    private ContentAPIResponseData responseData;
}

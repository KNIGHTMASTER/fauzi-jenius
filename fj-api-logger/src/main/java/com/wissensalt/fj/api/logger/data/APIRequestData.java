package com.wissensalt.fj.api.logger.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Getter
@Setter
public class APIRequestData implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 637935412738517898L;
    private String remoteAddress;
    private int remotePort;
    private String remoteUser;
    private String userAgent;
    private String method;
    private String requestUrl;
    private List<String> headers;
    private List<String> cookies;
    private String payload;
}

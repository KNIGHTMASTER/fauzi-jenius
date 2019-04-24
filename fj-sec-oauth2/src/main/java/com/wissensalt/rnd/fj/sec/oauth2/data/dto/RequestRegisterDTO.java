package com.wissensalt.rnd.fj.sec.oauth2.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created on 4/25/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Getter
@Setter
public class RequestRegisterDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 4290004433287050108L;
    private String userName;
    private String password;
}

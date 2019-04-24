package com.wissensalt.rnd.fj.account.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created on 4/24/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Getter
@Setter
public class RequestUserDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8653143376226834736L;
    private String password;
}

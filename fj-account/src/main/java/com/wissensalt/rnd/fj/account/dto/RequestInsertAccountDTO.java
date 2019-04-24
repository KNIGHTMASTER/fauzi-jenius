package com.wissensalt.rnd.fj.account.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created on 4/24/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Getter
@Setter
public class RequestInsertAccountDTO extends RequestUserDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1500823624355721991L;

    private String userName;
    private String accountNumber;
    private String emailAddress;
    private String identityNumber;
}

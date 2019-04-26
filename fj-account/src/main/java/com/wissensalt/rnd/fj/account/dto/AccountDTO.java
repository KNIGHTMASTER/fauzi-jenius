package com.wissensalt.rnd.fj.account.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created on 4/26/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Getter
@Setter
public class AccountDTO implements Serializable{

    private static final long serialVersionUID = -6341170925150339171L;

    private String userName;
    private String accountNumber;
    private String emailAddress;
    private String identityNumber;
}

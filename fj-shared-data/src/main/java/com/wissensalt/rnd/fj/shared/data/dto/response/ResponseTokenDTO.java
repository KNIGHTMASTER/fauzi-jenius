package com.wissensalt.rnd.fj.shared.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created on 5/14/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTokenDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6423810795240924661L;

    private String accessToken;
    private ResponseData responseData;
}

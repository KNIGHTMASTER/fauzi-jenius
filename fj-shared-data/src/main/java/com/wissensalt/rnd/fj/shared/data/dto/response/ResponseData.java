package com.wissensalt.rnd.fj.shared.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created on 4/24/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7214475693280308245L;

    private String responseCode;
    private String responseMsg;
}
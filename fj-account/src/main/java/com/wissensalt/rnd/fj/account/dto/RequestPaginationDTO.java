package com.wissensalt.rnd.fj.account.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class RequestPaginationDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5133361991658181371L;

    @JsonProperty("offset")
    private Integer offset;

    @JsonProperty("limit")
    private Integer limit;

    @JsonProperty("order")
    private String order;

    @JsonProperty("sort")
    private String sort;
}

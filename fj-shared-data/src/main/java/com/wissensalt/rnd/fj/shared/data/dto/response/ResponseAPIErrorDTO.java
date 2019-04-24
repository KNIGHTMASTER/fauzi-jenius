package com.wissensalt.rnd.fj.shared.data.dto.response;

import lombok.*;

import java.util.Date;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAPIErrorDTO {
    private Date timestamp;
    private Integer status;
    private String exception;
    private String message;
    private String path;
    private String error;
}

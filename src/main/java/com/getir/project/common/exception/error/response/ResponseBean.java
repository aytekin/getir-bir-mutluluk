package com.getir.project.common.exception.error.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean {
    private Integer code;
    private String message;
    private long timeStamp = System.currentTimeMillis();



    public ResponseBean(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

}
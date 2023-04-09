package com.getir.project.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum JwtTokenType {
    BEARER("BEARER");

    private String name;


}

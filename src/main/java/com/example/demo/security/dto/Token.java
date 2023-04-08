package com.example.demo.security.dto;

import com.example.demo.common.enums.JwtTokenType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    private String token;
    private Date expires;
    private JwtTokenType type;
}

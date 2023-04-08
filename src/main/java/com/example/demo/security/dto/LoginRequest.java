package com.example.demo.security.dto;

import com.example.demo.common.constants.RegexConstants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class LoginRequest {

    @NotBlank(message = "username is must not be null")
    @Pattern(regexp = RegexConstants.USERNAME,
            message = "invalid username format")
    private String username;

    @NotBlank(message = "password is must not be null")
    @Pattern(regexp = RegexConstants.PASSWORD,
            message = "password must be min 8 character and at least one letter and one number")
    private String password;
}

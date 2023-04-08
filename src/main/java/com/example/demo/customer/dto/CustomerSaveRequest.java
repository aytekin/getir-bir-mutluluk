package com.example.demo.customer.dto;


import com.example.demo.common.constants.RegexConstants;
import com.example.demo.common.utils.PasswordEncryptConverter;
import com.example.demo.common.utils.ToLowerCaseConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CustomerSaveRequest {
    @NotNull(message = "Firstname cannot be null")
    @Pattern(regexp = RegexConstants.FIRST_NAME, message = "Firstname can contains only alphabet characters")
    @Size(min = 1, max = 32, message = "Firstname length should be in between 1-32")
    private String name;

    @NotNull(message = "Lastname cannot be null")
    @Pattern(regexp = RegexConstants.ONLY_ALPHABET, message = "Lastname can contains only alphabet characters")
    @Size(min = 1, max = 32, message = "Lastname length should be in between 1-32")
    private String lastname;

    @NotBlank
    @Pattern(regexp = RegexConstants.USERNAME, message = "Username can contains only Alphanumeric and _. characters")
    private String username;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 32 , message = "Password length should be in between 8-32")
    @Pattern(regexp = RegexConstants.PASSWORD, message = "Password must contains at least a uppercase, at least a lowercase and at least a number characters")
    private String password;

    @NotBlank(message = "Email cannot be blank")
    @Pattern(regexp = RegexConstants.EMAIL, message = "Email format incorrect")
    @JsonDeserialize(converter = ToLowerCaseConverter.class)
    private String email;

}

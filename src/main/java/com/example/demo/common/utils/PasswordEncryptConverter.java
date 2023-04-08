package com.example.demo.common.utils;

import com.fasterxml.jackson.databind.util.StdConverter;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@AllArgsConstructor
public class PasswordEncryptConverter  extends StdConverter<String, String> {
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String convert(String value) {
        return bCryptPasswordEncoder.encode(value);
    }

}

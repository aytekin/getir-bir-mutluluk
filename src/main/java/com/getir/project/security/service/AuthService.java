package com.getir.project.security.service;

import com.getir.project.security.dto.LoginRequest;
import com.getir.project.security.dto.LoginResponse;
import com.getir.project.security.dto.Token;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AuthService {
    private AuthenticationManager authenticationManager;
    private JwtProvider jwtProvider;

    public LoginResponse login (LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        Token tokenResponse = jwtProvider.createToken(request.getUsername());
        return LoginResponse.builder()
                .accessToken(tokenResponse.getToken())
                .tokenType(tokenResponse.getType().getName())
                .expires(tokenResponse.getExpires())
                .build();
    }
}

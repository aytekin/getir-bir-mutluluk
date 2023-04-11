package com.getir.project.integration;

import com.getir.project.CaseApplication;
import com.getir.project.security.dto.LoginResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CaseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthControllerIntegrationTest {


    @LocalServerPort
    private int port;


    @Test
    void testLogin() throws JSONException, URISyntaxException {
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject parameters = new JSONObject();

        // please change to the credentials before the run test
        parameters.put("username", "Garett46");
        parameters.put("password", "Getir...123");

        RequestEntity requestEntity = new RequestEntity(parameters.toString(), headers,
                HttpMethod.POST, new URI(createURLWithPort("/api/auth/login")));

        ResponseEntity<LoginResponse> response =
                restTemplate.exchange(requestEntity, new ParameterizedTypeReference<>() {
                });

        assertNotNull(Objects.requireNonNull(response.getBody()).getAccessToken());
    }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}

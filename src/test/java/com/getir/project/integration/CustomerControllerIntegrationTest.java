package com.getir.project.integration;

import com.getir.project.CaseApplication;
import com.getir.project.customer.dto.CustomerSaveRequest;
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
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CaseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Test
    void testCustomerSave() throws URISyntaxException {
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        RequestEntity requestEntity = new RequestEntity(buildCustomerSaveRequest(), headers, HttpMethod.POST, new URI(createURLWithPort("/api/customer/save")));

        ResponseEntity<CustomerSaveRequest> response = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<>() {});

        assertNotNull(Objects.requireNonNull(response.getBody()).getEmail());
    }

    private CustomerSaveRequest buildCustomerSaveRequest() {
        return CustomerSaveRequest.builder()
                .name("getir")
                .lastname("birmutluluk")
                .username(UUID.randomUUID().toString())
                .password("Getir...123")
                .email(UUID.randomUUID() + "@getir.com").build();
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}

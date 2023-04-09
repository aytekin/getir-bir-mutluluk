package com.getir.project.customer.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class CustomerResponse {

    private String name;

    private String lastname;

    private String username;

    private String email;
}

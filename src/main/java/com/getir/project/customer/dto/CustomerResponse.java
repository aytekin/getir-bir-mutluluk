package com.getir.project.customer.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

    private String name;

    private String lastname;

    private String username;

    private String email;
}

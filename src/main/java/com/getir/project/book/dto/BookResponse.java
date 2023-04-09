package com.getir.project.book.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class BookResponse {
    private String name;

    private Double price;

    private Long stock;
}

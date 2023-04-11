package com.getir.project.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private String name;

    private Double price;

    private Long stock;
}

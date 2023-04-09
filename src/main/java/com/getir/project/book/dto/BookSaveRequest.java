package com.getir.project.book.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class BookSaveRequest {
    @Size(min = 3, max = 32, message = "Name length must be in between 3-32 characters")
    @NotBlank(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Price must not be null")
    private Double price;

    @NotNull(message = "Total price must not be null")
    @Max(value = Long.MAX_VALUE, message = "Total price cannot exceed the max value")
    private Long stock;

}

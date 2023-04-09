package com.example.demo.book;

import com.example.demo.common.entity.BaseEntityId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

@Getter
@Setter
@Entity
@Table(name = "t_book")
public class Book extends BaseEntityId {
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "stock")
    private Long stock;

}

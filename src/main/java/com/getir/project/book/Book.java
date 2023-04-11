package com.getir.project.book;

import com.getir.project.common.entity.BaseEntityId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_book")
public class Book extends BaseEntityId {
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "stock")
    private Long stock;

}

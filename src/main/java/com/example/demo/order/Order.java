package com.example.demo.order;

import com.example.demo.common.entity.BaseEntityId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "t_order")
public class Order extends BaseEntityId {
}

package com.example.demo.statistic;

import com.example.demo.common.entity.BaseEntityId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "t_statistic")
public class Statistic extends BaseEntityId {
}

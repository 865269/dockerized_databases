package com.matthew.dockerized_databases.item;

import lombok.Data;

import java.math.BigDecimal;

@Data
//@Entity
public class Item {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
}

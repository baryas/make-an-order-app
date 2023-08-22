package com.message.app.dto;

import lombok.Data;

@Data
public class Order {

    private int id ;

    private String name;

    private String description;

    private String price;
}

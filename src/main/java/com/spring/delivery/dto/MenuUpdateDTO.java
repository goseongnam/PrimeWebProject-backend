package com.spring.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MenuUpdateDTO {
    private String name;
    private String updatedName;
    private int price;
    private String description;
}

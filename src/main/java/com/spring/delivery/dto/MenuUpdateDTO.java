package com.spring.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuUpdateDTO {
    private String name;
    private String updatedName;
    private int price;
    private String description;
}

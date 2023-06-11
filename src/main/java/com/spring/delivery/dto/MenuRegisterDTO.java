package com.spring.delivery.dto;

import com.spring.delivery.domain.MenuType;
import com.spring.delivery.domain.Store;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MenuRegisterDTO {
    private String name;
    private MenuType menuType;
    private int price;
    private String description;
    private String imageName;
    private Long storeId;
}

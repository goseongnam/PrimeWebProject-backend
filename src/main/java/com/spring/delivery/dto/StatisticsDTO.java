package com.spring.delivery.dto;

import com.spring.delivery.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsDTO {
    private Long id;
    private int count;
    private Menu menu;
}

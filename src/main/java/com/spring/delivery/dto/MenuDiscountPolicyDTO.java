package com.spring.delivery.dto;

import com.spring.delivery.domain.DiscountPolicy;
import lombok.Data;

@Data
public class MenuDiscountPolicyDTO {
    private String name;
    private DiscountPolicy discountPolicy;
}

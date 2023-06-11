package com.spring.delivery.service;

import com.spring.delivery.domain.DiscountPolicy;
import com.spring.delivery.domain.MenuType;
import com.spring.delivery.dto.MenuDiscountPolicyDTO;
import com.spring.delivery.dto.MenuRegisterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MenuServiceTest {
    @Autowired
    MenuService menuService;

    @Test
    void applyMenuPolicy() {
        MenuRegisterDTO menuRegisterDTO = new MenuRegisterDTO("마라싸이버거", MenuType.MAIN.toString(), 7000, "이 햄버거는 무척 맛있다",
                "image001", 15L);
        menuService.create(menuRegisterDTO);
        MenuDiscountPolicyDTO menuDiscountPolicyDTO = new MenuDiscountPolicyDTO("마라싸이버거", DiscountPolicy.PERCENTAGE.toString());
        Long menuId = menuService.applyMenuPolicy(menuDiscountPolicyDTO);

        assertThat(menuRegisterDTO.getName())
                .as("수정 된 버거랑 이름이 같아야함")
                .isEqualTo(menuService.findMenuInfo(menuId).getName());
    }
}
package com.spring.delivery.controller;

import com.spring.delivery.domain.MenuType;
import com.spring.delivery.dto.MenuRegisterDTO;
import com.spring.delivery.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(MenuController.class)
class MenuControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    MenuService menuService;

    @Autowired
    private MenuController menuController;

    @Test
    void registerMenu() {
        MenuRegisterDTO menuRegisterDTO = new MenuRegisterDTO("싸이플렉스버거", MenuType.MAIN, 7000, "이 햄버거는 무척 맛있다",
                "image001", 15L);
        menuController.registerMenu(menuRegisterDTO);
    }

    @Test
    void findAllMenu() {
    }

    @Test
    void findMenuInfo() {
    }

    @Test
    void updateMenu() {
    }

    @Test
    void findAllDiscountPolicy() {
    }

    @Test
    void applyMenuPolicy() {
    }

    @Test
    void findStatistics() {
    }
}
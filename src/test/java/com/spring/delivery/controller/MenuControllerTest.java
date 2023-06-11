package com.spring.delivery.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.delivery.domain.MenuType;
import com.spring.delivery.dto.MenuRegisterDTO;
import com.spring.delivery.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MenuController.class)
class MenuControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    MenuService menuService;

    @Test
    void registerMenu() throws Exception {
        MenuRegisterDTO menuRegisterDTO = new MenuRegisterDTO("싸이플렉스버거", MenuType.MAIN.toString().toLowerCase(), 7000, "이 햄버거는 무척 맛있다",
                "image001", 15L);
        given(menuService.create(menuRegisterDTO)).willReturn(1L);
        String content = new ObjectMapper().writeValueAsString(menuRegisterDTO);

        mockMvc.perform(
                post("/api/menu/create")
                        .header("Authorization", "Bearer ")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
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
//        given(menuService)
    }

    @Test
    void findStatistics() {
    }
}
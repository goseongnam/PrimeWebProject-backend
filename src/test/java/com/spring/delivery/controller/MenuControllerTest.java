package com.spring.delivery.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.delivery.domain.MenuType;
import com.spring.delivery.dto.MenuDiscountPolicyDTO;
import com.spring.delivery.dto.MenuRegisterDTO;
import com.spring.delivery.dto.MenuUpdateDTO;
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
        MenuRegisterDTO menuRegisterDTO = new MenuRegisterDTO(
                "싸이플렉스버거",
                MenuType.MAIN.toString().toLowerCase(),
                7000,
                "이 햄버거는 무척 맛있다",
                "image001",
                1L
        );
        given(menuService.create(menuRegisterDTO)).willReturn(3L);
        String content = new ObjectMapper().writeValueAsString(menuRegisterDTO);
        String accessToken = "";

        mockMvc.perform(
                post("/api/menu/create")
                        .header("Authorization", "Bearer " + accessToken)
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    void updateMenu() throws Exception {
        MenuUpdateDTO menuUpdateDTO = new MenuUpdateDTO(
                "싸이플렉스버거",
                "싸이플렉스버거",
                8000,
                "이 햄버거는 무척 맛있다 하지만 비싸다"
        );
        given(menuService.updateMenu(menuUpdateDTO)).willReturn(3L);
        String content = new ObjectMapper().writeValueAsString(menuUpdateDTO);
        String accessToken = "";

        mockMvc.perform(
                        post("/api/menu/update")
                                .header("Authorization", "Bearer " + accessToken)
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    void applyMenuPolicy() throws Exception {
        MenuDiscountPolicyDTO menuDiscountPolicyDTO = new MenuDiscountPolicyDTO(
                "싸이플렉스버거",
                "percentage"
        );
        given(menuService.applyMenuPolicy(menuDiscountPolicyDTO)).willReturn(3L);
        String content = new ObjectMapper().writeValueAsString(menuDiscountPolicyDTO);
        String accessToken = "";

        mockMvc.perform(
                post("/api/menu/discount/apply")
                        .header("Authorization", "Bearer " + accessToken)
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }
}
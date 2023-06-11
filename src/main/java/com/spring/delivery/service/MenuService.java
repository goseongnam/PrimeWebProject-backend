package com.spring.delivery.service;

import com.spring.delivery.domain.*;
import com.spring.delivery.dto.MenuDiscountPolicyDTO;
import com.spring.delivery.dto.MenuInfoDTO;
import com.spring.delivery.dto.MenuRegisterDTO;
import com.spring.delivery.dto.MenuUpdateDTO;
import com.spring.delivery.repository.MenuRepository;
import com.spring.delivery.repository.StatisticsRepository;
import com.spring.delivery.repository.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final StoreRepository storeRepository;
    private final StatisticsRepository statisticsRepository;


    public void create(MenuRegisterDTO menuRegisterDTO){

        Store store = storeRepository.findOneById(menuRegisterDTO.getStoreId());

        Menu menu = new Menu(menuRegisterDTO.getName(), menuRegisterDTO.getMenuType(), DiscountPolicy.DEFAULT,
                menuRegisterDTO.getPrice(), menuRegisterDTO.getDescription(), menuRegisterDTO.getImageName(),
                store);

        validateDuplicateMenu(menu);
        menuRepository.save(menu);
    }
    private void validateDuplicateMenu(Menu menu){
        List<Menu> findMenus = menuRepository.findByName(menu.getName());
        if(!findMenus.isEmpty()){
            throw new IllegalStateException("이미 등록되어 있는 햄버거입니다");
        }
    }
    public List<MenuInfoDTO> findAllMenus() {
        List<Menu> menus = menuRepository.findAll();
        List<MenuInfoDTO> menuInfoDTOList = new ArrayList<>();
        menus.forEach(menu -> {
            MenuInfoDTO menuInfoDTO = new MenuInfoDTO();
            menuInfoDTO.builder()
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .description(menu.getDescription())
                    .menuType(menu.getMenuType())
                    .discountPolicy(menu.getDiscountPolicy())
                    .imageName(menu.getImageName())
                    .build();
            menuInfoDTOList.add(menuInfoDTO);
        });
        return menuInfoDTOList;
    }

    public Menu findMenuInfo(Long menuId) {
        return menuRepository.findOneById(menuId);
    }

    public String updateMenu(MenuUpdateDTO menuUpdateDTO) {
        List<Menu> findUpdateMenu = menuRepository.findByName(menuUpdateDTO.getName());
        Menu menu = new Menu(findUpdateMenu.get(0).getName(), findUpdateMenu.get(0).getMenuType(), findUpdateMenu.get(0).getDiscountPolicy(),
                findUpdateMenu.get(0).getPrice(), findUpdateMenu.get(0).getDescription(), findUpdateMenu.get(0).getImageName(),
                findUpdateMenu.get(0).getStore(), findUpdateMenu.get(0).getStatistics(), findUpdateMenu.get(0).getOrderItem());
        if(!menuUpdateDTO.getUpdatedName().isEmpty()) {
            menu.setName(menuUpdateDTO.getUpdatedName());
        }
        Integer tmp = menuUpdateDTO.getPrice();
        if(tmp != null) {
            menu.setPrice(menuUpdateDTO.getPrice());
        }
        if(!menuUpdateDTO.getDescription().isEmpty()) {
            menu.setDescription(menuUpdateDTO.getDescription());
        }
        menuRepository.save(menu);
        return menu.getName();
    }

    public void findAllDiscountPolicy() {
        //findMenuInfo로 재활용
    }

    public void applyMenuPolicy(MenuDiscountPolicyDTO menuDiscountPolicyDTO) {
        List<Menu> findUpdateMenu = menuRepository.findByName(menuDiscountPolicyDTO.getName());
        Menu menu = new Menu(findUpdateMenu.get(0).getName(), findUpdateMenu.get(0).getMenuType(), findUpdateMenu.get(0).getDiscountPolicy(),
                findUpdateMenu.get(0).getPrice(), findUpdateMenu.get(0).getDescription(), findUpdateMenu.get(0).getImageName(),
                findUpdateMenu.get(0).getStore(), findUpdateMenu.get(0).getStatistics(), findUpdateMenu.get(0).getOrderItem());
        menu.setDiscountPolicy(menuDiscountPolicyDTO.getDiscountPolicy());
        menuRepository.save(menu);
    }

    public List<Statistics> findStatistics() {
        return statisticsRepository.findAll();
    }
}

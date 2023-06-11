package com.spring.delivery;

import com.spring.delivery.controller.MenuController;
import com.spring.delivery.domain.Menu;
import com.spring.delivery.domain.MenuType;
import com.spring.delivery.domain.Statistics;
import com.spring.delivery.dto.MenuRegisterDTO;
import jdk.dynalink.beans.StaticClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class DeliveryApplicationTests {

	@Autowired
	private MenuController menuController;
	@Test
	public void 메뉴등록() throws Exception{


		MenuRegisterDTO menuRegisterDTO = new MenuRegisterDTO("싸이플렉스버거", MenuType.MAIN, 7000, "이 햄버거는 무척 맛있다",
				"image001", 15L);
		menuController.registerMenu(menuRegisterDTO);
	}


}

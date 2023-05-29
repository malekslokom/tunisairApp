package com.tunisair.service;

import com.tunisair.models.Menu;
import com.tunisair.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    // Implement service methods for Menu class
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(Long numeroVol, Long idRestauration) {
        return menuRepository.findById(numeroVol).orElse(null);
    }

    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public void deleteMenuById(Long numeroVol, Long idRestauration) {
        menuRepository.deleteByNumeroVolAndIdRestauration(numeroVol, idRestauration);
    }
}

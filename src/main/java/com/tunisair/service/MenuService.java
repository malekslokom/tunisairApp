package com.tunisair.service;

import com.tunisair.models.Menu;
import com.tunisair.repositories.MenuRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu getMenu(Long numeroVol, Long idRestauration) throws NotFoundException {
        return menuRepository.findById(numeroVol)
                .filter(menu -> menu.getIdRestauration().equals(idRestauration))
                .orElseThrow(() -> new NotFoundException("Menu not found with numeroVol: " + numeroVol +
                        " and idRestauration: " + idRestauration));
    }

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Long numeroVol, Long idRestauration, Menu menu) throws NotFoundException {
        Menu existingMenu = getMenu(numeroVol, idRestauration);

        // Update attributes of existingMenu with the new values from menu
        existingMenu.setMenuItems(menu.getMenuItems());

        return menuRepository.save(existingMenu);
    }

    public void deleteMenu(Long numeroVol, Long idRestauration) throws NotFoundException {
        Menu existingMenu = getMenu(numeroVol, idRestauration);
        menuRepository.delete(existingMenu);
    }
}

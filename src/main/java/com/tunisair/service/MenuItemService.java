package com.tunisair.service;

import com.tunisair.models.Menu;
import com.tunisair.models.MenuId;
import com.tunisair.models.MenuItem;
import com.tunisair.repositories.MenuItemRepository;
import com.tunisair.repositories.MenuRepository;

import javassist.NotFoundException;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final MenuRepository menuRepository;

    public MenuItemService(MenuItemRepository menuItemRepository,MenuRepository menuRepository) {
        this.menuItemRepository = menuItemRepository;
        this.menuRepository = menuRepository;
    }
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }
    public MenuItem getMenuItem(Long id) throws NotFoundException {
        return menuItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("MenuItem not found with id: " + id));
    }

    public MenuItem createMenuItem(MenuItem menuItem) {
        MenuId menuId = menuItem.getMenu().getId();
        Menu menu = menuRepository.findById(menuId).orElse(null);
    if (menu == null) {
        return null;
    }
    menuItem.setMenu(menu);

        return menuItemRepository.save(menuItem);
    }

    public MenuItem updateMenuItem(Long id, MenuItem menuItem) throws NotFoundException {
        MenuItem existingMenuItem = getMenuItem(id);

        existingMenuItem.setName(menuItem.getName());
        existingMenuItem.setMenu(menuItem.getMenu());

        return menuItemRepository.save(existingMenuItem);
    }

    public void deleteMenuItem(Long id) throws NotFoundException {
        MenuItem existingMenuItem = getMenuItem(id);
        menuItemRepository.delete(existingMenuItem);
    }
}

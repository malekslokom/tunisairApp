package com.tunisair.service;

import com.tunisair.models.MenuItem;
import com.tunisair.repositories.MenuItemRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public MenuItem getMenuItem(Long id) throws NotFoundException {
        return menuItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("MenuItem not found with id: " + id));
    }

    public MenuItem createMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public MenuItem updateMenuItem(Long id, MenuItem menuItem) throws NotFoundException {
        MenuItem existingMenuItem = getMenuItem(id);

        // Update attributes of existingMenuItem with the new values from menuItem
        existingMenuItem.setName(menuItem.getName());
        existingMenuItem.setMenus(menuItem.getMenus());

        return menuItemRepository.save(existingMenuItem);
    }

    public void deleteMenuItem(Long id) throws NotFoundException {
        MenuItem existingMenuItem = getMenuItem(id);
        menuItemRepository.delete(existingMenuItem);
    }
}

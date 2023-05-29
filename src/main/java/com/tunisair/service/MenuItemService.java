package com.tunisair.service;

import com.tunisair.models.MenuItem;
import com.tunisair.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id).orElse(null);
    }

    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public MenuItem updateMenuItem(Long id, MenuItem menuItem) {
        MenuItem existingMenuItem = menuItemRepository.findById(id).orElse(null);
        if (existingMenuItem != null) {
            // Update the existing menu item properties
            existingMenuItem.setName(menuItem.getName());
            // Update other properties as needed
            // ...

            // Save the updated menu item
            return menuItemRepository.save(existingMenuItem);
        }
        return null;
    }

    public void deleteMenuItemById(Long id) {
        menuItemRepository.deleteById(id);
    }
}

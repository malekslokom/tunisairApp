package com.tunisair.controller;

import com.tunisair.models.MenuItem;
import com.tunisair.service.MenuItemService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItem(@PathVariable("id") Long id) throws NotFoundException {
        MenuItem menuItem = menuItemService.getMenuItem(id);
        return ResponseEntity.ok(menuItem);
    }

    @PostMapping
    public ResponseEntity<MenuItem> createMenuItem(@RequestBody MenuItem menuItem) {
        MenuItem createdMenuItem = menuItemService.createMenuItem(menuItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMenuItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable("id") Long id,
                                                   @RequestBody MenuItem menuItem) throws NotFoundException {
        MenuItem updatedMenuItem = menuItemService.updateMenuItem(id, menuItem);
        return ResponseEntity.ok(updatedMenuItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable("id") Long id) throws NotFoundException {
        menuItemService.deleteMenuItem(id);
        return ResponseEntity.noContent().build();
    }
}

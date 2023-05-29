package com.tunisair.controller;

import com.tunisair.models.Menu;
import com.tunisair.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/{numeroVol}/{idRestauration}")
    public Menu getMenuById(
            @PathVariable("numeroVol") Long numeroVol,
            @PathVariable("idRestauration") Long idRestauration
    ) {
        return menuService.getMenuById(numeroVol, idRestauration);
    }

    @PostMapping
    public Menu saveMenu(@RequestBody Menu menu) {
        return menuService.saveMenu(menu);
    }

    @DeleteMapping("/{numeroVol}/{idRestauration}")
    public void deleteMenuById(
            @PathVariable("numeroVol") Long numeroVol,
            @PathVariable("idRestauration") Long idRestauration
    ) {
        menuService.deleteMenuById(numeroVol, idRestauration);
    }
}

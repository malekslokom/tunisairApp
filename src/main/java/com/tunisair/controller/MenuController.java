package com.tunisair.controller;

import com.tunisair.models.Menu;
import com.tunisair.service.MenuService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/{numeroVol}/{idRestauration}")
    public ResponseEntity<Menu> getMenu(@PathVariable("numeroVol") Long numeroVol,
                                        @PathVariable("idRestauration") Long idRestauration) throws NotFoundException {
        Menu menu = menuService.getMenu(numeroVol, idRestauration);
        return ResponseEntity.ok(menu);
    }

    @PostMapping
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        Menu createdMenu = menuService.createMenu(menu);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMenu);
    }

    @PutMapping("/{numeroVol}/{idRestauration}")
    public ResponseEntity<Menu> updateMenu(@PathVariable("numeroVol") Long numeroVol,
                                           @PathVariable("idRestauration") Long idRestauration,
                                           @RequestBody Menu menu) throws NotFoundException {
        Menu updatedMenu = menuService.updateMenu(numeroVol, idRestauration, menu);
        return ResponseEntity.ok(updatedMenu);
    }

    @DeleteMapping("/{numeroVol}/{idRestauration}")
    public ResponseEntity<Void> deleteMenu(@PathVariable("numeroVol") Long numeroVol,
                                           @PathVariable("idRestauration") Long idRestauration) throws NotFoundException {
        menuService.deleteMenu(numeroVol, idRestauration);
        return ResponseEntity.noContent().build();
    }
}

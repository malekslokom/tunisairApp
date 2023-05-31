// package com.tunisair.controller;

// // import com.tunisair.models.Menu;
// // import com.tunisair.service.MenuService;
// // import javassist.NotFoundException;
// // import org.springframework.http.HttpStatus;
// // import org.springframework.http.ResponseEntity;
// // import org.springframework.web.bind.annotation.*;

// // @RestController
// // @RequestMapping("/api/menus")
// // public class MenuController {

// //     private final MenuService menuService;

// //     public MenuController(MenuService menuService) {
// //         this.menuService = menuService;
// //     }

// //     @GetMapping("/{numeroVol}/{idRestauration}")
// //     public ResponseEntity<Menu> getMenu(@PathVariable("numeroVol") Long numeroVol,
// //                                         @PathVariable("idRestauration") Long idRestauration) throws NotFoundException {
// //         Menu menu = menuService.getMenu(numeroVol, idRestauration);
// //         return ResponseEntity.ok(menu);
// //     }

// //     @PostMapping
// //     public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
// //         Menu createdMenu = menuService.createMenu(menu);
// //         return ResponseEntity.status(HttpStatus.CREATED).body(createdMenu);
// //     }

// //     @PutMapping("/{numeroVol}/{idRestauration}")
// //     public ResponseEntity<Menu> updateMenu(@PathVariable("numeroVol") Long numeroVol,
// //                                            @PathVariable("idRestauration") Long idRestauration,
// //                                            @RequestBody Menu menu) throws NotFoundException {
// //         Menu updatedMenu = menuService.updateMenu(numeroVol, idRestauration, menu);
// //         return ResponseEntity.ok(updatedMenu);
// //     }

// //     @DeleteMapping("/{numeroVol}/{idRestauration}")
// //     public ResponseEntity<Void> deleteMenu(@PathVariable("numeroVol") Long numeroVol,
// //                                            @PathVariable("idRestauration") Long idRestauration) throws NotFoundException {
// //         menuService.deleteMenu(numeroVol, idRestauration);
// //         return ResponseEntity.noContent().build();
// //     }
// // }
// import com.tunisair.models.Menu;
// import com.tunisair.models.MenuId;
// import com.tunisair.service.MenuService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/menus")
// public class MenuController {
//     private final MenuService menuService;

//     @Autowired
//     public MenuController(MenuService menuService) {
//         this.menuService = menuService;
//     }

//     @GetMapping
//     public ResponseEntity<List<Menu>> getAllMenus() {
//         List<Menu> menus = menuService.getAllMenus();
//         return ResponseEntity.ok(menus);
//     }

//     @GetMapping("/{numeroVol}/{idRestauration}")
//     public ResponseEntity<Menu> getMenuById(
//             @PathVariable("numeroVol") Long numeroVol,
//             @PathVariable("idRestauration") Long idRestauration
//     ) {
//         MenuId id = new MenuId();
//         id.setNumeroVol(numeroVol);
//         id.setIdRestauration(idRestauration);
//         Optional<Menu> menu = menuService.getMenuById(id);
//         return menu.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//     }

//     @PostMapping
//     public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
//         Menu createdMenu = menuService.saveMenu(menu);
//         return ResponseEntity.status(HttpStatus.CREATED).body(createdMenu);
//     }

//     @PutMapping("/{numeroVol}/{idRestauration}")
//     public ResponseEntity<Menu> updateMenu(
//             @PathVariable("numeroVol") Long numeroVol,
//             @PathVariable("idRestauration") Long idRestauration,
//             @RequestBody Menu updatedMenu
//     ) {
//         MenuId id = new MenuId();
//         id.setNumeroVol(numeroVol);
//         id.setIdRestauration(idRestauration);
//         Menu menu = menuService.updateMenu(id, updatedMenu);
//         if (menu != null) {
//             return ResponseEntity.ok(menu);
//         }
//         return ResponseEntity.notFound().build();
//     }

//     @DeleteMapping("/{numeroVol}/{idRestauration}")
//     public ResponseEntity<Void> deleteMenu(
//             @PathVariable("numeroVol") Long numeroVol,
//             @PathVariable("idRestauration") Long idRestauration
//     ) {
//         MenuId id = new MenuId();
//         id.setNumeroVol(numeroVol);
//         id.setIdRestauration(idRestauration);
//         boolean deleted = menuService.deleteMenu(id);
//         if (deleted) {
//             return ResponseEntity.noContent().build();
//         }
//         return ResponseEntity.notFound().build();
//     }
// }
package com.tunisair.controller;

import com.tunisair.models.Menu;
import com.tunisair.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
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

    @GetMapping("/{id}")
    public Menu getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id);
    }

    @PostMapping
    public Menu createMenu(@RequestBody Menu menu) {
        return menuService.createMenu(menu);
    }

    @PutMapping("/{id}")
    public Menu updateMenu(@PathVariable Long id, @RequestBody Menu menu) {
        return menuService.updateMenu(id, menu);
    }

    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }
}

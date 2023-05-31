// package com.tunisair.service;

// // import com.tunisair.models.Menu;
// // import com.tunisair.repositories.MenuRepository;
// // import javassist.NotFoundException;
// // import org.springframework.stereotype.Service;

// // @Service
// // public class MenuService {

// //     private final MenuRepository menuRepository;

// //     public MenuService(MenuRepository menuRepository) {
// //         this.menuRepository = menuRepository;
// //     }

// //     public Menu getMenu(Long numeroVol, Long idRestauration) throws NotFoundException {
// //         return menuRepository.findById(numeroVol)
// //                 .filter(menu -> menu.getIdRestauration().equals(idRestauration))
// //                 .orElseThrow(() -> new NotFoundException("Menu not found with numeroVol: " + numeroVol +
// //                         " and idRestauration: " + idRestauration));
// //     }

// //     public Menu createMenu(Menu menu) {
// //         return menuRepository.save(menu);
// //     }

// //     public Menu updateMenu(Long numeroVol, Long idRestauration, Menu menu) throws NotFoundException {
// //         Menu existingMenu = getMenu(numeroVol, idRestauration);

// //         // Update attributes of existingMenu with the new values from menu
// //         existingMenu.setMenuItems(menu.getMenuItems());

// //         return menuRepository.save(existingMenu);
// //     }

// //     public void deleteMenu(Long numeroVol, Long idRestauration) throws NotFoundException {
// //         Menu existingMenu = getMenu(numeroVol, idRestauration);
// //         menuRepository.delete(existingMenu);
// //     }
// // }
// import com.tunisair.models.Menu;
// import com.tunisair.models.MenuId;
// import com.tunisair.repositories.MenuRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class MenuService {
//     private final MenuRepository menuRepository;

//     @Autowired
//     public MenuService(MenuRepository menuRepository) {
//         this.menuRepository = menuRepository;
//     }

//     public List<Menu> getAllMenus() {
//         return menuRepository.findAll();
//     }

//     public Optional<Menu> getMenuById(MenuId id) {
//         return menuRepository.findById(id);
//     }

//     public Menu saveMenu(Menu menu) {
//         return menuRepository.save(menu);
//     }

//     public Menu updateMenu(MenuId id, Menu updatedMenu) {
//         Optional<Menu> menu = menuRepository.findById(id);
//         if (menu.isPresent()) {
//             Menu existingMenu = menu.get();
//             existingMenu.setMenuItems(updatedMenu.getMenuItems());
//             // Update other properties as needed
//             // ...
//             return menuRepository.save(existingMenu);
//         }
//         return null;
//     }

//     public boolean deleteMenu(MenuId id) {
//         Optional<Menu> menu = menuRepository.findById(id);
//         if (menu.isPresent()) {
//             menuRepository.delete(menu.get());
//             return true;
//         }
//         return false;
//     }
// }
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

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Long id, Menu updatedMenu) {
        Menu menu = getMenuById(id);
        if (menu != null) {


            return menuRepository.save(menu);
        }
        return null;
    }

    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}

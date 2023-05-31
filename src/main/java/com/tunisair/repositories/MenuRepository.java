//  package com.tunisair.repositories;

// // import com.tunisair.models.Menu;
// // import org.springframework.data.jpa.repository.JpaRepository;
// // import org.springframework.stereotype.Repository;
// // @Repository
// // public interface MenuRepository extends JpaRepository<Menu, Long> {
// //    // void deleteByNumeroVolAndIdRestauration(Long numeroVol, Long idRestauration);
// // }
// import com.tunisair.models.Menu;
// import com.tunisair.models.MenuId;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
// public interface MenuRepository extends JpaRepository<Menu, MenuId> {
//     Menu findByIdNumeroVolAndIdIdRestauration(Long numeroVol, Long idRestauration);
//     // Add other custom query methods if needed
// }
package com.tunisair.repositories;

import com.tunisair.models.Menu;
import com.tunisair.models.MenuId;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
   Optional<Menu> findById(MenuId menuId);
    

}

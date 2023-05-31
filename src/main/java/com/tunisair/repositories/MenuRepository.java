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

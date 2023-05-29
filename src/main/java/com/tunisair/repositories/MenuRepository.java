package com.tunisair.repositories;

import com.tunisair.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    void deleteByNumeroVolAndIdRestauration(Long numeroVol, Long idRestauration);
}

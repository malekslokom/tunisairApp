package com.tunisair.repositories;

import com.tunisair.models.Equipage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipageRepository extends JpaRepository<Equipage, Long> {
    // Add custom query methods if needed
}

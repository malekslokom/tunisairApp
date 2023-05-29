package com.tunisair.repositories;

import com.tunisair.models.Pilote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PiloteRepository extends JpaRepository<Pilote, Long> {
    // Add custom query methods if needed
}

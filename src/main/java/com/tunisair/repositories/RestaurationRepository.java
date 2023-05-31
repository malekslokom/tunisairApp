package com.tunisair.repositories;

import com.tunisair.models.Restauration;


import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurationRepository extends JpaRepository<Restauration, Long> {
}

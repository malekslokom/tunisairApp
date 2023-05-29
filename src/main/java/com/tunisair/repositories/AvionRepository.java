package com.tunisair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tunisair.models.Avion;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Long> {
}


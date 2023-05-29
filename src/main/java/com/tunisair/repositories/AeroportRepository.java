package com.tunisair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tunisair.models.Aeroport;

@Repository
public interface AeroportRepository extends JpaRepository<Aeroport, Long> {
    // You can define additional custom query methods if needed
}

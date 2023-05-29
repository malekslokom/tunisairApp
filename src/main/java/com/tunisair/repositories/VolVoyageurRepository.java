package com.tunisair.repositories;

import com.tunisair.models.VolVoyageur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolVoyageurRepository extends JpaRepository<VolVoyageur, Long> {

}

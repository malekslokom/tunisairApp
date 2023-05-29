package com.tunisair.repositories;

import com.tunisair.models.VolMarchandise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolMarchandiseRepository extends JpaRepository<VolMarchandise, Long> {
}

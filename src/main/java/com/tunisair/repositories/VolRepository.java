package com.tunisair.repositories;

import com.tunisair.models.Vol;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolRepository extends JpaRepository<Vol, Long> {
    //List<Vol> findVolsByRestaurationsId(Long restaurationId);
}

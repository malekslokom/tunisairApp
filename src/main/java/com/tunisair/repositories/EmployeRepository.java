package com.tunisair.repositories;

import com.tunisair.models.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

}


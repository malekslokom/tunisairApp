package com.tunisair.service;

import java.util.List;

import com.tunisair.models.Avion;

public interface AvionService {
    Avion saveAvion(Avion avion);
    Avion getAvionById(Long id);
    List<Avion> getAllAvions();
    void deleteAvionById(Long id);
}

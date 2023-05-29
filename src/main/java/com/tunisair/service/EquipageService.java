package com.tunisair.services;

import com.tunisair.models.Equipage;
import com.tunisair.repositories.EquipageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipageService {
    private final EquipageRepository equipageRepository;

    @Autowired
    public EquipageService(EquipageRepository equipageRepository) {
        this.equipageRepository = equipageRepository;
    }

    // Implement service methods for Equipage class
    public List<Equipage> getAllEquipages() {
        return equipageRepository.findAll();
    }

    public Equipage getEquipageById(Long id) {
        return equipageRepository.findById(id).orElse(null);
    }

    public Equipage saveEquipage(Equipage equipage) {
        return equipageRepository.save(equipage);
    }

    public void deleteEquipageById(Long id) {
        equipageRepository.deleteById(id);
    }
}

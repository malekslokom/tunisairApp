package com.tunisair.service;

import com.tunisair.models.Equipage;
import com.tunisair.repositories.EquipageRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EquipageService {

    private final EquipageRepository equipageRepository;

    public EquipageService(EquipageRepository equipageRepository) {
        this.equipageRepository = equipageRepository;
    }

    public Equipage getEquipageById(Long id) throws NotFoundException {
        return equipageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipage not found with id: " + id));
    }

    public Equipage createEquipage(Equipage equipage) {
        return equipageRepository.save(equipage);
    }

    public Equipage updateEquipage(Long id, Equipage equipage) throws NotFoundException {
        Equipage existingEquipage = equipageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipage not found with id: " + id));

        // Update attributes of existingEquipage with the new values from equipage
        existingEquipage.setPilotes(equipage.getPilotes());
        existingEquipage.setStaffs(equipage.getStaffs());
        existingEquipage.setVols(equipage.getVols());

        return equipageRepository.save(existingEquipage);
    }

    public void deleteEquipage(Long id) throws NotFoundException {
        if (!equipageRepository.existsById(id)) {
            throw new NotFoundException("Equipage not found with id: " + id);
        }
        equipageRepository.deleteById(id);
    }
}

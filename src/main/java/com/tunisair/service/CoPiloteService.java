package com.tunisair.service;

import com.tunisair.models.CoPilote;
import com.tunisair.repositories.CoPiloteRepository;
import com.tunisair.repositories.CoPiloteRepository;
import javassist.NotFoundException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CoPiloteService {

    private final CoPiloteRepository coPiloteRepository;

    public CoPiloteService(CoPiloteRepository coPiloteRepository) {
        this.coPiloteRepository = coPiloteRepository;
    }
    public List<CoPilote> getAllCoPilotes() {
        return coPiloteRepository.findAll();
    }
    public CoPilote getCoPilote(Long id) throws NotFoundException {
        return coPiloteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CoPilote not found with id: " + id));
    }

    public CoPilote createCoPilote(CoPilote coPilote) {
        return coPiloteRepository.save(coPilote);
    }

    public CoPilote updateCoPilote(Long id, CoPilote coPilote) throws NotFoundException {
        CoPilote existingCoPilote = getCoPilote(id);

        // Update attributes of existingPilote with the new values from pilote
        existingCoPilote.setNbHeuresVol(coPilote.getNbHeuresVol());
        existingCoPilote.setNumeroLicence(coPilote.getNumeroLicence());
        existingCoPilote.setEquipage(coPilote.getEquipage());

        return coPiloteRepository.save(existingCoPilote);
    }

    public void deleteCoPilote(Long id) throws NotFoundException {
        CoPilote existingCoPilote = getCoPilote(id);
        coPiloteRepository.delete(existingCoPilote);
    }
}

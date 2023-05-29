package com.tunisair.service;

import com.tunisair.models.Escale;
import com.tunisair.repositories.EscaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscaleService {
    private final EscaleRepository escaleRepository;

    @Autowired
    public EscaleService(EscaleRepository escaleRepository) {
        this.escaleRepository = escaleRepository;
    }

    // Implement service methods for Escale class
    public List<Escale> getAllEscales() {
        return escaleRepository.findAll();
    }

    public Escale getEscaleById(Long id) {
        return escaleRepository.findById(id).orElse(null);
    }

    public Escale saveEscale(Escale escale) {
        return escaleRepository.save(escale);
    }

    public void deleteEscaleById(Long id) {
        escaleRepository.deleteById(id);
    }
}

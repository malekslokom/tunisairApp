package com.tunisair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunisair.models.Avion;
import com.tunisair.repositories.AvionRepository;

import java.util.List;

@Service
public class AvionServiceImpl implements AvionService {
    private AvionRepository avionRepository;

    @Autowired
    public AvionServiceImpl(AvionRepository avionRepository) {
        this.avionRepository = avionRepository;
    }

    @Override
    public Avion saveAvion(Avion avion) {
        return avionRepository.save(avion);
    }

    @Override
    public Avion getAvionById(Long id) {
        return avionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Avion> getAllAvions() {
        return avionRepository.findAll();
    }

    @Override
    public void deleteAvionById(Long id) {
        avionRepository.deleteById(id);
    }
}

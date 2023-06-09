package com.tunisair.service;

import com.tunisair.models.Aeroport;
import com.tunisair.models.Equipage;
import com.tunisair.models.Restauration;
import com.tunisair.models.VolVoyageur;
import com.tunisair.repositories.AeroportRepository;
import com.tunisair.repositories.EquipageRepository;
import com.tunisair.repositories.RestaurationRepository;
import com.tunisair.repositories.VolVoyageurRepository;

import javassist.NotFoundException;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class VolVoyageurService {

    private final VolVoyageurRepository volVoyageurRepository;
    private final RestaurationRepository restaurationRepository;
    private final AeroportRepository aeroportRepository;
    private final EquipageRepository equipageRepository;

    public VolVoyageurService(VolVoyageurRepository volVoyageurRepository, RestaurationRepository restaurationRepository,
            AeroportRepository aeroportRepository, EquipageRepository equipageRepository) {
        this.volVoyageurRepository = volVoyageurRepository;
        this.restaurationRepository = restaurationRepository;
        this.aeroportRepository = aeroportRepository;
        this.equipageRepository = equipageRepository;
    }
    public List<VolVoyageur> getAllVolVoyageurs() {
        return volVoyageurRepository.findAll();
    }
 

    public VolVoyageur getVolVoyageurById(Long id) throws NotFoundException {
        return volVoyageurRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("VolVoyageur not found with id: " + id));
    }

    public VolVoyageur createVolVoyageur(VolVoyageur volVoyageur) {
        if (volVoyageur.getAeroportDepart() != null && volVoyageur.getAeroportDepart().getIdAeroport() != null) {
            Optional<Aeroport> aeroportDepartOptional = aeroportRepository.findById(volVoyageur.getAeroportDepart().getIdAeroport());
            if (!aeroportDepartOptional.isPresent()) {

            }
            volVoyageur.setAeroportDepart(aeroportDepartOptional.get());
        }

        if (volVoyageur.getAeroportDestination() != null && volVoyageur.getAeroportDestination().getIdAeroport() != null) {
            Optional<Aeroport> aeroportDestinationOptional = aeroportRepository.findById(volVoyageur.getAeroportDestination().getIdAeroport());
            if (!aeroportDestinationOptional.isPresent()) {
            }
            volVoyageur.setAeroportDestination(aeroportDestinationOptional.get());
        }

        if (volVoyageur.getEquipage() != null && volVoyageur.getEquipage().getIdEquipage() != null) {
            Optional<Equipage> equipageOptional = equipageRepository.findById(volVoyageur.getEquipage().getIdEquipage());
            if (!equipageOptional.isPresent()) {
            }
            volVoyageur.setEquipage(equipageOptional.get());
        }

        Set<Restauration> verifiedRestaurations = new HashSet<>();
        for (Restauration restauration : volVoyageur.getRestaurations()) {
            if (restauration.getIdRestauration() != null) {
                Optional<Restauration> restaurationOptional = restaurationRepository.findById(restauration.getIdRestauration());
                if (!restaurationOptional.isPresent()) {
                }
                verifiedRestaurations.add(restaurationOptional.get());
            }
        }
        volVoyageur.setRestaurations(verifiedRestaurations);

        return volVoyageurRepository.save(volVoyageur);
    }

    public VolVoyageur updateVolVoyageur(Long id, VolVoyageur volVoyageur) throws NotFoundException {
        VolVoyageur existingVolVoyageur = volVoyageurRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("VolVoyageur not found with id: " + id));

        existingVolVoyageur.setDateDepart(volVoyageur.getDateDepart());
        existingVolVoyageur.setDateArrivee(volVoyageur.getDateArrivee());
        existingVolVoyageur.setRetard(volVoyageur.getRetard());
        existingVolVoyageur.setEtat(volVoyageur.getEtat());
        existingVolVoyageur.setAeroportDepart(volVoyageur.getAeroportDepart());
        existingVolVoyageur.setAeroportDestination(volVoyageur.getAeroportDestination());
        existingVolVoyageur.setEquipage(volVoyageur.getEquipage());

        return volVoyageurRepository.save(existingVolVoyageur);
    }

    public void deleteVolVoyageur(Long id) throws NotFoundException {
        VolVoyageur volVoyageur = volVoyageurRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("VolVoyageur not found with id: " + id));
        volVoyageurRepository.delete(volVoyageur);
    }
}
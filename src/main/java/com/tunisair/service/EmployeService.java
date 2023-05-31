package com.tunisair.service;

import com.tunisair.models.Employe;
import com.tunisair.repositories.EmployeRepository;
import javassist.NotFoundException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeService {

    private final EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }
    public Employe getEmployeById(Long id) throws NotFoundException {
        return employeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employe not found with id: " + id));
    }

    public Employe createEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    public Employe updateEmploye(Long id, Employe employe) throws NotFoundException {
        Employe existingEmploye = employeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employe not found with id: " + id));

        // Update attributes of existingEmploye with the new values from employe
        existingEmploye.setNom(employe.getNom());
        existingEmploye.setPrenom(employe.getPrenom());
        existingEmploye.setDateNaissance(employe.getDateNaissance());
        existingEmploye.setEmail(employe.getEmail());
        existingEmploye.setTelephone(employe.getTelephone());
        existingEmploye.setAdresse(employe.getAdresse());

        return employeRepository.save(existingEmploye);
    }

    public void deleteEmploye(Long id) throws NotFoundException {
        if (!employeRepository.existsById(id)) {
            throw new NotFoundException("Employe not found with id: " + id);
        }
        employeRepository.deleteById(id);
    }
}

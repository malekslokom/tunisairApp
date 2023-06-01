package com.tunisair.service;

import com.tunisair.models.CoPilote;
import com.tunisair.models.Equipage;
import com.tunisair.models.Pilote;
import com.tunisair.models.Staff;
import com.tunisair.repositories.CoPiloteRepository;
import com.tunisair.repositories.EquipageRepository;
import com.tunisair.repositories.PiloteRepository;
import com.tunisair.repositories.StaffRepository;

import javassist.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class EquipageService {

    private final EquipageRepository equipageRepository;
    private final StaffRepository staffRepository;

    public EquipageService(EquipageRepository equipageRepository,StaffRepository staffRepository) {
        this.equipageRepository = equipageRepository;
        this.staffRepository = staffRepository;

    }
    public List<Equipage> getAllEquipages() {
        return equipageRepository.findAll();
    }
    public Equipage getEquipageById(Long id) throws NotFoundException {
        return equipageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipage not found with id: " + id));
    }

    public Equipage createEquipage(Equipage equipage) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(equipage.getStaffs());
       // return equipageRepository.save(equipage);
        List<Staff> staffs = equipage.getStaffs();
        List<Staff> managedStaffs = new ArrayList<>();
        for (Staff staff : staffs) {
            managedStaffs.add(staffRepository.getOne(staff.getIdEmploye()));
        }
        equipage.setStaffs(managedStaffs);
        Equipage newEquipage= equipageRepository.save(equipage);
        for (Staff staff : staffs) {
            //managedStaffs.add(staffRepository.getOne(staff.getIdEmploye()));
            Staff usedStaff=staffRepository.getOne(staff.getIdEmploye());
            usedStaff.setEquipage(newEquipage);
            staffRepository.save(usedStaff);
        }
        return newEquipage;
    
    }

    public Equipage updateEquipage(Long id, Equipage equipage) throws NotFoundException {
        Equipage existingEquipage = equipageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipage not found with id: " + id));

        existingEquipage.setPilote(equipage.getPilote());
        existingEquipage.setCoPilote(equipage.getCoPilote());
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

package com.tunisair.service;

import com.tunisair.models.Staff;
import com.tunisair.repositories.StaffRepository;
import javassist.NotFoundException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff getStaff(Long id) throws NotFoundException {
        return staffRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Staff not found with id: " + id));
    }

    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff updateStaff(Long id, Staff staff) throws NotFoundException {
        Staff existingStaff = getStaff(id);

        // Update attributes of existingStaff with the new values from staff
        existingStaff.setRole(staff.getRole());
        existingStaff.setExperience(staff.getExperience());
        existingStaff.setEquipage(staff.getEquipage());

        return staffRepository.save(existingStaff);
    }

    public void deleteStaff(Long id) throws NotFoundException {
        Staff existingStaff = getStaff(id);
        staffRepository.delete(existingStaff);
    }
}

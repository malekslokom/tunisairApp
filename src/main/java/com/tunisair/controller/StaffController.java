package com.tunisair.controller;

import com.tunisair.models.Staff;
import com.tunisair.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable("id") Long id) {
        return staffService.getStaffById(id);
    }

    @PostMapping
    public Staff saveStaff(@RequestBody Staff staff) {
        return staffService.saveStaff(staff);
    }

    @DeleteMapping("/{id}")
    public void deleteStaffById(@PathVariable("id") Long id) {
        staffService.deleteStaffById(id);
    }
}

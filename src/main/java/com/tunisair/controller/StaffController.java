package com.tunisair.controller;

import com.tunisair.models.Staff;
import com.tunisair.service.StaffService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaff(@PathVariable("id") Long id) throws NotFoundException {
        Staff staff = staffService.getStaff(id);
        return ResponseEntity.ok(staff);
    }

    @PostMapping
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
        Staff createdStaff = staffService.createStaff(staff);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStaff);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable("id") Long id,
                                             @RequestBody Staff staff) throws NotFoundException {
        Staff updatedStaff = staffService.updateStaff(id, staff);
        return ResponseEntity.ok(updatedStaff);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable("id") Long id) throws NotFoundException {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }
}

package com.tunisair.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunisair.models.*;
import com.tunisair.payload.request.LoginRequest;
import com.tunisair.payload.request.SignupRequest;
import com.tunisair.payload.response.JwtResponse;
import com.tunisair.payload.response.MessageResponse;
import com.tunisair.repositories.*;
import com.tunisair.security.jwt.JwtUtils;
import com.tunisair.service.AeroportService;
import com.tunisair.service.UserDetailsImpl;


@RestController
@RequestMapping("/aeroports")
public class AeroportController {

    @Autowired
    private AeroportService aeroportService;

    // Endpoint to get all aeroports
    @GetMapping
    public List<Aeroport> getAllAeroports() {
        return aeroportService.getAllAeroports();
    }

    // Endpoint to get an aeroport by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Aeroport> getAeroportById(@PathVariable Long id) {
        Optional<Aeroport> aeroport = aeroportService.getAeroportById(id);
        if (aeroport.isPresent()) {
            return ResponseEntity.ok(aeroport.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to create a new aeroport
    @PostMapping
    public Aeroport createAeroport(@RequestBody Aeroport aeroport) {
        return aeroportService.createAeroport(aeroport);
    }

    // Endpoint to update an aeroport
    @PutMapping("/{id}")
    public ResponseEntity<Aeroport> updateAeroport(@PathVariable Long id, @RequestBody Aeroport updatedAeroport) {
        Optional<Aeroport> aeroport = aeroportService.updateAeroport(id, updatedAeroport);
        if (aeroport.isPresent()) {
            return ResponseEntity.ok(aeroport.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to delete an aeroport
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAeroport(@PathVariable Long id) {
        boolean deleted = aeroportService.deleteAeroport(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


package com.eleks.academy.pharmagator.controllers;

import com.eleks.academy.pharmagator.entities.Pharmacy;
import com.eleks.academy.pharmagator.repositories.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pharmacies")
public class PharmacyController {
    private final PharmacyRepository pharmacyRepository;

    @GetMapping
    public ResponseEntity<List<Pharmacy>> getAll() {
        return ResponseEntity.ok(pharmacyRepository.findAll());
    }
    
    @GetMapping(value = {"/{id}"})
    public ResponseEntity<Optional<Pharmacy>> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(pharmacyRepository.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pharmacy create(@Valid @RequestBody Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Pharmacy> update(@Valid @PathVariable("id") Long id, @RequestBody Pharmacy pharmacy) {
        Optional<Pharmacy> pharmacyOptional = pharmacyRepository.findById(id);
        if (pharmacyOptional.isPresent()) {
            Pharmacy pharmacyUpdated = pharmacyRepository.getById(pharmacy.getId());
            pharmacyUpdated.setName(pharmacy.getName());
            pharmacyUpdated.setMedicineLinkTemplate(pharmacy.getMedicineLinkTemplate());
            return ResponseEntity.ok(pharmacyRepository.save(pharmacyUpdated));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id) {
        pharmacyRepository.deleteById(id);
    }

}

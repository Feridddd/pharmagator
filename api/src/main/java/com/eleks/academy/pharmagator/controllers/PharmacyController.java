package com.eleks.academy.pharmagator.controllers;

import com.eleks.academy.pharmagator.entities.Pharmacy;
import com.eleks.academy.pharmagator.repositories.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import org.postgresql.shaded.com.ongres.scram.common.util.Preconditions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Pharmacy> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(pharmacyRepository.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pharmacy create(@RequestBody Pharmacy pharmacy) {
        Preconditions.checkNotNull(pharmacy,"Pharmacy");
        return pharmacyRepository.save(pharmacy);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pharmacy update(@PathVariable("id") Long id, @RequestBody Pharmacy pharmacy) {
        Preconditions.checkNotNull(pharmacyRepository.getById(pharmacy.getId()),"Pharmacy Id");
        Pharmacy pharmacyTemp = pharmacyRepository.getById(pharmacy.getId());
        pharmacyTemp.setName(pharmacy.getName());
        pharmacyTemp.setMedicineLinkTemplate(pharmacy.getMedicineLinkTemplate());

        Pharmacy pharmacyUpdated = pharmacyRepository.save(pharmacyTemp);
        return pharmacyUpdated;
    }

    @DeleteMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id) {
        pharmacyRepository.deleteById(id);
    }

}

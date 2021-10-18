package com.eleks.academy.pharmagator.controllers;

import com.eleks.academy.pharmagator.dataproviders.dto.MedicineDto;
import com.eleks.academy.pharmagator.entities.Medicine;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medicine")
public class MedicineController {
    private final ModelMapper modelMapper;

    public MedicineController(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }
    private Medicine convertToEntity (MedicineDto medicineDto) {
        Medicine medicine = modelMapper.map(medicineDto, Medicine.class);
        return medicine;
    }
}

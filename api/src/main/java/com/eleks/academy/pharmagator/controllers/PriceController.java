package com.eleks.academy.pharmagator.controllers;


import com.eleks.academy.pharmagator.dataproviders.dto.MedicineDto;
import com.eleks.academy.pharmagator.entities.Price;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/price")
public class PriceController {
    private ModelMapper modelMapper;

    public PriceController(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }
    private Price convertToEntity (MedicineDto medicineDto) {
        Price price = modelMapper.map(medicineDto, Price.class);
        return price;
    }
}

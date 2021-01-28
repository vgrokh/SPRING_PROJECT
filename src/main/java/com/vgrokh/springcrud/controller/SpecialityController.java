package com.vgrokh.springcrud.controller;


import com.vgrokh.springcrud.model.Speciality;
import com.vgrokh.springcrud.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;


@Controller
@RequestMapping("/api/specialities")
public class SpecialityController {

    @Autowired
    private SpecialityRepository specialityRepository;

    @GetMapping(path = "/get/{id}")
    public @ResponseBody
    Optional<Speciality> getSpecialityById(@PathVariable long id){
        return specialityRepository.findById(id);
    }

    @GetMapping(path= "/get/all")
    public @ResponseBody Iterable<Speciality> getAllSpecialities() {
        return specialityRepository.findAll();
    }

    @DeleteMapping(path= "/delete/{id}")
    public void deleteSpecialityById(@PathVariable long id){
        specialityRepository.deleteById(id);
    }

    @PostMapping(path = "/add")
    public void addSpeciality(@RequestParam String specialityName){
        Speciality speciality = new Speciality();
        long addAndUpdateDate = new Date().getTime();
        speciality.setName(specialityName);
        speciality.setCreated(addAndUpdateDate);
        speciality.setUpdated(addAndUpdateDate);
        specialityRepository.save(speciality);
    }

}

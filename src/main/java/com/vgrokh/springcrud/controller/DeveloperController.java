package com.vgrokh.springcrud.controller;

import com.vgrokh.springcrud.model.Developer;
import com.vgrokh.springcrud.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/v1/developers")
public class DeveloperController {

    @Autowired
    private DeveloperRepository developerRepository;

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Developer> getDeveloperById(@PathVariable long id){
        return developerRepository.findById(id);
    }

    @GetMapping
    public @ResponseBody Iterable<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    @DeleteMapping(path= "/delete/{id}")
    public void deleteDeveloperById(@PathVariable long id){
        developerRepository.deleteById(id);
    }

    @PostMapping(path = "/add")
    public void addDeveloper(@RequestParam String firstName, @RequestParam String lastName){
        Developer developer = new Developer();
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        developerRepository.save(developer);
    }
}

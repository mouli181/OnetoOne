package com.example.demoone.controller;


import com.example.demoone.model.Person;
import com.example.demoone.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    // Create a new Person
    @PostMapping("/create")
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    // Get All Persons
    @GetMapping("getAll")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    // Get Person By ID
    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    // Update Person
    @PutMapping("/update/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        return personService.getPersonById(id)
                .map(person -> {
                    person.setName(updatedPerson.getName());
                    person.setPassport(updatedPerson.getPassport());
                    return personService.savePerson(person);
                })
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
    }

    // Delete Person
    @DeleteMapping("delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.deletePersonById(id);
        return "Person deleted with id: " + id;
    }
}


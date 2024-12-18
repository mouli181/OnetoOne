package com.example.demoone.service;

import com.example.demoone.model.Person;
import com.example.demoone.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    // Create or Update Person
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    // Get All Persons
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    // Get Person By ID
    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    // Delete Person By ID
    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }
}

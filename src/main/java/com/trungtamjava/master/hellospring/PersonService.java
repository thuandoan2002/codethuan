package com.trungtamjava.master.hellospring;

import com.trungtamjava.master.hellospring.controller.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepo personRepo;

    public List<Person> getAll() {
        return personRepo.findAll();
    }
    public Optional<Person> getById(Integer id) {
        return personRepo.findById(id);
    }
}

package com.example.courses.core.controller;

import com.example.courses.core.bs.dao.PersonRepository;
import com.example.courses.core.eis.bo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/person",produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Person> getAll(){
        return personRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) Person person){
        return this.personRepository.save(person);
    }

    @RequestMapping(value = "/{id}",method= RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) Person person){
        return this.personRepository.save(person);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") Long id,@RequestBody(required = true) Person person){
        person = (Person)this.personRepository.findById(id).get();
        this.personRepository.delete(person);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Eliminado");
    }
}

package com.example.courses.core.controller;

import com.example.courses.core.bs.dao.OfficeAssigmentRepository;
import com.example.courses.core.eis.bo.OfficeAssigment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/office_assigment",produces = MediaType.APPLICATION_JSON_VALUE)
public class OfficeAssigmentController {
    @Autowired
    private OfficeAssigmentRepository  officeAssigmentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<OfficeAssigment> getAll(){
        return officeAssigmentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) OfficeAssigment officeAssigment){
        return this.officeAssigmentRepository.save(officeAssigment);
    }

    @RequestMapping(value = "/{id}",method= RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) OfficeAssigment officeAssigment){
        return this.officeAssigmentRepository.save(officeAssigment);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") Long id,@RequestBody(required = true) OfficeAssigment officeAssigment){
        officeAssigment = (OfficeAssigment) this.officeAssigmentRepository.findById(id).get();
        this.officeAssigmentRepository.delete(officeAssigment);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Eliminado");
    }

}

package com.example.courses.core.controller;

import com.example.courses.core.bs.dao.DepartmentRepository;
import com.example.courses.core.eis.bo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/department",produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Department> getAll(){
        return departmentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) Department onlineCourse){
        return this.departmentRepository.save(onlineCourse);
    }

    @RequestMapping(value = "/{id}",method= RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) Department department){
        return this.departmentRepository.save(department);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") Long id,@RequestBody(required = true) Department department){
        department = (Department) this.departmentRepository.findById(id).get();
        this.departmentRepository.delete(department);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Eliminado");
    }

}
package com.example.courses.core.controller;

import com.example.courses.core.bs.dao.CourseInstructorRepository;
import com.example.courses.core.eis.bo.CourseInstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/course_instructor",produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseInstructorController {
    @Autowired
    private CourseInstructorRepository courseInstructorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<CourseInstructor> getAll(){
        return courseInstructorRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) CourseInstructor courseInstructor){
        return this.courseInstructorRepository.save(courseInstructor);
    }

    @RequestMapping(value = "/{id}",method= RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) CourseInstructor courseInstructor){
        return this.courseInstructorRepository.save(courseInstructor);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") Long id,@RequestBody(required = true) CourseInstructor courseInstructor){
        courseInstructor = (CourseInstructor) this.courseInstructorRepository.findById(id).get();
        this.courseInstructorRepository.delete(courseInstructor);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Eliminado");
    }

}
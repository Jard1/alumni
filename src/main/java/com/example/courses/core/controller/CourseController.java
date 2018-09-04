package com.example.courses.core.controller;

import com.example.courses.core.bs.dao.CourseRepository;
import com.example.courses.core.eis.bo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/course",produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Course> getAll(){
        return courseRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) Course onlineCourse){
        return this.courseRepository.save(onlineCourse);
    }

    @RequestMapping(value = "/{id}",method= RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) Course course){
        return this.courseRepository.save(course);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") Long id,@RequestBody(required = true) Course course){
        course = (Course) this.courseRepository.findById(id).get();
        this.courseRepository.delete(course);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Eliminado");
    }

}
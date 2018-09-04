package com.example.courses.core.controller;

import com.example.courses.core.bs.dao.OnlineCourseRepository;
import com.example.courses.core.eis.bo.OnlineCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/online_course",produces = MediaType.APPLICATION_JSON_VALUE)
public class OnlineCourseController {
    @Autowired
    private OnlineCourseRepository onlineCourseRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<OnlineCourse> getAll(){
        return onlineCourseRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) OnlineCourse onlineCourse){
        return this.onlineCourseRepository.save(onlineCourse);
    }

    @RequestMapping(value = "/{id}",method= RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) OnlineCourse onlineCourse){
        return this.onlineCourseRepository.save(onlineCourse);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") Long id,@RequestBody(required = true) OnlineCourse onlineCourse){
        onlineCourse = (OnlineCourse) this.onlineCourseRepository.findById(id).get();
        this.onlineCourseRepository.delete(onlineCourse);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Eliminado");
    }

}

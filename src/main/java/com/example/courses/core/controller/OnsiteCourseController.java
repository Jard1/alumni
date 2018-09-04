package com.example.courses.core.controller;

import com.example.courses.core.bs.dao.OnsiteCourseRepository;
import com.example.courses.core.eis.bo.OnsiteCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/onsite_course",produces = MediaType.APPLICATION_JSON_VALUE)
public class OnsiteCourseController {
    @Autowired
    private OnsiteCourseRepository onsiteCourseRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<OnsiteCourse> getAll(){
        return onsiteCourseRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) OnsiteCourse onsiteCourse){
        return this.onsiteCourseRepository.save(onsiteCourse);
    }

    @RequestMapping(value = "/{id}",method= RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) OnsiteCourse onsiteCourse){
        return this.onsiteCourseRepository.save(onsiteCourse);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") Long id,@RequestBody(required = true) OnsiteCourse onsiteCourse){
        onsiteCourse = (OnsiteCourse)this.onsiteCourseRepository.findById(id).get();
        this.onsiteCourseRepository.delete(onsiteCourse);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Eliminado");
    }

}

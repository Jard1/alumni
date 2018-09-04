package com.example.courses.core.controller;

import com.example.courses.core.bs.dao.StudentGradeRepository;
import com.example.courses.core.eis.bo.StudentGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/student_grade",produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentGradeController {
    @Autowired
    private StudentGradeRepository studentGradeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<StudentGrade> getAll(){
        return studentGradeRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) StudentGrade studentGrade){
        return this.studentGradeRepository.save(studentGrade);
    }

    @RequestMapping(value = "/{id}",method= RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) StudentGrade studentGrade){
        return this.studentGradeRepository.save(studentGrade);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") Long id,@RequestBody(required = true) StudentGrade studentGrade){
        studentGrade = (StudentGrade)this.studentGradeRepository.findById(id).get();
        this.studentGradeRepository.delete(studentGrade);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Eliminado");
    }

}
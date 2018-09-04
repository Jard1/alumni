package com.example.courses.core.eis.bo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "course_instructor")
public class CourseInstructor implements  Serializable{

    @EmbeddedId
    private CourseInstructorID courseInstructorId;

    @ManyToOne
    @JoinColumn(name = "course_id",nullable = false,insertable = false,updatable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "person_id",nullable = false,insertable = false,updatable = false)
    private Person person;
}

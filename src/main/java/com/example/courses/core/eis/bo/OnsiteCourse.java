package com.example.courses.core.eis.bo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;
import java.sql.Time;

@Data
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "course_id")
public class OnsiteCourse extends Course implements Serializable {
    private Long courseId;
    private String location;
    private String days;
    private Time time;
}

package com.example.courses.core.eis.bo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmaent_id")
    private Long departmentId;

    @Column(name = "name")
    private String name;

    @Column(name = "budget")
    private String budget;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "administrator")
    private int administrator;

    @OneToMany(mappedBy = "department")
    private Set<Course> courses;
}

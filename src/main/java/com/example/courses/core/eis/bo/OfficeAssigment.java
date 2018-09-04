package com.example.courses.core.eis.bo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "office_assigment")
public class OfficeAssigment implements Serializable{
    @Id
    @Column(name = "instructor_id")
    private Long Id;

    @Column(name = "location")
    private String location;

    @Column(name = "timestamp")
    @Temporal(TemporalType.DATE)
    private Date timestamp;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Person instructorId;

}

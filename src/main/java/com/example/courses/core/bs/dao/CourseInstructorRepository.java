package com.example.courses.core.bs.dao;

import com.example.courses.core.eis.bo.CourseInstructor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseInstructorRepository extends PagingAndSortingRepository<CourseInstructor,Long> {
}

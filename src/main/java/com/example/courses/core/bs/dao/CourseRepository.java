package com.example.courses.core.bs.dao;

import com.example.courses.core.eis.bo.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepository extends PagingAndSortingRepository<Course,Long> {
}

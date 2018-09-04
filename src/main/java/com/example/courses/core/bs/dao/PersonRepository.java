package com.example.courses.core.bs.dao;

import com.example.courses.core.eis.bo.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person,Long>{
}

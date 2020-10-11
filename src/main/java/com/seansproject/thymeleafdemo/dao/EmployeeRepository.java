package com.seansproject.thymeleafdemo.dao;


import com.seansproject.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //add a method to sort by last name

    //Spring jpa parses method name to get type of method eg.
    // findAll .. get method
    //ByLastName .. order by last name
    // Asc .. order ascending
    List<Employee> findAllByOrderByLastNameAsc();

}

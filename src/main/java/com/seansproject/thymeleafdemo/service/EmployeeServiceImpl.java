package com.seansproject.thymeleafdemo.service;


import com.seansproject.thymeleafdemo.dao.EmployeeRepository;
import com.seansproject.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository =employeeRepository;
    }

    @Override
    // dont need @Transactional, jpa provides that
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    //@Transactional
    public Employee findById(int id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        Employee employee = null;

        if(byId.isPresent()){
            employee = byId.get();
        }else{
            throw new RuntimeException("Did not find employee by id - "+id);
        }

        return employee;
    }

    @Override
    //@Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    //@Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}

package com.proj.service;

import com.proj.Entity.Employee;
import com.proj.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao dao;

    public List<Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }

    public void saveEmployee(Employee emp) {
        dao.saveEmployee(emp);
    }

    public void deleteEmployee(int id) {
        dao.deleteById(id);
    }

    public Employee getEmployee(int id) {
        return dao.getById(id);
    }

    public void updateEmployee(Employee emp) {
        dao.updateEmployee(emp);
    }
}
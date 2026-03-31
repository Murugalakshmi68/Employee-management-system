package com.proj.dao;

import com.proj.Entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {
    private static List<Employee> list = new ArrayList<>();

    static {
        list.add(new Employee(1, "Muruga", "muruga@gmail.com", "IT", "Developer"));
        list.add(new Employee(2, "Lakshmi", "lakshmi@gmail.com", "HR", "Manager"));
    }

    public List<Employee> getAllEmployees() {
        return list;
    }

    public void saveEmployee(Employee emp) {
        emp.setId(list.size() + 1);
        list.add(emp);
    }

    public void deleteById(int id) {
        list.removeIf(e -> e.getId() == id);
    }

    public Employee getById(int id) {
        return list.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateEmployee(Employee emp) {
        for (Employee e : list) {
            if (e.getId() == emp.getId()) {
                e.setName(emp.getName());
                e.setEmail(emp.getEmail());
                e.setDepartment(emp.getDepartment());
                e.setRole(emp.getRole());
            }
        }
    }
}
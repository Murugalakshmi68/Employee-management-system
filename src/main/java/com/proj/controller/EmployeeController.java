package com.proj.controller;

import com.proj.Entity.Employee;
import com.proj.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("/")
    public String home(Model model) {

        List<Employee> list = service.getAllEmployees();

        model.addAttribute("employees", list);
        model.addAttribute("totalEmployees", list.size());

        Set<String> dept = new HashSet<>();
        Set<String> role = new HashSet<>();

        for (Employee e : list) {
            dept.add(e.getDepartment());
            role.add(e.getRole());
        }

        model.addAttribute("deptCount", dept.size());
        model.addAttribute("roleCount", role.size());

        return "home";
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("emp", new Employee());
        return "addEmployee";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employee emp) {
        service.saveEmployee(emp);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        service.deleteEmployee(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("emp", service.getEmployee(id));
        return "addEmployee";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Employee emp) {
        service.updateEmployee(emp);
        return "redirect:/";
    }
    @GetMapping("/search")
    public String search(@RequestParam String name, Model model) {

        List<Employee> list = service.searchEmployee(name);

        model.addAttribute("employees", list); // 🔥 MUST match JSP

        model.addAttribute("totalEmployees", list.size());

        Set<String> dept = new HashSet<>();
        Set<String> role = new HashSet<>();

        for (Employee e : list) {
            dept.add(e.getDepartment());
            role.add(e.getRole());
        }

        model.addAttribute("deptCount", dept.size());
        model.addAttribute("roleCount", role.size());

        return "home";
    }
}
package com.springboot.demo.controller;

import com.springboot.demo.entity.Department;
import com.springboot.demo.error.DepartmentNotFoundException;
import com.springboot.demo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){//Request body --> json file
        logger.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartments(){
        logger.info("Inside fetchDepartments of DepartmentController");
        return departmentService.fetchDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long Id) throws DepartmentNotFoundException {
        logger.info("Inside fetchDepartmentById of DepartmentController");
        return departmentService.fetchDepartmentById(Id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id")Long id){
        logger.info("Inside deleteDepartmentById of DepartmentController");
        departmentService.deleteDepartmentById(id);
        return "department deleted";
    }

    @PutMapping("departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long id,@RequestBody Department department){
        logger.info("Inside updateDepartmentById of DepartmentController");
        return departmentService.updateDepartmentById(id,department);
    }
}

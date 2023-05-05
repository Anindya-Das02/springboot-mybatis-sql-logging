package org.mybatis.example.controller;

import org.mybatis.example.mapper.EmployeeMapper;
import org.mybatis.example.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    private static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<?> index(){
        LOGGER.info("invoked /index");
        return ResponseEntity.ok(Map.of("status","employee index"));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Employee getEmployeeDetails(@PathVariable("id") int id){
        LOGGER.info("invoked /{" + id + "}");
        return employeeMapper.findEmployeeById(id);
    }
}

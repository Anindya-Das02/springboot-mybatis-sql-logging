package org.mybatis.example.controller;

import org.mybatis.example.mapper.EmployeeMapper;
import org.mybatis.example.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<?> createEmployee(RequestEntity<Employee> employeeRequestEntity){
        Employee employee = employeeRequestEntity.getBody();
        try {
            employeeMapper.insertEmployeeDetails(employee);
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.warning("Error occurred while inserting employee record exiting..");
            return ResponseEntity.status(500).body(Map.of("status","ERROR","message","Error occurred while inserting employee record"));
        }
        return ResponseEntity.ok(Map.of("status","employee created"));
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Employee> fetchEmployeeRecords(){
        LOGGER.info("invoked /all");
        return employeeMapper.fetchEmployeeList();
    }
}

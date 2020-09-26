package com.turing.springboot.demo.controller;

import com.turing.springboot.demo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    /*
        load employee data
        add mapping for "/list"
    */
    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData() {
        /*
            create employees
            create the list
            add to the list
        */
        Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslieandrews@gmail.com");
        Employee emp2 = new Employee(2, "Lila", "Aoka", "lilaaoka@gmail.com");
        Employee emp3 = new Employee(3, "Watts", "Pond", "wattspond@gmail.com");

        theEmployees = new ArrayList<>();
        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);
    }

     @GetMapping("/list")
    public String listEmployees(Model theModel){
        theModel.addAttribute("employees", theEmployees);
        return "list-employees";
    }
}

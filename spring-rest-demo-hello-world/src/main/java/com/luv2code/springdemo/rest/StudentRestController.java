package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    /*
        define endpoint for "/students" - return list of all students
    */

    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Poornial","Patel"));
        theStudents.add(new Student("Poal","Pel"));
        theStudents.add(new Student("Poial","Pael"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    /*
        Define endpoint for getting a single student
    */

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // check the studentId against the list size

        if((studentId >= theStudents.size() || (studentId <0))) {
            throw new StudentNotFoundException("Provided student ID not found: #" + studentId);
        }
        return theStudents.get(studentId);
    }


}

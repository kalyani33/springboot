package com.example.springboot.controller;

import com.example.springboot.bean.Student;
import com.example.springboot.exception.ErrorDetails;
import com.example.springboot.exception.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST API - create user,update user,delete user,get user,get all users"
)
@RestController
public class StudentController {

    @Operation(
            summary = "Get user REST API ",
            description = "Create REST API is used to Get a user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/student")
    public Student getStudnet(){
        Student student = new Student(
                1,"kalyani","Reddy"
        );
        return student;
    }

    @GetMapping("all-students")
    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(2,"Markram","Aiden"));
        students.add(new Student(3,"David","Warner"));
        students.add(new Student(4,"Virat","Kohli"));
        return students;
    }

    @GetMapping("student/{id}/{first-name}/{last-name}")
    public Student studentPathVariables(@PathVariable("id") int studentId,
                                        @PathVariable("first-name") String firstName,
                                        @PathVariable("last-name") String lastName){
        return new Student(studentId,firstName,lastName);
    }

    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam("id") int id,
                                          @RequestParam("firstname") String firstname,
                                          @RequestParam String lastname)
    {
        return new Student(id,firstname,lastname);
    }

    @Operation(
            summary = "Create user REST API ",
            description = "Create REST API is used to create a user"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("students/create")
    public Student createStudent(@Valid @RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return student;
    }

    @PutMapping("students/create")
    public Student updateStduent(@RequestBody Student student){
        System.out.println(student.getId());
        return student;
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                        WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
}

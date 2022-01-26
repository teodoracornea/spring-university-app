package ro.fasttrackit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.service.StudentService;
import ro.fasttrackit.service.model.StudentDto;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/api/students")
    public ResponseEntity createOrUpdateStudent(@RequestBody StudentDto studentRequest){
        this.studentService.createOrUpdateStudent(studentRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/students")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @DeleteMapping("/api/students/{id}")
    public void deleteStudentById(@PathVariable("id") Long studentID){
        this.studentService.deleteStudentById(studentID);
    }




}

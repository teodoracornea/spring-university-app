package ro.fasttrackit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.service.AssignStudentsService;
import ro.fasttrackit.service.model.AssignDto;
import ro.fasttrackit.service.model.AssignStudentsDto;

import java.util.List;


@RestController
public class AssignStudentsController {
    private final AssignStudentsService assignStudentsService;

    public AssignStudentsController(AssignStudentsService assignStudentsService) {
        this.assignStudentsService = assignStudentsService;
    }

    @PostMapping("api/assign-students")
    public ResponseEntity createOrUpdateStudentCourses(@RequestBody AssignDto assignRequest){
        String message = this.assignStudentsService.assignCoursesToStudents(assignRequest);

        return ResponseEntity.ok(message);
    }

    @GetMapping("api/assign-students")
    public ResponseEntity<List<AssignStudentsDto>> getAllAssigned(){
        return ResponseEntity.ok(assignStudentsService.getAllAssigned());
    }

    @DeleteMapping("api/assign-students/{id}")
    public void deleteAssignStudentsById(@PathVariable("id") Long assignId){
        this.assignStudentsService.deleteAssignedById(assignId);
    }
}

package ro.fasttrackit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.repository.dao.ScheduledCoursesEntity;
import ro.fasttrackit.service.AssignStudentsService;
import ro.fasttrackit.service.model.AssignDto;
import ro.fasttrackit.service.model.AssignStudentsDto;

import java.util.List;
import java.util.Set;

@RestController
public class AssignStudentsController {
    private final AssignStudentsService assignStudentsService;

    public AssignStudentsController(AssignStudentsService assignStudentsService) {
        this.assignStudentsService = assignStudentsService;
    }

    @PostMapping("api/assign-students")
    public ResponseEntity createOrUpdateStudentCourses(@RequestBody AssignDto assignRequest){
        Set<ScheduledCoursesEntity> listId = this.assignStudentsService.assignCoursesToStudents(assignRequest);
        return ResponseEntity.ok(listId);
    }

    @GetMapping("api/assign-students")
    public ResponseEntity<List<AssignStudentsDto>> getAllAssigned(){
        return ResponseEntity.ok(assignStudentsService.getAllAssigned());
    }
}

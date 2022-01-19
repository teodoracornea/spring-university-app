package ro.fasttrackit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.model.Semester;
import ro.fasttrackit.repository.dao.SemesterEntity;
import ro.fasttrackit.service.SemesterService;

import java.util.List;

@RestController
public class SemesterController {

    private final SemesterService semesterService;

    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @PostMapping("/api/semesters")
    public ResponseEntity createOrUpdateSemester(@RequestBody Semester semesterRequest){
        this.semesterService.createOrUpdateSemester(semesterRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/semesters")
    public ResponseEntity<List<Semester>> getAllSemesters(){
        return ResponseEntity.ok(semesterService.getAllSemesters());
    }

    @DeleteMapping("/api/semesters/{id}")
    public void deleteSemesterById(@PathVariable("id") Long semesterId){
        this.semesterService.deleteSemesterById(semesterId);

    }

    @GetMapping("/api/semesters-two")
    public ResponseEntity<List<SemesterEntity>> getAllSemestersTwo(){
        return ResponseEntity.ok(semesterService.findAllSemesterTwo());
    }


}

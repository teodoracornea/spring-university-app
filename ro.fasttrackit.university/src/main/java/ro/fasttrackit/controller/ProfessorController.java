package ro.fasttrackit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.service.ProfessorService;
import ro.fasttrackit.service.model.ProfessorDto;

import java.util.List;

@RestController
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping("/api/professors")
    public ResponseEntity createOrUpdateProfessor(@RequestBody ProfessorDto professorRequest){
        this.professorService.createOrUpdateProfessor(professorRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("api/professors")
    public ResponseEntity<List<ProfessorDto>> getAllProfessors(){
        return ResponseEntity.ok(professorService.getAllProfessors());
    }

    @DeleteMapping("api/professors/{id}")
    public void deleteProfessorsById(@PathVariable("id") Long professorId){
        this.professorService.deleProfessorById(professorId);
    }
}

package ro.fasttrackit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.service.ScheduledCoursesService;
import ro.fasttrackit.service.model.ScheduledCourseDto;

import java.util.List;

@RestController
public class ScheduledCoursesController {
    private final ScheduledCoursesService scheduledCoursesService;

    public ScheduledCoursesController(ScheduledCoursesService scheduledCoursesService) {
        this.scheduledCoursesService = scheduledCoursesService;
    }

    @PostMapping("/api/scheduled-courses")
    public ResponseEntity createOrUpdateSC(@RequestBody ScheduledCourseDto SCRequest){
    this.scheduledCoursesService.createOrUpdateSC(SCRequest);
    return ResponseEntity.ok().build();
}
    @GetMapping("/api/scheduled-courses")
    public ResponseEntity<List<ScheduledCourseDto>> getAllSC(){
        return ResponseEntity.ok(scheduledCoursesService.getAllSC());
    }

    @DeleteMapping("/api/scheduled-courses/{id}")
    public void deleteScheduledCourseByID(@PathVariable("id") Long scheduledCourseId ){
        this.scheduledCoursesService.deleteScheduledCourseById(scheduledCourseId);
    }
}

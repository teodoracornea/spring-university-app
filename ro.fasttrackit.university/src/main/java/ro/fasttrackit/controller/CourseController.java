package ro.fasttrackit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.service.CourseService;
import ro.fasttrackit.service.model.CourseDto;

import java.util.List;

@RestController
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/api/courses")
    public ResponseEntity createOrUpdateCourse(@RequestBody CourseDto courseRequest){
        this.courseService.createOrUpdateCourse(courseRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/courses")
    public ResponseEntity<List<CourseDto>> getAllCourses(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @DeleteMapping("/api/courses/{id}")
    public void deleteCourseById(@PathVariable("id") Long courseId){
        this.courseService.deleteCourseById(courseId);
    }
}


package ro.fasttrackit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.message.Sender;
import ro.fasttrackit.service.ScheduledCoursesService;
import ro.fasttrackit.service.model.MessageDto;
import ro.fasttrackit.service.model.ScheduledCourseDto;


import javax.transaction.Transactional;
import java.util.List;

@RestController
public class ScheduledCoursesController {
    private final ScheduledCoursesService scheduledCoursesService;
    private final Sender queueSender;

    public ScheduledCoursesController(ScheduledCoursesService scheduledCoursesService, Sender queueSender) {
        this.scheduledCoursesService = scheduledCoursesService;
        this.queueSender = queueSender;
    }

    @Transactional
    @PostMapping("/api/scheduled-courses")
    public ResponseEntity createOrUpdateSC(@RequestBody ScheduledCourseDto sCRequest){
    this.scheduledCoursesService.createOrUpdateSC(sCRequest);
    MessageDto messageDto = this.scheduledCoursesService.sendMessage(sCRequest);

    this.queueSender.send(messageDto.toString());
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

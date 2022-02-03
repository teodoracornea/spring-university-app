package ro.fasttrackit.service.model;

import ro.fasttrackit.repository.dao.SemesterEntity;
import ro.fasttrackit.repository.dao.StudentEntity;


import java.util.List;

public class AssignStudentsDto {
    private Long id;
    private Long studentId;
    private Long ScheduledCourseId;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getScheduledCourseId() {
        return ScheduledCourseId;
    }

    public void setScheduledCourseId(Long scheduledCourseId) {
        ScheduledCourseId = scheduledCourseId;
    }
}


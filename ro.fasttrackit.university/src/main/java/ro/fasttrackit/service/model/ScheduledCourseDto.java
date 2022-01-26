package ro.fasttrackit.service.model;

import java.util.Objects;

public class ScheduledCourseDto {
    private Long id;
    private Long courseId;
    private Long professorId;
    private Long semesterId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public Long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Long semesterId) {
        this.semesterId = semesterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduledCourseDto that = (ScheduledCourseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(courseId, that.courseId) && Objects.equals(professorId, that.professorId) && Objects.equals(semesterId, that.semesterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, professorId, semesterId);
    }
}


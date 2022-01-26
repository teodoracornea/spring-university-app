package ro.fasttrackit.repository.dao;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "scheduled_courses")
@Entity(name = "scheduled_courses")
public class ScheduledCoursesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long courseId;
    @Column
    private Long professorId;
    @Column
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
        ScheduledCoursesEntity that = (ScheduledCoursesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(courseId, that.courseId) && Objects.equals(professorId, that.professorId) && Objects.equals(semesterId, that.semesterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, professorId, semesterId);
    }
}

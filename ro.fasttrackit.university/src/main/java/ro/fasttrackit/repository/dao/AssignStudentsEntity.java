package ro.fasttrackit.repository.dao;

import javax.persistence.*;

@Table(name = "student_courses")
@Entity(name = "student_courses")
public class AssignStudentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private Long studentId;
    @Column
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
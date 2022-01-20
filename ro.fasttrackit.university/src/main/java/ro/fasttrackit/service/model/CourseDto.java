package ro.fasttrackit.service.model;


import java.util.Objects;

public class CourseDto {
    private Long id;
    private String course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseDto courseDto = (CourseDto) o;
        return Objects.equals(id, courseDto.id) && Objects.equals(course, courseDto.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, course);
    }
}

package ro.fasttrackit.service;

import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;
import ro.fasttrackit.repository.CourseRepository;
import ro.fasttrackit.repository.dao.CourseEntity;
import ro.fasttrackit.service.model.CourseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void createOrUpdateCourse(CourseDto toCreate){
        CourseEntity createOrUpdateMe = new CourseEntity();
        createOrUpdateMe.setId(toCreate.getId());
        createOrUpdateMe.setCourse(toCreate.getCourse());
        this.courseRepository.save(createOrUpdateMe);

    }

    public List<CourseDto> getAllCourses() {
        final List<CourseEntity> all = this.courseRepository.findAll();
        return all.stream()
                .map(courseEntity -> {
                    CourseDto createdCourse = new CourseDto();
                    createdCourse.setId(courseEntity.getId());
                    createdCourse.setCourse(courseEntity.getCourse());
                    return createdCourse;
                })
                .collect(Collectors.toList());
    }

    public void deleteCourseById(Long courseIdToDelete){

        this.courseRepository.deleteById(courseIdToDelete);
    }



}

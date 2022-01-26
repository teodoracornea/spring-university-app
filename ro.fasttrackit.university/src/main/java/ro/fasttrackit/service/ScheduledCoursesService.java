package ro.fasttrackit.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.repository.CourseRepository;
import ro.fasttrackit.repository.ProfessorRepository;
import ro.fasttrackit.repository.ScheduledCoursesRepository;
import ro.fasttrackit.repository.SemesterRepository;
import ro.fasttrackit.repository.dao.ScheduledCoursesEntity;
import ro.fasttrackit.service.model.ScheduledCourseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduledCoursesService {

    private final ScheduledCoursesRepository scheduledCoursesRepository;
    private final CourseRepository courseRepository;
    private final ProfessorRepository professorRepository;
    private final SemesterRepository semesterRepository;


    public ScheduledCoursesService(ScheduledCoursesRepository scheduledCoursesRepository, CourseRepository courseRepository, ProfessorRepository professorRepository, SemesterRepository semesterRepository) {
        this.scheduledCoursesRepository = scheduledCoursesRepository;
        this.courseRepository = courseRepository;
        this.professorRepository = professorRepository;
        this.semesterRepository = semesterRepository;
    }


    public void createOrUpdateSC(ScheduledCourseDto toCreate){
        ScheduledCoursesEntity createOrUpdateMe = new ScheduledCoursesEntity();
        if(courseRepository.existsById(toCreate.getCourseId())){
            if(professorRepository.existsById(toCreate.getProfessorId())){
                if(semesterRepository.existsById(toCreate.getSemesterId())){
                    createOrUpdateMe.setId(toCreate.getId());
                    createOrUpdateMe.setCourseId(toCreate.getCourseId());
                    createOrUpdateMe.setProfessorId(toCreate.getProfessorId());
                    createOrUpdateMe.setSemesterId(toCreate.getSemesterId());
                    this.scheduledCoursesRepository.save(createOrUpdateMe);
                }
                else throw new IllegalStateException("Semester does not exist");
            }
            else throw new IllegalStateException("Professor does not exist");
        }
        else throw new IllegalStateException("Course does not exist");

        this.scheduledCoursesRepository.save(createOrUpdateMe);
    }

    public List<ScheduledCourseDto> getAllSC(){
        final List<ScheduledCoursesEntity> all = this.scheduledCoursesRepository.findAll();
        return all.stream()
                .map(sCEntity -> {
                    ScheduledCourseDto createdSC = new ScheduledCourseDto();
                    createdSC.setId(sCEntity.getId());
                    createdSC.setCourseId(sCEntity.getCourseId());
                    createdSC.setProfessorId(sCEntity.getProfessorId());
                    createdSC.setSemesterId(sCEntity.getSemesterId());
                    return createdSC;
                })
                .collect(Collectors.toList());
    }

    public void deleteScheduledCourseById(Long scheduledCourseIdToDelete){
        this.scheduledCoursesRepository.deleteById(scheduledCourseIdToDelete);
    }
}


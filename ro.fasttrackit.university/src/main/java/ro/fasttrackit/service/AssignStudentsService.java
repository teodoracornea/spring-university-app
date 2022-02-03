package ro.fasttrackit.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.repository.ScheduledCoursesRepository;
import ro.fasttrackit.repository.SemesterRepository;
import ro.fasttrackit.repository.AssignStudentsRepository;
import ro.fasttrackit.repository.StudentRepository;
import ro.fasttrackit.repository.dao.AssignStudentsEntity;
import ro.fasttrackit.repository.dao.ScheduledCoursesEntity;
import ro.fasttrackit.repository.dao.SemesterEntity;
import ro.fasttrackit.service.model.AssignDto;
import ro.fasttrackit.service.model.AssignStudentsDto;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AssignStudentsService {
    private final AssignStudentsRepository assignStudentsRepository;
    private final StudentRepository studentRepository;
    private final StudentService studentService;
    private final SemesterService semesterService;
    private final SemesterRepository semesterRepository;
    private final ScheduledCoursesRepository scheduledCoursesRepository;

    public AssignStudentsService(AssignStudentsRepository assignStudentsRepository, StudentRepository studentRepository, StudentService studentService, SemesterService semesterService, SemesterRepository semesterRepository, ScheduledCoursesRepository scheduledCoursesRepository) {
        this.assignStudentsRepository = assignStudentsRepository;
        this.studentRepository = studentRepository;
        this.studentService = studentService;
        this.semesterService = semesterService;
        this.semesterRepository = semesterRepository;
        this.scheduledCoursesRepository = scheduledCoursesRepository;
    }

    public String assignCoursesToStudents(AssignDto assignDto) {
        final Set<Long> studentsId = assignDto.getStudentIdSet();
        final Set<Long> coursesId = new HashSet<>();
        final Set<Long> notAssigned = new HashSet<>();
        Integer successfullyAssigned=0;

        String universityDept = assignDto.getUniversityDept();
        String universityYear = assignDto.getUniversityYear();
        String semesterNo = assignDto.getSemesterNo();

        SemesterEntity semester = semesterService.findByUniversityDeptAndUniversityYearAndSemesterNo(universityDept, universityYear, semesterNo);
        Set<ScheduledCoursesEntity> scheduledCoursesEntitySet = scheduledCoursesRepository.findAllBySemesterId(semester.getId());

        for (Long id : studentsId) {
            if (studentRepository.existsById(id)) {
                successfullyAssigned+=1;
                for (ScheduledCoursesEntity schCourse : scheduledCoursesEntitySet) {
                    create(id, schCourse.getId());
                    coursesId.add(schCourse.getId());

                }
            }else notAssigned.add(id);
        }
        return studentsId.size() + " students were given as input. "+successfullyAssigned + " students were successfully assigned. "+ notAssigned.size()+ " students were not successfully assigned with IDs: "+ notAssigned.toString();
    }

    public void create (Long studentId, Long scheduledId){
        AssignStudentsEntity createOrUpdateMe = new AssignStudentsEntity();
        createOrUpdateMe.setScheduledCourseId(scheduledId);
        createOrUpdateMe.setStudentId(studentId);
        this.assignStudentsRepository.save(createOrUpdateMe);

    }

    public List<AssignStudentsDto> getAllAssigned(){
        final List<AssignStudentsEntity> all = this.assignStudentsRepository.findAll();
        return all.stream()
                .map(assigned ->{
                    AssignStudentsDto create = new AssignStudentsDto();
                    create.setId(assigned.getId());
                    create.setStudentId(assigned.getStudentId());
                    create.setScheduledCourseId(assigned.getScheduledCourseId());
                    return create;
                })
                .collect(Collectors.toList());

    }

    public void deleteAssignedById(Long assignedToDelete){
        assignStudentsRepository.deleteById(assignedToDelete);
    }




}

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

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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

    public Set<ScheduledCoursesEntity> assignCoursesToStudents(AssignDto assignDto) {
        final Set<Long> studentsId = assignDto.getStudentIdSet();
        final Set<Long> coursesId = new HashSet<>();
        String universityDept = assignDto.getUniversityDept();
        String universityYear = assignDto.getUniversityYear();
        String semesterNo = assignDto.getSemesterNo();
        SemesterEntity semester = semesterService.findByUniversityDeptAndUniversityYearAndSemesterNo(universityDept, universityYear, semesterNo);
        SemesterEntity semester1 = new SemesterEntity();
        semesterService.getAllSemesters().stream()
                .filter(s -> s.getSemesterNo().equals(semesterNo) && s.getUniversityDept().equals(universityDept)&& s.getUniversityYear().equals(universityYear))
                .map(s->{
                    semester1.setId(s.getId());
                    semester1.setUniversityDept(s.getUniversityDept());
                    semester1.setSemesterNo(s.getSemesterNo());
                    semester1.setUniversityYear(s.getUniversityYear());
                    semester1.setStartDate(s.getStartDate());
                    semester1.setEndDate(s.getEndDate());
                    return semester1;
                })
                .collect(Collectors.toSet());
        Set<ScheduledCoursesEntity> scheduledCoursesEntitySet = scheduledCoursesRepository.findAllBySemesterId(semester.getId());
        Set<ScheduledCoursesEntity> scheduledCoursesEntitySet2 = scheduledCoursesRepository.findAll().stream().
                filter(x -> x.getSemesterId().equals(semester1.getId()))
                .collect(Collectors.toSet());
        for (Long id : studentsId) {
            if (studentRepository.existsById(id)) {
                for (ScheduledCoursesEntity schCourse : scheduledCoursesEntitySet2) {
                    create(id, schCourse.getId());
                    coursesId.add(schCourse.getId());

                }
            }
        }
        return scheduledCoursesEntitySet2;
    }

        /*
        studentIDs
                .stream()
                .map(studentService::getStudentById)
                .forEach(student -> {
                    var studentScheduledCourses = student.getScheduleCourses();
                    var unassignedCourses = scheduledCourses
                            .stream()
                            .filter(scheduleCourse -> !studentScheduledCourses.contains(scheduleCourse))
                            .collect(Collectors.toSet());
                    if (unassignedCourses.size() == 0) {
                        var studentHuman = student.getHuman();
                        unassignedStudents.add(studentHuman.getFirstname() + " " + studentHuman.getLastname());
                    }
                    else {
                        assignedStudents.add(student);
                        studentScheduledCourses.addAll(unassignedCourses);
                        studentService.save(student);
                    }
                });
         */



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




}

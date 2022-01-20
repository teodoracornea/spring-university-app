package ro.fasttrackit.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.repository.StudentRepository;
import ro.fasttrackit.repository.dao.HumanEntity;
import ro.fasttrackit.repository.dao.StudentEntity;
import ro.fasttrackit.service.model.StudentDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createOrUpdateStudent(StudentDto toCreate){

        StudentEntity createOrUpdateMe = new StudentEntity();
        createOrUpdateMe.setId(toCreate.getId());
        createOrUpdateMe.setHuman(toCreate.getHuman());
        this.studentRepository.save(createOrUpdateMe);

    }

    public List<StudentDto> getAllStudents(){
        final List<StudentEntity> all = this.studentRepository.findAll();
        return all.stream()
                .map(studentEntity -> {
                    StudentDto createdStudent= new StudentDto();
                    createdStudent.setId(studentEntity.getId());
                    createdStudent.setHuman(studentEntity.getHuman());
                    return createdStudent;
                })
                .collect(Collectors.toList());

    }

}

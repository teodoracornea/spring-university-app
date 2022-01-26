package ro.fasttrackit.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.repository.HumansRepository;
import ro.fasttrackit.repository.StudentRepository;
import ro.fasttrackit.repository.dao.HumanEntity;
import ro.fasttrackit.repository.dao.StudentEntity;
import ro.fasttrackit.service.model.HumanDto;
import ro.fasttrackit.service.model.StudentDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final HumansRepository humansRepository;

    public StudentService(StudentRepository studentRepository, HumansRepository humansRepository) {
        this.studentRepository = studentRepository;
        this.humansRepository = humansRepository;
    }

    public void createOrUpdateStudent(StudentDto toCreate){
        HumanEntity createOrUpdateHuman = new HumanEntity();
        createOrUpdateHuman.setId(toCreate.getHuman().getId());
        createOrUpdateHuman.setCnp(toCreate.getHuman().getCnp());
        createOrUpdateHuman.setFirstname(toCreate.getHuman().getFirstname());
        createOrUpdateHuman.setLastName(toCreate.getHuman().getLastname());
        HumanEntity savedHuman = this.humansRepository.save(createOrUpdateHuman);

        StudentEntity createOrUpdateMe = new StudentEntity();
        createOrUpdateMe.setId(toCreate.getId());

        createOrUpdateMe.setHuman(savedHuman);

        this.studentRepository.save(createOrUpdateMe);

    }

    public List<StudentDto> getAllStudents(){
        final List<StudentEntity> all = this.studentRepository.findAll();
        return all.stream()
                .map(studentEntity -> {
                    StudentDto createdStudent= new StudentDto();
                    createdStudent.setId(studentEntity.getId());
                    HumanDto humanDto = new HumanDto();
                    humanDto.setId(studentEntity.getHuman().getId());
                    humanDto.setCnp(studentEntity.getHuman().getCnp());
                    humanDto.setFirstname(studentEntity.getHuman().getFirstname());
                    humanDto.setLastname(studentEntity.getHuman().getLastName());
                    createdStudent.setHuman(humanDto);
                    return createdStudent;
                })
                .collect(Collectors.toList());

    }

    public void deleteStudentById(Long studentIdToDelete){
        this.studentRepository.deleteById(studentIdToDelete);
    }



}

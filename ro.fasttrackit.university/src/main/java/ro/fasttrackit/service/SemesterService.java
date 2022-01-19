package ro.fasttrackit.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.model.Semester;
import ro.fasttrackit.repository.SemesterRepository;
import ro.fasttrackit.repository.dao.HumanEntity;
import ro.fasttrackit.repository.dao.SemesterEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SemesterService {
    private final SemesterRepository semesterRepository;

    public SemesterService(SemesterRepository semesterRepository){
        this.semesterRepository = semesterRepository;
    }

    public List<Semester> getAllSemesters(){
        final List<SemesterEntity> all = this.semesterRepository.findAll();
        return all.stream()
                .map(semesterEntity -> {
                    Semester createdSemester = new Semester();
                    createdSemester.setId(semesterEntity.getId());
                    createdSemester.setUniversityDept(semesterEntity.getUniversityDept());
                    createdSemester.setUniversityYear(semesterEntity.getUniversityYear());
                    createdSemester.setSemesterNo(semesterEntity.getSemesterNo());
                    createdSemester.setStartDate(semesterEntity.getStartDate());
                    createdSemester.setEndDate(semesterEntity.getEndDate());
                    return createdSemester;
                })
                .collect(Collectors.toList());
    }

    public void createOrUpdateSemester(Semester toCreate){

        SemesterEntity createOrUpdateMe = new SemesterEntity();
        createOrUpdateMe.setId(toCreate.getId());
        createOrUpdateMe.setUniversityDept(toCreate.getUniversityDept());
        createOrUpdateMe.setUniversityYear(toCreate.getUniversityYear());
        createOrUpdateMe.setSemesterNo(toCreate.getSemesterNo());
        createOrUpdateMe.setStartDate(toCreate.getStartDate());
        createOrUpdateMe.setEndDate(toCreate.getEndDate());
        this.semesterRepository.save(createOrUpdateMe);

    }

    public void deleteSemesterById(Long semesterIdToDelete){
        this.semesterRepository.deleteById(semesterIdToDelete);
    }

    public List<SemesterEntity> findAllSemesterTwo(){
        return this.semesterRepository.findAllSemesterTwo();
    }



}

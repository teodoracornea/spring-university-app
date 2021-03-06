package ro.fasttrackit.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.repository.SemesterRepository;
import ro.fasttrackit.repository.dao.HumanEntity;
import ro.fasttrackit.repository.dao.SemesterEntity;
import ro.fasttrackit.service.model.SemesterDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SemesterService {
    private final SemesterRepository semesterRepository;

    public SemesterService(SemesterRepository semesterRepository){
        this.semesterRepository = semesterRepository;
    }

    public List<SemesterDto> getAllSemesters(){
        final List<SemesterEntity> all = this.semesterRepository.findAll();
        return all.stream()
                .map(semesterEntity -> {
                    SemesterDto createdSemester = new SemesterDto();
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

    public void createOrUpdateSemester(SemesterDto toCreate){

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

    public List<SemesterDto> findAllSemesterTwo(){

        return this.semesterRepository.findAllSemesterTwo()
                .stream()
                .map(semesterEntity -> {
                    SemesterDto createdSemester = new SemesterDto();
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

    public SemesterEntity findByUniversityDeptAndUniversityYearAndSemesterNo(String universityDept, String universityYear, String semesterNo) {
//
        Optional<SemesterEntity> semesterOptional = this.semesterRepository.findByUniversityDeptAndUniversityYearAndSemesterNo(universityDept, universityYear, semesterNo);
        return semesterOptional.orElseThrow(() -> new RuntimeException("Could not find semester"));
//        if(semesterOptional.isEmpty()){SemesterEntity semesterFound = new SemesterEntity();
//            throw new RuntimeException("Could not find semester");
//        }
//        SemesterEntity semesterEntity = semesterOptional.get();
//        semesterFound.setUniversityYear(semesterEntity.getUniversityYear());
//        semesterFound.setSemesterNo(semesterEntity.getSemesterNo());
//        semesterFound.setUniversityDept(semesterEntity.getUniversityDept());
//        semesterFound.setStartDate(semesterEntity.getStartDate());
//        semesterFound.setEndDate(semesterEntity.getEndDate());



    }






}

package ro.fasttrackit.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.repository.HumansRepository;
import ro.fasttrackit.repository.ProfessorRepository;
import ro.fasttrackit.repository.dao.HumanEntity;
import ro.fasttrackit.repository.dao.ProfessorEntity;
import ro.fasttrackit.service.model.HumanDto;
import ro.fasttrackit.service.model.ProfessorDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final HumansRepository humansRepository;

    public ProfessorService(ProfessorRepository professorRepository, HumansRepository humansRepository) {
        this.professorRepository = professorRepository;
        this.humansRepository = humansRepository;
    }


    public void createOrUpdateProfessor(ProfessorDto toCreate){
        HumanEntity createOrUpdateHuman = new HumanEntity();
        createOrUpdateHuman.setId(toCreate.getHuman().getId());
        createOrUpdateHuman.setCnp(toCreate.getHuman().getCnp());
        createOrUpdateHuman.setLastName(toCreate.getHuman().getLastname());
        createOrUpdateHuman.setFirstname(toCreate.getHuman().getFirstname());
        HumanEntity savedHuman = this.humansRepository.save(createOrUpdateHuman);

        ProfessorEntity createOrUpdateMe = new ProfessorEntity();
        createOrUpdateMe.setId(toCreate.getId());

        createOrUpdateMe.setHuman(savedHuman);

        this.professorRepository.save(createOrUpdateMe);

    }

    public List<ProfessorDto> getAllProfessors(){
        final List<ProfessorEntity> all = this.professorRepository.findAll();
        return all.stream()
                .map(professorEntity -> {
                    ProfessorDto createdProfessor = new ProfessorDto();
                    createdProfessor.setId(professorEntity.getId());
                    HumanDto humanDto = new HumanDto();
                    humanDto.setId(professorEntity.getHuman().getId());
                    humanDto.setCnp(professorEntity.getHuman().getCnp());
                    humanDto.setLastname(professorEntity.getHuman().getLastName());
                    humanDto.setFirstname(professorEntity.getHuman().getFirstname());
                    createdProfessor.setHuman(humanDto);
                    return createdProfessor;
                })
                .collect(Collectors.toList());

    }

    public void deleteProfessorById(Long professorIdToDelete){
        this.professorRepository.deleteById(professorIdToDelete);
    }


}

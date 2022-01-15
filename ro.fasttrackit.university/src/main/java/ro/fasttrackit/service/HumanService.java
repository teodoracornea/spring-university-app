package ro.fasttrackit.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.model.Human;
import ro.fasttrackit.repository.HumansRepository;
import ro.fasttrackit.repository.dao.HumanEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HumanService {

    private final HumansRepository humansRepository;

    public HumanService(HumansRepository humansRepository) {
        this.humansRepository = humansRepository;
    }

//    GET to retrieve all Humans
    public List<Human> getAllHumans(){

        final List<HumanEntity> all = this.humansRepository.findAll();
        return all.stream()
                .map(humanEntity -> {
                    Human createdHuman =new Human();
                    createdHuman.setId(humanEntity.getId());
                    createdHuman.setCnp(humanEntity.getCnp());
                    createdHuman.setFirstname(humanEntity.getFirstname());
                    createdHuman.setLastname(humanEntity.getLastName());
                    return createdHuman;
                } )
                .collect(Collectors.toList());
    }

    public List<Human> findAllByLastName(String lastname){
        return this.humansRepository.findAllByLastNameContains(lastname).stream()
                .map(humanEntity -> {
                    Human createdHuman =new Human();
                    createdHuman.setId(humanEntity.getId());
                    createdHuman.setCnp(humanEntity.getCnp());
                    createdHuman.setFirstname(humanEntity.getFirstname());
                    createdHuman.setLastname(humanEntity.getLastName());
                    return createdHuman;
                } )
                .collect(Collectors.toList());
    }


//    POST to create or update a new Human by ID
    public void createOrUpdateHuman(Human toCreate){

        HumanEntity createOrUpdateMe = new HumanEntity();
        createOrUpdateMe.setId(toCreate.getId());
        createOrUpdateMe.setCnp(toCreate.getCnp());
        createOrUpdateMe.setFirstname(toCreate.getFirstname());
        createOrUpdateMe.setLastName(toCreate.getLastname());
        this.humansRepository.save(createOrUpdateMe);

    }

//    DELETE to delete a Human by ID
    public void deleteHumanById(Long humanIdToDelete){
        this.humansRepository.deleteById(humanIdToDelete);
    }

//    GET by ID to retrieve a single Human by an ID given as a Request Parameter
    public Human getHuman(Long humanIdToGet){
        this.humansRepository.findById(humanIdToGet);
        Human humanCreated = new Human();

        humanCreated.setId(humansRepository.findById(humanIdToGet).get().getId());
        humanCreated.setLastname(humansRepository.findById(humanIdToGet).get().getLastName());
        humanCreated.setFirstname(humansRepository.findById(humanIdToGet).get().getFirstname());
        humanCreated.setCnp(humansRepository.findById(humanIdToGet).get().getCnp());
        return humanCreated;
    }



}

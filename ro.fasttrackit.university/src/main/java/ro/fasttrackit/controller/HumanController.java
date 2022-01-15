package ro.fasttrackit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.model.Human;
import ro.fasttrackit.service.HumanService;

import java.util.List;

@RestController
public class HumanController {

    private final HumanService humanService;

    public HumanController(HumanService humanService) {
        this.humanService = humanService;
    }

    @GetMapping("/humans")
    public ResponseEntity<String> getText() {
        return ResponseEntity.ok("There are no humans!");

    }

    @GetMapping("/api/humans")
    public ResponseEntity<List<Human>> getAllHumans(@RequestParam(name = "lastname", required = false) String searchByLastName) {
        if(searchByLastName != null && searchByLastName.isBlank()){
            return ResponseEntity.ok(humanService.getAllHumans());
        }
        return ResponseEntity.ok(humanService.findAllByLastName(searchByLastName));
    }

    @PostMapping("/api/humans")
    public ResponseEntity createOrUpdateHuman(@RequestBody Human humanRequest){
        this.humanService.createOrUpdateHuman(humanRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/humans/{id}")
    public void deleteHumanById(@PathVariable("id") Long humanId){
        this.humanService.deleteHumanById(humanId);


    }

    @GetMapping("/api/humans/{id}")
    public ResponseEntity<Human> getHuman(@PathVariable("id") Long humanId){
        return ResponseEntity.ok(humanService.getHuman(humanId));
    }





}
package ro.fasttrackit.service.model;


public class StudentDto {
    private Long id;
    private HumanDto human;


    public HumanDto getHuman() {
        return human;
    }

    public void setHuman(HumanDto human) {
        this.human = human;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


}

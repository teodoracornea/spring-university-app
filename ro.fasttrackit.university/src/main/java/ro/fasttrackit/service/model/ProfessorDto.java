package ro.fasttrackit.service.model;

import java.util.Objects;

public class ProfessorDto {
    private Long id;
    private HumanDto human;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HumanDto getHuman() {
        return human;
    }

    public void setHuman(HumanDto human) {
        this.human = human;
    }

    @Override
    public String
    toString() {
        return "ProfessorDto{" +
                "id=" + id +
                ", human=" + human +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorDto that = (ProfessorDto) o;
        return Objects.equals(id, that.id) && Objects.equals(human, that.human);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, human);
    }
}

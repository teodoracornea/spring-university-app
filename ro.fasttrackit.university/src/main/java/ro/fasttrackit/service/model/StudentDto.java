package ro.fasttrackit.service.model;


import ro.fasttrackit.repository.dao.HumanEntity;

import java.util.Objects;

public class StudentDto extends HumanDto{
    private Long id;
    private HumanEntity human;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentDto that = (StudentDto) o;
        return Objects.equals(id, that.id) && Objects.equals(human, that.human);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, human);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public HumanEntity getHuman() {
        return human;
    }

    public void setHuman(HumanEntity human) {
        this.human = human;
    }
}

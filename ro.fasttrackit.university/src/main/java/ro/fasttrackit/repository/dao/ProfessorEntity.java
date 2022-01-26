package ro.fasttrackit.repository.dao;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "professors")
@Entity(name = "professors")
public class ProfessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(targetEntity = HumanEntity.class, cascade = CascadeType.ALL)
    private HumanEntity human;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HumanEntity getHuman() {
        return human;
    }

    public void setHuman(HumanEntity human) {
        this.human = human;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorEntity that = (ProfessorEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(human, that.human);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, human);
    }
}

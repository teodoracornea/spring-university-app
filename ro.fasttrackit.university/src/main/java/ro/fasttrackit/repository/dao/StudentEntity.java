package ro.fasttrackit.repository.dao;

import javax.persistence.*;
import java.util.Objects;
@Table(name = "students")
@Entity(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(targetEntity = HumanEntity.class, cascade = CascadeType.MERGE)
    private HumanEntity human;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(human, that.human);
    }


    public int hashCode() {
        return Objects.hash(id, human);
    }


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


}



package ro.fasttrackit.repository.dao;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "students")
public class StudentEntity extends HumanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "human_id", referencedColumnName = "id")
    private HumanEntity human;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(human, that.human);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, human);
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



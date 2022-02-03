package ro.fasttrackit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.repository.dao.AssignStudentsEntity;

@Repository
public interface AssignStudentsRepository extends JpaRepository<AssignStudentsEntity, Long> {

}

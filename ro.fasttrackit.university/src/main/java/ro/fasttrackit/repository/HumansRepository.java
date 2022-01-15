package ro.fasttrackit.repository;

import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.repository.dao.HumanEntity;

import java.util.List;

@Repository
public interface HumansRepository extends JpaRepository<HumanEntity, Long> {

List<HumanEntity> findAllByLastNameContains(String lastname);


}

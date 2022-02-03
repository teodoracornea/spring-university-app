package ro.fasttrackit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.repository.dao.ScheduledCoursesEntity;

import java.util.Set;

@Repository
public interface ScheduledCoursesRepository extends JpaRepository<ScheduledCoursesEntity, Long> {

    Set<ScheduledCoursesEntity> findAllBySemesterId(Long semesterId);

}

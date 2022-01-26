package ro.fasttrackit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.repository.dao.ScheduledCoursesEntity;

@Repository
public interface ScheduledCoursesRepository extends JpaRepository<ScheduledCoursesEntity, Long> {

}

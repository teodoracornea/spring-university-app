package ro.fasttrackit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.repository.dao.SemesterEntity;

import java.util.List;

@Repository
public interface SemesterRepository extends JpaRepository<SemesterEntity, Long> {

    @Query("select s from semesters s where s.semesterNo = '2'")
    List<SemesterEntity> findAllSemesterTwo();
}

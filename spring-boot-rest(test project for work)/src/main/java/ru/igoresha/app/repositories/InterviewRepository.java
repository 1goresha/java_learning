package ru.igoresha.app.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.igoresha.app.models.Interview;

import java.util.Date;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

    Page<Interview> findAllByNameContainsOrderByNameDesc(String value, Pageable pageable);

    Page<Interview> findAllByNameContainsOrderByNameAsc(String value, Pageable pageable);

    Page<Interview> findAllByNameContainsOrderByDateBeginDesc(String value, Pageable pageable);

    Page<Interview> findAllByNameContainsOrderByDateBeginAsc(String value, Pageable pageable);

    Page<Interview> findAllByDateBeginOrderByNameDesc(Date value, Pageable pageable);

    Page<Interview> findAllByDateBeginOrderByNameAsc(Date value, Pageable pageable);

    Page<Interview> findAllByDateBeginOrderByDateBeginDesc(Date value, Pageable pageable);

    Page<Interview> findAllByDateBeginOrderByDateBeginAsc(Date value, Pageable pageable);

    Page<Interview> findAllByDateEndOrderByNameDesc(Date value, Pageable pageable);

    Page<Interview> findAllByDateEndOrderByNameAsc(Date value, Pageable pageable);

    Page<Interview> findAllByDateEndOrderByDateBeginDesc(Date value, Pageable pageable);

    Page<Interview> findAllByDateEndOrderByDateBeginAsc(Date value, Pageable pageable);

    Page<Interview> findAllByIsActiveOrderByNameDesc(Boolean value, Pageable pageable);

    Page<Interview> findAllByIsActiveOrderByNameAsc(Boolean value, Pageable pageable);

    Page<Interview> findAllByIsActiveOrderByDateBeginDesc(Boolean value, Pageable pageable);

    Page<Interview> findAllByIsActiveOrderByDateBeginAsc(Boolean value, Pageable pageable);

    Page<Interview> findAll(Pageable pageable);

}

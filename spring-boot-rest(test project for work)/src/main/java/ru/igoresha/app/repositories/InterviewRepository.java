package ru.igoresha.app.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.igoresha.app.models.Interview;

import java.time.LocalDateTime;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

    Page<Interview> findAllByNameContainsOrderByNameAsc(String filter, Pageable pageable);
//    Page<Interview> findAllByOrder(LocalDateTime timeBegin);
}

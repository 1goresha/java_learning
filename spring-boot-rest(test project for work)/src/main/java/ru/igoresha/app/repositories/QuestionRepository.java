package ru.igoresha.app.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.igoresha.app.models.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Page<Question> findAllByInterviewIdOrderByDisplayOrderAsc(Long idI, Pageable pageable);

    List<Question> findAllByInterviewId(Long idI);

    Question findByInterviewIdAndDisplayOrder(Long idI, Integer displayOrder);
}

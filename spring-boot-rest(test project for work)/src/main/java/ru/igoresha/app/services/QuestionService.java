package ru.igoresha.app.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.igoresha.app.forms.QuestionForm;
import ru.igoresha.app.models.Question;

public interface QuestionService {

    Page<Question> findAll(Long idI, Pageable pageable);

    Question addQuestion(Long idI, QuestionForm questionForm);

    Question get(Long idI, Integer displayOrder);

    Question update(Long idI, Integer displayOrder, QuestionForm questionForm);

    void delete(Long idI, Integer displayOrder);
}

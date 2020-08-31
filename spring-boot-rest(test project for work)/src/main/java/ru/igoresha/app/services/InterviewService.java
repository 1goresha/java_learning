package ru.igoresha.app.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.igoresha.app.forms.InterviewForm;
import ru.igoresha.app.models.Interview;

import java.util.Date;

public interface InterviewService {
    Page<Interview> getPagesBySortAndDirectionAndFilter(String sort,
                                                        String direction,
                                                        String filter,
                                                        String value,
                                                        Pageable pageable);

    Interview addInterview(InterviewForm interviewForm);

    Interview update(Long id, InterviewForm interviewForm);

    void delete(Long id);

    Interview get(Long id);
}

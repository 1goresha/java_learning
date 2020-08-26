package ru.igoresha.app.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.igoresha.app.models.Interview;

public interface InterviewService {
    Page<Interview> getPageBySortAndFilter(String sort, String filter, Pageable pageable);
}

package ru.igoresha.app.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.igoresha.app.models.Interview;

import java.util.Date;

public interface InterviewService {
    Page<Interview> getPagesBySortAndDirectionAndFilter(String sort,
                                                        String direction,
                                                        String selectAll,
                                                        String where,
                                                        Pageable pageable);
}

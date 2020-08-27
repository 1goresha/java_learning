package ru.igoresha.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.igoresha.app.models.Interview;
import ru.igoresha.app.repositories.InterviewRepository;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    @Override
    public Page<Interview> getPageBySortAndFilter(String sort, String filter, Pageable pageable) {
        switch(sort){
            case("name") : return interviewRepository.findAllByNameContainsOrderByNameAsc(filter, pageable);
            case("timeBegin") :
                try{
//                    Date date = Date;
                    return interviewRepository.findAll(pageable);
                }catch (Exception e){
                    return interviewRepository.findAll(pageable);
                }
        }
        return interviewRepository.findAll(pageable);
    }
}
